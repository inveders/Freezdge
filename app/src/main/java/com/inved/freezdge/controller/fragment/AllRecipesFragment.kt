package com.inved.freezdge.controller.fragment

import android.os.Bundle
import com.inved.freezdge.R

class AllRecipesFragment:BaseFragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.getAllRecipes("chicken")
    }

    override fun getLayoutRes(): Int {
        return R.layout.all_recipes_fragment
    }
}