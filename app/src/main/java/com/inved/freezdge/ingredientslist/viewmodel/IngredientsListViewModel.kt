package com.inved.freezdge.ingredientslist.viewmodel

import androidx.lifecycle.ViewModel
import com.inved.freezdge.ingredientslist.database.IngredientsList
import com.inved.freezdge.ingredientslist.repository.IngredientsListRepository

class IngredientsListViewModel (private val ingredientsListRepository: IngredientsListRepository) : ViewModel() {

    fun getIngredientListByRecipe(recipeId:Long): MutableList<IngredientsList>? {
        return ingredientsListRepository.getIngredientListByRecipe(recipeId)
    }

    fun insertIngredientsList() {
        ingredientsListRepository.insertIngredientsList()
    }

    fun deleteAllIngredientsList() {
        return ingredientsListRepository.deleteAllIngredientsListInBox()
    }

}