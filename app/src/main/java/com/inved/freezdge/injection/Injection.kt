package com.inved.freezdge.injection

import com.inved.freezdge.favourites.repository.FavouritesRecipesRepository
import com.inved.freezdge.ingredientslist.repository.IngredientsRepository
import com.inved.freezdge.recipes.repository.RecipesRepository
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor

class Injection {

    companion object {

        fun providesViewModelFactory(boxStore: BoxStore): ViewModelFactory {
            val ingredientsRepository = IngredientsRepository(boxStore.boxFor())
            val recipesRepository = RecipesRepository(boxStore.boxFor())
            val favouritesRecipesRepository = FavouritesRecipesRepository(boxStore.boxFor())
            return ViewModelFactory(ingredientsRepository, favouritesRecipesRepository, recipesRepository)
        }
    }
}