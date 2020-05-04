package com.inved.freezdge.recipes.ui

import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.google.firebase.storage.FirebaseStorage
import com.inved.freezdge.R
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.view.CustomExpandableListAdapter
import com.inved.freezdge.recipes.view.RecipeStepView
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.Domain.Companion.convertDpToPixel
import com.inved.freezdge.utils.GlideApp


open class RecipeDetailActivity : BaseActivity() {

    lateinit var recipeTitle: TextView
    lateinit var recipePrepCookTime: TextView
    lateinit var recipeTotalTime: TextView
    lateinit var recipeDetailPhoto: ImageView
    lateinit var recipeKcal: TextView
    lateinit var recipeNumberPerson: TextView
    lateinit var recipeOwnerImage: ImageView
    lateinit var stepSummaryView: LinearLayout

    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private lateinit var listParent:ArrayList<String>
    private lateinit var listDataChild:HashMap<String,List<String>>

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_recipe_detail
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipeOwnerImage = findViewById(R.id.activity_recipe_detail_photo_owner)
        recipeNumberPerson = findViewById(R.id.activity_recipe_detail_number_person_image_text)
        recipeKcal = findViewById(R.id.activity_recipe_detail_kcal_image_text)
        recipeDetailPhoto = findViewById(R.id.activity_recipe_detail_photo)
        recipeTotalTime = findViewById(R.id.activity_recipe_total_time)
        recipePrepCookTime = findViewById(R.id.activity_recipe_detail_time_image_text)
        recipeTitle = findViewById(R.id.activity_recipe_detail_name)
        stepSummaryView = findViewById(R.id.summaryItemLinearLayout)
        initToolbarBaseActivity(R.string.toolbar_recipe_detail)

        val id: Long = intent.getLongExtra("RECIPE_ID", 0)
        getRecipeById(id)
    }

    private fun setupExpandableView() {
        expandableListView = findViewById(R.id.expandableListView)
        if (expandableListView != null) {

            adapter = CustomExpandableListAdapter(this, listParent, listDataChild)

            expandableListView?.setAdapter(adapter)

        }

        expandableListView?.setOnGroupExpandListener {
            var height = 0
            for (i in 0 until expandableListView!!.getChildCount()) {
                height += expandableListView!!.getChildAt(i).getMeasuredHeight()
                height += expandableListView!!.getDividerHeight()
            }
            expandableListView?.layoutParams?.height = (height + 6) * 10
        }

        // Listview Group collapsed listener
        expandableListView?.setOnGroupCollapseListener {

            expandableListView?.layoutParams?.height = convertDpToPixel(61)
        }

    }

    private fun addDataInExpandable(listFromString: List<String>) {

        val ingredientsList = ArrayList<String>()

        for(i in listFromString){
            ingredientsList.add(i)
        }

        listParent= ArrayList()
        listDataChild= HashMap()
        // Adding child data

        listParent.add("Ingrédients")
        listDataChild[listParent[0]] = ingredientsList // Header, Child data

    }

    private fun getRecipeById(id: Long) {
        val recipe: Recipes? = recipeModel.getRecipeLiveDataById(id)
        if (recipe != null) {
            fillRecipePage(recipe)
        }
    }

    private fun fillRecipePage(recipe: Recipes) {
        recipeTitle.text = recipe.recipeTitle
        recipePrepCookTime.text = getString(
            R.string.recipe_detail_item_detail_time,
            recipe.preparationTime,
            recipe.cookedTime
        )
        recipeTotalTime.text =
            getString(R.string.recipe_detail_item_total_time, recipe.totalrecipeTime)
        val kcal: String = if (recipe.recipeCalories?.isEmpty()!!) {
            getString(R.string.recipe_list_item_kcal_notknow)
        } else {
            recipe.recipeCalories!!
        }
        recipeKcal.text = getString(R.string.recipe_detail_item_kcal, kcal)
        recipeNumberPerson.text =
            getString(R.string.recipe_detail_item_number_person, recipe.numberPersons)


        val storage = FirebaseStorage.getInstance()
        // Create a reference to a file from a Google Cloud Storage URI
        val gsReference = recipe.recipePhotoUrl?.let { storage.getReferenceFromUrl(it) }
        GlideApp.with(App.applicationContext())
            .load(gsReference)
            .into(recipeDetailPhoto)


        if (!recipe.step1.isNullOrEmpty()) {
            addSummaryRecipeItems(getString(R.string.step_recipe, 1, recipe.step1))
        }
        if (!recipe.step2.isNullOrEmpty()) {
            addSummaryRecipeItems(getString(R.string.step_recipe, 2, recipe.step2))
        }
        if (!recipe.step3.isNullOrEmpty()) {
            addSummaryRecipeItems(getString(R.string.step_recipe, 3, recipe.step3))
        }
        if (!recipe.step4.isNullOrEmpty()) {
            addSummaryRecipeItems(getString(R.string.step_recipe, 4, recipe.step4))
        }
        if (!recipe.step5.isNullOrEmpty()) {
            addSummaryRecipeItems(getString(R.string.step_recipe, 5, recipe.step5))
        }
        if (!recipe.step6.isNullOrEmpty()) {
            addSummaryRecipeItems(getString(R.string.step_recipe, 6, recipe.step6))
        }
        if (!recipe.step7.isNullOrEmpty()) {
            addSummaryRecipeItems(getString(R.string.step_recipe, 7, recipe.step7))
        }
        if (!recipe.step8.isNullOrEmpty()) {
            addSummaryRecipeItems(getString(R.string.step_recipe, 8, recipe.step8))
        }
        if (!recipe.step9.isNullOrEmpty()) {
            addSummaryRecipeItems(getString(R.string.step_recipe, 9, recipe.step9))
        }
        if (!recipe.step10.isNullOrEmpty()) {
            addSummaryRecipeItems(getString(R.string.step_recipe, 10, recipe.step10))
        }
        if (!recipe.step11.isNullOrEmpty()) {
            addSummaryRecipeItems(getString(R.string.step_recipe, 11, recipe.step11))
        }
        if (!recipe.step12.isNullOrEmpty()) {
            addSummaryRecipeItems(getString(R.string.step_recipe, 12, recipe.step12))
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
            }
        }

        addDataInExpandable(Domain.retrieveListFromString(recipe.recipeIngredients))
        setupExpandableView()

    }


    fun openWebViewActivity(url: String) {
        let {
            val intent = Intent(this, WebviewActivity::class.java)
            intent.putExtra("WEBVIEW_URL", url)
            startActivity(intent)
        }
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