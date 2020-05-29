package com.inved.freezdge.favourites.viewmodel

import androidx.lifecycle.ViewModel
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.repository.FavouritesRecipesRepository
import io.objectbox.android.ObjectBoxLiveData

class FavouritesRecipesViewModel(private val favouritesRecipesRepository: FavouritesRecipesRepository):ViewModel() {


    fun detectFavouriteRecipe(recipeId: String?, recipeTitle: String?, recipeCalories: String?, recipeTime: String?,
                              recipeUrl: String?,
                              recipePhotoUrl: String?,
                              recipeIngredients: String?,cuisineType:String?,
                              dishType:String?,recipePhotoUrlOwner:String?) {
        favouritesRecipesRepository.detectFavouriteRecipe(recipeId,recipeTitle,recipeCalories,recipeTime,recipeUrl,recipePhotoUrl,recipeIngredients,cuisineType,dishType,recipePhotoUrlOwner)
    }

    fun isRecipeIdIsPresent(recipeId:String):Boolean? {
        return favouritesRecipesRepository.isRecipeIdIsPresent(recipeId)
    }

    fun isIngredientPresentInFavoriteRecipeUpdateGrocery(ingredientNameFrench: String,ingredientNameEnglish: String){
        favouritesRecipesRepository.isIngredientPresentInFavoriteRecipeUpdateGrocery(ingredientNameFrench,ingredientNameEnglish)
    }

    fun getAllFavouritesRecipes(): ObjectBoxLiveData<FavouritesRecipes> {
         return favouritesRecipesRepository.getAllFavouritesRecipes()
    }
}