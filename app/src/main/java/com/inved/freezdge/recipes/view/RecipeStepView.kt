package com.inved.freezdge.recipes.view

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.inved.freezdge.R
import com.inved.freezdge.utils.App

class RecipeStepView(context: Context?) : ConstraintLayout(App.appContext) {

    private lateinit var itemNameTextView: TextView

    fun init() {
        View.inflate(context, R.layout.item_recipe_steps, this)
        itemNameTextView=findViewById(R.id.itemNameTextView)
    }

    // view to add each ingredient on the recipe detail page (under the expandable list)
    fun setText(itemName: String?) {
        itemNameTextView.text = itemName
    }

}