package com.inved.freezdge.recipes.ui

import android.content.Intent
import android.os.Bundle
import android.widget.*
import butterknife.BindView
import butterknife.ButterKnife
import com.inved.freezdge.R
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.view.CustomExpandableListAdapter
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.GlideApp

class RecipeDetailActivity : BaseActivity() {

    @BindView(R.id.activity_recipe_detail_name)
    var recipeTitle: TextView? = null

    @BindView(R.id.activity_recipe_detail_time_image_text)
    var recipePrepCookTime: TextView? = null

    @BindView(R.id.activity_recipe_total_time)
    var recipeTotalTime: TextView? = null

    @BindView(R.id.activity_recipe_detail_photo)
    var recipeDetailPhoto: ImageView? = null

    @BindView(R.id.activity_recipe_detail_kcal_image_text)
    var recipeKcal: TextView? = null

    @BindView(R.id.activity_recipe_detail_number_person_image_text)
    var recipeNumberPerson: TextView? = null

    @BindView(R.id.activity_recipe_detail_photo_owner)
    var recipeOwnerImage: ImageView? = null


    @BindView(R.id.summaryItemLinearLayout)
    var stepSummaryView : LinearLayout?= null


    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var titleList: List<String> ? = null
    private lateinit var data: HashMap<String, List<String>>

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_recipe_detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ButterKnife.bind(this)
        initToolbarBaseActivity(R.string.toolbar_recipe_detail)
        setupExpandableView()
        val id:Long = intent.getLongExtra("RECIPE_ID",0)
        getRecipeById(id)
    }

    private fun setupExpandableView() {
        expandableListView = findViewById(R.id.expandableListView)
        if (expandableListView != null) {
            val listData = data
            titleList = ArrayList(listData.keys)
            adapter = CustomExpandableListAdapter(this, titleList as ArrayList<String>, listData)
            expandableListView!!.setAdapter(adapter)

            expandableListView!!.setOnGroupExpandListener { groupPosition -> Toast.makeText(applicationContext, (titleList as ArrayList<String>)[groupPosition] + " List Expanded.", Toast.LENGTH_SHORT).show() }

            expandableListView!!.setOnGroupCollapseListener { groupPosition -> Toast.makeText(applicationContext, (titleList as ArrayList<String>)[groupPosition] + " List Collapsed.", Toast.LENGTH_SHORT).show() }

            expandableListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
                Toast.makeText(applicationContext, "Clicked: " + (titleList as ArrayList<String>)[groupPosition] + " -> " + listData[(titleList as ArrayList<String>)[groupPosition]]!!.get(childPosition), Toast.LENGTH_SHORT).show()
                false
            }

            expandableListView!!.setOnGroupExpandListener {
                    groupPosition -> Toast.makeText(applicationContext, (titleList as ArrayList<String>)[groupPosition] + " List Expanded.", Toast.LENGTH_SHORT).show()
            }
        }



    }

    private fun getRecipeById(id:Long){
        val recipe: Recipes? =recipeModel.getRecipeLiveDataById(id)
         if(recipe!=null){
             fillRecipePage(recipe)
         }
    }

    private fun fillRecipePage(recipe: Recipes) {
        recipeTitle?.text=recipe.recipeTitle
        recipePrepCookTime?.text=getString(R.string.recipe_detail_item_detail_time,recipe.preparationTime,recipe.cookedTime)
        recipeTotalTime?.text=getString(R.string.recipe_detail_item_total_time,recipe.totalrecipeTime)
        recipeKcal?.text=getString(R.string.recipe_detail_item_kcal,recipe.recipeCalories)
        recipeNumberPerson?.text=getString(R.string.recipe_detail_item_number_person,recipe.numberPersons)

        recipeDetailPhoto?.let {
            GlideApp.with(App.applicationContext())
                .load(recipe.recipePhotoUrl)
                .centerCrop()
            .into(it)
        }

        recipeOwnerImage?.let {
            GlideApp.with(App.applicationContext())
                .load(recipe.recipePhotoUrlOwner)
                .circleCrop()
                .into(it)
        }

        recipeOwnerImage?.setOnClickListener { v -> recipe.recipeUrlOwnerLink?.let {
            openWebViewActivity(
                it
            )
        } }
        
        addDataInExpandable(Domain.retrieveListFromString(recipe.recipeIngredients))
        
    }

    private fun addDataInExpandable(listFromString: List<String>):HashMap<String, List<String>> {
        val listIngredients = ArrayList<String>()
        for (ingredient in listFromString){
            listIngredients.add(ingredient)
        }
        data["Ingredients"] = listIngredients

        return data
    }

    fun openWebViewActivity(url: String) {
        let { val intent= Intent(this, WebviewActivity::class.java)
            intent.putExtra("WEBVIEW_URL", url)
            startActivity(intent) }
    }

}