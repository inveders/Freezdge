package com.inved.freezdge.favourites.repository

import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.database.FavouritesRecipesDAO
import io.objectbox.android.ObjectBoxLiveData

class FavouritesRecipesRepository {

    companion object {

        fun isRecipeIdIsPresent(recipeId:String):Boolean? {
            return FavouritesRecipesDAO.isRecipeIdIsPresent(recipeId)
        }

        fun detectFavouriteRecipe(recipeId: String?, recipeTitle: String?, recipeCalories: String?, recipeTime: String?,
                                  recipeUrl: String?,
                                  recipePhotoUrl: String?,
                                  recipeIngredients: String?,
                                  cuisineType:String?,dishType:String?) {
            FavouritesRecipesDAO.detectFavouriteRecipe(recipeId,recipeTitle,recipeCalories,recipeTime,recipeUrl,recipePhotoUrl,recipeIngredients,cuisineType,dishType)
        }

        fun isIngredientPresentInFavoriteRecipeUpdateGrocery(ingredientNameFrench: String,ingredientNameEnglish: String){
            FavouritesRecipesDAO.isIngredientPresentInFavoriteRecipeUpdateGrocery(ingredientNameFrench,ingredientNameEnglish)
        }

        fun getAllFavouritesRecipes(): ObjectBoxLiveData<FavouritesRecipes> {
            // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
            return FavouritesRecipesDAO.getAllFavouritesRecipes()
        }
    }
}