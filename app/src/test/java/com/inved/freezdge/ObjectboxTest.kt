package com.inved.freezdge

import android.os.Build
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.model.ShowedRecipes
import com.inved.freezdge.utils.Domain
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class ObjectboxTest:AbstractObjectBoxTest() {

    @Test
    fun shouldGetAllIngredients() {
        assertEquals(332, ingredientsBox?.count()?.toInt())
    }

    @Test
    fun shouldGetTwoSelectedIngredients() {
        ingredientsRepository.updateIngredientSelectedByName("Tomate",true)
        ingredientsRepository.updateIngredientSelectedByName("Feuilles de manioc",true)
        val number=ingredientsRepository.getAllIngredientBySelected()?.size
        val trueSelected=ingredientsRepository.isIngredientSelected("Feuilles de manioc")
        assertEquals(2, number)
        assertTrue(trueSelected==true)
    }

    @Test
    fun shouldGetTwoSelectedIngredientsInGrocery() {
        ingredientsRepository.updateIngredientSelectedForGroceryByName("Tomate",true)
        ingredientsRepository.updateIngredientSelectedForGroceryByName("Feuilles de manioc",false)
         val trueInGrocery=ingredientsRepository.isIngredientSelectedInGrocery("Tomate")
        val falseInGrocery=ingredientsRepository.isIngredientSelectedInGrocery("Feuilles de manioc")
        trueInGrocery?.let { assertTrue(it) }
        falseInGrocery?.let { assertFalse(it) }
    }

    @Test
    fun shouldGetAllRecipes() {
        assertEquals(4, recipesRepository.countRecipesInBox()?.toInt())
    }

    @Test
    fun shouldDeleteAllRecipesAndAddAll() {
        recipesRepository.deleteAllRecipesInBox()
        assertEquals(4, recipesRepository.countRecipesInBox()?.toInt())
    }

    @Test
    fun shouldGetFirstRecipeTitle() {
        val recipeTitle = recipesRepository.getRecipeLiveDataById(1)?.recipeTitle
        assertEquals("Burger et frites de patate douce", recipeTitle)

    }

    @Test
    fun shouldGetOneFavouritesRecipes() {

     /*   val recipes: Recipes? = recipesRepository.getRecipeLiveDataById(1)
        val domain=Domain()
        val model = ShowedRecipes()
        model.apply {
            model.id = recipes?.fixedId
            model.recipeTitle = recipes?.recipeTitle
            model.recipeCalories = recipes?.recipeCalories
            model.totalrecipeTime = domain.preparationTime(recipes.totalrecipeTime)
            model.cuisineType = recipes?.cuisineType
            model.dishType = recipes?.dishType
            model.recipePhotoUrl = recipes?.recipePhotoUrl
            model.recipePhotoUrlOwner = recipes?.recipePhotoUrlOwner
            model.recipeUrlOwnerLink = recipes?.recipeUrlOwnerLink
            model.recipeIngredients = recipes?.recipeIngredients
            model.matchingValue =
                domain.getMatchingValue(,
                    recipes?.fixedId?.let { ingredientsListRepository.getIngredientListByRecipe(it) })
            model.isFavouriteRecipe = recipes?.fixedId.let { favouritesRecipesRepository.isRecipeIdIsPresent(it.toString()) }
            model.isAllRecipeFragment = true
            model.selectedDay = recipes?.fixedId?.let { daySelectedRepository.isRecipeSelected(it) }!!
        }


        favouritesRecipesRepository.detectFavouriteRecipe(
            model.id.toString(),
            model.recipeTitle,
            model.recipeCalories,
            model.totalrecipeTime,
            model.recipeUrlOwnerLink,
            model.recipePhotoUrl,
            model.recipeIngredients,
            model.cuisineType,
            model.dishType,
            model.recipePhotoUrlOwner,
            model.selectedDay
        )
        favouritesRecipesRepository.isRecipeIdIsPresent(myrecipe?.id.toString())?.let {
            assertTrue(
                it
            )
        }*/
    }

}
