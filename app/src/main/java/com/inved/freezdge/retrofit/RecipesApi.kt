package com.inved.freezdge.retrofit

import com.inved.freezdge.model.recipes.Recipe
import com.squareup.okhttp.Call
import retrofit2.http.GET

interface RecipesApi {

    @GET("search") /**A MODIFIER*/
    fun getRecipes(
      /*  @Query("location") location: String?,
        @Query("rankby") distance: String?,
        @Query("type") type: String?,
        @Query("key") api_key: String?
   */ ): Call<Recipe>?
}