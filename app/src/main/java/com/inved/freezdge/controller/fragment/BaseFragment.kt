package com.inved.freezdge.controller.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.model.RecipeModel
import com.inved.freezdge.model.recipes.Hit
import com.inved.freezdge.model.recipes.Results
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.ItemAdapter

abstract class BaseFragment : Fragment() {

    private val recipesItemAdapter = ItemAdapter<GenericItem>()
    private val fastAdapter = FastAdapter.with(recipesItemAdapter)

    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView

    //Network call
    private lateinit var recipeModel: RecipeModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(getLayoutRes(), container, false)
        recyclerView=view.findViewById(R.id.recyclerViewAllRecipes)
        initViewModel()
        setupRecyclerView()
        return view
    }

    abstract fun getLayoutRes(): Int

    //INITIALIZATION
    private fun initViewModel() {
        recipeModel = ViewModelProviders.of(this).get(RecipeModel::class.java)

    }

    private fun setupRecyclerView() {
        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = fastAdapter
        getAllRecipes("chicken")

    }

    //DATA
    fun getAllRecipes(ingredients: String) {
        recipeModel.getRecipes(ingredients)
            .observe(this, Observer<List<Hit>> { t: List<Hit>? ->
                Log.d(
                    "debago",
                    "la première recette est : ${t?.size}"
                )
                //recipesItemAdapter.add(t)
            })

    }


}