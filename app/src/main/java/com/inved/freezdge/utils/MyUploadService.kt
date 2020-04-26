package com.inved.freezdge.utils

import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.os.IBinder
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.inved.freezdge.socialmedia.firebase.UserHelper
import java.io.File

class MyUploadService: Service() {

    companion object{
        /**
         * Intent Actions
         */
        const val ACTION_UPLOAD = "action_upload"
        const val UPLOAD_COMPLETED = "upload_completed"
        const val UPLOAD_ERROR = "upload_error"

        /**
         * Intent Extras
         */
        const val EXTRA_FILE_URI = "extra_file_uri"
        const val EXTRA_DOCUMENT_ID = "extra_document_id"
        const val EXTRA_TYPE_ID = "extra_type_id"
        const val EXTRA_DOWNLOAD_URL = "extra_download_url"

        // [START declare_ref]
        private var mStorageRef: StorageReference? = null
        // [END declare_ref]

        // [END declare_ref]
        fun onBind(intent: Intent?): IBinder? {
            return null
        }

        fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
            //Log.d(TAG, "onStartCommand:" + intent + ":" + startId);
            if (ACTION_UPLOAD == intent.action) {
                val fileUri =
                    intent.getParcelableExtra<Uri>(EXTRA_FILE_URI)
                val documentId = intent.getStringExtra(EXTRA_DOCUMENT_ID)
                val type = intent.getStringExtra(EXTRA_TYPE_ID)
                mStorageRef = FirebaseStorage.getInstance().getReference(documentId)
                uploadFromUri(fileUri, documentId,type)
            }
            return START_REDELIVER_INTENT
        }

        // [START upload_from_uri]
        private fun uploadFromUri(
            fileUri: Uri,
            documentId: String,
            type:String
        ) {

            // [START get_child_ref]
            // Get a reference to store file at photos/<FILENAME>.jpg
            if (fileUri.lastPathSegment != null) {
                val photoRef: StorageReference? = mStorageRef?.child(type)

                val downloadURL = fileUri.lastPathSegment
                UserHelper.updatePhotoUrl(downloadURL, documentId)

                //File from external
                val imageCameraOrGallery = ImageCameraOrGallery()
                val localFile =
                    Uri.fromFile(File(fileUri.toString()))
                val fileExternal = imageCameraOrGallery.getFile(
                    App.applicationContext(), localFile
                ) //file external

                //File from internal
                val storageDir: File? = App.applicationContext()
                    .getExternalFilesDir(Environment.DIRECTORY_PICTURES)
                val mFileName = "/" + fileExternal!!.name
                val fileInternal = File(storageDir, mFileName) //file internal
                if (fileInternal.exists()) {
                    photoRef?.let { uploadInternalFile(it, fileUri) }
                } else if (fileExternal.exists()) {
                    //uploadExternalFile(photoRef, fileExternal)
                }
            }
        }

        private fun uploadInternalFile(
            photoRef: StorageReference,
            internalFile: Uri
        ) {
            // Upload file to Firebase Storage
            //Log.d(TAG, "uploadFromUri:dst:" + photoRef.getPath());
            photoRef.putFile(internalFile)
                .continueWithTask { task ->
                    // Forward any exceptions
                    if (!task.isSuccessful()) {
                        if (task.getException() != null) {
                            throw task.exception!!
                        }
                    }
                    photoRef.getDownloadUrl()
                }
                .addOnSuccessListener({ downloadUri -> })
                .addOnFailureListener({ exception -> })
        }

    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

}