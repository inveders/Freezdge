package com.inved.freezdge.recipes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.model.food.ResultsFood
import com.inved.freezdge.model.recipes.Results
import com.inved.freezdge.ingredientslist.repository.FoodRepository
import com.inved.freezdge.ingredientslist.repository.IngredientsRepository
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.database.RecipesDAO
import com.inved.freezdge.recipes.repository.RecipesRepository
import io.objectbox.android.ObjectBoxLiveData
import kotlinx.coroutines.Dispatchers

class RecipeModel(application: Application) : AndroidViewModel(application) {

    private val recipesRepository: RecipesRepository = RecipesRepository()
    private val foodRepository: FoodRepository =
        FoodRepository()

    fun getRecipes(arg: String): LiveData<Results> {
        return liveData(Dispatchers.IO) {
            val retrievedRecipes = recipesRepository.getRecipesLiveData(arg)
            emit (retrievedRecipes)
        }
    }

    fun getFood(arg: String): LiveData<ResultsFood> {
        return liveData(Dispatchers.IO) {
            val retrievedFood = foodRepository.getFoodLiveData(arg)
            emit (retrievedFood)
        }
    }

    fun getAllSelectedRecipes(): ObjectBoxLiveData<Recipes> {
        return RecipesRepository.getAllSelectedRecipes()
    }


    fun getRecipeLiveDataById(id:Long): ObjectBoxLiveData<Recipes> {
        return RecipesRepository.getRecipeLiveDataById(id)
    }

    fun isRecipeSelected(name: String?): Boolean {
        return RecipesRepository.isRecipeSelected(name)
    }


    fun updateRecipeSelectedByName(name: String?) {
        return RecipesRepository.updateRecipeSelectedByName(name)
    }
}