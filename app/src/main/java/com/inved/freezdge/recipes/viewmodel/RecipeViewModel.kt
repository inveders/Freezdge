package com.inved.freezdge.recipes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.model.Hit
import com.inved.freezdge.recipes.model.Results
import com.inved.freezdge.recipes.repository.RecipesRepository
import com.inved.freezdge.uiGeneral.fragment.BaseFragment
import io.objectbox.android.ObjectBoxLiveData
import kotlinx.coroutines.Dispatchers

class RecipeViewModel(private val recipesRepository: RecipesRepository) : ViewModel() {

    // retrofit call
    private suspend fun getRecipes(arg: String?): LiveData<Results> {
        return liveData(Dispatchers.IO) {
            val retrievedRecipes = recipesRepository.getRecipesLiveData(arg)
            emit(retrievedRecipes)
        }
    }

    fun getRecipeLiveDataById(id: Long): Recipes? {
        return recipesRepository.getRecipeLiveDataById(id)
    }

    fun getRecipeIfContainIngredient(ingredientName: String): ObjectBoxLiveData<Recipes> {
        return recipesRepository.getRecipeIfContainIngredient(ingredientName)
    }

    fun insertRecipesInDatabase() {
        return recipesRepository.insertRecipesInDatabase()
    }

    fun updateSharedPref() {
        return recipesRepository.updateSharedPref()
    }

    fun deleteAllRecipesInDatabase() {
        return recipesRepository.deleteAllRecipesInBox()
    }

    fun countAllRecipesInDatabase():Long {
        return recipesRepository.countRecipesInBox()
    }

    // Make retrofit call here to search all recipes matching with given ingredient, and add these recipes in a Mutable Hashset list to avoid duplication
    suspend fun getRetrofitRecipes(result: MutableList<Ingredients>): MutableLiveData<MutableList<Hit>>? {
        val setListRetrofitViewModel: MutableLiveData<MutableList<Hit>>? = MutableLiveData()
        val setRetrofitSetListRecipes:MutableSet<Hit>? = mutableSetOf()
        if (result.size != 0) {
            BaseFragment.listener?.showLoader()

            // We make a loop for each ingredient selected
            for (myresult in result) {
                getRecipes(myresult.name).observeForever {

                    for(i in it.hits.indices){
                        setRetrofitSetListRecipes?.add(it.hits[i])
                    }
                    setListRetrofitViewModel?.postValue(setRetrofitSetListRecipes?.toMutableList())
                }

            }

            return setListRetrofitViewModel
        }
        return null
    }

    // Search in our database all recipes wich match with given ingredients, and add these recipes in a Mutable Hashset list to avoid duplication
    fun getDatabaseRecipes(result: MutableList<Ingredients>): MutableLiveData<MutableList<Recipes>>? {

        val setListDatabaseViewModel: MutableLiveData<MutableList<Recipes>>? =
            MutableLiveData()
        val setDatabaseSetListRecipes:MutableSet<Recipes>? = mutableSetOf()

            if (result.size != 0) {
                BaseFragment.listener?.showLoader()
                for (myresult in result) {
                    myresult.name?.let { it ->
                        getRecipeIfContainIngredient(it)
                            .observeForever {
                                for(i in it.indices){
                                    setDatabaseSetListRecipes?.add(it[i])
                                    setListDatabaseViewModel?.postValue(setDatabaseSetListRecipes?.toMutableList())
                                }

                            }
                    }

                }
                return setListDatabaseViewModel
            }

        return null
    }

}