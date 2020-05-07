package com.inved.freezdge.injection

import android.content.Context
import com.inved.freezdge.favourites.repository.FavouritesRecipesRepository
import com.inved.freezdge.ingredientslist.repository.IngredientsRepository
import com.inved.freezdge.recipes.repository.RecipesRepository
import com.inved.freezdge.socialmedia.repository.SocialMediaRepository
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor

class Injection {

    companion object {

        fun providesViewModelFactory(boxStore: BoxStore,context:Context): ViewModelFactory {
            val ingredientsRepository = IngredientsRepository(boxStore.boxFor())
            val recipesRepository = RecipesRepository(boxStore.boxFor())
            val favouritesRecipesRepository = FavouritesRecipesRepository(boxStore.boxFor())
            val socialMediaRepository = SocialMediaRepository(context)
            return ViewModelFactory(ingredientsRepository, favouritesRecipesRepository, recipesRepository, socialMediaRepository)
        }
    }
}