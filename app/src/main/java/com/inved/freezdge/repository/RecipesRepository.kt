package com.inved.freezdge.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.inved.freezdge.BuildConfig
import com.inved.freezdge.model.recipes.Results
import com.inved.freezdge.retrofit.RecipesApi
import com.inved.freezdge.retrofit.RetrofitServiceRecipes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipesRepository {

    var mutableLiveData=MutableLiveData<List<Results>>()
    private val APP_KEY: String = BuildConfig.APP_KEY
    private val APP_ID: String = BuildConfig.APP_ID
    private var recipesApi:RecipesApi=RetrofitServiceRecipes.getRecipesApi();

    init {
        mutableLiveData.value = listOf()
    }

    fun getRecipesLiveData(ingredients: String):MutableLiveData<List<Results>> {

        val call = recipesApi.getRecipes(ingredients, APP_ID, APP_KEY)


       /* call.enqueue(object: Callback<List<Results>>, com.squareup.okhttp.Callback {
            override fun onFailure(call: Call<List<Results>>, t: Throwable) {
                Log.d("debago","Failure")
            }

            override fun onResponse(call: Call<List<Results>>, response: Response<List<Results>>) {
                val allRecipes = response.body()
                allRecipes?.let {

                }

                mutableLiveData.value=allRecipes
            }

            override fun onFailure(request: Request?, e: IOException?) {
                Log.d("debago","no way 1")
            }

            override fun onResponse(response: com.squareup.okhttp.Response?) {
                Log.d("debago","no way 2")
            }


        })*/



        call.enqueue(object : Callback<List<Results>> {
            override fun onResponse(call: Call<List<Results>>, response: Response<List<Results>>) {
                val allRecipes = response.body()
                if (allRecipes != null) {
                    Log.d("debago","All recipes one is ${allRecipes[0].hits?.get(0)?.recipe?.label}")
                    mutableLiveData.value=allRecipes
                }
            }
            override fun onFailure(call: Call<List<Results>>, t: Throwable) {
                Log.d("debago","Failure")
            }
        })

        return mutableLiveData
    }

}

