package com.inved.freezdge.retrofit

import com.inved.freezdge.model.food.ResultsFood
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodApi {

    @GET("parser")
    suspend fun getFood(
        @Query("ingr") ingr: String?,
        @Query("app_id") distance: String?,
        @Query("app_key") type: String?

    ): ResultsFood
}