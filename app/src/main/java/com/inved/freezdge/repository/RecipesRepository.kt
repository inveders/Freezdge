package com.inved.freezdge.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.inved.freezdge.BuildConfig
import com.inved.freezdge.model.recipes.Hit
import com.inved.freezdge.model.recipes.Results
import com.inved.freezdge.retrofit.RecipesApi
import com.inved.freezdge.retrofit.RetrofitServiceRecipes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipesRepository {

    var mutableLiveData=MutableLiveData<List<Hit>>()
    private val APP_KEY: String = BuildConfig.APP_KEY
    private val APP_ID: String = BuildConfig.APP_ID
    private var recipesApi:RecipesApi=RetrofitServiceRecipes.getRecipesApi();

    init {
        mutableLiveData.value = listOf()
    }

    fun getRecipesLiveData(ingredients: String):MutableLiveData<List<Hit>> {

        val call = recipesApi.getRecipes(ingredients, APP_ID, APP_KEY)

        call.enqueue(object : Callback<List<Hit>> {
            override fun onResponse(call: Call<List<Hit>>, response: Response<List<Hit>>) {
                val allRecipes = response.body()
                Log.d("debago","All recipes size are ${allRecipes?.size}")
                if (allRecipes != null) {
                    Log.d("debago","All recipes one is ${allRecipes.size}")
                    mutableLiveData.value=allRecipes
                }
            }
            override fun onFailure(call: Call<List<Hit>>, t: Throwable) {
                Log.d("debago","Failure")
            }
        })

        return mutableLiveData
    }

}

