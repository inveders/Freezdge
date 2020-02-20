package com.inved.freezdge.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.inved.freezdge.model.recipes.Results
import com.inved.freezdge.repository.RecipesRepository
import kotlinx.coroutines.Dispatchers

class RecipeModel(application: Application) : AndroidViewModel(application) {

    private val recipesRepository: RecipesRepository = RecipesRepository()

    fun getRecipes(arg: String): LiveData<Results> {
        return liveData(Dispatchers.IO) {
            val retrievedRecipes = recipesRepository.getRecipesLiveData(arg)
            emit (retrievedRecipes)
        }
    }

}