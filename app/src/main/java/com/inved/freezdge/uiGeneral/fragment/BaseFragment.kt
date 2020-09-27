package com.inved.freezdge.uiGeneral.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.inved.freezdge.BuildConfig
import com.inved.freezdge.R
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.ui.MyRecipesFragment
import com.inved.freezdge.favourites.view.ViewHolderFavouritesRecipes
import com.inved.freezdge.favourites.viewmodel.FavouritesRecipesViewModel
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.injection.Injection
import com.inved.freezdge.onboarding.OnboardingActivity
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.ui.AllRecipesFragment
import com.inved.freezdge.recipes.ui.RecipeDetailActivity
import com.inved.freezdge.recipes.ui.WebviewActivity
import com.inved.freezdge.recipes.view.ViewHolderRecipesDatabase
import com.inved.freezdge.recipes.viewmodel.RecipeViewModel
import com.inved.freezdge.socialmedia.ui.PreviewPhotoDialog
import com.inved.freezdge.uiGeneral.adapter.CloseButtonItem
import com.inved.freezdge.uiGeneral.dialog.GroceryListDialog
import com.inved.freezdge.utils.*
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.listeners.addClickListener
import kotlinx.android.synthetic.main.fragment_my_recipes.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


abstract class BaseFragment <T : ViewBinding, A : Any> : Fragment() {

    protected var handler: A? = null //It's base activity
    protected open var binding: T? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        @Suppress("UNCHECKED_CAST")
        this.handler = this.activity as? A
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        this.binding = this.setBinding(inflater,container)
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
    abstract fun setBinding(inflater: LayoutInflater, container: ViewGroup?): T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        insertFood()
        insertRecipes()
        detectWichFragmentIsOpen()
    }

    var domain = Domain()

    companion object {
        internal var listener: LoaderListener? = null
        fun setLoaderListener(callback: LoaderListener) {
            this.listener = callback
        }

        internal var listenerSearch: SearchButtonListener? = null
        fun setSearchButtonListener(callback: SearchButtonListener) {
            this.listenerSearch = callback
        }

        internal var listenerSearchFavourite: SearchFavouriteButtonListener? = null
        fun setSearchFavouriteButtonListener(callback: SearchFavouriteButtonListener) {
            this.listenerSearchFavourite = callback
        }

        var setlistDatabase: MutableList<Recipes> = mutableListOf()
        var setFavouriteList: MutableList<FavouritesRecipes> = mutableListOf()
        var setFavouriteListFilter: MutableList<FavouritesRecipes> = mutableListOf()
        var recipesNumberSize: Int? = 0
        var recipesFavouritesNumberSize: Int? = 0
        val setlistDatabaseFilter: MutableList<Recipes> = mutableListOf()

    }

    val recipesDatabaseItemAdapter = ItemAdapter<Recipes>()
    private var fastAdapter =
        FastAdapter.with(recipesDatabaseItemAdapter)

    val favouriteRecipesItemAdapter = ItemAdapter<FavouritesRecipes>()
    private val favouritesFastAdapter = FastAdapter.with(favouriteRecipesItemAdapter)

    private lateinit var linearLayoutManager: LinearLayoutManager

    //Viewmodel
    private lateinit var recipeViewModel: RecipeViewModel
    private lateinit var favouriteRecipesViewmodel: FavouritesRecipesViewModel
    private lateinit var ingredientsViewmodel: IngredientsViewModel





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
        }

        if (BuildConfig.VERSION_NAME != OnboardingActivity.sharedPrefVersionName.getString(
                OnboardingActivity.VERSION_APP_NAME,
                "1.0.0"
            )
        ) {
            recipeViewModel.deleteAllRecipesInDatabase()
            domain.updateSharedPrefVersionName()
        }
    }

    private fun setupRecipeRecyclerView() {
        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerview.layoutManager = linearLayoutManager
        recyclerview.adapter = fastAdapter

        //configure our fastAdapter
        fastAdapter.onClickListener =
            { v: View?, _: IAdapter<Recipes>, item: GenericItem, _: Int ->
                v?.let {
                    // When we click, we retrieve here the clicked element and sen list of benefits in the method
                    if (item is Recipes) {
                        val id: Long = item.id
                        openRecipeDetailActivity(id, 1)
                    }
                }
                true
            }

        handleFastAdapterClickImageFavourite(fastAdapter, favouriteRecipesViewmodel)
    }

    private fun setupFavouriteRecipeRecyclerView() {
        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerview.layoutManager = linearLayoutManager
        recyclerview.adapter = favouritesFastAdapter

        //configure our fastAdapter
        favouritesFastAdapter.onClickListener =
            { v: View?, _: IAdapter<FavouritesRecipes>, item: FavouritesRecipes, _: Int ->
                v?.let {
                    val url: String? = item.recipeUrl
                    openWebViewActivity(url)
                    if (item.recipePhotoUrl.let { it?.contains("freezdge", true) == true }) {
                        val id: Long? = item.recipeId?.toLong()
                        openRecipeDetailActivity(id, 2)
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

    private fun openRecipeDetailActivity(id: Long?, backpressValue: Int) {
        let {
            val intent = Intent(activity, RecipeDetailActivity::class.java)
            intent.putExtra("RECIPE_ID", id)
            intent.putExtra("BACKPRESS_VALUE", backpressValue)
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
                    not_found.visibility = View.VISIBLE
                    not_found.text = getString(R.string.internet_connexion)
                    floatingActionButton.hide()
                    topTextview.visibility = View.GONE
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
                        not_found.visibility = View.GONE
                        imageArrow.visibility = View.INVISIBLE
                        floatingActionButton.show()
                        listenerSearchFavourite?.showSearchButton()
                        for (myresult in result) {
                            favouriteRecipesItemAdapter.add(myresult)
                            setFavouriteList.add(myresult)
                        }
                        favouritesRecipesNumber()
                    } else {
                        not_found.visibility = View.VISIBLE
                        imageArrow.visibility = View.VISIBLE
                        floatingActionButton.hide()
                        listenerSearchFavourite?.hideSearchButton()
                        topTextview.visibility = View.GONE
                        not_found.text = getString(R.string.no_item_found_favourite)
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

        if (setlistDatabase.isNullOrEmpty()) {
            val nbIngredients: MutableList<Ingredients>? =
                ingredientsViewmodel.getIngredientsForFreezdgeList()
            if (nbIngredients?.size != 0) {
                recipeViewModel.getDatabaseRecipes(nbIngredients)
                    ?.observe(viewLifecycleOwner, Observer { result2 ->
                        if (result2.isNullOrEmpty()) {
                            not_found.visibility = View.VISIBLE
                            not_found.text =
                                getString(R.string.no_recipes_found)
                            topTextview.visibility = View.GONE
                            listenerSearch?.hideSearchButton()
                            floatingActionButton.hide()
                            listener?.hideLoader()
                        } else {
                            not_found.visibility = View.GONE
                            floatingActionButton.show()
                            listenerSearch?.showSearchButton()
                            fillAdapterDatabase(result2)
                        }
                    })
            } else {
                not_found.visibility = View.VISIBLE
                not_found.text =
                    getString(R.string.no_item_found_recipes)
                listenerSearch?.hideSearchButton()
                topTextview.visibility = View.GONE
                floatingActionButton.hide()
                listener?.hideLoader()
            }
        } else {
            fillAdapterDatabase(setlistDatabase)
        }


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


    private fun handleFastAdapterClickImageFavourite(
        fastAdapter: FastAdapter<Recipes>,
        favouriteRecipesViewmodel: FavouritesRecipesViewModel
    ) {

        fastAdapter.addClickListener({ vh: ViewHolderRecipesDatabase -> vh.imageFavourite }) { _, _, _: FastAdapter<Recipes>, item: GenericItem ->
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
                    item.dishType,
                    item.recipePhotoUrlOwner
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

        fastAdapter.addClickListener({ vh: ViewHolderRecipesDatabase -> vh.proportionText }) { _, _, i: FastAdapter<Recipes>, item: GenericItem ->
            //react on the click event
            if (item is Recipes) {
                onClickMatching(item.recipeIngredients)
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
                item.cuisineType, item.dishType, item.recipePhotoUrlOwner
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

        favouritesFastAdapter.addClickListener({ vh: ViewHolderFavouritesRecipes -> vh.proportionText }) { _, _, i: FastAdapter<FavouritesRecipes>, item: GenericItem ->
            //react on the click event
            if (item is FavouritesRecipes) {
                onClickMatching(item.recipeIngredients)
            }

        }


    }


    // click on post image to open preview dialog
    private fun onClickMatching(ingredients: String?) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        val previous = activity?.supportFragmentManager?.findFragmentByTag(GroceryListDialog.TAG)
        if (previous != null) {
            transaction?.remove(previous)
        }
        transaction?.addToBackStack(null)

        val ingredientsList:ArrayList<String> = domain.missingIngredients(ingredients)

        val dialogFragment = ingredientsList?.let { GroceryListDialog.newInstance(it) }
        if (transaction != null) {
            dialogFragment?.show(transaction, GroceryListDialog.TAG)
        }
    }


    // show number of recipes found
    private fun recipesNumber() {
        topTextview.visibility = View.VISIBLE
        recipesNumberSize = setlistDatabase.size
        if (recipesNumberSize != 1) {
            topTextview.text = getString(R.string.recipe_list_number, recipesNumberSize)
        } else {
            topTextview.text =
                getString(R.string.recipe_list_number_one, recipesNumberSize)
        }
    }

    // show number of favourites recipes found
    private fun favouritesRecipesNumber() {
        topTextview.visibility = View.VISIBLE
        recipesFavouritesNumberSize = setFavouriteList.size
        if (recipesFavouritesNumberSize != 1) {
            topTextview.text =
                getString(R.string.recipe_list_number, recipesFavouritesNumberSize)
        } else {
            topTextview.text =
                getString(R.string.recipe_list_number_one, recipesFavouritesNumberSize)
        }
    }

}

