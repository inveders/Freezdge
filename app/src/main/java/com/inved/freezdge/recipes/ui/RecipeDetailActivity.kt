package com.inved.freezdge.recipes.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.recipes.adapter.DetailRecipeItem
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.view.DetailRecipeExpandableSubItem
import com.inved.freezdge.recipes.view.DetailSummaryExpandableItem
import com.inved.freezdge.recipes.view.DetailSummaryExpandableSubItem
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import com.inved.freezdge.uiGeneral.activity.MainActivity
import com.inved.freezdge.utils.Domain
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.GenericItemAdapter
import com.mikepenz.fastadapter.adapters.ItemAdapter
import com.mikepenz.fastadapter.expandable.getExpandableExtension
import com.mikepenz.fastadapter.listeners.addClickListener


open class RecipeDetailActivity : BaseActivity() {

    var domain = Domain()
    private var backpressValue = 1
    lateinit var recipeTitle: TextView

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter<GenericItem>
    private lateinit var fastAdapter: FastAdapter<GenericItem>

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_recipe_detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView = findViewById(R.id.recyclerview)
        initToolbarBaseActivity(R.string.toolbar_recipe_detail)

        val id: Long = intent.getLongExtra("RECIPE_ID", 0)
        val backpressValueBis: Int = intent.getIntExtra("BACKPRESS_VALUE", 1)
        backpressValue = backpressValueBis
        getRecipeById(id)
    }

    private fun setupRecyclerView() {

        recyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.isNestedScrollingEnabled = false
        //   fastAdapter?.onClickListener = this
        itemAdapter = GenericItemAdapter()
        fastAdapter= FastAdapter.with(itemAdapter)
        fastAdapter.getExpandableExtension().isOnlyOneExpandedItem =false
        recyclerView.adapter = fastAdapter

        fastAdapter.addClickListener({ vh: DetailRecipeItem.ViewHolder -> vh.recipeOwnerImage }) { v: View, pos: Int, _: FastAdapter<GenericItem>, item: GenericItem ->

            if (item is DetailRecipeItem) {
                v.startAnimation(domain.animation())
                item.recipe?.recipeUrlOwnerLink?.let {
                    if (it.contains("facebook",ignoreCase = true) && isFbAppInstalled()) {
                        val uri:String = it
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
                        startActivity(intent);
                    }else{
                        openWebViewActivity(
                            it
                        )
                    }
                }
            }
        }

    }

    private fun fetchData(
        recipeIngredientsList: List<String>,
        recipeStepList: MutableList<String>,
        recipe: Recipes
    ){
        val items = mutableListOf<GenericItem>()

        items.add(DetailRecipeItem().apply {
            this.recipe = recipe
        })

        //add ingredients
        val ingredientsList = DetailSummaryExpandableItem().apply {
            this.title = getString(
                R.string.menu_bottom_ingredient_at_home
            )
        }
        recipeIngredientsList.forEach {
            ingredientsList.subItems.add(DetailSummaryExpandableSubItem().apply {
                this.ingredient = it
            })
        }
        items.add(ingredientsList)


        //add recipes step
        val recipeStep = DetailSummaryExpandableItem().apply {
            this.title = getString(
                R.string.recipe_detail_item_recipe_view
            )
        }
        recipeStepList.forEachIndexed { index, step ->
            recipeStep.subItems.add(DetailRecipeExpandableSubItem().apply {
                this.numberStep = index + 1
                this.recipeStep = step
            })
        }
        items.add(recipeStep)

        fillRecyclerView(items)
    }

    private fun fillRecyclerView(data: MutableList<GenericItem>) {
        itemAdapter?.clear()
        itemAdapter?.add(data)

    }

    private fun getRecipeById(id: Long) {
        setupRecyclerView()
        val recipe: Recipes? = recipeViewModel.getRecipeLiveDataById(id)
        if (recipe != null) {
            fetchData(
                domain.retrieveListFromString(recipe.recipeIngredients), fillRecipeSteps(
                    recipe
                ), recipe
            )
        }
    }


    private fun fillRecipeSteps(recipe: Recipes):MutableList<String> {
        val listRecipeStep: MutableList<String> = mutableListOf()
        recipe.step1.let {
            if(!it.isNullOrEmpty()){
                listRecipeStep.add(it)
            }

        }
        recipe.step2.let {
            if(!it.isNullOrEmpty()){
                listRecipeStep.add(it)
            }
        }
        recipe.step3.let {
            if(!it.isNullOrEmpty()){
                listRecipeStep.add(it)
            }
        }
        recipe.step4.let {
            if(!it.isNullOrEmpty()){
                listRecipeStep.add(it)
            }
        }
        recipe.step5.let {
            if(!it.isNullOrEmpty()){
                listRecipeStep.add(it)
            }
        }
        recipe.step6.let {
            if(!it.isNullOrEmpty()){
                listRecipeStep.add(it)
            }
        }
        recipe.step7.let {
            if(!it.isNullOrEmpty()){
                listRecipeStep.add(it)
            }
        }
        recipe.step8.let {
            if(!it.isNullOrEmpty()){
                listRecipeStep.add(it)
            }
        }
        recipe.step9.let {
            if(!it.isNullOrEmpty()){
                listRecipeStep.add(it)
            }
        }
        recipe.step10.let {
            if(!it.isNullOrEmpty()){
                listRecipeStep.add(it)
            }
        }
        recipe.step11.let {
            if(!it.isNullOrEmpty()){
                listRecipeStep.add(it)
            }
        }
        recipe.step12.let {
            if(!it.isNullOrEmpty()){
                listRecipeStep.add(it)
            }
        }
        return listRecipeStep
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("BACKPRESS", backpressValue)
        startActivity(intent)
    }

    private fun openWebViewActivity(url: String) {
        let {
            val intent = Intent(this, WebviewActivity::class.java)
            intent.putExtra("WEBVIEW_URL", url)
            startActivity(intent)
        }
    }

    private fun isFbAppInstalled():Boolean{
        return try {
            val info = packageManager.getApplicationInfo("com.facebook.katana", 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }

    }








}