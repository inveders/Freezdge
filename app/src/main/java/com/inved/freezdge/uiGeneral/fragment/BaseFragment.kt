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
import com.inved.freezdge.favourites.viewmodel.FavouritesRecipesViewModel
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.injection.Injection
import com.inved.freezdge.recipes.model.Hit
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.ui.AllRecipesFragment
import com.inved.freezdge.recipes.ui.RecipeDetailActivity
import com.inved.freezdge.recipes.ui.WebviewActivity
import com.inved.freezdge.recipes.viewmodel.RecipeViewModel
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.LoaderListener
import com.inved.freezdge.utils.NetworkUtils
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import kotlinx.coroutines.*


abstract class BaseFragment : Fragment() {

    lateinit var notFoundTeextView: TextView
    lateinit var notFoundImageView: ImageView

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    private lateinit var floatingActionButton: FloatingActionButton

    companion object {
        internal var listener: LoaderListener? = null
        fun setLoaderListener(callback: LoaderListener) {
            this.listener = callback
        }
        val setlistDatabase: MutableSet<MutableList<Recipes>> = mutableSetOf()
        val setlistRetrofit: MutableSet<List<Hit>> = mutableSetOf()
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

        view?.let {
            recipeViewModel.handleFastAdapterClick(fastAdapter,favouriteRecipesViewmodel,
                it
            )
        }
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

        view?.let {
            recipeViewModel.handleFavouriteFastAdapterClick(favouritesFastAdapter,favouriteRecipesViewmodel,
                it
            )
        }

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
                if(NetworkUtils.isInternetAvailable(App.applicationContext())){
                    Log.d("debago","internet yes")
                    getAllRecipes()
                }else{
                    notFoundTeextView.visibility=View.VISIBLE
                    notFoundTeextView.text=getString(R.string.internet_connexion)
                }
            }
            getForegroundFragment() is MyRecipesFragment -> run {
                setupFavouriteRecipeRecyclerView()
                getFavouritesRecipes()
            }
        }
    }

    fun getFavouritesRecipes() {
        favouriteRecipesItemAdapter.clear()

        favouriteRecipesViewmodel.getAllFavouritesRecipes()
            .observe(viewLifecycleOwner, Observer { result ->
                favouriteRecipesItemAdapter.clear()
                if (result != null) {
                    if (result.size != 0) {
                        notFoundTeextView.visibility = View.GONE
                        notFoundImageView.visibility = View.INVISIBLE
                        for (myresult in result) {
                            favouriteRecipesItemAdapter.add(myresult)
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
    fun getAllRecipes() {

        val result: MutableList<Ingredients> = ingredientsViewmodel.getIngredientsForFreezdgeList()
        Log.d("debago","setlistretrofit ${setlistRetrofit.size}")
        if(setlistRetrofit.isNullOrEmpty()){
            uiScope.launch {
                if (result.size != 0) {
                    Log.d("debago","result size not null")
                    listener?.showLoader()
                    notFoundTeextView.visibility = View.GONE
                    lifecycleScope.launch {
                        setList(result)
                    }
                    delay(4000)
                    fillAdapter()
                } else {
                    notFoundTeextView.visibility = View.VISIBLE
                    notFoundTeextView.text =
                        getString(R.string.no_item_found_recipes)
                }
            }

        }else{
            fillAdapter()
        }

    }

    suspend fun setList(result:MutableList<Ingredients>){
        for (myresult in result) {
            Log.d("debago","result loop")
            recipeViewModel.getRecipeIfContainIngredient(myresult.name!!)
                .observe(viewLifecycleOwner, Observer { recipes ->
                    setlistDatabase.add(recipes)
                })

            recipeViewModel.getRecipes(myresult.name!!)
                .observe(viewLifecycleOwner, Observer { hits ->
                    //  Log.d("debago", "in retrofit data in list")
                    setlistRetrofit.add(hits.hits)
                })
        }
    }

    private fun fillAdapter() {
        Log.d("debago", "in fill adapter ${setlistRetrofit.size}")
        recipesRetrofitItemAdapter.clear()
        recipesDatabaseItemAdapter.clear()
        for (recipes in setlistDatabase) {
            recipesDatabaseItemAdapter.add(recipes)
        }
        for (hits in setlistRetrofit) {
            recipesRetrofitItemAdapter.add(hits)
        }
        listener?.hideLoader()
    }

}

