package com.inved.freezdge.ingredientslist.ui

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import com.inved.freezdge.utils.AddIngredientsInDatabase
import com.inved.freezdge.utils.App
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import io.objectbox.Box
import io.objectbox.kotlin.boxFor


class SearchIngredientsActivity: BaseActivity() {

    private val foodSearchItemAdapter = ItemAdapter<Ingredients>()
    private val fastAdapterFoodSearch = FastAdapter.with(foodSearchItemAdapter)

    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView
    lateinit var ingredientViewmodel: IngredientsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView = findViewById(R.id.activity_search_recycler_view)
        initToolbarBaseActivity(R.string.toolbar_search_ingredients)
        setupRecyclerView()

        ingredientViewmodel = ViewModelProviders.of(this).get(IngredientsViewModel::class.java)

    }

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_search_ingredients
    }


    override fun onSupportNavigateUp() = true.also { onBackPressed() }

    private fun setupRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = fastAdapterFoodSearch
        getAllFood()

    }

    //DATA
    fun getAllFood() {
        ingredientViewmodel.getAllIngredients().observe(this, Observer {
            foodSearchItemAdapter.add(it)
        })
       /* val data: MutableList<Ingredients>?=mutableListOf()
        ingredientsBox.all.forEach{
            data?.add(it)
        }
        data?.let { foodSearchItemAdapter.add(it) }*/

    }


}