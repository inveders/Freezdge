package com.inved.freezdge.model.food

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Food_ {
    @SerializedName("foodId")
    @Expose
    var foodId: String? = null
    @SerializedName("label")
    @Expose
    var label: String? = null
    @SerializedName("nutrients")
    @Expose
    var nutrients: Nutrients_? = null
    @SerializedName("category")
    @Expose
    var category: String? = null
    @SerializedName("categoryLabel")
    @Expose
    var categoryLabel: String? = null
    @SerializedName("foodContentsLabel")
    @Expose
    var foodContentsLabel: String? = null
    @SerializedName("brand")
    @Expose
    var brand: String? = null
    @SerializedName("image")
    @Expose
    var image: String? = null

}