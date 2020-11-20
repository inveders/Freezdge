package com.inved.freezdge.ingredientslist.repository

import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.database.Ingredients_
import com.inved.freezdge.ingredientslist.firebase.FirebaseIngredientsUtils
import com.inved.freezdge.utils.AddIngredientsInDatabase
import io.objectbox.Box
import io.objectbox.android.ObjectBoxLiveData


class IngredientsRepository(private val getIngredientsBox: Box<Ingredients>?) {

    // update ingredient selection to show minus or plus image on the right in ingredientList page on recycler item click
    fun updateIngredient(ingredient: Ingredients) {

        ingredient.selectedIngredient = !ingredient.selectedIngredient
        getIngredientsBox?.put(ingredient)
        FirebaseIngredientsUtils().getIngredientByName(ingredient.name,
            isToDelete = false,
            isInGrocery = ingredient.grocerySelectedIngredient,
            isSelected = ingredient.selectedIngredient,
            ingredient = ingredient
        )
    }

    // update ingredient selection according to the name of the ingredient (chip)
    fun updateIngredientSelectedByName(name: String?,bool:Boolean) {

        if(name!=null){
            val ingredient:Ingredients? =
                getIngredientsBox?.query()?.equal(Ingredients_.name,name)?.build()?.findUnique()
            ingredient?.selectedIngredient = bool
            if(ingredient!=null){
                getIngredientsBox?.put(ingredient)
                FirebaseIngredientsUtils().getIngredientByName(ingredient.name,
                    isToDelete = !bool,
                    isInGrocery = ingredient.grocerySelectedIngredient,
                    isSelected = ingredient.selectedIngredient,
                    ingredient = ingredient
                )
            }

        }

    }

    // update ingredient selection according to the name of the ingredient (chip)
    fun getIngredientByName(name: String?):Ingredients? {

        if(name!=null){
            return getIngredientsBox?.query()?.equal(Ingredients_.name,name)?.build()?.findUnique()
        }
        return null
    }

    // to add or remove ingredient from grocery list
    fun updateIngredientSelectedForGroceryByName(name: String?,bool:Boolean) {

        if(name!=null){
            val ingredient:Ingredients? =
                getIngredientsBox?.query()?.equal(Ingredients_.name,name)?.build()?.findUnique()
            ingredient?.grocerySelectedIngredient = bool
            if(bool){
                ingredient?.selectedIngredient=false
            }
            if(ingredient!=null){
                getIngredientsBox?.put(ingredient)
                FirebaseIngredientsUtils().getIngredientByName(ingredient.name,
                    isToDelete = false,
                    isInGrocery = ingredient.grocerySelectedIngredient,
                    isSelected = ingredient.selectedIngredient,
                    ingredient = ingredient
                )
            }

        }

    }

    // check if ingredient is selected
    fun isIngredientSelected(name: String?):Boolean? {

        if(name!=null){
            val ingredient:Ingredients? =
                getIngredientsBox?.query()?.equal(Ingredients_.name,name)?.build()?.findUnique()

            return ingredient?.selectedIngredient
        }
        return false
    }

    // check if ingredient is in the grocery list
    fun isIngredientSelectedInGrocery(name: String?):Boolean? {

        if(name!=null){
            val ingredient:Ingredients? =
                getIngredientsBox?.query()?.equal(Ingredients_.name,name)?.build()?.findUnique()

            return ingredient?.grocerySelectedIngredient
        }
        return false
    }

    fun resetGroceryList(){
        getIngredientsBox?.all?.forEach {ingredient->
            ingredient?.grocerySelectedIngredient = false
            if(ingredient!=null){
                getIngredientsBox.put(ingredient)
                FirebaseIngredientsUtils().getIngredientByName(ingredient.name,
                    isToDelete = false,
                    isInGrocery = ingredient.grocerySelectedIngredient,
                    isSelected = ingredient.selectedIngredient,
                    ingredient = ingredient
                )
            }
        }
    }

    // insert all ingredients from my own file in the database
    fun insertIngredients() {
        AddIngredientsInDatabase(getIngredientsBox)
    }

    // insert all ingredients from my own file in the database
    fun countIngredients():Long? {
        return getIngredientsBox?.count()
    }

    // get all selected ingredients (in the fridge)
    fun getAllIngredientBySelected(): MutableList<Ingredients>? {
        return getIngredientsBox?.query()?.equal(Ingredients_.selectedIngredient,true)?.order(
            Ingredients_.name)?.build()?.find()
    }

    // get all ingredients from the grocery list
    fun getAllIngredientBySelectedForGrocery(): ObjectBoxLiveData<Ingredients> {
        return ObjectBoxLiveData(getIngredientsBox?.query()?.equal(Ingredients_.grocerySelectedIngredient,true)?.order(
            Ingredients_.name)?.build())
    }

    // get all ingredients of my database and show them by id
    fun getAllIngredientsByIdLiveData(): ObjectBoxLiveData<Ingredients> {
        return ObjectBoxLiveData(getIngredientsBox?.query()?.order(Ingredients_.id)?.build())
    }

    // get all ingredients of my database and show them by id
    fun getAllIngredientsById(): MutableList<Ingredients>? {
        return getIngredientsBox?.query()?.order(Ingredients_.id)?.build()?.find()
    }

    // get all ingredients by type (creamery, fruits & vegetables, epicerie, fish, or meat)
    fun getAllIngredientsByTypeId(typeIngredient:String): ObjectBoxLiveData<Ingredients> {
        return ObjectBoxLiveData(getIngredientsBox?.query()?.equal(Ingredients_.typeIngredient,typeIngredient)?.order(
            Ingredients_.name)?.build())
    }

    fun deleteAllIngredientsInBox() {
        getIngredientsBox?.removeAll()
        insertIngredients()
    }

}