package com.inved.freezdge.recipes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.inved.freezdge.R
import com.inved.freezdge.recipes.view.ViewHolder

class WebviewActivity : AppCompatActivity(),
    ViewHolder.ItemClikInterface  {

    private val webview:WebView=findViewById(R.id.webview)

    override fun favouriteClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun cardViewClick(url:String) {
        webview.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        webview.loadUrl("https://www.google.co.in/")
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
    }
}
