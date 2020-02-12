package com.inved.freezdge.model.recipes

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ENERCKCAL_ {
    @SerializedName("label")
    @Expose
    var label: String? = null
    @SerializedName("quantity")
    @Expose
    var quantity: Double? = null
    @SerializedName("unit")
    @Expose
    var unit: String? = null

}