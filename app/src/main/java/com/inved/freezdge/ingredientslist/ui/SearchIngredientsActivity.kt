package com.inved.freezdge.ingredientslist.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
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
    private var loader: LottieAnimationView? = null
    private var loaderContainer: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView = findViewById(R.id.activity_search_recycler_view)
        loader=findViewById(R.id.animation_view)
        loaderContainer=findViewById(R.id.animation_view_container)
        initToolbarBaseActivity(R.string.toolbar_search_ingredients)
        ingredientViewmodel = ViewModelProviders.of(this).get(IngredientsViewModel::class.java)
        showLoadingIndicator()
        insertFood()
        setupRecyclerView()
        getAllFood()


    }


    fun showLoadingIndicator() {
        Log.d("debago","in show, loader is $loader")
        loader?.post {
            loader!!.playAnimation()
            loaderContainer?.visibility = View.VISIBLE
        }
    }

    fun hideLoadingIndicator() {
        Log.d("debago","in hide, loader is $loader")
        loader?.post {
            loader!!.pauseAnimation()
            Log.d("debago","in hide loading indicator")
            loaderContainer?.visibility = View.GONE
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu?.findItem(R.id.search_menu)
        if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView
            val edittext =
                searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            edittext.hint = "TBL: Search ingredient here..."
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    showLoadingIndicator()
                    if (newText!!.isNotEmpty()) {

                        foodSearchItemAdapter.clear()
                        val search = newText.toLowerCase(Locale.ROOT)
                        ingredientViewmodel.getAllIngredients()
                            .observe({ lifecycle }, { list ->

                                list.forEach {
                                    if (it.name!!.toLowerCase(Locale.ROOT).contains(search)) {
                                        foodSearchItemAdapter.add(it)
                                        hideLoadingIndicator()
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
            Log.d("debago","get all food")
            hideLoadingIndicator()
        })

    }


}