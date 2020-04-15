package com.inved.freezdge.ingredientslist.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import java.util.*


class SearchIngredientsActivity : BaseActivity() {

    private val foodSearchItemAdapter = ItemAdapter<Ingredients>()
    private val fastAdapterFoodSearch = FastAdapter.with(foodSearchItemAdapter)

    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView
    lateinit var ingredientViewmodel: IngredientsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView = findViewById(R.id.activity_search_recycler_view)
        initToolbarBaseActivity(R.string.toolbar_search_ingredients)
        ingredientViewmodel = ViewModelProviders.of(this).get(IngredientsViewModel::class.java)
        insertFood()
        setupRecyclerView()
        getAllFood()

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu?.findItem(R.id.search_menu)
        if (searchItem != null) {
            val searchView = searchItem.actionView as androidx.appcompat.widget.SearchView
            val edittext=searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            edittext.hint="TBL: Search ingredient here..."
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    if (newText!!.isNotEmpty()) {

                        foodSearchItemAdapter.clear()
                        val search = newText.toLowerCase(Locale.ROOT)
                        ingredientViewmodel.getAllIngredients()
                            .observe({ lifecycle }, { list ->

                                list.forEach {
                                    if (it.name!!.toLowerCase(Locale.ROOT).contains(search)) {
                                        foodSearchItemAdapter.add(it)
                                    }
                                }

                            })

                    } else {
                        getAllFood()
                    }

                    return true
                }
            })
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_search_ingredients
    }


    override fun onSupportNavigateUp() = true.also { onBackPressed() }

    private fun setupRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = fastAdapterFoodSearch

        //configure our fastAdapter
        fastAdapterFoodSearch.onClickListener =
            { v: View?, _: IAdapter<Ingredients>, item: Ingredients, position: Int ->
                v?.let {
                    ingredientViewmodel.updateIngredient(item)
                    fastAdapterFoodSearch.notifyAdapterItemChanged(position)
                }
                false
            }

    }

    //DATA

    private fun insertFood() {
        ingredientViewmodel.insertIngredients()
    }


    fun getAllFood() {
        foodSearchItemAdapter.clear()
        ingredientViewmodel.getAllIngredients().observe(this, Observer {
            foodSearchItemAdapter.add(it)
        })

    }


}