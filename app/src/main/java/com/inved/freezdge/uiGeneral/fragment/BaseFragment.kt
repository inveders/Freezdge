package com.inved.freezdge.uiGeneral.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.inved.freezdge.R
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.ui.MyRecipesFragment
import com.inved.freezdge.favourites.view.ViewHolderFavouritesRecipes
import com.inved.freezdge.favourites.viewmodel.FavouritesRecipesViewModel
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.injection.Injection
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.model.Hit
import com.inved.freezdge.recipes.ui.AllRecipesFragment
import com.inved.freezdge.recipes.ui.RecipeDetailActivity
import com.inved.freezdge.recipes.ui.WebviewActivity
import com.inved.freezdge.recipes.view.ViewHolderRecipesDatabase
import com.inved.freezdge.recipes.view.ViewHolderRecipesRetrofit
import com.inved.freezdge.recipes.viewmodel.RecipeViewModel
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.LoaderListener
import com.inved.freezdge.utils.NetworkUtils
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.listeners.addClickListener
import kotlinx.coroutines.*
import kotlin.math.roundToInt


abstract class BaseFragment : Fragment() {

    lateinit var notFoundTeextView: TextView
    lateinit var notFoundImageView: ImageView

    private var viewModelJob = Job()
    private lateinit var floatingActionButton: FloatingActionButton

    companion object {
        internal var listener: LoaderListener? = null
        fun setLoaderListener(callback: LoaderListener) {
            this.listener = callback
        }

        var setlistDatabase: MutableList<Recipes> = mutableListOf()
        var setFavouriteList: MutableList<FavouritesRecipes> = mutableListOf()
        var setFavouriteListFilter: MutableList<FavouritesRecipes> = mutableListOf()
        var setlistRetrofit: MutableList<Hit> = mutableListOf()
        val setlistDatabaseFilter: MutableList<Recipes> = mutableListOf()
        val setlistRetrofitFilter: MutableList<Hit> = mutableListOf()
    }

    val recipesRetrofitItemAdapter = ItemAdapter<Hit>()
    val recipesDatabaseItemAdapter = ItemAdapter<Recipes>()
    private var fastAdapter: GenericFastAdapter =
        FastAdapter.with(listOf(recipesDatabaseItemAdapter, recipesRetrofitItemAdapter))

    val favouriteRecipesItemAdapter = ItemAdapter<FavouritesRecipes>()
    val favouritesFastAdapter = FastAdapter.with(favouriteRecipesItemAdapter)

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView

    //Viewmodel
    private lateinit var recipeViewModel: RecipeViewModel
    lateinit var favouriteRecipesViewmodel: FavouritesRecipesViewModel
    private lateinit var ingredientsViewmodel: IngredientsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getLayoutRes(), container, false)
        floatingActionButton = view.findViewById(R.id.floating_button)
        recyclerView = view.findViewById(R.id.recyclerview)
        notFoundTeextView = view.findViewById(R.id.not_found)
        notFoundImageView = view.findViewById(R.id.image_arrow)
        initViewModel()
        insertFood()
        insertRecipes()
        detectWichFragmentIsOpen()
        return view
    }

    abstract fun getLayoutRes(): Int

    //INITIALIZATION
    private fun initViewModel() {
        val viewModelFactory = Injection.providesViewModelFactory(App.ObjectBox.boxStore)
        recipeViewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(RecipeViewModel::class.java)
        favouriteRecipesViewmodel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(FavouritesRecipesViewModel::class.java)
        ingredientsViewmodel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(IngredientsViewModel::class.java)
    }

    private fun insertFood() {
        ingredientsViewmodel.insertIngredients()
    }

    private fun insertRecipes() {
        recipeViewModel.insertRecipesInDatabase()
    }

    private fun setupRecipeRecyclerView() {
        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = fastAdapter

        //configure our fastAdapter
        fastAdapter.onClickListener =
            { v: View?, _: IAdapter<GenericItem>, item: GenericItem, _: Int ->
                v?.let {
                    // When we click, we retrieve here the clicked element and sen list of benefits in the method
                    if (item is Hit) {
                        val urlRetrofit: String = item.recipe?.url.toString()
                        openWebViewActivity(urlRetrofit)
                    } else if (item is Recipes) {
                        val id: Long = item.id
                        openRecipeDetailActivity(id)
                    }
                }
                true
            }

        handleFastAdapterClick(fastAdapter, favouriteRecipesViewmodel)
    }

    private fun setupFavouriteRecipeRecyclerView() {
        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = favouritesFastAdapter

        //configure our fastAdapter
        favouritesFastAdapter.onClickListener =
            { v: View?, _: IAdapter<FavouritesRecipes>, item: FavouritesRecipes, _: Int ->
                v?.let {
                    val url: String? = item.recipeUrl
                    openWebViewActivity(url)

                    if (item.recipePhotoUrl?.contains("freezdge", true)!!) {
                        val id: Long = item.recipeId!!.toLong()
                        openRecipeDetailActivity(id)

                    } else {
                        val urlRetrofit: String = item.recipeUrl!!
                        openWebViewActivity(urlRetrofit)
                    }
                }
                true
            }

        handleFavouriteFastAdapterClick(favouritesFastAdapter, favouriteRecipesViewmodel)

    }

    private fun openWebViewActivity(url: String?) {
        let {
            val intent = Intent(activity, WebviewActivity::class.java)
            intent.putExtra("WEBVIEW_URL", url)
            startActivity(intent)
        }
    }

    private fun openRecipeDetailActivity(id: Long) {
        let {
            val intent = Intent(activity, RecipeDetailActivity::class.java)
            intent.putExtra("RECIPE_ID", id)
            startActivity(intent)
        }
    }

    private fun detectWichFragmentIsOpen() {
        when {
            getForegroundFragment() is AllRecipesFragment -> run {
                setupRecipeRecyclerView()
                 if (NetworkUtils.typeNetworkConnection(App.applicationContext()) != NetworkUtils.Companion.TypeConnection.NONE) {
                    lifecycleScope.launch {
                        getAllRecipes()
                    }

                } else {
                    notFoundTeextView.visibility = View.VISIBLE
                    notFoundTeextView.text = getString(R.string.internet_connexion)
                }
            }
            getForegroundFragment() is MyRecipesFragment -> run {
                setupFavouriteRecipeRecyclerView()
                getFavouritesRecipes()
            }
        }
    }

    private fun getFavouritesRecipes() {
        favouriteRecipesItemAdapter.clear()
        setFavouriteList.clear()
        favouriteRecipesViewmodel.getAllFavouritesRecipes()
            .observe(viewLifecycleOwner, Observer { result ->
                favouriteRecipesItemAdapter.clear()
                if (result != null) {
                    if (result.size != 0) {
                        notFoundTeextView.visibility = View.GONE
                        notFoundImageView.visibility = View.INVISIBLE
                        for (myresult in result) {
                            favouriteRecipesItemAdapter.add(myresult)
                            setFavouriteList.add(myresult)
                        }
                    } else {
                        notFoundTeextView.visibility = View.VISIBLE
                        notFoundImageView.visibility = View.VISIBLE
                        notFoundTeextView.text = getString(R.string.no_item_found_favourite)
                    }
                }
            })
    }

    private fun getForegroundFragment(): Fragment? {
        val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.navHost)
        return if (navHostFragment == null) null else navHostFragment.childFragmentManager.fragments[0]
    }

    //DATA
    private suspend fun getAllRecipes() {
        if (setlistRetrofit.isNullOrEmpty()) {
            val result: MutableList<Ingredients> =
                ingredientsViewmodel.getIngredientsForFreezdgeList()
            recipeViewModel.getRetrofitRecipes(result)
                ?.observe(viewLifecycleOwner, Observer { result ->
                    if (result.isNullOrEmpty()) {
                        notFoundTeextView.visibility = View.VISIBLE
                        notFoundTeextView.text =
                            getString(R.string.no_item_found_recipes)
                        listener?.hideLoader()
                    } else {
                        notFoundTeextView.visibility = View.GONE
                        fillAdapterRetrofit(result)
                    }
                })
            recipeViewModel.getDatabaseRecipes(result)
                ?.observe(viewLifecycleOwner, Observer { result ->
                    if (result.isNullOrEmpty()) {
                        notFoundTeextView.visibility = View.VISIBLE
                        notFoundTeextView.text =
                            getString(R.string.no_item_found_recipes)
                        listener?.hideLoader()
                    } else {
                        notFoundTeextView.visibility = View.GONE
                        fillAdapterDatabase(result)
                    }
                })
        } else {
            fillAdapterRetrofit(setlistRetrofit)
            fillAdapterDatabase(setlistDatabase)
        }

    }


    private fun fillAdapterRetrofit(setlistRetrofit: MutableList<Hit>) {
        recipesRetrofitItemAdapter.clear()
        for (hits in setlistRetrofit) {
            recipesRetrofitItemAdapter.add(hits)
        }
        BaseFragment.setlistRetrofit = setlistRetrofit
        listener?.hideLoader()
    }

    private fun fillAdapterDatabase(setlistDatabase: MutableList<Recipes>) {
        recipesDatabaseItemAdapter.clear()
        for (recipes in setlistDatabase) {
            recipesDatabaseItemAdapter.add(recipes)
        }
        BaseFragment.setlistDatabase = setlistDatabase
        listener?.hideLoader()
    }


    private fun handleFastAdapterClick(
        fastAdapter: GenericFastAdapter,
        favouriteRecipesViewmodel: FavouritesRecipesViewModel
    ) {
        fastAdapter.addClickListener({ vh: ViewHolderRecipesRetrofit -> vh.imageFavourite }) { _, _, _: FastAdapter<GenericItem>, item: GenericItem ->
            //react on the click event
            if (item is Hit) {
                favouriteRecipesViewmodel.detectFavouriteRecipe(
                    item.recipe?.uri,
                    item.recipe?.label,
                    item.recipe?.calories?.div(10)?.roundToInt().toString(),
                    Domain.preparationTime(item.recipe?.totalTime),
                    item.recipe?.url,
                    item.recipe?.image,
                    item.recipe?.ingredientLines.toString(),
                    item.recipe?.cuisineType?.get(0),
                    item.recipe?.dishType?.get(0)
                )

                val bool: Boolean? =
                    item.recipe?.uri?.let { favouriteRecipesViewmodel.isRecipeIdIsPresent(it) }

                GlobalScope.launch(Dispatchers.IO) {
                    delay(500)
                    Domain.correspondanceCalculForGrocery(
                        item.recipe?.ingredientLines.toString(),
                        bool!!
                    )
                }

                if (bool!!) {
                    view.let { it1 ->
                        it1?.let {
                            item.getViewHolder(it).imageFavourite.setImageResource(
                                R.drawable.ic_favorite_selected_24dp
                            )
                        }
                    }
                } else {
                    view.let { it1 ->
                        it1?.let {
                            item.getViewHolder(it).imageFavourite.setImageResource(
                                R.drawable.ic_favorite_not_selected_24dp
                            )
                        }
                    }
                }

                fastAdapter.notifyAdapterDataSetChanged()
            }

        }

        fastAdapter.addClickListener({ vh: ViewHolderRecipesDatabase -> vh.imageFavourite }) { _, _, _: FastAdapter<GenericItem>, item: GenericItem ->
            //react on the click event
            if (item is Recipes) {
                favouriteRecipesViewmodel.detectFavouriteRecipe(
                    item.id.toString(),
                    item.recipeTitle,
                    item.recipeCalories,
                    item.totalrecipeTime,
                    item.recipeUrlOwnerLink,
                    item.recipePhotoUrl,
                    item.recipeIngredients,
                    item.cuisineType,
                    item.dishType
                )

                val bool: Boolean? =
                    item.id.let {
                        it.let { it1 ->
                            favouriteRecipesViewmodel.isRecipeIdIsPresent(
                                it1.toString()
                            )
                        }
                    }

                GlobalScope.launch(Dispatchers.IO) {
                    delay(500)
                    item.recipeIngredients?.let {
                        Domain.correspondanceCalculForGrocery(
                            it,
                            bool!!
                        )
                    }
                }

                if (bool!!) {
                    view.let { it1 ->
                        it1?.let {
                            item.getViewHolder(it).imageFavourite.setImageResource(
                                R.drawable.ic_favorite_selected_24dp
                            )
                        }
                    }
                } else {
                    view.let { it1 ->
                        it1?.let {
                            item.getViewHolder(it).imageFavourite.setImageResource(
                                R.drawable.ic_favorite_not_selected_24dp
                            )
                        }
                    }
                }

                fastAdapter.notifyAdapterDataSetChanged()
            }
        }
    }

    private fun handleFavouriteFastAdapterClick(
        favouritesFastAdapter: FastAdapter<FavouritesRecipes>,
        favouriteRecipesViewmodel: FavouritesRecipesViewModel
    ) {
        favouritesFastAdapter.addClickListener({ vh: ViewHolderFavouritesRecipes -> vh.imageFavourite }) { _, _: Int, _: FastAdapter<FavouritesRecipes>, item: FavouritesRecipes ->
            //react on the click event

            favouriteRecipesViewmodel.detectFavouriteRecipe(
                item.recipeId, item.recipeTitle, item.recipeCalories,
                item.recipeTime, item.recipeUrl, item.recipePhotoUrl, item.recipeIngredients,
                item.cuisineType, item.dishType
            )

            val bool: Boolean? =
                item.recipeId.let { favouriteRecipesViewmodel.isRecipeIdIsPresent(it!!) }

            GlobalScope.launch(Dispatchers.IO) {
                delay(500)
                item.recipeIngredients?.let { Domain.correspondanceCalculForGrocery(it, bool!!) }
            }

            if (bool!!) {
                view.let { it1 ->
                    it1?.let {
                        item.getViewHolder(it).imageFavourite.setImageResource(
                            R.drawable.ic_favorite_selected_24dp
                        )
                    }
                }
            } else {
                view.let { it1 ->
                    it1?.let {
                        item.getViewHolder(it).imageFavourite.setImageResource(
                            R.drawable.ic_favorite_not_selected_24dp
                        )
                    }
                }
            }

            favouritesFastAdapter.notifyAdapterDataSetChanged()
        }
    }

}

