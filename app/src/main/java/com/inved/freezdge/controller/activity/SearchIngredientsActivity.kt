package com.inved.freezdge.controller.activity

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.inved.freezdge.R

class SearchIngredientsActivity:BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initToolbarBaseActivity(R.string.toolbar_search_ingredients)
        getAllFood("apple")
    }

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_search_ingredients
    }


    override fun onSupportNavigateUp() = true.also { onBackPressed() }

    //DATA
    fun getAllFood(ingredients: String) {
        recipeModel.getFood(ingredients)
            .observe(this, Observer { result ->
                Log.d(
                    "debago",
                    "le premier food est : ${result.parsed?.get(0)?.food?.label}"
                )
               // recipesItemAdapter.add(result.hits)
            })
    }

}