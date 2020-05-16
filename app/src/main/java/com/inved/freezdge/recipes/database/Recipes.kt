package com.inved.freezdge.recipes.database

import android.view.View
import com.inved.freezdge.R
import com.inved.freezdge.recipes.view.ViewHolderRecipesDatabase
import com.mikepenz.fastadapter.items.AbstractItem
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Recipes (
    @Id
    var id: Long = 0,
    var recipeTitle: String? = null,
    var recipeCalories: String? = null,
    var totalrecipeTime: String? = null,
    var preparationTime: String? = null,
    var cuisineType: String? = null,
    var dishType: String? = null,
    var cookedTime: String? = null,
    var recipePhotoUrl: String? = null,
    var recipePhotoUrlOwner: String? = null,
    var recipeUrlOwnerLink: String? = null,
    var numberPersons: Int? = 0,
    var recipeIngredients: String? = null,
    var selectedRecipe: Boolean = false,
    var numberSteps: Int? = 0,
    var step1: String? = null,
    var step2: String? = null,
    var step3: String? = null,
    var step4: String? = null,
    var step5: String? = null,
    var step6: String? = null,
    var step7: String? = null,
    var step8: String? = null,
    var step9: String? = null,
    var step10: String? = null,
    var step11: String? = null,
    var step12: String? = null
) : AbstractItem<ViewHolderRecipesDatabase>() {

    // defines the type defining this item. must be unique. preferably an id
    override val type: Int
        get() = R.id.recipe_list_database_row_id

    // defines the layout which will be used for this item in the list
    override val layoutRes: Int
        get() = R.layout.item_recipes_list_database

    override fun getViewHolder(v: View): ViewHolderRecipesDatabase {

        return ViewHolderRecipesDatabase(v)
    }

}