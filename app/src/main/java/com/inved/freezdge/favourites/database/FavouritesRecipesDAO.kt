package com.inved.freezdge.favourites.database

import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.android.ObjectBoxLiveData
import io.objectbox.kotlin.boxFor

class FavouritesRecipesDAO {

    companion object {
        fun getFavouritesRecipesBox(): Box<FavouritesRecipes> {
            val boxStore: BoxStore = App.ObjectBox.boxStore
            return boxStore.boxFor()

        }


        fun detectFavouriteRecipe(recipeId: String?, recipeTitle: String?, recipeCalories: String?, recipeTime: String?,
                                  recipeUrl: String?,
                                  recipePhotoUrl: String?,
                                  recipeIngredients: String?) {

            val favouritesRecipes: FavouritesRecipes? =
                getFavouritesRecipesBox().query().equal(FavouritesRecipes_.recipeId, recipeId!!)
                    .build().findUnique()
            if (favouritesRecipes != null) {
                removeFavouriteRecipe(favouritesRecipes)
            } else {
                insertFavouriteRecipe(recipeId,recipeTitle,recipeCalories,recipeTime,recipeUrl,recipePhotoUrl,recipeIngredients)
            }
        }

        fun isRecipeIdIsPresent(recipeId: String): Boolean? {
            val favouritesRecipes: FavouritesRecipes? =
                getFavouritesRecipesBox().query().equal(FavouritesRecipes_.recipeId, recipeId)
                    .build().findUnique()
            return favouritesRecipes != null
        }

        fun isIngredientPresentInFavoriteRecipeUpdateGrocery(ingredientNameFrench: String,ingredientNameEnglish: String){

           for(i in getFavouritesRecipesBox().query().order(FavouritesRecipes_.id).build().find()){
               if (i.recipeIngredients?.let { it.contains(ingredientNameFrench, true) }!!) {

                   Domain.updateItemForGroceryList(ingredientNameFrench, true,ingredientNameEnglish)
               }

               if (i.recipeIngredients?.let { it.contains(ingredientNameEnglish, true) }!!) {

                   Domain.updateItemForGroceryList(ingredientNameFrench, true,ingredientNameEnglish)
               }
           }

        }

        fun insertFavouriteRecipe(
            recipeId: String?, recipeTitle: String?, recipeCalories: String?, recipeTime: String?,
            recipeUrl: String?,
            recipePhotoUrl: String?,
            recipeIngredients: String?
        ) {
            getFavouritesRecipesBox().put(
                FavouritesRecipes(
                    recipeId = recipeId,
                    recipeTitle =recipeTitle,
                    recipeCalories =recipeCalories,
                    recipeTime =recipeTime,
                    recipeUrl =recipeUrl,
                    recipePhotoUrl =recipePhotoUrl,
                    recipeIngredients =recipeIngredients
                )
            )
        }

        fun removeFavouriteRecipe(favouritesRecipes: FavouritesRecipes) {

            getFavouritesRecipesBox().remove(favouritesRecipes.id)

        }


        fun getAllFavouritesRecipes(): ObjectBoxLiveData<FavouritesRecipes> {
            // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
            return ObjectBoxLiveData(
                getFavouritesRecipesBox().query().order(FavouritesRecipes_.id).build()
            )
        }

    }

}