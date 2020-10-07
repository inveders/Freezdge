package com.inved.freezdge.ingredientslist.ui

import android.content.Intent
import android.os.Bundle
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.inved.freezdge.R
import com.inved.freezdge.databinding.ActivityMainBinding
import com.inved.freezdge.databinding.FragmentMyIngredientsListBinding
import com.inved.freezdge.favourites.viewmodel.FavouritesRecipesViewModel
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.uiGeneral.fragment.BaseFragment
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.ChipUtil
import com.inved.freezdge.utils.Domain
import kotlinx.android.synthetic.main.fragment_my_ingredients_list.*
import kotlinx.android.synthetic.main.fragment_my_recipes.*
import kotlinx.android.synthetic.main.fragment_my_recipes.floatingActionButton
import kotlinx.android.synthetic.main.fragment_my_recipes.not_found
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MyIngredientsListFragment : BaseFragment<FragmentMyIngredientsListBinding, ActivityMainBinding>() {

    private lateinit var ingredientsViewmodel: IngredientsViewModel
    private lateinit var favouritesRecipesViewmodel: FavouritesRecipesViewModel
    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMyIngredientsListBinding {
        return FragmentMyIngredientsListBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        floatingActionButton.setOnClickListener { openSearchIngredientActivity() }
        ingredientsViewmodel =
            ViewModelProviders.of(this).get(IngredientsViewModel::class.java)
        favouritesRecipesViewmodel =
            ViewModelProviders.of(this).get(FavouritesRecipesViewModel::class.java)
        setupChips()
        setHasOptionsMenu(true)
    }

    override fun onResume() {
        super.onResume()
        setupChips()
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        val searchItem = menu.findItem(R.id.searchItem)
        searchItem.isVisible = false
        val clearIngredientItem = menu.findItem(R.id.clearIngredientItem)
        val likeItem = menu.findItem(R.id.likeItem)
        likeItem.isVisible = false
        val result: MutableList<Ingredients>? = ingredientsViewmodel.getIngredientsForFreezdgeList()
        clearIngredientItem.isVisible = result?.size != 0

        clearIngredientItem.setOnMenuItemClickListener {
            launchAlertDialog()
            true
        }
        super.onPrepareOptionsMenu(menu)
    }

    // if there is no ingredient change UI to show text, if there is ingredient, show chips
    private fun setupChips() {

        val result: MutableList<Ingredients>? = ingredientsViewmodel.getIngredientsForFreezdgeList()

        if (result?.size != 0) {
            not_found.visibility = View.GONE
            imageArrowIng.visibility = View.GONE
            chipGroup.removeAllViews()
            if (result != null) {
                handleChip(result)
            }

        } else {
            not_found.visibility = View.VISIBLE
            imageArrowIng.visibility = View.VISIBLE
            not_found.text = getString(R.string.no_item_found_ingredients)
        }

    }

    // configure chip with ingredient name, color
    private fun handleChip(result: MutableList<Ingredients>) {
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
            chip.closeIcon = context?.let {
                ContextCompat.getDrawable(it, R.drawable.ic_clear_grey_24dp)
            }
            // Set chip close icon click listener
            chip.setOnCloseIconClickListener {

                val ids = chipGroup.checkedChipIds
                if(ids.size==0){
                    removeChip(chip)
                }else{
                    for (id in ids) {
                        val chipFromGroup: Chip = chipGroup.findViewById(id)
                        removeChip(chipFromGroup)
                    }
                }

                setlistDatabase.clear()
            }
            setlistDatabase.clear()
            chipGroup.addView(chip)
        }
    }

    fun removeChip(chip:Chip){
        GlobalScope.launch(Dispatchers.IO) {
            ingredientsViewmodel.updateIngredientSelectedByName(
                chip.text.toString(),
                false
            )
            chip.text.toString()?.let { it1 ->
                chip.text.toString()?.let { it2 ->
                    favouritesRecipesViewmodel.isIngredientPresentInFavoriteRecipeUpdateGrocery(
                        it1, it2
                    )
                }
            }
        }
        chipGroup.removeView(chip)
    }

    // Open Search Ingredient Activity on floating button click
    private fun openSearchIngredientActivity() {
        activity?.let {
            val intent = Intent(it, SearchIngredientsActivity::class.java)
            it.startActivity(intent)
        }
    }

    //launch dialog to choose if we really want to clear our ingredient list
    private fun launchAlertDialog() {
        val builder = context?.let { MaterialAlertDialogBuilder(it) }
        builder?.setTitle(getString(R.string.menu_bottom_ingredient_at_home))
        builder?.setMessage(getString(R.string.dialog_question_clear_ingredients))

        builder?.setPositiveButton(getString(R.string.Yes)) { _, _ ->
            Toast.makeText(
                activity,
                getString(R.string.ingredient_list_clear), Toast.LENGTH_SHORT
            ).show()
            unselectAllIngredients()
        }

        builder?.setNegativeButton(android.R.string.no) { dialog, _ ->
            Toast.makeText(
                activity,
                getString(R.string.dialog_cancel_action), Toast.LENGTH_SHORT
            ).show()
            dialog.dismiss()
        }
        builder?.show()
    }



    //clear all ingredients in the list and put ingredient not selected in the objectbox database
    private fun unselectAllIngredients(){
        chipGroup.removeAllViews()
        val result: MutableList<Ingredients>? = ingredientsViewmodel.getIngredientsForFreezdgeList()
        if (result != null) {
            for (myresult in result) {
                // Set chip close icon click listener
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
        }
    }

}