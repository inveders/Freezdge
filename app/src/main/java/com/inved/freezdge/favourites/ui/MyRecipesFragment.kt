package com.inved.freezdge.favourites.ui

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.inved.freezdge.R
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.model.recipes.Hit
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.uiGeneral.fragment.BaseFragment
import com.inved.freezdge.utils.App

class MyRecipesFragment: BaseFragment() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_my_recipes
    }

    private lateinit var floatingActionButton: FloatingActionButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        floatingActionButton = view.findViewById(R.id.floating_button)
        floatingActionButton.setOnClickListener {


            launchFilterDialog() }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {


        val searchItem = menu.findItem(R.id.search_menu)
        Log.d("debago","in on prepareOptionMenu")
        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView

            val edittext =
                searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            edittext.hint = getString(R.string.search_recipe_searchview_label)
            val tf = ResourcesCompat.getFont(App.applicationContext(), R.font.bebasneue_regular)
            edittext.typeface=tf

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean {

                    favouriteRecipesItemAdapter.filter(newText)
                    favouriteRecipesItemAdapter.itemFilter.filterPredicate =
                        { item: FavouritesRecipes, constraint: CharSequence? ->
                            item.recipeTitle!!.contains(
                                constraint.toString(),
                                ignoreCase = true
                            )
                            item.cuisineType!!.contains(
                                constraint.toString(),
                                ignoreCase = true
                            )
                        }

                    return true
                }
            })


        }
        return super.onPrepareOptionsMenu(menu)
    }

    private fun launchFilterDialog() {
        val builder = MaterialAlertDialogBuilder(activity)
        builder.setTitle(getString(R.string.array_dialog_title))
            .setItems(R.array.filter_recipe_array,
                DialogInterface.OnClickListener { dialog, which ->
                    // The 'which' argument contains the index position
                    // of the selected item
                    Log.d("debago","selected element $which")
                    when(which){
                        0->filterLogicDishType(activity?.getString(R.string.array_filter_entry_search))
                        1->filterLogicDishType(activity?.getString(R.string.array_filter_plat_search))
                        2->filterLogicDishType(activity?.getString(R.string.array_filter_dessert_search))
                        3->filterLogicDishType(activity?.getString(R.string.array_filter_cocktail_search))
                        4->filterLogicDishType("")
                    }
                })
        builder.create()
        builder.show()

    }

    fun filterLogicDishType(filterText:String?){
        favouriteRecipesItemAdapter.filter(filterText)
        favouriteRecipesItemAdapter.itemFilter.filterPredicate =
            { item: FavouritesRecipes, constraint: CharSequence? ->
                item.dishType!!.contains(
                    constraint.toString(),
                    ignoreCase = true
                )
            }

    }

}