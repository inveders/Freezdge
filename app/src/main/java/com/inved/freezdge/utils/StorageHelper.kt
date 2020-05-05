package com.inved.freezdge.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.Uri

class StorageHelper: BroadcastReceiver() {
    private val ctx: Context = App.applicationContext()

    fun uploadFromUri(
        fileUri: Uri?,
        documentId: String?,
        type: String?
    ) {

        // Start MyUploadService to upload the file, so that the file is uploaded
        // even if this Activity is killed or put in the background
        ctx.startService(
            Intent(ctx, MyUploadService::class.java)
                .putExtra(MyUploadService.EXTRA_FILE_URI, fileUri)
                .putExtra(MyUploadService.EXTRA_DOCUMENT_ID, documentId)
                .putExtra(MyUploadService.EXTRA_TYPE_ID, type)
                .setAction(MyUploadService.ACTION_UPLOAD)
        )
    }

    override fun onReceive(context: Context?, intent: Intent?) {}
}