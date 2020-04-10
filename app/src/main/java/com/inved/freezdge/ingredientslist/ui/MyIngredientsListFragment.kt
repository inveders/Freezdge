package com.inved.freezdge.ingredientslist.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.chip.Chip
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

    private fun setupChips() {
        ingredientsViewmodel.getIngredientsForFreezdgeList()
            .observe(viewLifecycleOwner, Observer { result ->
                if(result!=null){
                    for (myresult in result){
                        val chip= Chip(chipGroup.context)
                        chip.text=myresult.name
                        chip.isClickable=true
                        chip.isCheckable=true
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