package com.inved.freezdge.socialmedia.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.FileProvider
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.firebase.auth.FirebaseAuth
import com.inved.freezdge.BuildConfig
import com.inved.freezdge.R
import com.inved.freezdge.socialmedia.firebase.Post
import com.inved.freezdge.socialmedia.firebase.PostHelper
import com.inved.freezdge.utils.*
import java.io.File
import java.io.IOException
import java.util.*

class PhotoDialog : DialogFragment() {

    companion object {
        //final values
        private const val REQUEST_CAMERA_PHOTO = 456
        private const val REQUEST_GALLERY_PHOTO = 455
        const val TAG = "PHOTO"

        private const val KEY_PHOTO = "photoParam"
        private const val KEY_PHOTO_ID = "tip_id"
        @JvmStatic
        fun newInstance(param1: Int,param2:String) =
            PhotoDialog().apply {
                arguments = Bundle().apply {
                    putInt(KEY_PHOTO, param1)
                    putString(KEY_PHOTO_ID, param2)
                }
            }
    }

    //Photo
    private var urlPicture: String? = null
    private var cameraFilePath: String? = null
    private var imageCameraOrGallery: ImageCameraOrGallery? = null

    //UI
    private var photoPreview: ImageView? = null
    private var photoTitle: EditText? = null
    private var validateButton: TextView? = null
    private var cancelButton: ImageButton? = null
    private var mPhotoFile: File?=null
    private lateinit var mContext: Context
    private lateinit var postIdUpdate: String
    // --------------
    // LIFE CYCLE AND VIEW MODEL
    // --------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullscreenDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =
            inflater.inflate(R.layout.dialog_fullscreen_add_photo, container, false)
        mContext= App.instance!!.applicationContext
        imageCameraOrGallery = ImageCameraOrGallery()
        photoPreview = view.findViewById(R.id.photo_preview)

        photoTitle = view.findViewById(R.id.titleEdittext)
         validateButton = view.findViewById(R.id.validate_button)
        cancelButton = view.findViewById(R.id.close_button)

        val id:Int?=arguments?.getInt(KEY_PHOTO,0)
        postIdUpdate= arguments?.getString(KEY_PHOTO_ID, null)!!
        initializeMethods(id)
        when (id) {
            1 -> {
                dispatchTakePictureIntent()
            }
            2 -> {
                dispatchGalleryIntent()
            }
            3 -> {
            fillDialog(postIdUpdate)
            }
            else -> {
                dialog?.dismiss()
            }
        }
        return view
    }

    private fun initializeMethods(id:Int?) {

        cancelButton?.setOnClickListener { v: View? ->
            cancelButton?.startAnimation(Domain.animation())
            dialog!!.dismiss() }
        validateButton?.setOnClickListener { v: View? ->
            validateButton?.startAnimation(Domain.animation())
            createPhotoPost(id) }
    }

    // --------------
    // AGENT
    // --------------
    private fun createPhotoPost(id:Int?) {
        if (urlPicture==null) {
            Toast.makeText(activity,
                getString(R.string.no_picture_add_photo_dialog), Toast.LENGTH_SHORT).show()
        } else {
            var title:String? =null
            if(photoTitle!=null){
                title = photoTitle?.text.toString()
            }

            var uid: String?=null
            if (FirebaseAuth.getInstance().currentUser != null) {
                uid = FirebaseAuth.getInstance().currentUser?.uid
            }
            if (id == 1 || id== 2) {
                if (uid != null) {
                    val postId:String =Domain.createRandomString()
                    //create post in firebase
                    PostHelper.createPost(postId, Calendar.getInstance().time as Date,
                        title,null,urlPicture,uid,getString(R.string.social_media_post_type_photo),0)

                    //to upload a photo on Firebase storage
                    if (urlPicture != null) {
                        val storageHelper = StorageHelper()
                        storageHelper.uploadFromUri(
                            Uri.parse(urlPicture),
                            postId,
                            getString(R.string.type_storage_users)
                        )
                    }

                    Toast.makeText(
                        activity,
                        getString(R.string.toast_created_photo),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }else{
                PostHelper.updateTitleAstuce(title,postIdUpdate)
                Toast.makeText(
                    activity,
                    getString(R.string.toast_updated_photo_post),
                    Toast.LENGTH_LONG
                ).show()
            }


            //to close the dialog
            if (dialog != null) {
                dialog!!.dismiss()
            }
        }
    }

    private fun fillDialog(postId: String?) {
        postId?.let {
            PostHelper.getPost(it)?.get()?.addOnCompleteListener { task ->
                if (task.result != null) {
                    if (task.result!!.documents.isNotEmpty()) {

                        val post: Post =
                            task.result!!.documents[0].toObject(Post::class.java)!!

                        photoTitle?.setText(post.titleAstuce)
                        photoPreview?.let {
                            GlideApp.with(mContext)
                                .load(post.urlPhoto)
                                .apply(RequestOptions.centerCropTransform())
                                .placeholder(R.drawable.ic_anon_user_48dp)
                                .into(it)
                        }

                        urlPicture=post.urlPhoto
                        photoPreview?.setOnClickListener {  Toast.makeText(activity,
                            App.resource().getString(R.string.post_cant_change_photo), Toast.LENGTH_SHORT).show() }
                    }
                }
            }?.addOnFailureListener { e ->

            }
        }


    }
    // --------------
    // TAKE A PICTURE
    // --------------

    /**
     * Capture image from camera
     */

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(mContext.packageManager) != null) {
            // Create the File where the photo should go
            var photoFile: File? = null
            try {
                photoFile = imageCameraOrGallery?.createImageFile()
                cameraFilePath = photoFile?.let { imageCameraOrGallery?.getCameraFilePath(it) }
            } catch (ex: IOException) {
                ex.printStackTrace()
                // Error occurred while creating the File
            }
            if (photoFile != null) {
                val photoURI = FileProvider.getUriForFile(
                    mContext, BuildConfig.APPLICATION_ID + ".fileprovider",
                    photoFile
                )
                mPhotoFile = photoFile
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                startActivityForResult(
                    takePictureIntent,
                    REQUEST_CAMERA_PHOTO
                )
            }
        }
    }

    /**
     * Select image fro gallery
     */
    private fun dispatchGalleryIntent() {
        val pickPhoto = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        pickPhoto.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        startActivityForResult(pickPhoto, REQUEST_GALLERY_PHOTO)
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        // Result code is RESULT_OK only if the user selects an Image
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                REQUEST_GALLERY_PHOTO -> {
                    //data.getData returns the content URI for the selected Image
                    val selectedImage = data!!.data
                    try {
                        mPhotoFile = FileCompressor.compressToFile(
                            File(
                                imageCameraOrGallery?.getRealPathFromUri(selectedImage)
                            )
                        )
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                    if (selectedImage != null) {
                        urlPicture = imageCameraOrGallery?.getRealPathFromUri(selectedImage)
                        showImageInCircle(urlPicture)
                    }
                }
                REQUEST_CAMERA_PHOTO -> {
                    try {
                        mPhotoFile = mPhotoFile?.let { FileCompressor.compressToFile(it) }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                    if (cameraFilePath != null) {
                        urlPicture = cameraFilePath
                        showImageInCircle(cameraFilePath)
                    }
                }
            }
        }
    }

    private fun showImageInCircle(photoStringFromRoom: String?) {
        val fileUri = Uri.parse(photoStringFromRoom)
        if (fileUri.path != null) {
            photoPreview?.let {
                Glide.with(mContext)
                    .load(File(fileUri.path))
                    .apply(RequestOptions.centerCropTransform())
                    .placeholder(R.drawable.ic_anon_user_48dp)
                    .into(it)
            }
        }
    }

}