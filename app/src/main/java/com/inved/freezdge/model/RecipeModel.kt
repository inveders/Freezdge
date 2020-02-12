package com.inved.freezdge.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.inved.freezdge.repository.RecipesRepository

class RecipeModel:AndroidViewModel(Application())  {

    val recipesRepository = RecipesRepository()

    fun getRecipes(ingredients:String):LiveData<List<Result>>{
        return recipesRepository.getRecipesLiveData(ingredients)
    }
}