package com.inved.freezdge.favourites.database

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class FavouritesRecipes(
    @Id
    var id: Long = 0,
    var recipeId: String? = null,
    var kitchen: String? = null
)