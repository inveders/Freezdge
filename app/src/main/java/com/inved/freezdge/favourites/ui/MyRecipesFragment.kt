package com.inved.freezdge.favourites.ui

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.inved.freezdge.R
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.uiGeneral.fragment.BaseFragment
import com.inved.freezdge.utils.App

class MyRecipesFragment : BaseFragment() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_my_recipes
    }

    private lateinit var floatingActionButton: FloatingActionButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        floatingActionButton = view.findViewById(R.id.floating_button)
        floatingActionButton.setOnClickListener {
            launchFilterDialog()
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        val searchItem = menu.findItem(R.id.search_menu)
        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView
            val edittext =
                searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            edittext.hint = getString(R.string.search_recipe_searchview_label)
            val tf = ResourcesCompat.getFont(App.applicationContext(), R.font.bebasneue_regular)
            edittext.typeface = tf

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
            .setItems(
                R.array.filter_recipe_array
            ) { _, which ->
                // The 'which' argument contains the index position of selected item
                when (which) {
                    0 -> filterDishType(activity?.getString(R.string.array_filter_entry_search))
                    1 -> filterDishType(activity?.getString(R.string.array_filter_plat_search))
                    2 -> filterDishType(activity?.getString(R.string.array_filter_dessert_search))
                    3 -> filterDishType(activity?.getString(R.string.array_filter_cocktail_search))
                    4 -> {
                        filterDishType("")
                    }
                }
            }
        builder.create()
        builder.show()

    }

    private fun filterDishType(filterText: String?) {
        setFavouriteListFilter.clear()

        for(recipes in setFavouriteList){
            if(recipes.dishType?.contains(filterText.toString(),true)!!){
                setFavouriteListFilter.add(recipes)
            }
        }

        if(filterText.equals("")){
            fillFavouriteAdapterFilter(setFavouriteList)
        }else{
            fillFavouriteAdapterFilter(setFavouriteListFilter)
        }


    }

    private fun fillFavouriteAdapterFilter(setfavouritelist: MutableList<FavouritesRecipes>) {
        favouriteRecipesItemAdapter.clear()

        for (recipes in setfavouritelist) {
            favouriteRecipesItemAdapter.add(recipes)
        }
        favouritesRecipesNumberFilter()
    }

    private fun favouritesRecipesNumberFilter(){

        recipesFavouritesNumberSize= setFavouriteListFilter.size
        if(recipesFavouritesNumberSize!=1){
            numberRecipesTextview.text = getString(R.string.recipe_list_number, recipesFavouritesNumberSize)
        }else{
            numberRecipesTextview.text = getString(R.string.recipe_list_number_one, recipesFavouritesNumberSize)
        }
    }

}