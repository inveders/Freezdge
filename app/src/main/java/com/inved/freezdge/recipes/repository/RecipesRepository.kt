package com.inved.freezdge.recipes.repository

import com.inved.freezdge.BuildConfig
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.database.Recipes_
import com.inved.freezdge.recipes.retrofit.RecipesApi
import com.inved.freezdge.recipes.retrofit.RetrofitServiceRecipes
import com.inved.freezdge.uiGeneral.fragment.BaseFragment
import com.inved.freezdge.utils.AddRecipesInDatabase
import io.objectbox.Box
import io.objectbox.android.ObjectBoxLiveData

class RecipesRepository(private val getRecipesBox: Box<Recipes>) {

    private val appKEY: String = BuildConfig.APP_KEY_RECIPES
    private val appID: String = BuildConfig.APP_ID_RECIPES

    private var client: RecipesApi = RetrofitServiceRecipes.webservice

    suspend fun getRecipesLiveData(ingredients: String) = client.getRecipes(ingredients, appID, appKEY)

    fun getRecipeLiveDataById(id:Long): Recipes? {
        // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
        return getRecipesBox.query().equal(Recipes_.id,id).build().findUnique()
    }

    fun getRecipeIfContainIngredient(ingredientName: String): ObjectBoxLiveData<Recipes>  {
        return ObjectBoxLiveData(
            getRecipesBox.query().contains(Recipes_.recipeIngredients,ingredientName).build())
    }

    fun insertRecipesInDatabase() {
        AddRecipesInDatabase(getRecipesBox)
        val editor = BaseFragment.sharedPref.edit()
        editor.putLong(BaseFragment.PREF_NAME, getRecipesBox.count())
        editor.apply()
    }


    fun deleteAllRecipesInBox() {
        getRecipesBox.removeAll()
        insertRecipesInDatabase()
    }

    fun countRecipesInBox():Long {
        return getRecipesBox.count()
    }

}

