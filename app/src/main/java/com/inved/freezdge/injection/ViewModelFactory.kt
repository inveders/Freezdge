package com.inved.freezdge.injection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.inved.freezdge.favourites.repository.FavouritesRecipesRepository
import com.inved.freezdge.favourites.viewmodel.FavouritesRecipesViewModel
import com.inved.freezdge.ingredientslist.repository.IngredientsRepository
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.recipes.repository.RecipesRepository
import com.inved.freezdge.recipes.viewmodel.RecipeViewModel
import com.inved.freezdge.socialmedia.repository.SocialMediaRepository
import com.inved.freezdge.socialmedia.viewmodel.SocialMediaViewModel

class ViewModelFactory(
    private val ingredientsRepository: IngredientsRepository,
    private val favouritesRecipesRepository: FavouritesRecipesRepository,
    private val recipesRepository: RecipesRepository,
    private val socialMediaRepository: SocialMediaRepository
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(IngredientsViewModel::class.java) -> IngredientsViewModel(ingredientsRepository) as T
            modelClass.isAssignableFrom(FavouritesRecipesViewModel::class.java) -> FavouritesRecipesViewModel(favouritesRecipesRepository) as T
            modelClass.isAssignableFrom(RecipeViewModel::class.java) -> RecipeViewModel(recipesRepository) as T
            modelClass.isAssignableFrom(SocialMediaViewModel::class.java) -> SocialMediaViewModel(socialMediaRepository) as T

            else -> throw Exception("Unknown ViewModel class")

        }

    }
}