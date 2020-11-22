package com.inved.freezdge.ingredientslist.database

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class IngredientsList(
    @Id
    var id: Long = 0,
    var recipeId: Long? = null,
    var ingredientsId: Long? = null,
    var ingredientsName: String? = null,
    var ingredientsReplacementId: Long? = null,
    var quantity: Double? = null,
    var unit: String? = null,
    var recipeMirror: Long? = null
)