package com.inved.freezdge.recipes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.recipes.database.Recipes
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

    private fun getRecipeIfContainIngredient(ingredientName: String): ObjectBoxLiveData<Recipes> {
        return recipesRepository.getRecipeIfContainIngredient(ingredientName)
    }

    fun insertRecipesInDatabase() {
        return recipesRepository.insertRecipesInDatabase()
    }

    fun deleteAllRecipesInDatabase() {
        return recipesRepository.deleteAllRecipesInBox()
    }

    fun countAllRecipesInDatabase():Long? {
        return recipesRepository.countRecipesInBox()
    }

    // Search in our database all recipes wich match with given ingredients, and add these recipes in a Mutable Hashset list to avoid duplication
    fun getDatabaseRecipes(ingredientsList: MutableList<Ingredients>?): MutableLiveData<MutableList<Recipes>>? {

        var setListDatabaseViewModel: MutableLiveData<MutableList<Recipes>>? =
            MutableLiveData()
        var setDatabaseSetListRecipes:MutableSet<Recipes>? = mutableSetOf()

                BaseFragment.listener?.showLoader()
                if (ingredientsList != null) {
                    for (myIngredient in ingredientsList) {
                        myIngredient.name?.let { it ->
                            getRecipeIfContainIngredient(it)
                                .observeForever {
                                    if(it.size==0){
                                        setListDatabaseViewModel?.postValue(setDatabaseSetListRecipes?.toMutableList())
                                    }else{
                                        for(i in it.indices){
                                            setDatabaseSetListRecipes?.add(it[i])
                                             setListDatabaseViewModel?.postValue(setDatabaseSetListRecipes?.toMutableList())
                                           // setListDatabaseViewModel?.value=setDatabaseSetListRecipes?.toMutableList()
                                        }
                                    }


                                }
                        }

                    }
                }
                return setListDatabaseViewModel
    }

}