package com.inved.freezdge.uiGeneral.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.inved.freezdge.BuildConfig
import com.inved.freezdge.R
import kotlinx.android.synthetic.main.activity_main.*

class SplashScreenActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)
        //making this activity full screen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_screen)
        appVersion.text = getString(R.string.app_version, BuildConfig.VERSION_NAME)
        //4 second splash time
        Handler().postDelayed({
            //start main activity
            startActivity(Intent(this, LoginActivity::class.java))
            //finish this activity
            finish()
        },3000)
    }
}