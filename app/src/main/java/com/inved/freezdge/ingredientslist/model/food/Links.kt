package com.inved.freezdge.ingredientslist.model.food

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Links {
    @SerializedName("next")
    @Expose
    var next: Next? = null

}