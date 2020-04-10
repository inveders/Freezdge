package com.inved.freezdge.ingredientslist.repository

import com.inved.freezdge.BuildConfig
import com.inved.freezdge.ingredientslist.retrofit.FoodApi
import com.inved.freezdge.ingredientslist.retrofit.RetrofitServiceFood

class FoodRepository {

    private val appKEY: String = BuildConfig.APP_KEY_FOOD
    private val appID: String = BuildConfig.APP_ID_FOOD

    private var client: FoodApi = RetrofitServiceFood.webservice

    suspend fun getFoodLiveData(ingredients: String) = client.getFood(ingredients, appID, appKEY)
}