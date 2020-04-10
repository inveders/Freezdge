package com.inved.freezdge.ingredientslist.model.food

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Hint {
    @SerializedName("food")
    @Expose
    var food: Food_? = null
    @SerializedName("measures")
    @Expose
    var measures: List<Measure>? = null

}