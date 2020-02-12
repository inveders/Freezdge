package com.inved.freezdge.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.inved.freezdge.retrofit.RecipesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipesRepository {

    var mutableLiveData:MutableLiveData<List<Result>>=MutableLiveData;

    fun getRecipesLiveData(ingredients: String):MutableLiveData<List<Result>> {

        val call: Call<RecipesData> =
            RecipesApi.getRecipes(location, rankby, type, MAP_API_KEY)

        call.enqueue(object: Callback<List<RecipesData>> {
            override fun onResponse(call: Call<List<RecipesData>>, response: Response<List<RecipesData>>) {
                val allRecipes = response.body()
                allRecipes?.let {
                    for( call in it) {
                        Log.d("debago","Arret Tan ${call.libelle}")
                    }

                    mutableLiveData.value(allRecipes)
                }
            }
            override fun onFailure(call: Call<List<RecipesData>>, t: Throwable) {
                Log.e("TAN", "Error : $t")
            }
        })

    }

}