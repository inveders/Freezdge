package com.inved.freezdge.controller.activity

import android.os.Bundle
import com.inved.freezdge.R

class MyGroceryListActivity:BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbarBaseActivity(R.string.toolbar_grocery_list)
    }

    override fun getLayoutContentViewID(): Int {
        return R.layout.my_grocery_list_activity
    }

    override fun onSupportNavigateUp() = true.also { onBackPressed() }
}