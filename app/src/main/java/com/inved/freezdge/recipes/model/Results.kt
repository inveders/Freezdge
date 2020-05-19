package com.inved.freezdge.recipes.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Results {
    @SerializedName("q")
    @Expose
    var q: String? = null
    @SerializedName("from")
    @Expose
    var from: Int? = null
    @SerializedName("to")
    @Expose
    var to: Int? = null
    @SerializedName("more")
    @Expose
    var more: Boolean? = null
    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("hits")
    @Expose
    var hits: List<Hit> = listOf()
}
