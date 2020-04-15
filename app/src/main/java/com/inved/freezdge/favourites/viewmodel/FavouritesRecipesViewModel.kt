package com.inved.freezdge.favourites.viewmodel

import androidx.lifecycle.ViewModel
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.repository.FavouritesRecipesRepository
import io.objectbox.android.ObjectBoxLiveData

class FavouritesRecipesViewModel:ViewModel() {

    fun detectFavouriteRecipe(recipeId: String?, recipeTitle: String?, recipeCalories: String?, recipeTime: String?,
                              recipeUrl: String?,
                              recipePhotoUrl: String?,
                              recipeIngredients: String?) {
        FavouritesRecipesRepository.detectFavouriteRecipe(recipeId,recipeTitle,recipeCalories,recipeTime,recipeUrl,recipePhotoUrl,recipeIngredients)
    }

    fun isRecipeIdIsPresent(recipeId:String):Boolean? {
        return FavouritesRecipesRepository.isRecipeIdIsPresent(recipeId)
    }

    fun getAllFavouritesRecipes(): ObjectBoxLiveData<FavouritesRecipes> {
        // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
        return FavouritesRecipesRepository.getAllFavouritesRecipes()
    }
}