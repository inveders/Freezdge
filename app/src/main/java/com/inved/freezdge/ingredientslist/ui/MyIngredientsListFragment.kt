package com.inved.freezdge.ingredientslist.ui

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.inved.freezdge.R
import com.inved.freezdge.favourites.viewmodel.FavouritesRecipesViewModel
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.uiGeneral.fragment.BaseFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async


class MyIngredientsListFragment : BaseFragment() {

    private lateinit var ingredientsViewmodel: IngredientsViewModel
    private lateinit var favouritesRecipesViewmodel: FavouritesRecipesViewModel
    override fun getLayoutRes(): Int {
        return R.layout.fragment_my_ingredients_list
    }

    private lateinit var floatingActionButton: FloatingActionButton
    private lateinit var chipGroup: ChipGroup

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        floatingActionButton = view.findViewById(R.id.fragment_ingredient_list_floating_button)
        chipGroup = view.findViewById(R.id.chipGroup)
        floatingActionButton.setOnClickListener { _ -> openSearchIngredientActivity() }
        ingredientsViewmodel =
            ViewModelProviders.of(this).get(IngredientsViewModel::class.java)
        favouritesRecipesViewmodel =
            ViewModelProviders.of(this).get(FavouritesRecipesViewModel::class.java)
        setupChips()
    }

    override fun onResume() {
        super.onResume()
        setupChips()
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        val searchItem = menu.findItem(R.id.search_menu)
        searchItem.isVisible = false
        super.onPrepareOptionsMenu(menu)
    }

    private fun setupChips() {

        val result:MutableList<Ingredients> = ingredientsViewmodel.getIngredientsForFreezdgeList()

                if (result != null) {
                    if (result.size != 0) {
                        notFoundTeextView.visibility = View.GONE
                        notFoundImageView.visibility = View.GONE
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
                            handleChipColor(myresult,chip)
                            chip.closeIcon = context?.let {
                                ContextCompat.getDrawable(it, R.drawable.ic_clear_grey_24dp)
                            }
                            // Set chip close icon click listener
                            chip.setOnCloseIconClickListener {
                                // Smoothly remove chip from chip group
                                GlobalScope.async(Dispatchers.IO) {
                                    ingredientsViewmodel.updateIngredientSelectedByName(
                                        myresult.name,
                                        false
                                    )
                                    myresult.name?.let { it1 ->
                                        myresult.nameEnglish?.let { it2 ->
                                            favouritesRecipesViewmodel.isIngredientPresentInFavoriteRecipeUpdateGrocery(
                                                it1, it2
                                            )
                                        }
                                    }
                                }
                                chipGroup.removeView(chip)
                                setlistRetrofit.clear()
                            }
                            chipGroup.addView(chip)
                        }
                    } else {
                        notFoundTeextView.visibility = View.VISIBLE
                        notFoundImageView.visibility = View.VISIBLE
                        notFoundTeextView.text = getString(R.string.no_item_found_ingredients)
                    }

                }


    }

    fun openSearchIngredientActivity() {
        activity?.let {
            val intent = Intent(it, SearchIngredientsActivity::class.java)
            it.startActivity(intent)
        }
    }

    fun handleChipColor(myresult:Ingredients,chip:Chip){
        if (myresult.typeIngredient.equals(getString(R.string.ingredient_type_cream))) {
            chip.chipBackgroundColor = context?.let {
                ContextCompat.getColor(
                    it, R.color.colorCream
                )
            }?.let { ColorStateList.valueOf(it) }
        }
        if (myresult.typeIngredient.equals(getString(R.string.ingredient_type_fruits_vegetables))) {
            chip.chipBackgroundColor = context?.let {
                ContextCompat.getColor(
                    it, R.color.colorVegetables
                )
            }?.let { ColorStateList.valueOf(it) }
        }
        if(myresult.typeIngredient.equals(getString(R.string.ingredient_type_epicerie))){
            chip.chipBackgroundColor = context?.let {
                ContextCompat.getColor(
                    it, R.color.colorEpicerie)
            }?.let { ColorStateList.valueOf(it) }
        }
        if(myresult.typeIngredient.equals(getString(R.string.ingredient_type_fish))){
            chip.chipBackgroundColor = context?.let {
                ContextCompat.getColor(
                    it, R.color.colorFish)
            }?.let { ColorStateList.valueOf(it) }
        }
        if(myresult.typeIngredient.equals(getString(R.string.ingredient_type_meat))){
            chip.chipBackgroundColor = context?.let {
                ContextCompat.getColor(
                    it, R.color.colorMeat)
            }?.let { ColorStateList.valueOf(it) }
        }

    }
}