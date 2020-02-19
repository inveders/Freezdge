package com.inved.freezdge.repository

import com.inved.freezdge.BuildConfig
import com.inved.freezdge.retrofit.RecipesApi
import com.inved.freezdge.retrofit.RetrofitServiceRecipes

class RecipesRepository {

    private val appKEY: String = BuildConfig.APP_KEY
    private val appID: String = BuildConfig.APP_ID

    var client: RecipesApi = RetrofitServiceRecipes.webservice

    suspend fun getRecipesLiveData(ingredients: String) = client.getRecipes(ingredients, appID, appKEY)


}

