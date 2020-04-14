package com.inved.freezdge.favourites.database

import com.inved.freezdge.favourites.repository.FavouritesRecipesRepository
import com.inved.freezdge.utils.App
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


        fun detectFavouriteRecipe(recipeId: String) {
            val favouritesRecipes: FavouritesRecipes? =
                getFavouritesRecipesBox().query().equal(FavouritesRecipes_.recipeId, recipeId)
                    .build().findUnique()
            if(favouritesRecipes!=null){
                removeFavouriteRecipe(favouritesRecipes)
            }else{
                insertFavouriteRecipe(recipeId)
            }
        }

        fun isRecipeIdIsPresent(recipeId:String):Boolean {
            val favouritesRecipes: FavouritesRecipes? =
                getFavouritesRecipesBox().query().equal(FavouritesRecipes_.recipeId, recipeId)
                    .build().findUnique()
            return favouritesRecipes!=null
        }

        fun insertFavouriteRecipe(recipeId: String) {
            getFavouritesRecipesBox().put(
                FavouritesRecipes(
                    recipeId = recipeId
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