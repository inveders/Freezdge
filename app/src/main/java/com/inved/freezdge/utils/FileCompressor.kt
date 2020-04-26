package com.inved.freezdge.utils

import android.graphics.Bitmap.CompressFormat
import android.os.Environment
import java.io.File
import java.io.IOException

class FileCompressor {

    companion object{
        private val compressFormat = CompressFormat.JPEG
        private const val mFileName = "/"
        private val storageDir: File? = App.instance?.applicationContext?.getExternalFilesDir(Environment.DIRECTORY_PICTURES)

        @Throws(IOException::class)
        fun compressToFile(imageFile: File?): File? {
            return imageFile?.name?.let { compressToFile(imageFile, it) }
        }

        @Throws(IOException::class)
        private fun compressToFile(
            imageFile: File?,
            compressedFileName: String
        ): File? {
            val quality = 80
            val maxHeight = 816
            //max width and height values of the compressed image is taken as 612x816
            val maxWidth = 612
            return ImageUtil.compressImage(
                imageFile, maxWidth, maxHeight, compressFormat, quality,
                "file://$storageDir$mFileName" + File.separator + compressedFileName
            )
        }
    }



}