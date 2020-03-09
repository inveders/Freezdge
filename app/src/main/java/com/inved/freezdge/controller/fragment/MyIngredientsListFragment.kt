package com.inved.freezdge.controller.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.inved.freezdge.R
import com.inved.freezdge.controller.activity.SearchIngredientsActivity

class MyIngredientsListFragment: BaseFragment() {
    override fun getLayoutRes(): Int {
        return R.layout.fragment_my_ingredients_list
    }

    private lateinit var floatingActionButton:FloatingActionButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        floatingActionButton =view.findViewById(R.id.fragment_ingredient_list_floating_button)
        floatingActionButton.setOnClickListener{v -> openSearchIngredientActivity() }
    }

    fun openSearchIngredientActivity(){
        activity?.let{
            val intent = Intent (it, SearchIngredientsActivity::class.java)
            it.startActivity(intent)
        }
    }
}