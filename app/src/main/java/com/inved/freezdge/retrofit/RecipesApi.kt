package com.inved.freezdge.retrofit

import com.inved.freezdge.model.recipes.Hit
import com.inved.freezdge.model.recipes.Results
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call


interface RecipesApi {

    @GET("search")
    fun getRecipes(
        @Query("q") q: String?,
        @Query("app_id") distance: String?,
        @Query("app_key") type: String?

    ):Call<List<Hit>>
}