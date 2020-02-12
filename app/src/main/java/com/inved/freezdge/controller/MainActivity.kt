package com.inved.freezdge.controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.inved.freezdge.R
import com.inved.freezdge.model.RecipeModel

class MainActivity : AppCompatActivity() {

    private lateinit var recipeModel:RecipeModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
    }

    fun initViewModel() {
        recipeModel = ViewModelProviders.of(this).get(RecipeModel::class.java)
        getAllRecipes("chicken")

    }

    fun getAllRecipes(ingredients:String){
        recipeModel.getRecipes(ingredients)
    }

}
