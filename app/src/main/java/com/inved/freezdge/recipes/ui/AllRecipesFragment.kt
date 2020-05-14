package com.inved.freezdge.recipes.ui

import android.os.Bundle
import android.view.Menu
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
import com.mikepenz.fastadapter.adapters.ItemAdapter

class AllRecipesFragment : BaseFragment() {

    override fun getLayoutRes(): Int {
        return R.layout.fragment_all_recipes
    }

    private lateinit var floatingActionButton: FloatingActionButton

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        floatingActionButton = view.findViewById(R.id.floating_button)
        floatingActionButton.setOnClickListener { launchFilterDialog() }
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
                    handleTeextFilter(
                        newText,
                        recipesRetrofitItemAdapter,
                        recipesDatabaseItemAdapter
                    )
                    return true
                }
            })
        }
        return super.onPrepareOptionsMenu(menu)
    }

    fun handleTeextFilter(
        newText: String,
        recipesRetrofitItemAdapter: ItemAdapter<Hit>,
        recipesDatabaseItemAdapter: ItemAdapter<Recipes>
    ) {

        recipesRetrofitItemAdapter.filter(newText)
        recipesRetrofitItemAdapter.itemFilter.filterPredicate =
            { item: Hit, constraint: CharSequence? ->
                item.recipe?.label!!.contains(
                    constraint.toString(),
                    ignoreCase = true
                )
            }

        recipesDatabaseItemAdapter.filter(newText)
        recipesDatabaseItemAdapter.itemFilter.filterPredicate =
            { item: Recipes, constraint: CharSequence? ->
                item.recipeTitle!!.contains(
                    constraint.toString(),
                    ignoreCase = true
                )
            }
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
        setlistRetrofitFilter.clear()
        setlistDatabaseFilter.clear()

        for(recipes in setlistRetrofit){
            if(!recipes.recipe?.dishType?.get(0).isNullOrEmpty()){
                if(recipes.recipe?.dishType?.get(0)?.contains(filterText.toString(),true)!!){
                    setlistRetrofitFilter.add(recipes)
                }
            }
        }

        for(recipes in setlistDatabase){
            if(recipes.dishType?.contains(filterText.toString(),true)!!){
                setlistDatabaseFilter.add(recipes)
            }
        }

        if(filterText.equals("")){
            fillAdapterFilter(setlistDatabase, setlistRetrofit)
        }else{
            fillAdapterFilter(setlistDatabaseFilter, setlistRetrofitFilter)
        }


    }

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

    private fun recipesNumberFilter(){
        recipesNumberSize= setlistDatabaseFilter.size+ setlistRetrofitFilter.size
        if(recipesNumberSize!=1){
            numberRecipesTextview.text = getString(R.string.recipe_list_number, recipesNumberSize)
        }else{
            numberRecipesTextview.text = getString(R.string.recipe_list_number_one, recipesNumberSize)
        }
    }


}