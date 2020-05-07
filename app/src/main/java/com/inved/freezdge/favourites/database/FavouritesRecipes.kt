package com.inved.freezdge.favourites.database

import android.view.View
import com.inved.freezdge.R
import com.inved.freezdge.favourites.view.ViewHolderFavouritesRecipes
import com.mikepenz.fastadapter.items.AbstractItem
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
    var dishType: String? = null
) : AbstractItem<ViewHolderFavouritesRecipes>() {

    /** defines the type defining this item. must be unique. preferably an id */
    override val type: Int
        get() = R.id.recipe_list_retrofit_row_id

    /** defines the layout which will be used for this item in the list  */
    override val layoutRes: Int
        get() = R.layout.item_recipes_list_retrofit

    override fun getViewHolder(v: View): ViewHolderFavouritesRecipes {
        return ViewHolderFavouritesRecipes(
            v
        )
    }



}