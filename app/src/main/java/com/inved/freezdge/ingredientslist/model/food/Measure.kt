package com.inved.freezdge.ingredientslist.model.food

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Measure {
    @SerializedName("uri")
    @Expose
    var uri: String? = null
    @SerializedName("label")
    @Expose
    var label: String? = null
    @SerializedName("qualified")
    @Expose
    var qualified: List<List<Qualified>>? = null

}