package com.inved.freezdge.utils

import android.app.Service
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.os.Handler
import android.os.IBinder
import com.google.android.gms.tasks.Task
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import com.inved.freezdge.R
import com.inved.freezdge.socialmedia.firebase.PostHelper
import com.inved.freezdge.socialmedia.firebase.UserHelper
import java.io.File

class MyUploadService : Service() {

    // [START declare_ref]
    private var mStorageRef: StorageReference? = null

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        if (ACTION_UPLOAD == intent.action) {
            val fileUri =
                intent.getParcelableExtra<Uri>(EXTRA_FILE_URI)
            val documentId = intent.getStringExtra(EXTRA_DOCUMENT_ID)
            val type = intent.getStringExtra(EXTRA_TYPE_ID)
            if(documentId!=null)
            mStorageRef = FirebaseStorage.getInstance().getReference(documentId)
            uploadFromUri(fileUri, documentId, type)
        }
        return START_REDELIVER_INTENT
    }

    // [START upload_from_uri]
    private fun uploadFromUri(
        fileUri: Uri?,
        documentId: String?,
        type: String?
    ) {

        // [START get_child_ref]
        // Get a reference to store file at photos/<FILENAME>.jpg
        if (fileUri?.lastPathSegment != null) {
            val photoRef: StorageReference? = type?.let { mStorageRef?.child(it)?.child("$documentId.jpg") }

            //File from external
            val localFile =
                Uri.fromFile(File(fileUri.toString()))
            val fileExternal = FileUtils(App.appContext).getFile(
                localFile
            ) //file external

            //File from internal
            val storageDir: File? = App.applicationContext()
                .getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val mFileName = "/" + fileExternal?.name
            val fileInternal = File(storageDir, mFileName) //file internal
            if (fileInternal.exists()) {
                photoRef?.let { documentId?.let { it1 -> uploadInternalFile(it, fileUri, it1,type) } }
            } else if (fileExternal?.exists()==true) {
                photoRef?.let { documentId?.let { it1 ->
                    uploadExternalFile(it, fileExternal,
                        it1,type)
                } }
            }
        }
    }

    private fun uploadInternalFile(
        photoRef: StorageReference,
        internalFile: Uri,
        documentId: String,
        type: String
    ) {
        // Upload file to Firebase Storage
        //Log.d(TAG, "uploadFromUri:dst:" + photoRef.getPath());
        photoRef.putFile(internalFile)
            .continueWithTask { task ->
                // Forward any exceptions
                if (!task.isSuccessful) {
                    if (task.exception != null) {
                        throw task.exception!!
                    }
                }
                photoRef.downloadUrl
            }
            .addOnSuccessListener { downloadUri ->
                downloadUri.toString()
                if(type == App.resource().getString(R.string.type_storage_posts)){
                    PostHelper.updatePhotoUrl(downloadUri.toString(), documentId)
                }else if(type == App.resource().getString(R.string.type_storage_users)){
                    UserHelper.updatePhotoUrl(downloadUri.toString(), documentId)
                }

                //10 sec before deleting files
                Handler().postDelayed({
                   FileUtils(App.appContext).deleteFile(internalFile)
                },10000)
            }
            .addOnFailureListener { }
    }

    private fun uploadExternalFile(
        photoRef: StorageReference,
        externalFile: File?,
        documentId: String,
        type: String
    ) {
        photoRef.putFile(Uri.fromFile(externalFile))
            .continueWithTask { task: Task<UploadTask.TaskSnapshot?> ->
                // Forward any exceptions
                if (!task.isSuccessful) {
                    if (task.exception != null) {
                        throw task.exception!!
                    }
                }

                photoRef.downloadUrl
            }
            .addOnSuccessListener { downloadUri ->
                downloadUri.toString()
                if(type == App.resource().getString(R.string.type_storage_posts)){
                    PostHelper.updatePhotoUrl(downloadUri.toString(), documentId)
                }else if(type == App.resource().getString(R.string.type_storage_users)){
                    UserHelper.updatePhotoUrl(downloadUri.toString(), documentId)
                }

            }
            .addOnFailureListener { }
    }

    companion object {
        /**
         * Intent Actions
         */
        const val ACTION_UPLOAD = "action_upload"

        /**
         * Intent Extras
         */
        const val EXTRA_FILE_URI = "extra_file_uri"
        const val EXTRA_DOCUMENT_ID = "extra_document_id"
        const val EXTRA_TYPE_ID = "extra_type_id"
    }


}