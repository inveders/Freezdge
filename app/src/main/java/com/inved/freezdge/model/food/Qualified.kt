package com.inved.freezdge.model.food

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Qualified {
    @SerializedName("uri")
    @Expose
    var uri: String? = null
    @SerializedName("label")
    @Expose
    var label: String? = null

}