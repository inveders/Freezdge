package com.inved.freezdge.ingredientslist.repository

import com.inved.freezdge.ingredientslist.database.IngredientsList
import com.inved.freezdge.ingredientslist.database.IngredientsList_
import com.inved.freezdge.utils.AddIngredientsListDatabase
import io.objectbox.Box

class IngredientsListRepository (private val getIngredientsListBox: Box<IngredientsList>?) {

    // get all ingredients List for a recipe
    fun getIngredientListByRecipe(recipeId:Long): MutableList<IngredientsList>? {
        return getIngredientsListBox?.query()?.equal(IngredientsList_.recipeId,recipeId)?.order(
            IngredientsList_.id)?.build()?.find()
    }

    fun insertIngredientsList() {
        AddIngredientsListDatabase(getIngredientsListBox)
    }

    fun deleteAllIngredientsListInBox() {
        getIngredientsListBox?.removeAll()
        insertIngredientsList()
    }
}