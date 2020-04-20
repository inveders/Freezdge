package com.inved.freezdge.uiGeneral.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.inved.freezdge.R
import com.inved.freezdge.recipes.viewmodel.RecipeModel
import kotlinx.android.synthetic.main.activity_recipe_detail.*


abstract class BaseActivity:AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    //Viewmodel
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
        toolbar.setNavigationOnClickListener { onBackPressed() }

    }

    //INITIALIZATION
    private fun initViewModel() {
        recipeModel = ViewModelProviders.of(this).get(RecipeModel::class.java)

    }
}