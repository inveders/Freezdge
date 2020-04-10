package com.inved.freezdge.uiGeneral.fragment

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
import com.inved.freezdge.favourites.ui.MyRecipesFragment
import com.inved.freezdge.favourites.viewmodel.FavouritesRecipesViewModel
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.ui.MyIngredientsListFragment
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.model.recipes.Hit
import com.inved.freezdge.recipes.ui.AllRecipesFragment
import com.inved.freezdge.recipes.viewmodel.RecipeModel
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter


abstract class BaseFragment : Fragment() {

    private val recipesItemAdapter = ItemAdapter<Hit>()
    private val fastAdapter = FastAdapter.with(recipesItemAdapter)



    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView

    //Viewmodel
    private lateinit var recipeModel: RecipeModel
    private lateinit var favouriteRecipesViewmodel: FavouritesRecipesViewModel
    private lateinit var ingredientsViewmodel: IngredientsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(getLayoutRes(), container, false)
        recyclerView = view.findViewById(R.id.recyclerview)
        initViewModel()
        setupRecyclerView()
        detectWichFragmentIsOpen()
        return view
    }

    abstract fun getLayoutRes(): Int

    //INITIALIZATION
    private fun initViewModel() {
        recipeModel = ViewModelProviders.of(this).get(RecipeModel::class.java)
        favouriteRecipesViewmodel =
            ViewModelProviders.of(this).get(FavouritesRecipesViewModel::class.java)
        ingredientsViewmodel =
            ViewModelProviders.of(this).get(IngredientsViewModel::class.java)

    }

    private fun setupRecyclerView() {
        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = fastAdapter


    }

    private fun detectWichFragmentIsOpen() {
        when {
            getForegroundFragment() is AllRecipesFragment -> run {
                getAllRecipes()
            }
            getForegroundFragment() is MyRecipesFragment -> run {
                getFavouritesRecipes()
            }
            getForegroundFragment() is MyIngredientsListFragment -> run {
                //TODO
            }
        }
    }

    private fun getFavouritesRecipes() {
        recipesItemAdapter.clear()

        favouriteRecipesViewmodel.getAllFavouritesRecipes()
            .observe(viewLifecycleOwner, Observer { result ->
                if(result!=null){
                    for (myresult in result){
                        recipeModel.getRecipesById(myresult.recipeId!!)
                            .observe(viewLifecycleOwner, Observer { result2 ->
                                Log.d(
                                    "debago",
                                    "la première recette est : ${result2.hits.size}"
                                )
                                recipesItemAdapter.add(result2.hits)
                            })
                    }
                }

            })

    }

    fun getForegroundFragment(): Fragment? {
        val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.navHost)
        return if (navHostFragment == null) null else navHostFragment.childFragmentManager.fragments[0]
    }

    //DATA
    fun getAllRecipes() {

        recipesItemAdapter.clear()

        ingredientsViewmodel.getIngredientsForFreezdgeList()
            .observe(viewLifecycleOwner, Observer { result ->
                if(result!=null){
                    for (myresult in result){
                        recipeModel.getRecipes(myresult.name!!)
                            .observe(viewLifecycleOwner, Observer { result2 ->
                                Log.d(
                                    "debago",
                                    "la première recette est : ${result2.hits.size}"
                                )
                                recipesItemAdapter.add(result2.hits)
                            })
                    }
                }

            })

    }
}