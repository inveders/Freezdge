package com.inved.freezdge.recipes.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.inved.freezdge.R
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.view.ViewHolderFavouritesRecipes
import com.inved.freezdge.favourites.viewmodel.FavouritesRecipesViewModel
import com.inved.freezdge.recipes.model.Hit
import com.inved.freezdge.recipes.model.Results
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.repository.RecipesRepository
import com.inved.freezdge.recipes.view.ViewHolderRecipesDatabase
import com.inved.freezdge.recipes.view.ViewHolderRecipesRetrofit
import com.inved.freezdge.utils.Domain
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericFastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.listeners.addClickListener
import io.objectbox.android.ObjectBoxLiveData
import kotlinx.coroutines.*
import kotlin.math.roundToInt

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

    fun handleFastAdapterClick(
        fastAdapter: GenericFastAdapter,
        favouriteRecipesViewmodel: FavouritesRecipesViewModel,
        view: View
    ) {
        fastAdapter.addClickListener({ vh: ViewHolderRecipesRetrofit -> vh.imageFavourite }) { _, _, _: FastAdapter<GenericItem>, item: GenericItem ->
            //react on the click event
            if (item is Hit) {
                favouriteRecipesViewmodel.detectFavouriteRecipe(
                    item.recipe?.uri,
                    item.recipe?.label,
                    item.recipe?.calories?.div(10)?.roundToInt().toString(),
                    Domain.preparationTime(item.recipe?.totalTime),
                    item.recipe?.url,
                    item.recipe?.image,
                    item.recipe?.ingredientLines.toString(),
                    item.recipe?.cuisineType?.get(0),
                    item.recipe?.dishType?.get(0)
                )

                val bool: Boolean? =
                    item.recipe?.uri?.let { favouriteRecipesViewmodel.isRecipeIdIsPresent(it) }

                GlobalScope.launch(Dispatchers.IO) {
                    delay(500)
                    Domain.correspondanceCalculForGrocery(
                        item.recipe?.ingredientLines.toString(),
                        bool!!
                    )
                }

                if (bool!!) {
                    view.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_selected_24dp) }
                } else {
                    view.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_not_selected_24dp) }
                }

                fastAdapter.notifyAdapterDataSetChanged()
            }

        }

        fastAdapter.addClickListener({ vh: ViewHolderRecipesDatabase -> vh.imageFavourite }) { _, _, _: FastAdapter<GenericItem>, item: GenericItem ->
            //react on the click event
            if (item is Recipes) {
                favouriteRecipesViewmodel.detectFavouriteRecipe(
                    item.id.toString(),
                    item.recipeTitle,
                    item.recipeCalories,
                    item.totalrecipeTime,
                    item.recipeUrlOwnerLink,
                    item.recipePhotoUrl,
                    item.recipeIngredients,
                    item.cuisineType,
                    item.dishType
                )

                val bool: Boolean? =
                    item.id.let {
                        it.let { it1 ->
                            favouriteRecipesViewmodel.isRecipeIdIsPresent(
                                it1.toString()
                            )
                        }
                    }

                GlobalScope.launch(Dispatchers.IO) {
                    delay(500)
                    item.recipeIngredients?.let {
                        Domain.correspondanceCalculForGrocery(
                            it,
                            bool!!
                        )
                    }
                }

                if (bool!!) {
                    view.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_selected_24dp) }
                } else {
                    view.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_not_selected_24dp) }
                }

                fastAdapter.notifyAdapterDataSetChanged()
            }
        }
    }

    fun handleFavouriteFastAdapterClick(
        favouritesFastAdapter: FastAdapter<FavouritesRecipes>,
        favouriteRecipesViewmodel: FavouritesRecipesViewModel,
        view: View
    ) {
        favouritesFastAdapter.addClickListener({ vh: ViewHolderFavouritesRecipes -> vh.imageFavourite }) { _, _: Int, _: FastAdapter<FavouritesRecipes>, item: FavouritesRecipes ->
            //react on the click event

            favouriteRecipesViewmodel.detectFavouriteRecipe(
                item.recipeId, item.recipeTitle, item.recipeCalories,
                item.recipeTime, item.recipeUrl, item.recipePhotoUrl, item.recipeIngredients,
                item.cuisineType, item.dishType
            )

            val bool: Boolean? =
                item.recipeId.let { favouriteRecipesViewmodel.isRecipeIdIsPresent(it!!) }

            GlobalScope.launch(Dispatchers.IO) {
                delay(500)
                item.recipeIngredients?.let { Domain.correspondanceCalculForGrocery(it, bool!!) }
            }

            if (bool!!) {
                view.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_selected_24dp) }
            } else {
                view.let { it1 -> item.getViewHolder(it1).imageFavourite.setImageResource(R.drawable.ic_favorite_not_selected_24dp) }
            }

            favouritesFastAdapter.notifyAdapterDataSetChanged()
        }
    }
}