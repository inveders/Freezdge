package com.inved.freezdge.model.food

import android.view.View
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.inved.freezdge.R
import com.inved.freezdge.view.ViewHolderFood
import com.mikepenz.fastadapter.items.AbstractItem

class Hint: AbstractItem<ViewHolderFood>() {
    @SerializedName("food")
    @Expose
    var food: Food_? = null
    @SerializedName("measures")
    @Expose
    var measures: List<Measure>? = null

    /** defines the type defining this item. must be unique. preferably an id */
    override val type: Int
        get() = R.id.ingredient_list_row_id

    /** defines the layout which will be used for this item in the list  */
    override val layoutRes: Int
        get() = R.layout.item_ingredients_list

    override fun getViewHolder(v: View): ViewHolderFood {
        return ViewHolderFood(v)
    }

}