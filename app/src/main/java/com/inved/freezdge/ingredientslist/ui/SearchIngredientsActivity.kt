package com.inved.freezdge.ingredientslist.ui

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.inved.freezdge.R
import com.inved.freezdge.recipes.ui.AllRecipesFragment
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_search_ingredients.*


class SearchIngredientsActivity : BaseActivity() {

    private var loader: LottieAnimationView? = null
    private var loaderContainer: FrameLayout? = null

    private val navController by lazy { findNavController(R.id.navHostIngredient) }
    private val bottomNavigationView by lazy { findViewById<BottomNavigationView>(R.id.activity_search_bottom_navigation) }
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initToolbar(navController)
        setUpNavigationBottom(navController)
        loader=findViewById(R.id.animation_view)
        loaderContainer=findViewById(R.id.animation_view_container)
        initToolbarBaseActivity(R.string.toolbar_search_ingredients)
         showLoadingIndicator()


    }

    //INITIALIZATION


    fun initToolbar(navController: NavController){

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.fragment_cream,
                R.id.fragment_fruits_vegetables,
                R.id.fragment_epicerie,
                R.id.fragment_fish,
                R.id.fragment_meat
            )
        )

        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)

    }

    private fun setUpNavigationBottom(navController: NavController) {

        NavigationUI.setupWithNavController(bottomNavigationView,navController)
        bottomNavigationView.menu.findItem(R.id.action_to_fragment_cream).isChecked = true
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.search_menu, menu)
        val searchItem = menu?.findItem(R.id.search_menu)
      /*  if (searchItem != null) {
            val searchView = searchItem.actionView as SearchView
            val edittext =
                searchView.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
            edittext.hint = getString(R.string.search_ingredient_searchview_label)
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    showLoadingIndicator()
                    if (newText!!.isNotEmpty()) {

                        foodSearchItemAdapter.clear()
                        val search = newText.toLowerCase(Locale.ROOT)
                        ingredientViewmodel.getAllIngredients()
                            .observe({ lifecycle }, { list ->

                                var count:Int=0
                                if(list.size!=0){
                                    list.forEach {
                                        if (it.name!!.toLowerCase(Locale.ROOT).contains(search)) {
                                            foodSearchItemAdapter.add(it)
                                            count=count.plus(1)
                                        }
                                    }

                                    if(count==0){
                                        Toast.makeText(applicationContext,getString(R.string.toastNoIngredientResultSearch),Toast.LENGTH_SHORT).show()
                                    }
                                    hideLoadingIndicator()
                                }

                            })

                    } else {

                    }

                    return true
                }
            })
        }*/
        return super.onCreateOptionsMenu(menu)
    }

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_search_ingredients
    }


    override fun onSupportNavigateUp() = true.also { onBackPressed() }

    fun showLoadingIndicator() {
        AllRecipesFragment.loader?.post {
            AllRecipesFragment.loader!!.playAnimation()
            AllRecipesFragment.loaderContainer?.visibility = View.VISIBLE
        }
    }

    fun hideLoadingIndicator() {
        AllRecipesFragment.loader?.post {
            AllRecipesFragment.loader!!.pauseAnimation()
            AllRecipesFragment.loaderContainer?.visibility = View.GONE
        }
    }

    fun setUpNavigation() {

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment?
        NavigationUI.setupWithNavController(
            activity_search_bottom_navigation,
            navHostFragment!!.navController
        )
    }
}