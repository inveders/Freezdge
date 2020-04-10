package com.inved.freezdge.favourites.repository

import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.database.FavouritesRecipesDAO
import io.objectbox.android.ObjectBoxLiveData

class FavouritesRecipesRepository {

    companion object {
        fun insertFavouriteRecipe(recipeId:String) {
            FavouritesRecipesDAO.insertFavouriteRecipe(recipeId)
        }

        fun removeFavouriteRecipe(favouritesRecipes: FavouritesRecipes) {
            FavouritesRecipesDAO.removeFavouriteRecipe(favouritesRecipes)
        }

        fun getAllFavouritesRecipes(): ObjectBoxLiveData<FavouritesRecipes> {
            // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
            return FavouritesRecipesDAO.getAllFavouritesRecipes()
        }
    }
}