package com.inved.freezdge.controller.activity

import android.os.Bundle
import com.inved.freezdge.R

class SearchIngredientsActivity:BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initToolbarBaseActivity(R.string.toolbar_search_ingredients)
    }

    override fun getLayoutContentViewID(): Int {
        return R.layout.search_ingredients_activity
    }


    override fun onSupportNavigateUp() = true.also { onBackPressed() }

}