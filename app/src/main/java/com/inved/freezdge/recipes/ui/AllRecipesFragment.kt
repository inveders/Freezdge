package com.inved.freezdge.recipes.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.inved.freezdge.R
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.model.Hit
import com.inved.freezdge.uiGeneral.fragment.BaseFragment
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.SearchButtonListener
import com.mikepenz.fastadapter.adapters.ItemAdapter

class AllRecipesFragment : BaseFragment(),SearchButtonListener {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_all_recipes
    }

    private lateinit var floatingActionButton: FloatingActionButton
    lateinit var searchItem: MenuItem
    companion object{
        var isSearchButtonShowed:Boolean=true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        setSearchButtonListener(this)
        floatingActionButton = view.findViewById(R.id.floating_button)
        floatingActionButton.setOnClickListener { launchFilterDialog() }
    }

    // manage searchview to find recipe on name
    override fun onPrepareOptionsMenu(menu: Menu) {
        searchItem = menu.findItem(R.id.search_menu)
        Log.d("debago","is buton to show? "+isSearchButtonShowed)
        searchItem.isVisible = isSearchButtonShowed
        val clearIngredientItem = menu.findItem(R.id.menu_ingredientss_clear)
        clearIngredientItem.isVisible = false
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
                handleTextFilter(
                    newText,
                    recipesRetrofitItemAdapter,
                    recipesDatabaseItemAdapter
                )
                return true
            }
        })
        return super.onPrepareOptionsMenu(menu)
    }

    // handle the text of searchview for recipes from retrofit or database
    fun handleTextFilter(
        newText: String,
        recipesRetrofitItemAdapter: ItemAdapter<Hit>,
        recipesDatabaseItemAdapter: ItemAdapter<Recipes>
    ) {

        recipesRetrofitItemAdapter.filter(newText)
        recipesRetrofitItemAdapter.itemFilter.filterPredicate =
            { item: Hit, constraint: CharSequence? ->
                item.recipe?.label?.contains(
                    constraint.toString(),
                    ignoreCase = true
                )==true
            }

        recipesDatabaseItemAdapter.filter(newText)
        recipesDatabaseItemAdapter.itemFilter.filterPredicate =
            { item: Recipes, constraint: CharSequence? ->
                item.recipeTitle?.contains(
                    constraint.toString(),
                    ignoreCase = true
                )==true
            }
    }

    // launch dialog to choose dish type and filter recipes
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

    // the given text only filter on dishType for recipes from retrofit or database
    private fun filterDishType(filterText: String?) {
        setlistRetrofitFilter.clear()
        setlistDatabaseFilter.clear()

        for(recipes in setlistRetrofit){
            if(!recipes.recipe?.dishType?.get(0).isNullOrEmpty()){
                if(recipes.recipe?.dishType?.get(0)?.contains(filterText.toString(),true)==true){
                    setlistRetrofitFilter.add(recipes)
                }
            }
        }

        for(recipes in setlistDatabase){
            if(recipes.dishType?.contains(filterText.toString(),true)==true){
                setlistDatabaseFilter.add(recipes)
            }
        }

        if(filterText.equals("")){
            fillAdapterFilter(setlistDatabase, setlistRetrofit)
        }else{
            fillAdapterFilter(setlistDatabaseFilter, setlistRetrofitFilter)
        }
    }

    // clear adapter and fill it with the filter recipes
    private fun fillAdapterFilter(setlistDatabase: MutableList<Recipes>, setlistRetrofit: MutableList<Hit>) {
        recipesRetrofitItemAdapter.clear()
        recipesDatabaseItemAdapter.clear()
        for (recipes in setlistDatabase) {
            recipesDatabaseItemAdapter.add(recipes)
        }
        for (hits in setlistRetrofit) {
            recipesRetrofitItemAdapter.add(hits)
        }
        recipesNumberFilter()
    }

    // determines the recipes filter number to show
    private fun recipesNumberFilter(){
        recipesNumberSize= setlistDatabaseFilter.size+ setlistRetrofitFilter.size
        if(recipesNumberSize!=1){
            numberRecipesTextview.text = getString(R.string.recipe_list_number, recipesNumberSize)
        }else{
            numberRecipesTextview.text = getString(R.string.recipe_list_number_one, recipesNumberSize)
        }
    }

    override fun showSearchButton() {
        isSearchButtonShowed=true
        searchItem.isVisible = true
    }

    override fun hideSearchButton() {
        isSearchButtonShowed=false
        searchItem.isVisible = false
    }


}