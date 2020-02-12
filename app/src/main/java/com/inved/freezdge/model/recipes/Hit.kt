package com.inved.freezdge.model.recipes

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Hit {
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