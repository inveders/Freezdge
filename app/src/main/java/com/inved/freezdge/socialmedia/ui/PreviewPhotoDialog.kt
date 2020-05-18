package com.inved.freezdge.socialmedia.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import com.inved.freezdge.R
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.GlideApp


class PreviewPhotoDialog : DialogFragment() {

    companion object {

        //final values
        const val TAG = "PREVIEW"
        private const val KEY_PREVIEW = "preview_photo"

        // to pass image url in tis dialog
        @JvmStatic
        fun newInstance(param1: String) =
            PreviewPhotoDialog().apply {
                arguments = Bundle().apply {
                    putString(KEY_PREVIEW, param1)
                }
            }
    }

    //UI
    private var profilPhoto: ImageView? = null
    private lateinit var mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =
            inflater.inflate(R.layout.dialog_image, container, false)
        mContext = App.applicationContext()

        profilPhoto = view.findViewById(R.id.your_image)
        val postImage = arguments?.getString(KEY_PREVIEW, null)

        fillDialog(postImage)
        return view
    }

    // fill the dialog with the image we click on
    private fun fillDialog(postImage:String?) {
        profilPhoto?.let {
            GlideApp.with(App.applicationContext())
                .load(postImage)
                .into(it)
        }
    }

}