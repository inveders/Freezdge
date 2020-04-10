package com.inved.freezdge.ingredientslist.ui

import android.os.Bundle
import com.inved.freezdge.R
import com.inved.freezdge.uiGeneral.activity.BaseActivity

class MyGroceryListActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbarBaseActivity(R.string.toolbar_grocery_list)
    }

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_my_grocery_list
    }

    override fun onSupportNavigateUp() = true.also { onBackPressed() }
}