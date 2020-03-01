package com.inved.freezdge.controller.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.inved.freezdge.R
import com.inved.freezdge.model.RecipeModel


abstract class BaseActivity:AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    //Network call
    lateinit var recipeModel: RecipeModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutContentViewID())
        initViewModel()


    }

    protected abstract fun getLayoutContentViewID(): Int

    protected fun initToolbarBaseActivity(id:Int){

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(id)

    }

    //INITIALIZATION
    private fun initViewModel() {
        recipeModel = ViewModelProviders.of(this).get(RecipeModel::class.java)

    }
}