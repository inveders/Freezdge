package com.inved.freezdge.recipes.repository

import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.database.Recipes_
import com.inved.freezdge.recipes.retrofit.RecipesApi
import com.inved.freezdge.recipes.retrofit.RetrofitServiceRecipes
import com.inved.freezdge.utils.AddRecipesInDatabase
import io.objectbox.Box
import io.objectbox.android.ObjectBoxLiveData

class RecipesRepository(private val getRecipesBox: Box<Recipes>?) {

    private val appKEY: String = com.inved.freezdge.BuildConfig.APP_KEY_RECIPES
    private val appID: String = com.inved.freezdge.BuildConfig.APP_ID_RECIPES

    private var client: RecipesApi = RetrofitServiceRecipes.webservice

    // retrofit call to retrieve recipes wich contains given ingredient
    suspend fun getRecipesLiveData(ingredient: String?) = client.getRecipes(ingredient, appID, appKEY)

    // get one specific recipe from our database
    fun getRecipeLiveDataById(id:Long): Recipes? {
        // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
        return getRecipesBox?.query()?.equal(Recipes_.id,id)?.build()?.findUnique()
    }

    // in database, get recipes wich contains  given ingredient name
    fun getRecipeIfContainIngredient(ingredientName: String): ObjectBoxLiveData<Recipes>  {
        return ObjectBoxLiveData(
            getRecipesBox?.query()?.contains(Recipes_.recipeIngredients,ingredientName)?.build())
    }

    // insert in database all recipes of mine
    fun insertRecipesInDatabase() {
        AddRecipesInDatabase(getRecipesBox)
    }

    // delete all recipes in the database and inert again (only if there is an update of the database)
    fun deleteAllRecipesInBox() {
        getRecipesBox?.removeAll()
        insertRecipesInDatabase()
    }

    // count all recipes in the database
    fun countRecipesInBox():Long? {
        return getRecipesBox?.count()
    }

    //get all recipes
    fun getAllRecipes(): MutableList<Recipes>? {
        // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
        return getRecipesBox?.all
    }

}

