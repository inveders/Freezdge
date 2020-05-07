package com.inved.freezdge.recipes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.inved.freezdge.model.recipes.Results
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.repository.RecipesRepository
import io.objectbox.android.ObjectBoxLiveData
import kotlinx.coroutines.Dispatchers

class RecipeViewModel(private val recipesRepository: RecipesRepository) : ViewModel() {

    suspend fun getRecipes(arg: String): LiveData<Results> {
        return liveData(Dispatchers.IO) {
            val retrievedRecipes = recipesRepository.getRecipesLiveData(arg)
            emit (retrievedRecipes)
        }
    }

    fun getAllSelectedRecipes(): ObjectBoxLiveData<Recipes> {
        return recipesRepository.getAllSelectedRecipes()
    }


    fun getRecipeLiveDataById(id:Long): Recipes? {
        return recipesRepository.getRecipeLiveDataById(id)
    }

    fun isRecipeSelected(name: String?): Boolean {
        return recipesRepository.isRecipeSelected(name)
    }


    fun updateRecipeSelectedByName(name: String?) {
        return recipesRepository.updateRecipeSelectedByName(name)
    }

    suspend fun getRecipeIfContainIngredient(ingredientName: String): ObjectBoxLiveData<Recipes>  {
        return recipesRepository.getRecipeIfContainIngredient(ingredientName)
    }

    fun insertRecipesInDatabase() {
        return recipesRepository.insertRecipesInDatabase()
    }
}