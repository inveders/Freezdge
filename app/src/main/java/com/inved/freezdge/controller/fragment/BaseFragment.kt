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
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter




abstract class BaseFragment : Fragment() {

    private val recipesItemAdapter = ItemAdapter<Hit>()
    private val fastAdapter = FastAdapter.with(recipesItemAdapter)

    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView

    //Viewmodel
    private lateinit var recipeModel: RecipeModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(getLayoutRes(), container, false)
        recyclerView = view.findViewById(R.id.recyclerview)
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
        detectWichFragmentIsOpen()

    }

    private fun detectWichFragmentIsOpen(){
        when {
            getForegroundFragment() is AllRecipesFragment -> run {
                getAllRecipes("chicken")
                Log.d(
                    "debago",
                    "I'm in All recipes fragment"
                )
            }
            getForegroundFragment() is MyRecipesFragment -> run {
                Log.d(
                    "debago",
                    "I'm in My favourites fragment"
                )
            }
            getForegroundFragment() is MyIngredientsListFragment -> run {
                Log.d(
                    "debago",
                    "I'm in My Ingredients fragment"
                )
            }
        }
    }

    fun getForegroundFragment(): Fragment? {
        val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.navHost)
        return if (navHostFragment == null) null else navHostFragment!!.childFragmentManager.fragments[0]
    }

    //DATA
    fun getAllRecipes(ingredients: String) {
        recipeModel.getRecipes(ingredients)
            .observe(viewLifecycleOwner, Observer { result ->
                Log.d(
                    "debago",
                    "la première recette est : ${result.hits.size}"
                )
                recipesItemAdapter.add(result.hits)
            })
    }
}