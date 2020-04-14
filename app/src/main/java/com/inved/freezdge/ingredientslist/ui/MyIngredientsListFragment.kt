package com.inved.freezdge.ingredientslist.ui

import android.content.Intent
import android.os.Bundle
import android.transition.TransitionManager
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.uiGeneral.fragment.BaseFragment
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter


class MyIngredientsListFragment: BaseFragment() {

    private val foodSearchItemAdapter = ItemAdapter<Ingredients>()
    private val fastAdapterFoodSearch = FastAdapter.with(foodSearchItemAdapter)
    private lateinit var ingredientsViewmodel: IngredientsViewModel
    override fun getLayoutRes(): Int {
        return R.layout.fragment_my_ingredients_list
    }

    private lateinit var floatingActionButton:FloatingActionButton
    private lateinit var chipGroup: ChipGroup

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        floatingActionButton =view.findViewById(R.id.fragment_ingredient_list_floating_button)
        chipGroup =view.findViewById(R.id.chipGroup)
        floatingActionButton.setOnClickListener{v -> openSearchIngredientActivity() }
        ingredientsViewmodel =
            ViewModelProviders.of(this).get(IngredientsViewModel::class.java)
        setupChips()
    }

    override fun onResume() {
        super.onResume()
        setupChips()
    }

    private fun setupChips() {

        ingredientsViewmodel.getIngredientsForFreezdgeList()
            .observe(viewLifecycleOwner, Observer { result ->
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
                            Log.d("debago","in close icon inti")
                            ContextCompat.getDrawable(it,R.drawable.ic_clear_grey_24dp) }
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

    fun openSearchIngredientActivity(){
        activity?.let{
            val intent = Intent (it, SearchIngredientsActivity::class.java)
            it.startActivity(intent)
        }
    }
}