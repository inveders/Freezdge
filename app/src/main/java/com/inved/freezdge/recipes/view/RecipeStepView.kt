package com.inved.freezdge.recipes.view

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.inved.freezdge.R
import com.inved.freezdge.uiGeneral.fragment.BaseFragment

class RecipeStepView(context: Context?) : ConstraintLayout(context) {

    lateinit var itemNameTextView: TextView

    open fun init() {
        View.inflate(context, R.layout.item_recipe_steps, this)
        itemNameTextView=findViewById(R.id.itemNameTextView)
    }

    open fun setText(itemName: String?) {
        itemNameTextView.text = itemName
    }

}