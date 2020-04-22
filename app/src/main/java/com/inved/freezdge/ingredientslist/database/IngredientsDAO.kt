package com.inved.freezdge.ingredientslist.database

import com.inved.freezdge.utils.AddIngredientsInDatabase
import com.inved.freezdge.utils.App
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.android.ObjectBoxLiveData
import io.objectbox.kotlin.boxFor


class IngredientsDAO {

    companion object {
        fun getIngredientsBox(): Box<Ingredients> {
            val boxStore: BoxStore = App.ObjectBox.boxStore
            return boxStore.boxFor()

        }

        fun updateIngredient(ingredient: Ingredients) {

            ingredient.selectedIngredient = !ingredient.selectedIngredient
            getIngredientsBox().put(ingredient)
        }

        fun updateIngredientSelectedByName(name: String?,bool:Boolean) {

            if(name!=null){
                val ingredient:Ingredients? =
                    getIngredientsBox().query().equal(Ingredients_.name,name).build().findUnique()
                ingredient?.selectedIngredient = bool
                if(ingredient!=null)
                getIngredientsBox().put(ingredient)
            }

        }

        fun updateIngredientSelectedForGroceryByName(name: String?,bool:Boolean) {

            if(name!=null){
                val ingredient:Ingredients? =
                    getIngredientsBox().query().equal(Ingredients_.name,name).build().findUnique()
                ingredient?.grocerySelectedIngredient = bool
                if(ingredient!=null)
                    getIngredientsBox().put(ingredient)
            }

        }

        fun isIngredientSelected(name: String?):Boolean {

            if(name!=null){
                val ingredient:Ingredients? =
                    getIngredientsBox().query().equal(Ingredients_.name,name).build().findUnique()

                return ingredient!!.selectedIngredient
            }
            return false
        }

        fun isIngredientSelectedInGrocery(name: String?):Boolean {

            if(name!=null){
                val ingredient:Ingredients? =
                    getIngredientsBox().query().equal(Ingredients_.name,name).build().findUnique()

                return ingredient!!.grocerySelectedIngredient
            }
            return false
        }

        fun insertIngredients() {
            AddIngredientsInDatabase(getIngredientsBox())
        }

        fun getAllIngredientBySelected(): ObjectBoxLiveData<Ingredients> {
            // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
            return ObjectBoxLiveData(getIngredientsBox().query().equal(Ingredients_.selectedIngredient,true).order(Ingredients_.name).build())
        }



        fun getAllIngredientBySelectedForGrocery(): ObjectBoxLiveData<Ingredients> {
            // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
            return ObjectBoxLiveData(getIngredientsBox().query().equal(Ingredients_.grocerySelectedIngredient,true).order(Ingredients_.name).build())
        }

        fun getAllIngredientsById(): ObjectBoxLiveData<Ingredients> {
            // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
            return ObjectBoxLiveData(getIngredientsBox().query().order(Ingredients_.id).build())
        }

        fun getAllIngredientsByTypeId(typeIngredient:String): ObjectBoxLiveData<Ingredients> {
            // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
            return ObjectBoxLiveData(getIngredientsBox().query().equal(Ingredients_.typeIngredient,typeIngredient).order(Ingredients_.name).build())
        }



    }


}