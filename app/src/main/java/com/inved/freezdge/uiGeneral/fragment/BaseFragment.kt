package com.inved.freezdge.uiGeneral.fragment

import android.content.Intent
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
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.ui.MyRecipesFragment
import com.inved.freezdge.favourites.viewmodel.FavouritesRecipesViewModel
import com.inved.freezdge.ingredientslist.ui.MyIngredientsListFragment
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.model.recipes.Hit
import com.inved.freezdge.recipes.ui.AllRecipesFragment
import com.inved.freezdge.recipes.ui.WebviewActivity
import com.inved.freezdge.recipes.view.ViewHolder
import com.inved.freezdge.recipes.viewmodel.RecipeModel
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.listeners.addClickListener


abstract class BaseFragment : Fragment() {

    private val recipesItemAdapter = ItemAdapter<Hit>()
    private val fastAdapter = FastAdapter.with(recipesItemAdapter)

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
        initViewModel()

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

    private fun setupRecipeRecyclerView() {
        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = fastAdapter

        //configure our fastAdapter
        fastAdapter.onClickListener = { v: View?, _: IAdapter<Hit>, item: Hit, _: Int ->
            v?.let {
                val url: String = item.recipe?.url.toString()
                    openWebViewActivity(url)
            }
            true
        }

        fastAdapter.addClickListener({ vh: ViewHolder -> vh.imageFavourite }) { _, position, _: FastAdapter<Hit>, item: Hit ->
            //react on the click event

            favouriteRecipesViewmodel.detectFavouriteRecipe(item.recipe!!.uri,item.recipe!!.label,item.recipe!!.calories.toString(),
                item.recipe!!.totalTime.toString(),item.recipe!!.url,item.recipe!!.image,item.recipe!!.ingredientLines.toString())

            val bool: Boolean? =item.recipe?.uri?.let {favouriteRecipesViewmodel.isRecipeIdIsPresent(it) }

            if(bool!!){
                view?.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_selected_24dp) }
            }else{
                view?.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_not_selected_24dp) }
            }

        }

    }

    private fun setupFavouriteRecipeRecyclerView() {
        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = favouritesFastAdapter

        //configure our fastAdapter
        favouritesFastAdapter.onClickListener = { v: View?, _: IAdapter<FavouritesRecipes>, item: FavouritesRecipes, _: Int ->
            v?.let {
                val url: String = item.recipeUrl!!
                openWebViewActivity(url)
            }
            true
        }

        favouritesFastAdapter.addClickListener({ vh: FavouritesRecipes.ViewHolderFavouritesRecipes -> vh.imageFavourite }) { _, position, _: FastAdapter<FavouritesRecipes>, item: FavouritesRecipes ->
            //react on the click event

            favouriteRecipesViewmodel.detectFavouriteRecipe(item.recipeId,item.recipeTitle,item.recipeCalories,
                item.recipeTime,item.recipeUrl,item.recipePhotoUrl,item.recipeIngredients)

            val bool: Boolean? =item.recipeId.let {favouriteRecipesViewmodel.isRecipeIdIsPresent(it!!) }

            if(bool!!){
                view?.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_selected_24dp) }
            }else{
                view?.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_not_selected_24dp) }
            }

        }

    }

    fun openWebViewActivity(url: String) {
        let { val intent= Intent(activity, WebviewActivity::class.java)
            intent.putExtra("WEBVIEW_URL", url)
            startActivity(intent) }
    }

    private fun detectWichFragmentIsOpen() {
        when {
            getForegroundFragment() is AllRecipesFragment -> run {
                setupRecipeRecyclerView()
                getAllRecipes()
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
                if (result != null) {
                    for (myresult in result) {
                        favouriteRecipesItemAdapter.add(myresult)
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
                if (result != null) {
                    for (myresult in result) {
                        recipeModel.getRecipes(myresult.name!!)
                            .observe(viewLifecycleOwner, Observer { result2 ->

                                recipesItemAdapter.add(result2.hits)
                            })
                    }
                }

            })

    }

}