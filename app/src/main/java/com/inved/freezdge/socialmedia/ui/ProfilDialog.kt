package com.inved.freezdge.socialmedia.ui

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.FileProvider
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.auth.FirebaseAuth
import com.inved.freezdge.BuildConfig
import com.inved.freezdge.R
import com.inved.freezdge.socialmedia.firebase.User
import com.inved.freezdge.socialmedia.firebase.UserHelper
import com.inved.freezdge.utils.*
import permissions.dispatcher.NeedsPermission
import permissions.dispatcher.RuntimePermissions
import java.io.File
import java.io.IOException

@RuntimePermissions
class ProfilDialog : DialogFragment() {

    companion object {
        //final values
        private const val REQUEST_CAMERA_PHOTO = 456
        private const val REQUEST_GALLERY_PHOTO = 455

        //final values
        const val TAG = "PROFIL"
        private const val KEY_PROFIL = "profil"
        private lateinit var uid: String

        @JvmStatic
        fun newInstance(param1: String) =
            ProfilDialog().apply {
                arguments = Bundle().apply {
                    putString(KEY_PROFIL, param1)
                }
            }
    }

    //Photo
    private var urlPicture: String? = null
    private var cameraFilePath: String? = null
    private var imageCameraOrGallery: ImageCameraOrGallery? = null

    //UI
    private var profilPhoto: ImageView? = null
    private var lastnameEditText: EditText? = null
    private var firstnameEditText: EditText? = null
    private var changePhotoText: TextView? = null
    private var addActionButton: ImageButton? = null
    private var cancelSearchButton: ImageButton? = null
    private var mPhotoFile: File? = null
    private lateinit var mContext: Context

    // --------------
    // LIFE CYCLE AND VIEW MODEL
    // --------------
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =
            inflater.inflate(R.layout.dialog_update_profile, container, false)
        mContext = App.instance!!.applicationContext

        uid = FirebaseAuth.getInstance().currentUser!!.uid
        imageCameraOrGallery = ImageCameraOrGallery()
        profilPhoto = view.findViewById(R.id.profil_photo)
        changePhotoText =
            view.findViewById(R.id.change_profil_photo_text)
        lastnameEditText = view.findViewById(R.id.lastnameEdittext)
        firstnameEditText = view.findViewById(R.id.firstnameEdittext)
        addActionButton = view.findViewById(R.id.agent_add_dialog_validate)
        cancelSearchButton = view.findViewById(R.id.agent_add_dialog_close)

        initializeMethods()
        fillDialog()
        return view
    }

    private fun initializeMethods() {
        changePhotoText?.setOnClickListener { v: View? -> selectImage() }
        cancelSearchButton?.setOnClickListener { v: View? -> dialog!!.dismiss() }
        addActionButton?.setOnClickListener { v: View? -> updateProfile() }
    }


    private fun fillDialog() {
        UserHelper.getUser(uid)?.get()?.addOnCompleteListener { task ->
            if (task.result != null) {
                if (task.result!!.documents.isNotEmpty()) {

                    val user: User =
                        task.result!!.documents[0].toObject(User::class.java)!!

                    Log.d("debago","user firstname is ${user.firstname}")
                    firstnameEditText?.setText(user.firstname)
                    lastnameEditText?.setText(user.lastname)

                    //to upload a photo on Firebase storage
                    if(user.photoUrl!=null){
                        urlPicture=user.photoUrl
                        profilPhoto?.let {
                            Glide.with(mContext)
                                .load(user.photoUrl)
                                .apply(RequestOptions.circleCropTransform())
                                .placeholder(R.drawable.ic_anon_user_48dp)
                                .into(it)
                        }
                    }else{
                        profilPhoto?.let {
                            Glide.with(mContext)
                                .load(R.drawable.ic_anon_user_48dp)
                                .apply(RequestOptions.circleCropTransform())
                                .placeholder(R.drawable.ic_anon_user_48dp)
                                .into(it)
                        }
                    }

                }
            }
        }?.addOnFailureListener { e ->
            Log.e(
                "debago",
                "Problem during the user creation"
            )
        }
    }

    // --------------
    // AGENT
    // --------------
    private fun updateProfile() {
           if (firstnameEditText?.text.toString().isEmpty()) {
               firstnameEditText?.error = getString(R.string.set_error_firstname)
           } else if (lastnameEditText!!.text.toString().isEmpty()) {
            lastnameEditText!!.error = getString(R.string.set_error_lastname)
        } else {
            val firstname = firstnameEditText?.text.toString()
            val lastname = lastnameEditText?.text.toString()

            if (uid != null) {
                //update agent in firebase
                UserHelper.updateFirstname(firstname, uid)
                UserHelper.updateLastname(lastname, uid)
                UserHelper.updatePhotoUrl(urlPicture, uid)
            }


            //to upload a photo on Firebase storage
            if (urlPicture != null) {
                val storageHelper = StorageHelper()
                storageHelper.uploadFromUri(
                    Uri.parse(urlPicture),
                    FirebaseAuth.getInstance().currentUser?.uid,
                    getString(R.string.type_storage_users)
                )
            }

               Toast.makeText(
                   activity,
                   getString(R.string.toast_updated_profil),
                   Toast.LENGTH_LONG
               ).show()

            //to close the dialog
            if (dialog != null) {
                dialog!!.dismiss()
            }
        }
    }

    private fun fillUserData() {

        /**   firstnameEditText.setText(realEstateAgents.getFirstname())
        lastnameEditText.setText(realEstateAgents.getLastname())
        urlPicture = realEstateAgents.getUrlPicture()
        // showImageInCircle(realEstateAgents.getUrlPicture());
        showImage(realEstateAgents.getUrlPicture())*/

    }
    // --------------
    // TAKE A PICTURE
    // --------------
    /**
     * Alert dialog for capture or select from galley
     */
    private fun selectImage() {
        val items = arrayOf<CharSequence>(
            getString(R.string.dialog_select_image_take_photo),
            App.resource()
                .getString(R.string.dialog_select_image_choose_from_library),
            App.resource().getString(R.string.dialog_select_image_cancel)
        )
        val builder =
            MaterialAlertDialogBuilder(activity)
        builder.setItems(
            items
        ) { dialog: DialogInterface, item: Int ->
            if (items[item] == App.instance?.resources
                    ?.getString(R.string.dialog_select_image_take_photo)
            ) {
               dispatchTakePictureIntentWithPermissionCheck()
            } else if (items[item] == getString(R.string.dialog_select_image_choose_from_library)) {
                dispatchGalleryIntentWithPermissionCheck()
            } else if (items[item] == getString(R.string.dialog_select_image_cancel)) {
                dialog.dismiss()
            }
        }
        builder.show()
    }

    /**
     * Capture image from camera
     */
    @NeedsPermission(Manifest.permission.CAMERA)
    fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (mContext != null) {
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
                        mContext, BuildConfig.APPLICATION_ID.toString() + ".fileprovider",
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
    }

    /**
     * Select image fro gallery
     */
    @NeedsPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
    fun dispatchGalleryIntent() {
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
            profilPhoto?.let {
                Glide.with(mContext)
                    .load(File(fileUri.path))
                    .apply(RequestOptions.circleCropTransform())
                    .placeholder(R.drawable.ic_anon_user_48dp)
                    .into(it)
            }
        }
    }


    // --------------
    // PERMISSION
    // --------------
    override fun onRequestPermissionsResult(rc: Int, permissions: Array<out String>, results: IntArray) {
        // Java: "MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, rc, results);"
        // I'm not satisfied with the method signature here, since it's too similar to the Android one.
        // However, the signature is already pretty long, so I'm open for ideas.
        this.onRequestPermissionsResult(rc, results)
    }


}