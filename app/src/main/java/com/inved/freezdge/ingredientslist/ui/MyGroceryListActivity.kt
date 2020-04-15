package com.inved.freezdge.ingredientslist.ui

import android.content.Context
import android.os.Bundle
import android.transition.TransitionManager
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import io.objectbox.BoxStore.context

class MyGroceryListActivity: BaseActivity() {

    private lateinit var ingredientsViewmodel: IngredientsViewModel
    private lateinit var chipGroup: ChipGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbarBaseActivity(R.string.toolbar_grocery_list)
        chipGroup =findViewById(R.id.chipGroup)
        ingredientsViewmodel =
            ViewModelProviders.of(this).get(IngredientsViewModel::class.java)
        setupChips()

    }

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_my_grocery_list
    }

    override fun onSupportNavigateUp() = true.also { onBackPressed() }

    private fun setupChips() {

        ingredientsViewmodel.getIngredientsForGrocery()
            .observe(this, Observer { result ->
                if(result!=null){
                    chipGroup.removeAllViews()
                    for (myresult in result){
                        val chip= Chip(chipGroup.context)
                        val chipDrawable = ChipDrawable.createFromAttributes(
                            chipGroup.context,
                            null,
                            0,
                            R.style.Widget_MaterialComponents_Chip_Entry
                        )
                        chip.setChipDrawable(chipDrawable)
                        chip.text=myresult.name
                        chip.closeIcon=context?.let {
                            ContextCompat.getDrawable(context as Context,R.drawable.ic_clear_grey_24dp) }
                        // Set chip close icon click listener
                        chip.setOnCloseIconClickListener{
                            // Smoothly remove chip from chip group
                            ingredientsViewmodel.updateIngredientSelectedByName(myresult.name)
                            TransitionManager.beginDelayedTransition(chipGroup)
                            chipGroup.removeView(chip)
                        }
                        chip.isClickable=true
                        chipGroup.addView(chip)
                    }
                }

            })
    }
}