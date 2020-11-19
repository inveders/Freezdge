package com.inved.freezdge.uiGeneral.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.inved.freezdge.BuildConfig
import com.inved.freezdge.R
import com.inved.freezdge.schedule.adapter.CalendarDayNameItem
import com.inved.freezdge.schedule.adapter.NotYetPlanedItem
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.database.FavouritesRecipes_
import com.inved.freezdge.schedule.model.DaySelectionModel
import com.inved.freezdge.schedule.ui.CalendarFragment
import com.inved.freezdge.favourites.ui.MyRecipesFragment
import com.inved.freezdge.schedule.ui.SelectDayDialog
import com.inved.freezdge.schedule.viewmodel.DaySelectedViewModel
import com.inved.freezdge.favourites.viewmodel.FavouritesRecipesViewModel
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.ui.MyIngredientsListFragment
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.injection.Injection
import com.inved.freezdge.onboarding.OnboardingActivity
import com.inved.freezdge.recipes.adapter.ListRecipeItem
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.model.ShowedRecipes
import com.inved.freezdge.recipes.ui.AllRecipesFragment
import com.inved.freezdge.recipes.ui.RecipeDetailActivity
import com.inved.freezdge.recipes.ui.WebviewActivity
import com.inved.freezdge.recipes.viewmodel.RecipeViewModel
import com.inved.freezdge.uiGeneral.dialog.GroceryListDialog
import com.inved.freezdge.utils.*
import com.inved.freezdge.utils.enumtype.ChipsDayType
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.IAdapter
import com.mikepenz.fastadapter.adapters.GenericItemAdapter
import com.mikepenz.fastadapter.listeners.addClickListener
import io.objectbox.kotlin.boxFor
import kotlinx.android.synthetic.main.fragment_my_recipes.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

enum class FragmentDetected(val number: Int) {
    ALL_RECIPES_FRAGMENT(1),
    FAVOURITE_FRAGMENT(2),
    CALENDAR_FRAGMENT(3),
    MY_INGREDIENTS_FRAGMENT(4)
}

abstract class BaseFragment<T : ViewBinding, A : Any> : Fragment(),
    SelectDayDialog.SelectDateListener {

    private var handler: A? = null //It's base activity
    protected open var binding: T? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        @Suppress("UNCHECKED_CAST")
        this.handler = this.activity as? A
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        this.binding = this.setBinding(inflater, container)
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
        insertDays()
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

    var itemAdapter = GenericItemAdapter()
    var fastAdapter = FastAdapter.with(itemAdapter)

    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var gridLayoutManager: GridLayoutManager

    //Viewmodel
    lateinit var recipeViewModel: RecipeViewModel
    private lateinit var favouriteRecipesViewmodel: FavouritesRecipesViewModel
    private lateinit var ingredientsViewmodel: IngredientsViewModel
    private lateinit var daySelectedViewModel: DaySelectedViewModel

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
        daySelectedViewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(DaySelectedViewModel::class.java)
    }

    private fun insertDays() {

        if (daySelectedViewModel.countDays()?.toInt() == 0) {
            Log.d("debago", "count day are " + daySelectedViewModel.countDays())
            daySelectedViewModel.insertDays()
        }

        if (BuildConfig.VERSION_NAME != OnboardingActivity.sharedPrefVersionName.getString(
                OnboardingActivity.VERSION_APP_NAME,
                BuildConfig.VERSION_NAME
            )
        ) {
            daySelectedViewModel.deleteAllDays()
            domain.updateSharedPrefVersionName()
        } else {
            domain.updateSharedPrefVersionName()
        }
    }

    private fun insertFood() {

        if (ingredientsViewmodel.countIngredients()?.toInt() == 0) {
            ingredientsViewmodel.insertIngredients()
        }

        if (BuildConfig.VERSION_NAME != OnboardingActivity.sharedPrefVersionName.getString(
                OnboardingActivity.VERSION_APP_NAME,
                BuildConfig.VERSION_NAME
            )
        ) {
            ingredientsViewmodel.deleteAllIngredients()
            domain.updateSharedPrefVersionName()
        } else {
            domain.updateSharedPrefVersionName()
        }
    }

    private fun insertRecipes() {

        if (recipeViewModel.countAllRecipesInDatabase()?.toInt() == 0) {
            recipeViewModel.insertRecipesInDatabase()
        }

        if (BuildConfig.VERSION_NAME != OnboardingActivity.sharedPrefVersionName.getString(
                OnboardingActivity.VERSION_APP_NAME,
                BuildConfig.VERSION_NAME
            )
        ) {
            recipeViewModel.deleteAllRecipesInDatabase()
            domain.updateSharedPrefVersionName()
        } else {
            domain.updateSharedPrefVersionName()
        }
    }

    private fun setupRecipeRecyclerView(wichFragment: Int) {
        gridLayoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        linearLayoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        if (wichFragment == FragmentDetected.CALENDAR_FRAGMENT.number) {
            recyclerview.layoutManager = gridLayoutManager
        } else {
            recyclerview.layoutManager = linearLayoutManager
        }
        recyclerview.adapter = fastAdapter

        //configure our fastAdapter
        fastAdapter.onClickListener =
            { v: View?, _: IAdapter<GenericItem>, item: GenericItem, _: Int ->
                v?.let {
                    // When we click, we retrieve here the clicked element and sen list of benefits in the method
                    if (item is ListRecipeItem) {
                        if (item.model?.isFavouriteRecipe == true) {
                            val url: String? = item.model?.recipeUrlOwnerLink
                            openWebViewActivity(url)
                            if (item.model?.recipePhotoUrl.let {
                                    it?.contains(
                                        "freezdge",
                                        true
                                    ) == true
                                }) {
                                val id: Long? = item.model?.id
                                openRecipeDetailActivity(
                                    id,
                                    FragmentDetected.FAVOURITE_FRAGMENT.number
                                )
                            }
                        } else {
                            val id: Long? = item.model?.id
                            openRecipeDetailActivity(
                                id,
                                FragmentDetected.ALL_RECIPES_FRAGMENT.number
                            )
                        }

                    }
                }
                true
            }

        if (wichFragment == FragmentDetected.ALL_RECIPES_FRAGMENT.number) {
            handleFastAdapterClickImageFavourite(fastAdapter, favouriteRecipesViewmodel)
        } else if (wichFragment == FragmentDetected.FAVOURITE_FRAGMENT.number || wichFragment == FragmentDetected.CALENDAR_FRAGMENT.number) {
            handleFavouriteFastAdapterClick(fastAdapter, favouriteRecipesViewmodel)
        }

        if (wichFragment == FragmentDetected.CALENDAR_FRAGMENT.number) {
            //handle click on notYetPlaned
            handleCalendarFastAdapterClick()
        }

    }

    private fun handleCalendarFastAdapterClick() {
        fastAdapter.addClickListener({ vh: NotYetPlanedItem.ViewHolder -> vh.imageItem }) { v: View, pos: Int, _: FastAdapter<GenericItem>, item: GenericItem ->
            if (item is NotYetPlanedItem) {
                val clickedDay: DaySelectionModel? = DaySelectionModel().apply {
                    this.day = item.day
                    if (item.isLunchOrDinner == ChipsDayType.LUNCH.chipPosition) {
                        this.lunch = 1
                        this.dinner = 0L
                    } else if (item.isLunchOrDinner == ChipsDayType.DINNER.chipPosition) {
                        this.lunch = 0L
                        this.dinner = 1
                    }
                }
                openSelectDateDialog(clickedDay, pos, null)

            }
        }
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
                setupRecipeRecyclerView(FragmentDetected.ALL_RECIPES_FRAGMENT.number)
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
                setupRecipeRecyclerView(FragmentDetected.FAVOURITE_FRAGMENT.number)
                getFavouritesRecipes()
            }
            getForegroundFragment() is CalendarFragment -> run {
                setupRecipeRecyclerView(FragmentDetected.CALENDAR_FRAGMENT.number)
                getCalendarRecipes()
            }
            getForegroundFragment() is MyIngredientsListFragment -> run {
                setupRecipeRecyclerView(FragmentDetected.MY_INGREDIENTS_FRAGMENT.number)
            }
        }
    }

    private fun getFavouritesRecipes() {
        itemAdapter.clear()
        favouriteRecipesViewmodel.getAllFavouritesRecipes()
            .observe(viewLifecycleOwner, Observer { result ->
                itemAdapter.clear()
                if (result != null) {
                    if (result.size != 0) {
                        setFavouriteList.clear()
                        not_found.visibility = View.GONE
                        imageArrow.visibility = View.INVISIBLE
                        floatingActionButton.show()
                        listenerSearchFavourite?.showSearchButton()
                        fillFavouriteAdapterDatabase(result)
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


    fun getCalendarRecipes() {
        itemAdapter.clear()
        val items = mutableListOf<GenericItem>()
        daySelectedViewModel.getSelectedDay()?.forEach { res ->

            items.add(CalendarDayNameItem().apply {
                dayName = domain.handleSelectedDay(res.id)
            })
            items.add(CalendarDayNameItem().apply {
                dayName = ""
            })

            if (res.lunch == 0L) {
                items.add(NotYetPlanedItem().apply {
                    this.day = res.id
                    this.isLunchOrDinner = ChipsDayType.LUNCH.chipPosition
                })
            } else {
                res.lunch?.let {
                    recipeViewModel.getRecipeLiveDataById(it)?.let {
                        items.add(ListRecipeItem().apply {
                            this.model = fillModelListRecipes(it)
                            this.isReducedWidth = true
                            this.selectedDay = res
                            this.selectedPosition = ChipsDayType.LUNCH.chipPosition
                        })
                    }
                }
            }

            if (res.dinner == 0L) {
                items.add(NotYetPlanedItem().apply {
                    this.day = res.id
                    this.isLunchOrDinner = ChipsDayType.DINNER.chipPosition
                })
            } else {
                res.dinner?.let {
                    recipeViewModel.getRecipeLiveDataById(it)?.let {
                        items.add(ListRecipeItem().apply {
                            this.model = fillModelListRecipes(it)
                            this.isReducedWidth = true
                            this.selectedDay = res
                            this.selectedPosition = ChipsDayType.DINNER.chipPosition
                        })
                    }
                }
            }

        }

        if (items.isNullOrEmpty()) {
            not_found.visibility = View.VISIBLE
            not_found.text = getString(R.string.no_item_found_calendar)
        } else {
            not_found.visibility = View.GONE
        }
        itemAdapter.add(items)

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
                            //  listenerSearch?.hideSearchButton()
                            floatingActionButton.hide()
                            listener?.hideLoader()
                        } else {
                            not_found.visibility = View.GONE
                            floatingActionButton.show()
                            //  listenerSearch?.showSearchButton()
                            fillAdapterDatabase(result2)
                        }
                    })
            } else {
                not_found.visibility = View.VISIBLE
                not_found.text =
                    getString(R.string.no_item_found_recipes)
                //  listenerSearch?.hideSearchButton()
                topTextview.visibility = View.GONE
                floatingActionButton.hide()
                listener?.hideLoader()
            }
        } else {
            fillAdapterDatabase(setlistDatabase)
        }


    }

    private fun fillAdapterDatabase(setlistDatabase: MutableList<Recipes>) {
        itemAdapter.clear()
        val items = mutableListOf<GenericItem>()
        val myList: MutableList<ShowedRecipes>? = mutableListOf()
        setlistDatabase.forEach { recipe ->
            fillModelListRecipes(recipe)?.let { myList?.add(it) }
        }
        myList?.sortByDescending { it.matchingValue }

        myList?.forEach {
            items.add(ListRecipeItem().apply {
                this.model = it
            })
        }
        itemAdapter.add(items)
        BaseFragment.setlistDatabase = setlistDatabase
        recipesNumber()
        listener?.hideLoader()
    }

    private fun fillFavouriteAdapterDatabase(setlistDatabase: MutableList<FavouritesRecipes>) {
        itemAdapter.clear()
        val items = mutableListOf<GenericItem>()
        val myList: MutableList<ShowedRecipes>? = mutableListOf()
        setlistDatabase.forEach { favouriteRecipe ->
            fillModelListFavouriteRecipes(favouriteRecipe)?.let { myList?.add(it) }
        }
        myList?.sortByDescending { it.matchingValue }

        myList?.forEach {
            items.add(ListRecipeItem().apply {
                this.model = it
            })
        }
        itemAdapter.add(items)
        setFavouriteList = setlistDatabase
        favouritesRecipesNumber()
    }

    fun fillModelListRecipes(recipes: Recipes): ShowedRecipes? {
        val model = ShowedRecipes()
        model.apply {
            model.id = recipes.id
            model.recipeTitle = recipes.recipeTitle
            model.recipeCalories = recipes.recipeCalories
            model.totalrecipeTime = domain.preparationTime(recipes.totalrecipeTime)
            model.cuisineType = recipes.cuisineType
            model.dishType = recipes.dishType
            model.recipePhotoUrl = recipes.recipePhotoUrl
            model.recipePhotoUrlOwner = recipes.recipePhotoUrlOwner
            model.recipeUrlOwnerLink = recipes.recipeUrlOwnerLink
            model.recipeIngredients = recipes.recipeIngredients
            model.matchingValue =
                domain.ingredientsFavouriteMatchingMethod(recipes.recipeIngredients)
            model.isFavouriteRecipe = recipes.id.toString().let { isRecipeIdIsPresent(it) }
            model.isAllRecipeFragment = true
            model.selectedDay = daySelectedViewModel.isRecipeSelectedInCalendar(recipes.id)
            return model
        }

    }


    fun fillModelListFavouriteRecipes(recipes: FavouritesRecipes): ShowedRecipes? {
        val model = ShowedRecipes()
        model.apply {
            model.id = recipes.recipeId?.toLong()
            model.favouriteId = recipes.id
            model.recipeTitle = recipes.recipeTitle
            model.recipeCalories = recipes.recipeCalories
            model.totalrecipeTime = recipes.recipeTime
            model.cuisineType = recipes.cuisineType
            model.dishType = recipes.dishType
            model.recipePhotoUrl = recipes.recipePhotoUrl
            model.recipePhotoUrlOwner = recipes.recipePhotoUrlOwner
            model.recipeUrlOwnerLink = recipes.recipeUrl
            model.recipeIngredients = recipes.recipeIngredients
            model.matchingValue =
                domain.ingredientsFavouriteMatchingMethod(recipes.recipeIngredients)
            model.isFavouriteRecipe = recipes.recipeId?.let { isRecipeIdIsPresent(it) }
            model.isAllRecipeFragment = false
            model.selectedDay =
                daySelectedViewModel.isRecipeSelectedInCalendar(recipes.recipeId?.toLong()!!)
            return model
        }

    }

    private fun isRecipeIdIsPresent(recipeId: String): Boolean {
        val favouritesRecipes: FavouritesRecipes? =
            App.ObjectBox.boxStore.boxFor<FavouritesRecipes>()
                .query().equal(FavouritesRecipes_.recipeId, recipeId)
                .build().findUnique()
        return favouritesRecipes != null
    }

    private fun handleFastAdapterClickImageFavourite(
        fastAdapter: FastAdapter<GenericItem>,
        favouriteRecipesViewmodel: FavouritesRecipesViewModel
    ) {

        fastAdapter.addClickListener({ vh: ListRecipeItem.ViewHolder -> vh.imageFavourite }) { _, _, _: FastAdapter<GenericItem>, item: GenericItem ->
            //react on the click event
            if (item is ListRecipeItem) {
                favouriteRecipesViewmodel.detectFavouriteRecipe(
                    item.model?.id.toString(),
                    item.model?.recipeTitle,
                    item.model?.recipeCalories,
                    item.model?.totalrecipeTime,
                    item.model?.recipeUrlOwnerLink,
                    item.model?.recipePhotoUrl,
                    item.model?.recipeIngredients,
                    item.model?.cuisineType,
                    item.model?.dishType,
                    item.model?.recipePhotoUrlOwner,
                    item.model?.selectedDay
                )

                GlobalScope.launch(Dispatchers.IO) {
                    delay(500)
                    item.model?.recipeIngredients?.let {
                        domain.correspondanceCalculForGrocery(
                            it,
                            item.model?.isFavouriteRecipe
                        )
                    }
                }

                if (item.model?.isFavouriteRecipe == false) {
                    view.let { it1 ->
                        it1?.let {
                            item.getViewHolder(it).imageFavourite.setImageResource(
                                R.drawable.ic_favorite_selected_24dp
                            )
                        }
                    }
                    item.model?.isFavouriteRecipe = true
                } else {
                    view.let { it1 ->
                        it1?.let {
                            item.getViewHolder(it).imageFavourite.setImageResource(
                                R.drawable.ic_favorite_not_selected_24dp
                            )
                        }
                    }
                    //   item.model?.id?.let { daySelectedViewModel.reinitLunchValues(it) }
                    //   item.model?.id?.let { daySelectedViewModel.reinitDinnerValues(it) }
                    item.model?.isFavouriteRecipe = false
                }

                fastAdapter.notifyAdapterDataSetChanged()
            }

        }

        fastAdapter.addClickListener({ vh: ListRecipeItem.ViewHolder -> vh.proportionText }) { _, _, i: FastAdapter<GenericItem>, item: GenericItem ->
            //react on the click event
            if (item is ListRecipeItem) {
                onClickMatching(item.model?.recipeIngredients)
            }

        }

        fastAdapter.addClickListener({ vh: ListRecipeItem.ViewHolder -> vh.selectDateButton }) { _, pos: Int, i: FastAdapter<GenericItem>, item: GenericItem ->
            //react on the click event
            if (item is ListRecipeItem) {
                openSelectDateDialog(
                    null,
                    pos,
                    item.model?.id.toString()
                )
            }
        }
    }

    //click on a favourite recipe, manage favourite image enable or not
    private fun handleFavouriteFastAdapterClick(
        favouritesFastAdapter: FastAdapter<GenericItem>,
        favouriteRecipesViewmodel: FavouritesRecipesViewModel
    ) {
        favouritesFastAdapter.addClickListener({ vh: ListRecipeItem.ViewHolder -> vh.imageFavourite }) { _, _: Int, _: FastAdapter<GenericItem>, item: GenericItem ->
            //react on the click event

            if (item is ListRecipeItem) {
                favouriteRecipesViewmodel.detectFavouriteRecipe(
                    item.model?.id.toString(),
                    item.model?.recipeTitle,
                    item.model?.recipeCalories,
                    item.model?.totalrecipeTime,
                    item.model?.recipeUrlOwnerLink,
                    item.model?.recipePhotoUrl,
                    item.model?.recipeIngredients,
                    item.model?.cuisineType,
                    item.model?.dishType,
                    item.model?.recipePhotoUrlOwner,
                    item.model?.selectedDay
                )

                GlobalScope.launch(Dispatchers.IO) {
                    delay(500)
                    item.model?.recipeIngredients?.let {
                        domain.correspondanceCalculForGrocery(
                            it,
                            item.model?.isFavouriteRecipe
                        )
                    }
                }

                favouritesFastAdapter.notifyAdapterDataSetChanged()
            }

        }

        favouritesFastAdapter.addClickListener({ vh: ListRecipeItem.ViewHolder -> vh.proportionText }) { _, _, i: FastAdapter<GenericItem>, item: GenericItem ->
            //react on the click event
            if (item is ListRecipeItem) {
                onClickMatching(item.model?.recipeIngredients)
            }
        }

        favouritesFastAdapter.addClickListener({ vh: ListRecipeItem.ViewHolder -> vh.selectDateButton }) { _, pos: Int, i: FastAdapter<GenericItem>, item: GenericItem ->
            //react on the click event
            if (item is ListRecipeItem) {
                openSelectDateDialog(
                    null,
                    pos,
                    item.model?.id.toString()
                )
            }
        }


    }


    private fun openSelectDateDialog(
        clickedDay: DaySelectionModel?,
        itemPosition: Int?,
        recipeId: String?
    ) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        val previous = activity?.supportFragmentManager?.findFragmentByTag(SelectDayDialog.TAG)
        if (previous != null) {
            transaction?.remove(previous)
        }
        transaction?.addToBackStack(null)
        SelectDayDialog.setSelectDateListener(this)
        val dialogFragment: DialogFragment? = if (clickedDay == null) {
            SelectDayDialog.newInstance(null, itemPosition, recipeId)
        } else {
            SelectDayDialog.newInstance(clickedDay, itemPosition, recipeId)
        }
        if (transaction != null) {
            dialogFragment?.show(transaction, SelectDayDialog.TAG)
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

        val ingredientsList: ArrayList<String> = domain.missingIngredients(ingredients)

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


    override fun onDateSelected(
        selectedDayList: MutableList<DaySelectionModel?>?,
        itemPosition: Int?,
        recipeId: String?
    ) {

        if (recipeId != null) {
            selectedDayList?.forEach { s ->
                if (s != null) {
                    s.day?.let { dayValue ->
                        s.lunch?.let { lunchValue ->
                            s.dinner?.let { dinnerValue ->
                                daySelectedViewModel.updateSelectedDayValues(
                                    dayValue,
                                    lunchValue, dinnerValue
                                )
                            }
                        }
                    }
                }

            }
            updateGroceryList()
        }
        when {
            getForegroundFragment() is MyRecipesFragment -> run {
                getFavouritesRecipes()
            }
            getForegroundFragment() is CalendarFragment -> run {
                getCalendarRecipes()

            }
        }
        if (itemPosition != null) {
            recyclerview.scrollToPosition(itemPosition)
        }

    }

    private fun updateGroceryList() {
        ingredientsViewmodel.resetGroceryList()
        daySelectedViewModel.getSelectedDay()?.forEach { daySelected ->
            val lunchRecipe =
                daySelected.lunch?.let { recipeViewModel.getRecipeLiveDataById(it) }
            val dinnerRecipe =
                daySelected.dinner?.let { recipeViewModel.getRecipeLiveDataById(it) }
            updateGroceryToTrue(lunchRecipe)
            updateGroceryToTrue(dinnerRecipe)
        }

    }

    private fun updateGroceryToTrue(recipe: Recipes?) {
        recipe?.recipeIngredients?.let {
            domain.retrieveListFromString(it).forEach { eachIngredient ->

                ingredientsViewmodel.getAllIngredients()?.forEach { ingredientName ->
                    if (eachIngredient.contains(ingredientName.name.toString(), true)) {
                        if (ingredientsViewmodel.isIngredientSelected(ingredientName.name) == false) {
                            if (ingredientsViewmodel.isIngredientSelectedInGrocery(
                                    ingredientName.name
                                ) == false
                            ) {
                                ingredientsViewmodel.updateIngredientSelectedForGroceryByName(
                                    ingredientName.name,
                                    true
                                )
                            }
                        }
                    }
                }


            }
        }

    }

}

