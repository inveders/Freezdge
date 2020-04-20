package com.inved.freezdge.recipes.view

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.inved.freezdge.R

class RecipeStepView(context: Context?) : ConstraintLayout(context) {

    @BindView(R.id.itemNameTextView)
    var itemNameTextView: TextView? = null

    open fun init() {
        View.inflate(context, R.layout.item_recipe_steps, this)
        ButterKnife.bind(this)
    }

    open fun setText(itemName: String?) {
        itemNameTextView!!.text = itemName
    }


}