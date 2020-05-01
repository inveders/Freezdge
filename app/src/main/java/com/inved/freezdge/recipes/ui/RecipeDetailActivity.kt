package com.inved.freezdge.recipes.ui

import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.inved.freezdge.R
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.view.CustomExpandableListAdapter
import com.inved.freezdge.recipes.view.RecipeStepView
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.GlideApp
import kotlinx.android.synthetic.main.activity_recipe_detail.*

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
    var listData = HashMap<String, List<String>>()
    private var data: HashMap<String, List<String>>?=null



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

            titleList = ArrayList(listData.keys)
            adapter =
                listData?.let {
                    CustomExpandableListAdapter(this, titleList as ArrayList<String>,
                        it
                    )
                }
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
        recipeTitle.text=recipe.recipeTitle
        recipePrepCookTime.text=getString(R.string.recipe_detail_item_detail_time,recipe.preparationTime,recipe.cookedTime)
        recipeTotalTime.text=getString(R.string.recipe_detail_item_total_time,recipe.totalrecipeTime)
        val kcal:String = if(recipe.recipeCalories.isNullOrEmpty()){
            getString(R.string.recipe_list_item_kcal_notknow)
        }else{
            recipe.recipeCalories!!
        }
        recipeKcal.text=getString(R.string.recipe_detail_item_kcal,kcal)
        recipeNumberPerson.text=getString(R.string.recipe_detail_item_number_person,recipe.numberPersons)

        recipeDetailPhoto.let {
            GlideApp.with(App.applicationContext())
                .load(recipe.recipePhotoUrl)
                .centerCrop()
            .into(it)
        }

        if(!recipe.step1.isNullOrEmpty()){
            addSummaryRecipeItems(getString(R.string.step_recipe,1,recipe.step1))
        }
        if(!recipe.step2.isNullOrEmpty()){
            addSummaryRecipeItems(getString(R.string.step_recipe,2,recipe.step2))
        }
        if(!recipe.step3.isNullOrEmpty()){
            addSummaryRecipeItems(getString(R.string.step_recipe,3,recipe.step3))
        }
        if(!recipe.step4.isNullOrEmpty()){
            addSummaryRecipeItems(getString(R.string.step_recipe,4,recipe.step4))
        }
        if(!recipe.step5.isNullOrEmpty()){
            addSummaryRecipeItems(getString(R.string.step_recipe,5,recipe.step5))
        }
        if(!recipe.step6.isNullOrEmpty()){
            addSummaryRecipeItems(getString(R.string.step_recipe,6,recipe.step6))
        }
        if(!recipe.step7.isNullOrEmpty()){
            addSummaryRecipeItems(getString(R.string.step_recipe,7,recipe.step7))
        }
        if(!recipe.step8.isNullOrEmpty()){
            addSummaryRecipeItems(getString(R.string.step_recipe,8,recipe.step8))
        }
        if(!recipe.step9.isNullOrEmpty()){
            addSummaryRecipeItems(getString(R.string.step_recipe,9,recipe.step9))
        }
        if(!recipe.step10.isNullOrEmpty()){
            addSummaryRecipeItems(getString(R.string.step_recipe,10,recipe.step10))
        }
        if(!recipe.step11.isNullOrEmpty()){
            addSummaryRecipeItems(getString(R.string.step_recipe,11,recipe.step11))
        }
        if(!recipe.step12.isNullOrEmpty()){
            addSummaryRecipeItems(getString(R.string.step_recipe,12,recipe.step12))
        }

        recipeOwnerImage.let {
            GlideApp.with(App.applicationContext())
                .load(recipe.recipePhotoUrlOwner)
                .circleCrop()
                .into(it)
        }

        recipeOwnerImage.setOnClickListener {
            recipe.recipeUrlOwnerLink?.let {
            openWebViewActivity(
                it
            )
        } }
        
        addDataInExpandable(Domain.retrieveListFromString(recipe.recipeIngredients))
        setupExpandableView()
        
    }

    private fun addDataInExpandable(listFromString: List<String>):HashMap<String, List<String>> {
        data?.clear()


        val listIngredients = ArrayList<String>()
        for (ingredient in listFromString){
            listIngredients.add(ingredient)
        }

        listData["Ingredients"] = listIngredients
        data?.set("Ingredients", listIngredients)

//        listData= this!!.data!!
        return listData
    }

    fun openWebViewActivity(url: String) {
        let { val intent= Intent(this, WebviewActivity::class.java)
            intent.putExtra("WEBVIEW_URL", url)
            startActivity(intent) }
    }

    private fun addSummaryRecipeItems(
        stepRecipe: String
    ) {
        //TBL
        val stepRecipeSummaryView =
            RecipeStepView(this)
        stepRecipeSummaryView.init()
        stepRecipeSummaryView.setText(stepRecipe)
        stepSummaryView.addView(stepRecipeSummaryView)
    }

}