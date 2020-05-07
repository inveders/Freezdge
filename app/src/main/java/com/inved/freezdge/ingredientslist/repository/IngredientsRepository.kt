package com.inved.freezdge.ingredientslist.repository

import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.database.Ingredients_
import com.inved.freezdge.utils.AddIngredientsInDatabase
import io.objectbox.Box
import io.objectbox.android.ObjectBoxLiveData


class IngredientsRepository(private val getIngredientsBox: Box<Ingredients>) {

    fun updateIngredient(ingredient: Ingredients) {

        ingredient.selectedIngredient = !ingredient.selectedIngredient
        getIngredientsBox.put(ingredient)
    }

    fun updateIngredientSelectedByName(name: String?,bool:Boolean) {

        if(name!=null){
            val ingredient:Ingredients? =
                getIngredientsBox.query().equal(Ingredients_.name,name).build().findUnique()
            ingredient?.selectedIngredient = bool
            if(ingredient!=null)
                getIngredientsBox.put(ingredient)
        }

    }

    fun updateIngredientSelectedForGroceryByName(name: String?,bool:Boolean) {

        if(name!=null){
            val ingredient:Ingredients? =
                getIngredientsBox.query().equal(Ingredients_.name,name).build().findUnique()
            ingredient?.grocerySelectedIngredient = bool
            if(ingredient!=null)
                getIngredientsBox.put(ingredient)
        }

    }

    fun isIngredientSelected(name: String?):Boolean {

        if(name!=null){
            val ingredient:Ingredients? =
                getIngredientsBox.query().equal(Ingredients_.name,name).build().findUnique()

            return ingredient!!.selectedIngredient
        }
        return false
    }

    fun isIngredientSelectedInGrocery(name: String?):Boolean {

        if(name!=null){
            val ingredient:Ingredients? =
                getIngredientsBox.query().equal(Ingredients_.name,name).build().findUnique()

            return ingredient!!.grocerySelectedIngredient
        }
        return false
    }

    fun insertIngredients() {
        AddIngredientsInDatabase(getIngredientsBox)
    }

    fun getAllIngredientBySelected(): MutableList<Ingredients> {
        // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
        return getIngredientsBox.query().equal(Ingredients_.selectedIngredient,true).order(
            Ingredients_.name).build().find()
    }



    fun getAllIngredientBySelectedForGrocery(): ObjectBoxLiveData<Ingredients> {
        // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
        return ObjectBoxLiveData(getIngredientsBox.query().equal(Ingredients_.grocerySelectedIngredient,true).order(
            Ingredients_.name).build())
    }

    fun getAllIngredientsById(): ObjectBoxLiveData<Ingredients> {
        // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
        return ObjectBoxLiveData(getIngredientsBox.query().order(Ingredients_.id).build())
    }

    fun getAllIngredientsByTypeId(typeIngredient:String): ObjectBoxLiveData<Ingredients> {
        // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
        return ObjectBoxLiveData(getIngredientsBox.query().equal(Ingredients_.typeIngredient,typeIngredient).order(
            Ingredients_.name).build())
    }

}