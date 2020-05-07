package com.inved.freezdge.favourites.repository

import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.database.FavouritesRecipes_
import com.inved.freezdge.utils.Domain
import io.objectbox.Box
import io.objectbox.android.ObjectBoxLiveData

class FavouritesRecipesRepository(private val getFavouritesRecipesBox: Box<FavouritesRecipes>) {

    fun detectFavouriteRecipe(recipeId: String?, recipeTitle: String?, recipeCalories: String?, recipeTime: String?,
                              recipeUrl: String?,
                              recipePhotoUrl: String?,
                              recipeIngredients: String?,cuisineType:String?,dishType:String?) {

        val favouritesRecipes: FavouritesRecipes? =
            getFavouritesRecipesBox.query().equal(FavouritesRecipes_.recipeId, recipeId!!)
                .build().findUnique()
        if (favouritesRecipes != null) {
            removeFavouriteRecipe(favouritesRecipes)
        } else {
            insertFavouriteRecipe(recipeId,recipeTitle,recipeCalories,recipeTime,recipeUrl,recipePhotoUrl,recipeIngredients,cuisineType,dishType)
        }
    }

    fun isRecipeIdIsPresent(recipeId: String): Boolean? {
        val favouritesRecipes: FavouritesRecipes? =
            getFavouritesRecipesBox.query().equal(FavouritesRecipes_.recipeId, recipeId)
                .build().findUnique()
        return favouritesRecipes != null
    }

    fun isIngredientPresentInFavoriteRecipeUpdateGrocery(ingredientNameFrench: String,ingredientNameEnglish: String){

        for(i in getFavouritesRecipesBox.query().order(FavouritesRecipes_.id).build().find()){
            if (i.recipeIngredients?.contains(ingredientNameFrench, true)!!) {

                Domain.updateItemForGroceryList(ingredientNameFrench, true,ingredientNameEnglish)
            }

            if (i.recipeIngredients?.contains(ingredientNameEnglish, true)!!) {

                Domain.updateItemForGroceryList(ingredientNameFrench, true,ingredientNameEnglish)
            }
        }

    }

    fun insertFavouriteRecipe(
        recipeId: String?, recipeTitle: String?, recipeCalories: String?, recipeTime: String?,
        recipeUrl: String?,
        recipePhotoUrl: String?,
        recipeIngredients: String?,
        cuisineType: String?,
        dishType: String?
    ) {
        getFavouritesRecipesBox.put(
            FavouritesRecipes(
                recipeId = recipeId,
                recipeTitle =recipeTitle,
                recipeCalories =recipeCalories,
                recipeTime =recipeTime,
                recipeUrl =recipeUrl,
                recipePhotoUrl =recipePhotoUrl,
                recipeIngredients =recipeIngredients,
                cuisineType = cuisineType,
                dishType = dishType
            )
        )
    }

    fun removeFavouriteRecipe(favouritesRecipes: FavouritesRecipes) {
        getFavouritesRecipesBox.remove(favouritesRecipes.id)
    }


    fun getAllFavouritesRecipes(): ObjectBoxLiveData<FavouritesRecipes> {
         return ObjectBoxLiveData(
            getFavouritesRecipesBox.query().order(FavouritesRecipes_.id).build()
        )
    }
}