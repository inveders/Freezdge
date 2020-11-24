package com.inved.freezdge.ingredientslist.database

import android.view.View
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.view.ViewHolderIngredients
import com.mikepenz.fastadapter.items.AbstractItem
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id


@Entity
data class Ingredients(@Id var id: Long = 0,
                       var name: String? = null,
                       var nameEnglish: String? = null,
                       var typeIngredient: String? = null,
                       var photoUrl: String? = null,
                       var selectedIngredient: Boolean = false,
                       var grocerySelectedIngredient: Boolean = false,
                       var fixedId :Long = 0,
                       var supermarketSection: String? = null): AbstractItem<ViewHolderIngredients>(){

    // defines the type defining this item. must be unique. preferably an id
    override val type: Int
    get() = R.id.ingredient_list_row_id

    // defines the layout which will be used for this item in the list
    override val layoutRes: Int
    get() = R.layout.item_ingredients_list

    override fun getViewHolder(v: View): ViewHolderIngredients {
        return ViewHolderIngredients(
            v
        )
    }

}