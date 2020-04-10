package com.inved.freezdge.ingredientslist.model.food

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Food {
    @SerializedName("foodId")
    @Expose
    var foodId: String? = null
    @SerializedName("label")
    @Expose
    var label: String? = null
    @SerializedName("nutrients")
    @Expose
    var nutrients: Nutrients? = null
    @SerializedName("category")
    @Expose
    var category: String? = null
    @SerializedName("categoryLabel")
    @Expose
    var categoryLabel: String? = null

}