package com.inved.freezdge.recipes.ui

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.inved.freezdge.R

class WebviewActivity : AppCompatActivity() {

    private lateinit var webview:WebView

    private fun cardViewClick(url:String) {
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
        val url:String? = intent.getStringExtra("WEBVIEW_URL")
        val url2 = url?.replace("http://","https://")
        url2?.let { cardViewClick(it) }
    }
}
