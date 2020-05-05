package com.inved.freezdge.uiGeneral.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
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
import com.inved.freezdge.R
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.ui.MyRecipesFragment
import com.inved.freezdge.favourites.view.ViewHolderFavouritesRecipes
import com.inved.freezdge.favourites.viewmodel.FavouritesRecipesViewModel
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.ui.MyIngredientsListFragment
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.model.recipes.Hit
import com.inved.freezdge.model.recipes.Results
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.ui.AllRecipesFragment
import com.inved.freezdge.recipes.ui.RecipeDetailActivity
import com.inved.freezdge.recipes.ui.WebviewActivity
import com.inved.freezdge.recipes.view.ViewHolderRecipesDatabase
import com.inved.freezdge.recipes.view.ViewHolderRecipesRetrofit
import com.inved.freezdge.recipes.viewmodel.RecipeModel
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.Domain.Companion.preparationTime
import com.inved.freezdge.utils.LoaderListener
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.listeners.addClickListener
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.math.roundToInt


abstract class BaseFragment : Fragment() {

    lateinit var notFoundTeextView: TextView
    lateinit var notFoundImageView: ImageView

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    companion object {
        internal var listener: LoaderListener? = null
        fun setLoaderListener(callback: LoaderListener) {
            this.listener = callback
        }
        val setlistDatabase: MutableSet<MutableList<Recipes>> = mutableSetOf()
        val setlistRetrofit: MutableSet<List<Hit>> = mutableSetOf()
    }


    private val recipesRetrofitItemAdapter = ItemAdapter<Hit>()
    private val recipesDatabaseItemAdapter = ItemAdapter<Recipes>()
    private var fastAdapter: GenericFastAdapter =
        FastAdapter.with(listOf(recipesDatabaseItemAdapter, recipesRetrofitItemAdapter))

    private val favouriteRecipesItemAdapter = ItemAdapter<FavouritesRecipes>()
    private val favouritesFastAdapter = FastAdapter.with(favouriteRecipesItemAdapter)

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView

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
        recipeModel = ViewModelProviders.of(this).get(RecipeModel::class.java)
        favouriteRecipesViewmodel =
            ViewModelProviders.of(this).get(FavouritesRecipesViewModel::class.java)
        ingredientsViewmodel =
            ViewModelProviders.of(this).get(IngredientsViewModel::class.java)

    }

    private fun insertFood() {
        ingredientsViewmodel.insertIngredients()
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


        fastAdapter.addClickListener({ vh: ViewHolderRecipesRetrofit -> vh.imageFavourite }) { _, position, _: FastAdapter<GenericItem>, item: GenericItem ->
            //react on the click event
            if (item is Hit) {
                favouriteRecipesViewmodel.detectFavouriteRecipe(
                    item.recipe?.uri,
                    item.recipe?.label,
                    item.recipe?.calories?.div(10)?.roundToInt().toString(),
                    preparationTime(item.recipe?.totalTime),
                    item.recipe?.url,
                    item.recipe?.image,
                    item.recipe?.ingredientLines.toString()
                )

                val bool: Boolean? =
                    item.recipe?.uri?.let { favouriteRecipesViewmodel.isRecipeIdIsPresent(it) }

                GlobalScope.async(Dispatchers.IO) {
                    delay(500)
                    Domain.correspondanceCalculForGrocery(
                        item.recipe?.ingredientLines.toString(),
                        bool!!
                    )
                }

                if (bool!!) {
                    view?.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_selected_24dp) }
                } else {
                    view?.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_not_selected_24dp) }
                }

                fastAdapter.notifyAdapterDataSetChanged()
            }

        }


        fastAdapter.addClickListener({ vh: ViewHolderRecipesDatabase -> vh.imageFavourite }) { _, position, _: FastAdapter<GenericItem>, item: GenericItem ->
            //react on the click event
            if (item is Recipes) {
                favouriteRecipesViewmodel.detectFavouriteRecipe(
                    item.id.toString(),
                    item.recipeTitle,
                    item.recipeCalories,
                    item.totalrecipeTime,
                    item.recipeUrlOwnerLink,
                    item.recipePhotoUrl,
                    item.recipeIngredients
                )

                Log.d("debago", "recipe id is ${item.id}")
                val bool: Boolean? =
                    item.id.let {
                        it?.let { it1 ->
                            favouriteRecipesViewmodel.isRecipeIdIsPresent(
                                it1.toString()
                            )
                        }
                    }

                GlobalScope.async(Dispatchers.IO) {
                    delay(500)
                    item.recipeIngredients?.let {
                        Domain.correspondanceCalculForGrocery(
                            it,
                            bool!!
                        )
                    }
                }

                Log.d("debago", "bool is ${bool}")
                if (bool!!) {
                    view?.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_selected_24dp) }
                } else {
                    view?.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_not_selected_24dp) }
                }

                fastAdapter.notifyAdapterDataSetChanged()

            }

        }

    }

    private fun insertRecipes() {
        recipeModel.insertRecipesInDatabase()
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
                    Log.d("debago", "recipe id ${item.id} and recipe url ${item.recipeUrl}")
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

        favouritesFastAdapter.addClickListener({ vh: ViewHolderFavouritesRecipes -> vh.imageFavourite }) { _, position: Int, _: FastAdapter<FavouritesRecipes>, item: FavouritesRecipes ->
            //react on the click event

            favouriteRecipesViewmodel.detectFavouriteRecipe(
                item.recipeId, item.recipeTitle, item.recipeCalories,
                item.recipeTime, item.recipeUrl, item.recipePhotoUrl, item.recipeIngredients
            )

            Log.d("debago", "item recipe favourite ${item.recipeId}")
            val bool: Boolean? =
                item.recipeId.let { favouriteRecipesViewmodel.isRecipeIdIsPresent(it!!) }

            GlobalScope.async(Dispatchers.IO) {
                delay(500)
                item.recipeIngredients?.let { Domain.correspondanceCalculForGrocery(it, bool!!) }
            }

            if (bool!!) {
                view?.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_selected_24dp) }
            } else {
                view?.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_not_selected_24dp) }
            }

            favouritesFastAdapter.notifyAdapterDataSetChanged()
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
                getAllRecipes()

                /*    viewLifecycleOwner.lifecycleScope.launch {
                        // Launch a concurrent coroutine to check if the main thread is blocked
                        /*   launch {
                               for (k in 1..3) {
                                   Log.d("debago","I'm not blocked $k")
                                   delay(100)
                               }
                           }*/
                        // Collect the flow
                        Log.d("debago", "in gell all recipes")
                        fooRetrofitRecipes()
                            .onCompletion { fillAdapter() }
                            .collect { value -> setlistRetrofit.add(value) }

                        fooDatabaseRecipes()
                            .collect { value -> setlistDatabase.add(value) }


                    }*/

                //4second splash time
              /*  Handler().postDelayed({
                    //start main activity
                    fillAdapter()
                }, 4000)*/

            }
            getForegroundFragment() is MyRecipesFragment -> run {
                setupFavouriteRecipeRecyclerView()
                getFavouritesRecipes()
            }
            getForegroundFragment() is MyIngredientsListFragment -> run {
                //TODO
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

    fun fooRetrofitRecipes(): Flow<List<Hit>> = flow { // flow builder
        val result: MutableList<Ingredients> = ingredientsViewmodel.getIngredientsForFreezdgeList()


        if (result.size != 0) {
            Log.d("debago", "in observer RETROFIT")
            listener?.showLoader()
            notFoundTeextView.visibility = View.GONE

            for (myresult in result) {

                /*   recipeModel.getRecipeIfContainIngredient(myresult.name!!)
                                           .observe(viewLifecycleOwner, Observer<MutableList<Recipes>> { recipes ->

                                               setlistDatabase.add(recipes)

                                               //    Log.d("debago", "in DATABASE data in list")
                                           })*/


                recipeModel.getRecipes(myresult.name!!)
                    .observe(viewLifecycleOwner, Observer<Results> { hits ->
                        //  Log.d("debago", "in retrofit data in list")
                        lifecycleScope.async(Dispatchers.Default) {
                            setlistRetrofit.add(hits.hits)
                            // Log.d("debago","in emit recipes retrofit")
                            emit(hits.hits)
                        }
                    })


            }


        } else {
            notFoundTeextView.visibility = View.VISIBLE
            notFoundTeextView.text =
                getString(R.string.no_item_found_recipes)
        }


    }.flowOn(Dispatchers.IO)

    fun fooDatabaseRecipes(): Flow<MutableList<Recipes>> = flow { // flow builder
        val result: MutableList<Ingredients> = ingredientsViewmodel.getIngredientsForFreezdgeList()

        if (result != null) {
            if (result.size != 0) {
                Log.d("debago", "in observer RETROFIT")
                listener?.showLoader()
                notFoundTeextView.visibility = View.GONE

                for (myresult in result) {

                    recipeModel.getRecipeIfContainIngredient(myresult.name!!)
                        .observe(viewLifecycleOwner, Observer<MutableList<Recipes>> { recipes ->
                            lifecycleScope.async(Dispatchers.Default) {
                                setlistDatabase.add(recipes)
                                emit(recipes)
                            }

                            //    Log.d("debago", "in DATABASE data in list")
                        })

                }

            }

        } else {
            notFoundTeextView.visibility = View.VISIBLE
            notFoundTeextView.text =
                getString(R.string.no_item_found_recipes)
        }


    }.flowOn(Dispatchers.IO)


    //DATA
    fun getAllRecipes() {

        val result: MutableList<Ingredients> = ingredientsViewmodel.getIngredientsForFreezdgeList()

        if(setlistRetrofit.isNullOrEmpty()){
            uiScope.launch {
                if (result.size != 0) {

                    listener?.showLoader()
                    notFoundTeextView.visibility = View.GONE
                    lifecycleScope.launch {
                        for (myresult in result) {

                            recipeModel.getRecipeIfContainIngredient(myresult.name!!)
                                .observe(viewLifecycleOwner, Observer { recipes ->

                                    setlistDatabase.add(recipes)

                                    //    Log.d("debago", "in DATABASE data in list")
                                })

                            recipeModel.getRecipes(myresult.name!!)
                                .observe(viewLifecycleOwner, Observer { hits ->
                                    //  Log.d("debago", "in retrofit data in list")
                                    setlistRetrofit.add(hits.hits)


                                })
                        }

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

