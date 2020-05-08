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

    suspend fun getRecipes(arg: String): LiveData<Results> {
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

    suspend fun getRetrofitRecipes(result: MutableList<Ingredients>): MutableLiveData<MutableSet<List<Hit>>>? {
        val setListRetrofitViewModel: MutableLiveData<MutableSet<List<Hit>>>? = MutableLiveData()
        val setRetrofitListRecipes: MutableSet<List<Hit>>? = mutableSetOf()

        if (result.size != 0) {
            BaseFragment.listener?.showLoader()

            for (myresult in result) {
                getRecipes(myresult.name!!).observeForever {
                    setRetrofitListRecipes?.add(it.hits)
                    setListRetrofitViewModel?.postValue(setRetrofitListRecipes)
                }
            }
            return setListRetrofitViewModel
        }
        return null
    }


    fun getDatabaseRecipes(result: MutableList<Ingredients>): MutableLiveData<MutableSet<MutableList<Recipes>>>? {

        val setListDatabaseViewModel: MutableLiveData<MutableSet<MutableList<Recipes>>>? =
            MutableLiveData()
        val setDatabaseListRecipes: MutableSet<MutableList<Recipes>>? = mutableSetOf()

            if (result.size != 0) {
                BaseFragment.listener?.showLoader()
                for (myresult in result) {
                    getRecipeIfContainIngredient(myresult.name!!)
                        .observeForever {
                            setDatabaseListRecipes?.add(it)
                            setListDatabaseViewModel?.postValue(setDatabaseListRecipes)
                        }
                }
                return setListDatabaseViewModel
            }

        return null
    }

}