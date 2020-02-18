package com.inved.freezdge.controller.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.inved.freezdge.R


abstract class BaseActivity:AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutContentViewID());


    }

    protected abstract fun getLayoutContentViewID(): Int

    protected fun initToolbarBaseActivity(id:Int){

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(id)

    }
}