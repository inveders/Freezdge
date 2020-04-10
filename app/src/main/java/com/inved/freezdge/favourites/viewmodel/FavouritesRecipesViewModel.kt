package com.inved.freezdge.favourites.viewmodel

import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.repository.FavouritesRecipesRepository
import io.objectbox.android.ObjectBoxLiveData

class FavouritesRecipesViewModel {

    fun insertFavouriteRecipe(recipeId:String) {
        FavouritesRecipesRepository.insertFavouriteRecipe(recipeId)
    }

    fun removeFavouriteRecipe(favouritesRecipes: FavouritesRecipes) {
        FavouritesRecipesRepository.removeFavouriteRecipe(favouritesRecipes)
    }

    fun getAllFavouritesRecipes(): ObjectBoxLiveData<FavouritesRecipes> {
        // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
        return FavouritesRecipesRepository.getAllFavouritesRecipes()
    }
}