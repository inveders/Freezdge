package com.inved.freezdge.controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inved.freezdge.R
import com.inved.freezdge.model.RecipeModel

class MainActivity : AppCompatActivity() {

    private var recipeModel: RecipeModel()
    /**INIT WITH APPLICATION or remove it from viex model**/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
    }

    fun initViewModel() {
        recipeModel = ViewModelProviders.of(this).get(RecipeModel::class.java)


    }

    fun getAllRecipes(ingredients:String){
        recipeModel.getRecipes(ingredients)
    }

}
