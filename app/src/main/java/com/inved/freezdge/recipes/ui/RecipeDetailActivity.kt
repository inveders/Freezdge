package com.inved.freezdge.recipes.ui

import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.inved.freezdge.R
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.view.CustomExpandableListAdapter
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.GlideApp

class RecipeDetailActivity : BaseActivity() {

    lateinit var recipeTitle: TextView
    lateinit var recipePrepCookTime: TextView
    lateinit var recipeTotalTime: TextView
    lateinit var recipeDetailPhoto: ImageView
    lateinit var recipeKcal: TextView
    lateinit var recipeNumberPerson: TextView
    lateinit var recipeOwnerImage: ImageView
    lateinit var stepSummaryView : LinearLayout

    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var titleList: List<String> ? = null

    private val data: HashMap<String, List<String>>
        get() {
            val listData = HashMap<String, List<String>>()

            val samsungMobiles = ArrayList<String>()
            samsungMobiles.add("Samsung Galaxy S9+")
            samsungMobiles.add("Samsung Galaxy Note 7")
            samsungMobiles.add("Samsung Galaxy Note 5 Dual")
            samsungMobiles.add("Samsung Galaxy S8")
            samsungMobiles.add("Samsung Galaxy A8")
            samsungMobiles.add("Samsung Galaxy Note 4")

            listData["Samsung"] = samsungMobiles

            return listData
        }


    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_recipe_detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipeOwnerImage=findViewById(R.id.activity_recipe_detail_photo_owner)
        recipeNumberPerson=findViewById(R.id.activity_recipe_detail_number_person_image_text)
        recipeKcal=findViewById(R.id.activity_recipe_detail_kcal_image_text)
        recipeDetailPhoto=findViewById(R.id.activity_recipe_detail_photo)
        recipeTotalTime=findViewById(R.id.activity_recipe_total_time)
        recipePrepCookTime=findViewById(R.id.activity_recipe_detail_time_image_text)
        recipeTitle=findViewById(R.id.activity_recipe_detail_name)
        stepSummaryView=findViewById(R.id.summaryItemLinearLayout)
        initToolbarBaseActivity(R.string.toolbar_recipe_detail)

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
        setupExpandableView()
        
    }

    private fun addDataInExpandable(listFromString: List<String>):HashMap<String, List<String>> {

        val listIngredients = ArrayList<String>()
        for (ingredient in listFromString){
            listIngredients.add(ingredient)
        }
        data.clear()
        data["Ingredients"] = listIngredients

        return data
    }

    fun openWebViewActivity(url: String) {
        let { val intent= Intent(this, WebviewActivity::class.java)
            intent.putExtra("WEBVIEW_URL", url)
            startActivity(intent) }
    }

}