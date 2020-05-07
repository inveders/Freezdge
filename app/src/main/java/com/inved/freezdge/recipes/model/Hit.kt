package com.inved.freezdge.recipes.model

import android.view.View
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.inved.freezdge.R
import com.inved.freezdge.recipes.view.ViewHolderRecipesRetrofit
import com.mikepenz.fastadapter.items.AbstractItem


class Hit : AbstractItem<ViewHolderRecipesRetrofit>() {

    @SerializedName("recipe")
    @Expose
    var recipe: Recipe? = null
    @SerializedName("bookmarked")
    @Expose
    var bookmarked: Boolean? = null
    @SerializedName("bought")
    @Expose
    var bought: Boolean? = null

    /** defines the type defining this item. must be unique. preferably an id */
    override val type: Int
        get() = R.id.recipe_list_retrofit_row_id

    /** defines the layout which will be used for this item in the list  */
    override val layoutRes: Int
        get() = R.layout.item_recipes_list_retrofit

    override fun getViewHolder(v: View): ViewHolderRecipesRetrofit {

        return ViewHolderRecipesRetrofit(v)
    }
}