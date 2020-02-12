package com.inved.freezdge.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.inved.freezdge.model.recipes.Hit
import com.inved.freezdge.model.recipes.Results
import com.inved.freezdge.repository.RecipesRepository

class RecipeModel(application: Application):AndroidViewModel(application)  {

    private val recipesRepository = RecipesRepository()

    fun getRecipes(ingredients:String):LiveData<List<Results>>{
        return recipesRepository.getRecipesLiveData(ingredients)
    }
}