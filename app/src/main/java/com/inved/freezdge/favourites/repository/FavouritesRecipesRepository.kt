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
        daySelected: String?
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
                    recipePhotoUrlOwner,
                    daySelected
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
        return getFavouritesRecipesBox?.query()?.equal(FavouritesRecipes_.recipeId, recipeId)
            ?.build()?.findUnique()
    }

    // for each recipes in favourite database, check if the given ingredient is contained in, if yes add it in the grocery list
    fun isIngredientPresentInFavoriteRecipeUpdateGrocery(
        ingredientNameFrench: String,
        ingredientNameEnglish: String
    ) {

        for (i in getFavouritesRecipesBox?.query()?.order(FavouritesRecipes_.id)?.build()
            ?.find()!!) {
            if (i.recipeIngredients?.contains(ingredientNameFrench, true) == true) {

                domain.updateItemForGroceryList(ingredientNameFrench, true, ingredientNameEnglish)
            }

            if (i.recipeIngredients?.contains(ingredientNameEnglish, true) == true) {

                domain.updateItemForGroceryList(ingredientNameFrench, true, ingredientNameEnglish)
            }
        }

    }

    fun updateDaySelected(recipeId: String, daySelected: String?) {

        val favouritesRecipes: FavouritesRecipes? =
            App.ObjectBox.boxStore.boxFor<FavouritesRecipes>().query()
                .equal(FavouritesRecipes_.recipeId, recipeId)
                .build().findUnique()
        if (daySelected != null) {
            favouritesRecipes?.daySelected = daySelected
            if (favouritesRecipes != null)
                App.ObjectBox.boxStore.boxFor<FavouritesRecipes>().put(favouritesRecipes)
        } else {
            favouritesRecipes?.daySelected = null
            if (favouritesRecipes != null)
                App.ObjectBox.boxStore.boxFor<FavouritesRecipes>().put(favouritesRecipes)
        }
    }


    // insert recipe in favourite database
    private fun insertFavouriteRecipe(
        recipeId: String?, recipeTitle: String?, recipeCalories: String?, recipeTime: String?,
        recipeUrl: String?,
        recipePhotoUrl: String?,
        recipeIngredients: String?,
        cuisineType: String?,
        dishType: String?,
        recipePhotoUrlOwner: String?,
        daySelected: String?
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
                recipePhotoUrlOwner = recipePhotoUrlOwner,
                daySelected = daySelected
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