package com.inved.freezdge.model.food

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ResultsFood {
    @SerializedName("text")
    @Expose
    var text: String? = null
    @SerializedName("parsed")
    @Expose
    var parsed: List<Parsed>? = null
    @SerializedName("hints")
    @Expose
    var hints: List<Hint> = listOf()
    @SerializedName("_links")
    @Expose
    var links: Links? = null

}