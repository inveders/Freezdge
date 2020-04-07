package com.inved.freezdge.controller.activity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.adapter.IngredientsItem
import com.inved.freezdge.database.Ingredients
import com.inved.freezdge.model.IngredientsModel
import com.inved.freezdge.utils.AddIngredientsInDatabase
import com.inved.freezdge.utils.App
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import io.objectbox.Box
import io.objectbox.kotlin.boxFor

class SearchIngredientsActivity:BaseActivity() {

    private val foodSearchItemAdapter = ItemAdapter<IngredientsItem>()
    private val fastAdapterFoodSearch = FastAdapter.with(foodSearchItemAdapter)

    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView
    lateinit var ingredientsBox:Box<Ingredients>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ingredientsBox = App.ObjectBox.boxStore.boxFor()
        AddIngredientsInDatabase(ingredientsBox)
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
        getAllFood()

    }

    //DATA
    fun getAllFood() {

        val data: MutableList<IngredientsModel>?=mutableListOf()
        ingredientsBox.all.forEach{
            val ingredientModel= IngredientsModel(it.name,it.type,it.photoUrl,it.isSelected)
            data?.add(ingredientModel)
        }


        val items = mutableListOf<IngredientsItem>()

        data?.forEach{
            val ingredient = IngredientsItem().apply {
                this.model=it
            }

            items.add(ingredient)

        }
        foodSearchItemAdapter.add(items)

    }

}