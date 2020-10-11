package com.inved.freezdge.favourites.viewmodel

import androidx.lifecycle.ViewModel
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.repository.FavouritesRecipesRepository
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.utils.App
import io.objectbox.android.ObjectBoxLiveData
import io.objectbox.kotlin.boxFor

class FavouritesRecipesViewModel(private val favouritesRecipesRepository: FavouritesRecipesRepository):ViewModel() {


    fun detectFavouriteRecipe(recipeId: String?, recipeTitle: String?, recipeCalories: String?, recipeTime: String?,
                              recipeUrl: String?,
                              recipePhotoUrl: String?,
                              recipeIngredients: String?,cuisineType:String?,
                              dishType:String?,recipePhotoUrlOwner:String?,
                              daySelected:String?) {
        favouritesRecipesRepository.detectFavouriteRecipe(recipeId,recipeTitle,recipeCalories,recipeTime,recipeUrl,recipePhotoUrl,recipeIngredients,cuisineType,dishType,recipePhotoUrlOwner,daySelected)
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

    fun updateDaySelected(recipeId: String,daySelected: String?) {
        return favouritesRecipesRepository.updateDaySelected(recipeId,daySelected)
    }



}