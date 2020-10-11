package com.inved.freezdge.ingredientslist.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.inved.freezdge.R
import com.inved.freezdge.databinding.ActivityMyGroceryListBinding
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.injection.Injection
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import com.inved.freezdge.uiGeneral.activity.MainActivity
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.ChipUtil
import com.inved.freezdge.utils.Domain
import kotlinx.android.synthetic.main.fragment_my_ingredients_list.*

class MyGroceryListActivity: BaseActivity() {

    private lateinit var binding: ActivityMyGroceryListBinding
    private lateinit var ingredientsViewmodel: IngredientsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbarBaseActivity(R.string.toolbar_grocery_list)
       initViewModel()
        setupChips()
    }

    private fun initViewModel() {
        val viewModelFactory = Injection.providesViewModelFactory(App.ObjectBox.boxStore)
        ingredientsViewmodel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(IngredientsViewModel::class.java)
    }

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_my_grocery_list
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("BACKPRESS", 0)
        startActivity(intent)
    }

    // configure chip with ingredient name, color
    private fun setupChips() {
        ingredientsViewmodel.getIngredientsForGrocery()
            .observe(this, Observer { result ->
                if (result != null) {
                    if (result.size != 0) {
                        not_found.visibility = View.GONE
                        chipGroup.removeAllViews()
                        for (myresult in result) {
                            val chip = Chip(chipGroup.context)
                            val chipDrawable = ChipDrawable.createFromAttributes(
                                chipGroup.context,
                                null,
                                0,
                                R.style.Widget_MaterialComponents_Chip_Entry
                            )
                            chip.setChipDrawable(chipDrawable)
                            chip.text = myresult.name
                            val chipUtil = ChipUtil()
                            chipUtil.handleChipColor(myresult, chip, App.applicationContext())
                            chip.closeIcon = applicationContext?.let {
                                ContextCompat.getDrawable(
                                    applicationContext as Context,
                                    R.drawable.ic_clear_grey_24dp
                                )
                            }
                            // Set chip close icon click listener
                            chip.setOnCloseIconClickListener {
                                launchAlertDialog(chipGroup,chip)
                            }
                            chip.isClickable = true
                            chipGroup.addView(chip)
                        }
                    } else {
                        not_found.visibility = View.VISIBLE
                        not_found.text = getString(R.string.no_item_found_grocery)
                    }
                }
            })
    }

    // when we want to delete a ingredient from grocery list, a dialog is launch before delete,and
    // if yes the ingredient is added in ingredient list and delete from grocery list
    private fun launchAlertDialog(chipFromGroup: ChipGroup,chip:Chip) {
        val builder = MaterialAlertDialogBuilder(this)
        builder.setTitle(getString(R.string.menu_grocery_list))
        if(chipFromGroup.checkedChipIds.size==0){
            builder.setMessage(getString(R.string.dialog_question_grocery))
        }else{
            builder.setMessage(getString(R.string.dialog_question_grocery_multiple_ingredients))
        }

        val chipgroupText :ArrayList<String> = arrayListOf()

        val ids = chipFromGroup.checkedChipIds
        for (id in ids) {
            val chipFromGroup: Chip = chipGroup.findViewById(id)
            chipgroupText.add(chipFromGroup.text.toString())
        }
        var removedIngredients : String?=null
        removedIngredients = if(chipgroupText.isNullOrEmpty()){
            chip.text.toString()
        }else{
            Domain().retrieveStringFromListString(chipgroupText)
        }


        builder.setPositiveButton(getString(R.string.Yes)) { _, _ ->
            Toast.makeText(
                applicationContext,
                getString(R.string.grocery_list_removed, removedIngredients), Toast.LENGTH_SHORT
            ).show()

            chipgroupText.forEach {
                ingredientsViewmodel.updateIngredientSelectedByName(it, true)
                ingredientsViewmodel.updateIngredientSelectedForGroceryByName(
                    it,
                    false
                )
            }
            TransitionManager.beginDelayedTransition(chipGroup)
            if(ids.size==0){
                chipGroup.removeView(chipFromGroup)
            }else{
                for (id in ids) {
                    val chip: Chip = chipGroup.findViewById(id)
                    chipGroup.removeView(chip)
                }
            }

        }

        builder.setNegativeButton(android.R.string.no) { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }
}