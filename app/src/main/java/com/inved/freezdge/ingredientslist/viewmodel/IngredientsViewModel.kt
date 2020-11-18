package com.inved.freezdge.ingredientslist.viewmodel

import androidx.lifecycle.ViewModel
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.repository.IngredientsRepository
import io.objectbox.android.ObjectBoxLiveData


class IngredientsViewModel(private val ingredientsRepository: IngredientsRepository) : ViewModel() {

    fun insertIngredients() {
        ingredientsRepository.insertIngredients()
    }

    fun countIngredients():Long? {
        return ingredientsRepository.countIngredients()
    }

    fun updateIngredient(ingredient: Ingredients) {
        return ingredientsRepository.updateIngredient(ingredient)
    }

    fun getIngredientsForFreezdgeList(): MutableList<Ingredients>? {
        return ingredientsRepository.getAllIngredientBySelected()
    }

    fun updateIngredientSelectedByName(name:String?,bool:Boolean) {
        return ingredientsRepository.updateIngredientSelectedByName(name,bool)
    }

    fun updateIngredientSelectedForGroceryByName(name:String?,bool:Boolean) {
        return ingredientsRepository.updateIngredientSelectedForGroceryByName(name,bool)
    }

    fun getIngredientsForGrocery(): ObjectBoxLiveData<Ingredients> {
        return ingredientsRepository.getAllIngredientBySelectedForGrocery()
    }

    fun getAllIngredientsLiveData(): ObjectBoxLiveData<Ingredients> {
        return ingredientsRepository.getAllIngredientsByIdLiveData()
    }

    fun getAllIngredients(): MutableList<Ingredients>? {
        return ingredientsRepository.getAllIngredientsById()
    }

    fun deleteAllIngredients() {
        return ingredientsRepository.deleteAllIngredientsInBox()
    }


    fun getAllIngredientsByType(typeIngredient:String): ObjectBoxLiveData<Ingredients> {
        return ingredientsRepository.getAllIngredientsByTypeId(typeIngredient)
    }

    fun isIngredientSelected(name: String?): Boolean? {
        return ingredientsRepository.isIngredientSelected(name)
    }

    fun isIngredientSelectedInGrocery(name: String?): Boolean? {
        return ingredientsRepository.isIngredientSelectedInGrocery(name)
    }

    fun resetGroceryList() {
        return ingredientsRepository.resetGroceryList()
    }

}