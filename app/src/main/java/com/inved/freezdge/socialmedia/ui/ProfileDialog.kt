package com.inved.freezdge.socialmedia.ui

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.FileProvider
import androidx.fragment.app.DialogFragment
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
class ProfileDialog : DialogFragment() {

    interface ChangePhotoListener {
        fun onPhotoChanged()
    }

    companion object {
        //final values
        private const val REQUEST_CAMERA_PHOTO = 457
        private const val REQUEST_GALLERY_PHOTO = 458
        private var photoListener: ChangePhotoListener? = null
        fun setChangePhotoListener(callback: ChangePhotoListener) {
            this.photoListener = callback
        }

        //final values
        const val TAG = "PROFIL"
        private const val KEY_PROFIL = "profil"
        private var uid: String? = null

        //To pass args to our dialog
        @JvmStatic
        fun newInstance(param1: String) =
            ProfileDialog().apply {
                arguments = Bundle().apply {
                    putString(KEY_PROFIL, param1)
                }
            }
    }

    //Photo
    private var urlPicture: String? = null
    private var cameraFilePath: String? = null
    private var fileUtils: FileUtils? = null

    //UI
    private var profilPhoto: ImageView? = null
    private var lastnameEditText: EditText? = null
    private var firstnameEditText: EditText? = null
    private var changePhotoText: TextView? = null
    private var addActionButton: ImageButton? = null
    private var cancelSearchButton: ImageButton? = null
    private var mPhotoFile: File? = null
    private lateinit var mContext: Context
    var domain = Domain()

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
            inflater.inflate(R.layout.dialog_update_profile, container, false)
        mContext = App.applicationContext()
        uid = FirebaseAuth.getInstance().currentUser?.uid
        fileUtils = FileUtils(mContext)
        profilPhoto = view.findViewById(R.id.profil_photo)
        changePhotoText =
            view.findViewById(R.id.change_profil_photo_text)
        lastnameEditText = view.findViewById(R.id.lastnameEdittext)
        firstnameEditText = view.findViewById(R.id.firstnameEdittext)
        addActionButton = view.findViewById(R.id.profil_add_dialog_validate)
        cancelSearchButton = view.findViewById(R.id.profil_add_dialog_close)
        initializeMethods()
        fillDialog()
        return view
    }

    private fun initializeMethods() {
        profilPhoto?.setOnClickListener { selectImage() }
        changePhotoText?.setOnClickListener { selectImage() }
        cancelSearchButton?.setOnClickListener {
            cancelSearchButton?.startAnimation(domain.animation())
            dialog?.dismiss()
        }
        addActionButton?.setOnClickListener {
            addActionButton?.startAnimation(domain.animation())
            updateProfile()
        }
    }


    // fill dialog with the user informations
    private fun fillDialog() {
        UserHelper.getUser(uid)?.get()?.addOnCompleteListener { task ->
            if (task.result != null) {
                if (task.result?.documents?.isNotEmpty() == true) {

                    val user: User? =
                        task.result!!.documents[0].toObject(User::class.java)

                    firstnameEditText?.setText(user?.firstname)
                    lastnameEditText?.setText(user?.lastname)

                    //to upload a photo on Firebase storage
                    if (user?.photoUrl != null) {
                        urlPicture = user.photoUrl
                    }
                    GlideUtils.loadPhotoWithGlideCircleCropUrl(user?.photoUrl, profilPhoto)
                }
            }
        }?.addOnFailureListener {
        }
    }

    //Check photo before update profile (after click on validate button)
    private fun updateProfile() {
        if (firstnameEditText?.text.toString().isEmpty()) {
            firstnameEditText?.error = getString(R.string.set_error_firstname)
        } else if (lastnameEditText?.text.toString().isEmpty()) {
            lastnameEditText?.error = getString(R.string.set_error_lastname)
        } else {
            val firstname = firstnameEditText?.text.toString()
            val lastname = lastnameEditText?.text.toString()

            //update post in firebase
            UserHelper.updateFirstname(firstname, uid)
            UserHelper.updateLastname(lastname, uid)
            UserHelper.updatePhotoUrl(urlPicture, uid)

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
                dialog?.dismiss()
                photoListener?.onPhotoChanged()
            }
        }
    }

    // --------------
    // TAKE A PICTURE
    // --------------
    //Alert dialog for capture or select from galley

    private fun selectImage() {
        val items = arrayOf<CharSequence>(
            getString(R.string.dialog_select_image_take_photo),
            App.resource()
                .getString(R.string.dialog_select_image_choose_from_library),
            App.resource().getString(R.string.dialog_select_image_cancel)
        )
        val builder =
            context?.let { MaterialAlertDialogBuilder(it) }
        builder?.setItems(
            items
        ) { dialog: DialogInterface, item: Int ->
            when {
                items[item] == App.resource()
                    .getString(R.string.dialog_select_image_take_photo)
                -> {
                    dispatchTakePictureIntentWithPermissionCheck()
                }
                items[item] == getString(R.string.dialog_select_image_choose_from_library) -> {
                    dispatchGalleryIntentWithPermissionCheck()
                }
                items[item] == getString(R.string.dialog_select_image_cancel) -> {
                    dialog.dismiss()
                }
            }
        }
        builder?.show()
    }

    // Capture image from camera

    @NeedsPermission(Manifest.permission.CAMERA)
    fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(mContext.packageManager) != null) {
            // Create the File where the photo should go
            var photoFile: File? = null
            try {
                photoFile = fileUtils?.createImageFile()
                cameraFilePath = photoFile?.let { fileUtils?.getCameraFilePath(it) }
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

    //Select image fro gallery

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
                    val selectedImage = data?.data
                    try {
                        if (selectedImage != null) {
                            fileUtils?.getPath(selectedImage).let {
                                if (!it.isNullOrEmpty()) {
                                    mPhotoFile = FileCompressor.compressToFile(
                                        File(
                                            it
                                        )
                                    )
                                }
                            }
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                    if (selectedImage != null) {
                        urlPicture = fileUtils?.getPath(selectedImage)
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
            GlideUtils.loadPhotoWithGlideCircleCropUrl(photoStringFromRoom, profilPhoto)
        }
    }


    // --------------
    // PERMISSION
    // --------------
    override fun onRequestPermissionsResult(
        rc: Int,
        permissions: Array<out String>,
        results: IntArray
    ) {
        // Java: "MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, rc, results);"
        this.onRequestPermissionsResult(rc, results)
    }

}