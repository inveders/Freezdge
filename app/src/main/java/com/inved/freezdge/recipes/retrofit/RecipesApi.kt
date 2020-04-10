package com.inved.freezdge.recipes.retrofit

import com.inved.freezdge.model.recipes.Results
import retrofit2.http.GET
import retrofit2.http.Query


interface RecipesApi {

    @GET("search")
    suspend fun getRecipes(
        @Query("q") q: String?,
        @Query("app_id") distance: String?,
        @Query("app_key") type: String?

    ): Results
}