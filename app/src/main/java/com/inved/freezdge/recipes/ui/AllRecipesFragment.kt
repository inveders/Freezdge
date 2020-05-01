package com.inved.freezdge.recipes.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.inved.freezdge.R
import com.inved.freezdge.uiGeneral.fragment.BaseFragment

class AllRecipesFragment: BaseFragment(){


    override fun getLayoutRes(): Int {
        return R.layout.fragment_all_recipes
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("debago","on create 1")
       /*
        Handler().postDelayed({
            //start main activity
            animation_view_container?.visibility=View.GONE
        },4000)*/
        return super.onCreateView(inflater, container, savedInstanceState)

    }






}