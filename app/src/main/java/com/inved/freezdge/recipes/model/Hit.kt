package com.inved.freezdge.recipes.model

import android.view.View
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.inved.freezdge.R
import com.mikepenz.fastadapter.items.AbstractItem


class Hit() {

    @SerializedName("recipe")
    @Expose
    var recipe: Recipe? = null
    @SerializedName("bookmarked")
    @Expose
    var bookmarked: Boolean? = null
    @SerializedName("bought")
    @Expose
    var bought: Boolean? = null

}