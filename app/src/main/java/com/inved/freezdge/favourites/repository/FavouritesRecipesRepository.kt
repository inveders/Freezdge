package com.inved.freezdge.favourites.repository

import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.database.FavouritesRecipes_
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import io.objectbox.Box
import io.objectbox.android.ObjectBoxLiveData
import io.objectbox.kotlin.boxFor

class FavouritesRecipesRepository(private val getFavouritesRecipesBox: Box<FavouritesRecipes>?) {
    var domain = Domain()

    // detect if favourites recipes is in database, if not we add, if yes we remove
    fun detectFavouriteRecipe(
        recipeId: String?,
        recipeTitle: String?,
        recipeCalories: String?,
        recipeTime: String?,
        recipeUrl: String?,
        recipePhotoUrl: String?,
        recipeIngredients: String?,
        cuisineType: String?,
        dishType: String?,
        recipePhotoUrlOwner: String?,
        daySelected: Boolean?
    ) {

        if (!recipeId.isNullOrEmpty()) {
            val favouritesRecipes: FavouritesRecipes? =
                getFavouritesRecipesBox?.query()?.equal(FavouritesRecipes_.recipeId, recipeId)
                    ?.build()?.findUnique()
            if (favouritesRecipes != null) {
                removeFavouriteRecipe(favouritesRecipes)
            } else {
                insertFavouriteRecipe(
                    recipeId,
                    recipeTitle,
                    recipeCalories,
                    recipeTime,
                    recipeUrl,
                    recipePhotoUrl,
                    recipeIngredients,
                    cuisineType,
                    dishType,
                    recipePhotoUrlOwner
                )
            }
        }

    }

    // check if a specific recipe is present in favourite database
    fun isRecipeIdIsPresent(recipeId: String): Boolean? {
        val favouritesRecipes: FavouritesRecipes? =
            getFavouritesRecipesBox?.query()?.equal(FavouritesRecipes_.recipeId, recipeId)
                ?.build()?.findUnique()
        return favouritesRecipes != null
    }

    // get day by recipeId in favourite
    fun getFavouriteRecipeById(recipeId: String): FavouritesRecipes? {
        return getFavouritesRecipesBox?.query()?.equal(FavouritesRecipes_.id, recipeId.toLong())
            ?.build()?.findUnique()
    }

    // insert recipe in favourite database
    private fun insertFavouriteRecipe(
        recipeId: String?, recipeTitle: String?, recipeCalories: String?, recipeTime: String?,
        recipeUrl: String?,
        recipePhotoUrl: String?,
        recipeIngredients: String?,
        cuisineType: String?,
        dishType: String?,
        recipePhotoUrlOwner: String?
    ) {
        getFavouritesRecipesBox?.put(
            FavouritesRecipes(
                recipeId = recipeId,
                recipeTitle = recipeTitle,
                recipeCalories = recipeCalories,
                recipeTime = recipeTime,
                recipeUrl = recipeUrl,
                recipePhotoUrl = recipePhotoUrl,
                recipeIngredients = recipeIngredients,
                cuisineType = cuisineType,
                dishType = dishType,
                recipePhotoUrlOwner = recipePhotoUrlOwner
            )
        )
    }

    // remove a recipe from favourite database
    private fun removeFavouriteRecipe(favouritesRecipes: FavouritesRecipes) {
        getFavouritesRecipesBox?.remove(favouritesRecipes.id)
    }


    // retrieve all favourites recipes
    fun getAllFavouritesRecipes(): ObjectBoxLiveData<FavouritesRecipes> {
        return ObjectBoxLiveData(
            getFavouritesRecipesBox?.query()?.order(FavouritesRecipes_.id)?.build()
        )
    }
}