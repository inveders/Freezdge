package com.inved.freezdge.recipes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Ingredient {
    @SerializedName("text")
    @Expose
    var text: String? = null
    @SerializedName("weight")
    @Expose
    var weight: Double? = null

}