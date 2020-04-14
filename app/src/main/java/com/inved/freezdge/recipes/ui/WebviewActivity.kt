package com.inved.freezdge.recipes.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.inved.freezdge.R
import com.inved.freezdge.recipes.view.ViewHolder

class WebviewActivity : AppCompatActivity() {

    private lateinit var webview:WebView

    fun cardViewClick(url:String) {
        Log.d("debago","in on cardview webactivity")
        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webview.loadUrl(url)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        webview=findViewById(R.id.webview)
        val url:String = intent.getStringExtra("WEBVIEW_URL")
        cardViewClick(url)
        Log.d("debago","in on create webactivity")
    }
}
