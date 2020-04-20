package com.inved.freezdge.recipes.repository

import com.inved.freezdge.BuildConfig
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.database.RecipesDAO
import com.inved.freezdge.recipes.retrofit.RecipesApi
import com.inved.freezdge.recipes.retrofit.RetrofitServiceRecipes
import io.objectbox.android.ObjectBoxLiveData

class RecipesRepository {

    private val appKEY: String = BuildConfig.APP_KEY_RECIPES
    private val appID: String = BuildConfig.APP_ID_RECIPES

    private var client: RecipesApi = RetrofitServiceRecipes.webservice

    suspend fun getRecipesLiveData(ingredients: String) = client.getRecipes(ingredients, appID, appKEY)

    companion object {

        fun getAllSelectedRecipes(): ObjectBoxLiveData<Recipes> {
            return RecipesDAO.getAllSelectedRecipes()
        }


        fun getRecipeLiveDataById(id:Long): Recipes? {
            return RecipesDAO.getRecipeLiveDataById(id)
        }

        fun isRecipeSelected(name: String?): Boolean {
            return RecipesDAO.isRecipeSelected(name)
        }


        fun updateRecipeSelectedByName(name: String?) {
            return RecipesDAO.updateRecipeSelectedByName(name)
        }

        fun getRecipeIfContainIngredient(ingredientName: String): ObjectBoxLiveData<Recipes>  {
            return RecipesDAO.getRecipeIfContainIngredient(ingredientName)
        }

        fun insertRecipesInDatabase() {
           return RecipesDAO.insertRecipesInDatabase()
        }
    }

}

