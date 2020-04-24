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
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.ui.AllRecipesFragment
import com.inved.freezdge.recipes.ui.RecipeDetailActivity
import com.inved.freezdge.recipes.ui.WebviewActivity
import com.inved.freezdge.recipes.view.ViewHolderRecipesDatabase
import com.inved.freezdge.recipes.view.ViewHolderRecipesRetrofit
import com.inved.freezdge.recipes.viewmodel.RecipeModel
import com.inved.freezdge.utils.Domain
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.listeners.addClickListener
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlin.math.roundToInt


abstract class BaseFragment : Fragment() {

    lateinit var notFoundTeextView: TextView
    lateinit var notFoundImageView: ImageView


    private val recipesRetrofitItemAdapter = ItemAdapter<Hit>()
    private val recipesDatabaseItemAdapter = ItemAdapter<Recipes>()
    private var fastAdapter: GenericFastAdapter =
        FastAdapter.with(listOf(recipesDatabaseItemAdapter, recipesRetrofitItemAdapter))

    private val favouriteRecipesItemAdapter = ItemAdapter<FavouritesRecipes>()
    private val favouritesFastAdapter = FastAdapter.with(favouriteRecipesItemAdapter)

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private var disposable: Disposable? = null

    //Viewmodel
    private lateinit var recipeModel: RecipeModel
    private lateinit var favouriteRecipesViewmodel: FavouritesRecipesViewModel
    private lateinit var ingredientsViewmodel: IngredientsViewModel
    private val setlistDatabase: MutableSet<MutableList<Recipes>> = mutableSetOf()
    private val setlistRetrofit: MutableSet<List<Hit>> = mutableSetOf()

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
                Log.d("debago", "position in base fragment is $position")
                favouriteRecipesViewmodel.detectFavouriteRecipe(
                    item.recipe!!.uri,
                    item.recipe!!.label,
                    item.recipe?.calories!!.div(10).roundToInt().toString(),
                    Domain.preparationTime(item.recipe?.totalTime),
                    item.recipe!!.url,
                    item.recipe!!.image,
                    item.recipe!!.ingredientLines.toString()
                )

                val bool: Boolean? =
                    item.recipe?.uri?.let { favouriteRecipesViewmodel.isRecipeIdIsPresent(it) }

                GlobalScope.async(Dispatchers.IO) {
                    Log.d("debago", "In coroutine grocery")
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
            }

        }


        fastAdapter.addClickListener({ vh: ViewHolderRecipesDatabase -> vh.imageFavourite }) { _, position, _: FastAdapter<GenericItem>, item: GenericItem ->
            //react on the click event

            if (item is Recipes) {
                Log.d("debago", "position in base fragment is $position")
                favouriteRecipesViewmodel.detectFavouriteRecipe(
                    item.recipeTitle,
                    item.recipeTitle,
                    item.recipeCalories,
                    item.totalrecipeTime,
                    item.recipeUrlOwnerLink,
                    item.recipePhotoUrl,
                    item.recipeIngredients
                )

                val bool: Boolean? =
                    item.recipeTitle.let {
                        it?.let { it1 ->
                            favouriteRecipesViewmodel.isRecipeIdIsPresent(
                                it1
                            )
                        }
                    }

                GlobalScope.async(Dispatchers.IO) {
                    item.recipeIngredients?.let {
                        Domain.correspondanceCalculForGrocery(
                            it,
                            bool!!
                        )
                    }
                }

                if (bool!!) {
                    view?.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_selected_24dp) }
                } else {
                    view?.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_not_selected_24dp) }
                }
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
                    val url: String = item.recipeUrl!!
                    openWebViewActivity(url)
                }
                true
            }

        favouritesFastAdapter.addClickListener({ vh: ViewHolderFavouritesRecipes -> vh.imageFavourite }) { _, _, _: FastAdapter<FavouritesRecipes>, item: FavouritesRecipes ->
            //react on the click event

            favouriteRecipesViewmodel.detectFavouriteRecipe(
                item.recipeId, item.recipeTitle, item.recipeCalories,
                item.recipeTime, item.recipeUrl, item.recipePhotoUrl, item.recipeIngredients
            )


            val bool: Boolean? =
                item.recipeId.let { favouriteRecipesViewmodel.isRecipeIdIsPresent(it!!) }

            GlobalScope.async(Dispatchers.IO) {
                Log.d("debago", "In coroutine grocery")
                item.recipeIngredients?.let { Domain.correspondanceCalculForGrocery(it, bool!!) }
            }

            if (bool!!) {
                view?.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_selected_24dp) }
            } else {
                view?.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_not_selected_24dp) }
            }

        }

    }

    private fun openWebViewActivity(url: String) {
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
                //4second splash time
                Handler().postDelayed({
                    //start main activity
                    fillAdapter()
                },4000)

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

    //DATA
    private fun getAllRecipes() {

        ingredientsViewmodel.getIngredientsForFreezdgeList()
            .observe(viewLifecycleOwner, Observer { result ->
                    if (result != null) {
                        if (result.size != 0) {
                            notFoundTeextView.visibility = View.GONE
                           fillSetList(result)
                        } else {
                            Log.d("debago", "in no result found")
                            notFoundTeextView.visibility = View.VISIBLE
                            notFoundTeextView.text =
                                getString(R.string.no_item_found_recipes)
                        }
                    }

            })


    }

    fun fillSetList(result:List<Ingredients>){

        for (myresult in result) {

            recipeModel.getRecipeIfContainIngredient(myresult.name!!)
                .observe(viewLifecycleOwner, Observer { recipes ->
                    setlistDatabase.add(recipes)
                })

            recipeModel.getRecipes(myresult.name!!)
                .observe(viewLifecycleOwner, Observer { hits ->

                    setlistRetrofit.add(hits.hits)
                })

        }
    }

    fun fillAdapter(){
        recipesRetrofitItemAdapter.clear()
        recipesDatabaseItemAdapter.clear()
        for (recipes in setlistDatabase) {
            recipesDatabaseItemAdapter.add(recipes)
        }
        for (hits in setlistRetrofit) {
            recipesRetrofitItemAdapter.add(hits)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (disposable != null) {
            disposable!!.dispose()
        }
    }
}