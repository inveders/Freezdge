package com.inved.freezdge.favourites.database

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class FavouritesRecipes(
    @Id
    var id: Long = 0,
    var recipeId: String? = null,
    var recipeTitle: String? = null,
    var recipeCalories: String? = null,
    var recipeTime: String? = null,
    var recipeUrl: String? = null,
    var recipePhotoUrl: String? = null,
    var recipeIngredients: String? = null,
    var cuisineType: String? = null,
    var dishType: String? = null,
    var recipePhotoUrlOwner: String? = null,
    var daySelected: String? = null
)