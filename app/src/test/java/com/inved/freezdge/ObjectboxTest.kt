package com.inved.freezdge

import com.inved.freezdge.recipes.database.Recipes
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ObjectboxTest:AbstractObjectBoxTest() {

    @Test
    fun shouldGetAllIngredients() {
        assertEquals(332, ingredientsBox?.count())
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
        assertTrue(trueInGrocery==true)
        assertFalse(falseInGrocery==false)
    }

    @Test
    fun shouldGetAllRecipes() {
        assertEquals(3, recipesRepository.countRecipesInBox())
    }

    @Test
    fun shouldDeleteAllRecipesAndAddAll() {
        recipesRepository.deleteAllRecipesInBox()
        assertEquals(3, recipesRepository.countRecipesInBox())
    }

    @Test
    fun shouldGetFirstRecipeTitle() {
        val recipeTitle = recipesRepository.getRecipeLiveDataById(1)?.recipeTitle
        assertEquals("Burger et frites de patate douce", recipeTitle)

    }

    @Test
    fun shouldGetOneFavouritesRecipes() {

        val myrecipe: Recipes? = recipesRepository.getRecipeLiveDataById(1)
        favouritesRecipesRepository.detectFavouriteRecipe(
            myrecipe?.id.toString(),
            myrecipe?.recipeTitle,
            myrecipe?.recipeCalories,
            myrecipe?.totalrecipeTime,
            myrecipe?.recipeUrlOwnerLink,
            myrecipe?.recipePhotoUrl,
            myrecipe?.recipeIngredients,
            myrecipe?.cuisineType,
            myrecipe?.dishType
        )
        favouritesRecipesRepository.isRecipeIdIsPresent(myrecipe?.id.toString())?.let {
            assertTrue(
                it
            )
        }
    }

}
