package com.inved.freezdge.recipes.repository

import com.inved.freezdge.BuildConfig
import com.inved.freezdge.recipes.retrofit.RecipesApi
import com.inved.freezdge.recipes.retrofit.RetrofitServiceRecipes

class RecipesRepository {

    private val appKEY: String = BuildConfig.APP_KEY_RECIPES
    private val appID: String = BuildConfig.APP_ID_RECIPES

    private var client: RecipesApi = RetrofitServiceRecipes.webservice

    suspend fun getRecipesLiveData(ingredients: String) = client.getRecipes(ingredients, appID, appKEY)

    suspend fun getRecipesByIdLiveData(recipeId: String) = client.getRecipesById(recipeId, appID, appKEY)

}

