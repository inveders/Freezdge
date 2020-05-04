package com.inved.freezdge.ingredientslist.viewmodel

import androidx.lifecycle.ViewModel
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.repository.IngredientsRepository
import io.objectbox.android.ObjectBoxLiveData


class IngredientsViewModel : ViewModel() {


    fun insertIngredients() {
        IngredientsRepository.insertIngredients()
    }

    fun updateIngredient(ingredient: Ingredients) {
        return IngredientsRepository.updateIngredient(ingredient)
    }

    fun getIngredientsForFreezdgeList(): MutableList<Ingredients> {
        return IngredientsRepository.getIngredientsLiveDataBySelected()
    }

    fun updateIngredientSelectedByName(name:String?,bool:Boolean) {
        return IngredientsRepository.updateIngredientSelectedByName(name,bool)
    }

    fun updateIngredientSelectedForGroceryByName(name:String?,bool:Boolean) {
        return IngredientsRepository.updateIngredientSelectedForGroceryByName(name,bool)
    }

    fun getIngredientsForGrocery(): ObjectBoxLiveData<Ingredients> {
        return IngredientsRepository.getIngredientsLiveDataBySelectedForGrocery()
    }

    fun getAllIngredients(): ObjectBoxLiveData<Ingredients> {
        return IngredientsRepository.getIngredientsLiveDataById()
    }

    fun getAllIngredientsByType(typeIngredient:String): ObjectBoxLiveData<Ingredients> {
        return IngredientsRepository.getIngredientsLiveDataByTypeId(typeIngredient)
    }

    fun isIngredientSelected(name: String?): Boolean {
        return IngredientsRepository.isIngredientSelected(name)
    }

    fun isIngredientSelectedInGrocery(name: String?): Boolean {
        return IngredientsRepository.isIngredientSelectedInGrocery(name)
    }

}