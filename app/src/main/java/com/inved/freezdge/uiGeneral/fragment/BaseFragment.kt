package com.inved.freezdge.uiGeneral.fragment

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt


abstract class BaseFragment : Fragment() {

    lateinit var notFoundTeextView: TextView
    lateinit var numberRecipesTextview: TextView
    lateinit var notFoundImageView: ImageView


    private lateinit var floatingActionButton: FloatingActionButton
    var domain = Domain()

    companion object {
        internal var listener: LoaderListener? = null
        fun setLoaderListener(callback: LoaderListener) {
            this.listener = callback
        }

        var setlistDatabase: MutableList<Recipes> = mutableListOf()
        var setFavouriteList: MutableList<FavouritesRecipes> = mutableListOf()
        var setFavouriteListFilter: MutableList<FavouritesRecipes> = mutableListOf()
        var setlistRetrofit: MutableList<Hit> = mutableListOf()
        var recipesNumberSize: Int? = 0
        var recipesFavouritesNumberSize: Int? = 0
        val setlistDatabaseFilter: MutableList<Recipes> = mutableListOf()
        val setlistRetrofitFilter: MutableList<Hit> = mutableListOf()

        private var PRIVATE_MODE = 0
        const val PREF_NAME = "RECIPES_DATABASE"
        val sharedPref: SharedPreferences =
            App.applicationContext().getSharedPreferences(
                PREF_NAME,
                PRIVATE_MODE
            )
    }

    val recipesRetrofitItemAdapter = ItemAdapter<Hit>()
    val recipesDatabaseItemAdapter = ItemAdapter<Recipes>()
    private var fastAdapter: GenericFastAdapter =
        FastAdapter.with(listOf(recipesDatabaseItemAdapter, recipesRetrofitItemAdapter))

    val favouriteRecipesItemAdapter = ItemAdapter<FavouritesRecipes>()
    private val favouritesFastAdapter = FastAdapter.with(favouriteRecipesItemAdapter)

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView

    //Viewmodel
    private lateinit var recipeViewModel: RecipeViewModel
    private lateinit var favouriteRecipesViewmodel: FavouritesRecipesViewModel
    private lateinit var ingredientsViewmodel: IngredientsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getLayoutRes(), container, false)
        floatingActionButton = view.findViewById(R.id.floating_button)
        recyclerView = view.findViewById(R.id.recyclerview)
        notFoundTeextView = view.findViewById(R.id.not_found)
        numberRecipesTextview = view.findViewById(R.id.topTextview)
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
        if (recipeViewModel.countAllRecipesInDatabase()?.toInt() == 0) {
            recipeViewModel.insertRecipesInDatabase()
            recipeViewModel.updateSharedPref()
        } else if (recipeViewModel.countAllRecipesInDatabase() != sharedPref.getLong(
                PREF_NAME,
                0
            )
        ) {
            recipeViewModel.deleteAllRecipesInDatabase()
            recipeViewModel.updateSharedPref()
        }
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
                    if (item.recipePhotoUrl.let { it?.contains("freezdge", true)==true }) {
                        val id: Long? = item.recipeId?.toLong()
                        openRecipeDetailActivity(id)
                    } else {
                        val urlRetrofit: String? = item.recipeUrl
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

    private fun openRecipeDetailActivity(id: Long?) {
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
                if (NetworkUtils.isNetworkAvailable(App.applicationContext())) {
                    lifecycleScope.launch {
                        getAllRecipes()
                    }

                } else {
                    notFoundTeextView.visibility = View.VISIBLE
                    notFoundTeextView.text = getString(R.string.internet_connexion)
                    floatingActionButton.hide()
                    numberRecipesTextview.visibility = View.GONE
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
        favouriteRecipesViewmodel.getAllFavouritesRecipes()
            .observe(viewLifecycleOwner, Observer { result ->
                favouriteRecipesItemAdapter.clear()
                if (result != null) {
                    if (result.size != 0) {
                        setFavouriteList.clear()
                        notFoundTeextView.visibility = View.GONE
                        notFoundImageView.visibility = View.INVISIBLE
                        floatingActionButton.show()
                        for (myresult in result) {
                            favouriteRecipesItemAdapter.add(myresult)
                            setFavouriteList.add(myresult)
                        }
                        favouritesRecipesNumber()
                    } else {
                        notFoundTeextView.visibility = View.VISIBLE
                        notFoundImageView.visibility = View.VISIBLE
                        floatingActionButton.hide()
                        numberRecipesTextview.visibility = View.GONE
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
            val result: MutableList<Ingredients>? =
                ingredientsViewmodel.getIngredientsForFreezdgeList()
            if (result?.size != 0) {
                recipeViewModel.getDatabaseRecipes(result)
                    ?.observe(viewLifecycleOwner, Observer { result2 ->
                        if (result2.isNullOrEmpty()) {
                            notFoundTeextView.visibility = View.VISIBLE
                            notFoundTeextView.text =
                                getString(R.string.no_recipes_found)
                            numberRecipesTextview.visibility = View.GONE
                            floatingActionButton.hide()
                            listener?.hideLoader()
                        } else {
                            notFoundTeextView.visibility = View.GONE
                            floatingActionButton.show()
                            fillAdapterDatabase(result2)
                        }
                    })
                recipeViewModel.getRetrofitRecipes(result)
                    ?.observe(viewLifecycleOwner, Observer { result3 ->
                        if (result3.isNullOrEmpty()) {
                            notFoundTeextView.visibility = View.VISIBLE
                            notFoundTeextView.text =
                                getString(R.string.no_recipes_found)
                            numberRecipesTextview.visibility = View.GONE
                            floatingActionButton.hide()
                            listener?.hideLoader()
                        } else {
                            notFoundTeextView.visibility = View.GONE
                            floatingActionButton.show()
                            fillAdapterRetrofit(result3)
                        }
                    })
            } else {
                notFoundTeextView.visibility = View.VISIBLE
                notFoundTeextView.text =
                    getString(R.string.no_item_found_recipes)
                numberRecipesTextview.visibility = View.GONE
                floatingActionButton.hide()
                listener?.hideLoader()
            }

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
        recipesNumber()
        listener?.hideLoader()
    }

    private fun fillAdapterDatabase(setlistDatabase: MutableList<Recipes>) {
        recipesDatabaseItemAdapter.clear()
        for (recipes in setlistDatabase) {
            recipesDatabaseItemAdapter.add(recipes)
        }
        BaseFragment.setlistDatabase = setlistDatabase
        recipesNumber()
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
                    domain.preparationTime(item.recipe?.totalTime),
                    item.recipe?.url,
                    item.recipe?.image,
                    item.recipe?.ingredientLines.toString(),
                    item.recipe?.cuisineType?.get(0),
                    item.recipe?.dishType?.get(0)
                )

                if (!item.recipe?.uri.isNullOrEmpty()) {
                    val bool: Boolean? = item.recipe?.uri?.let {
                        favouriteRecipesViewmodel.isRecipeIdIsPresent(
                            it
                        )
                    }

                    GlobalScope.launch(Dispatchers.IO) {
                        delay(500)
                        domain.correspondanceCalculForGrocery(
                            item.recipe?.ingredientLines.toString(),
                            bool
                        )
                    }

                    if (bool == true) {
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
                        domain.correspondanceCalculForGrocery(
                            it,
                            bool
                        )
                    }
                }

                if (bool == true) {
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

    //click on a favourite recipe, manage favourite image enable or not
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

            val bool: Boolean? = item.recipeId.let {
                it?.let { it1 ->
                    favouriteRecipesViewmodel.isRecipeIdIsPresent(
                        it1
                    )
                }
            }

            GlobalScope.launch(Dispatchers.IO) {
                delay(500)
                item.recipeIngredients?.let { domain.correspondanceCalculForGrocery(it, bool) }
            }

            if (bool == true) {
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

    // show number of recipes found
    private fun recipesNumber() {
        numberRecipesTextview.visibility = View.VISIBLE
        recipesNumberSize = setlistDatabase.size + setlistRetrofit.size
        if (recipesNumberSize != 1) {
            numberRecipesTextview.text = getString(R.string.recipe_list_number, recipesNumberSize)
        } else {
            numberRecipesTextview.text =
                getString(R.string.recipe_list_number_one, recipesNumberSize)
        }
    }

    // show number of favourites recipes found
    private fun favouritesRecipesNumber() {
        numberRecipesTextview.visibility = View.VISIBLE
        recipesFavouritesNumberSize = setFavouriteList.size
        if (recipesFavouritesNumberSize != 1) {
            numberRecipesTextview.text =
                getString(R.string.recipe_list_number, recipesFavouritesNumberSize)
        } else {
            numberRecipesTextview.text =
                getString(R.string.recipe_list_number_one, recipesFavouritesNumberSize)
        }
    }

}

