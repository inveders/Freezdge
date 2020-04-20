package com.inved.freezdge.recipes.database

import com.inved.freezdge.utils.App
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.android.ObjectBoxLiveData
import io.objectbox.kotlin.boxFor

class RecipesDAO {

    companion object {
        fun getRecipesBox(): Box<Recipes> {
            val boxStore: BoxStore = App.ObjectBox.boxStore
            return boxStore.boxFor()

        }

        fun updateRecipeSelectedByName(name: String?) {

            if(name!=null){
                val recpie: Recipes? =
                    getRecipesBox().query().equal(Recipes_.recipeTitle,name).build().findUnique()
                recpie?.selectedRecipe = false
                if(recpie!=null)
                    getRecipesBox().put(recpie)
            }

        }

        fun isRecipeSelected(name: String?):Boolean {

            if(name!=null){
                val recipes: Recipes? =
                    getRecipesBox().query().equal(Recipes_.recipeTitle,name).build().findUnique()

                return recipes!!.selectedRecipe
            }
            return false
        }


        fun getAllSelectedRecipes(): ObjectBoxLiveData<Recipes> {
            // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
            return ObjectBoxLiveData(
                getRecipesBox().query().equal(Recipes_.selectedRecipe,true).build())
        }


        fun getRecipeLiveDataById(id:Long): ObjectBoxLiveData<Recipes> {
            // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
            return ObjectBoxLiveData(getRecipesBox().query().equal(Recipes_.id,id).build())
        }

        fun getRecipeIfContainIngredient(ingredientName: String): ObjectBoxLiveData<Recipes>  {
            return ObjectBoxLiveData(getRecipesBox().query().contains(Recipes_.recipeIngredients,ingredientName).build())
        }

    }
}