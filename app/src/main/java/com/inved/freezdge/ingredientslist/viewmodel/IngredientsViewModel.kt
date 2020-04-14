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

    fun getIngredientsForFreezdgeList(): ObjectBoxLiveData<Ingredients> {
        return IngredientsRepository.getIngredientsLiveDataBySelected()
    }

    fun updateIngredientSelectedByName(name:String?) {
        return IngredientsRepository.updateIngredientSelectedByName(name)
    }

    fun getIngredientsForGrocery(): ObjectBoxLiveData<Ingredients> {
        return IngredientsRepository.getIngredientsLiveDataBySelectedForGrocery()
    }

    fun getAllIngredients(): ObjectBoxLiveData<Ingredients> {
        return IngredientsRepository.getIngredientsLiveDataById()
    }


}