package com.inved.freezdge.controller.activity

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.model.RecipeModel
import com.inved.freezdge.model.food.Hint
import com.inved.freezdge.model.recipes.Hit
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter

class SearchIngredientsActivity:BaseActivity() {

    private val foodSearchItemAdapter = ItemAdapter<Hint>()
    private val fastAdapterFoodSearch = FastAdapter.with(foodSearchItemAdapter)

    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView = findViewById(R.id.activity_search_recycler_view)
        initToolbarBaseActivity(R.string.toolbar_search_ingredients)
        setupRecyclerView()

    }

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_search_ingredients
    }


    override fun onSupportNavigateUp() = true.also { onBackPressed() }

    private fun setupRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = fastAdapterFoodSearch
        getAllFood("chicken")

    }

    //DATA
    fun getAllFood(ingredients: String) {
        recipeModel.getFood(ingredients)
            .observe(this, Observer { result ->
                Log.d(
                    "debago",
                    "le premier ingrédiebt est : ${result.hints?.get(0)?.food?.label}"
                )
               foodSearchItemAdapter.add(result.hints)
            })
    }

}