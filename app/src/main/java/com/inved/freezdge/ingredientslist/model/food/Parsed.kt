package com.inved.freezdge.ingredientslist.model.food
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Parsed  {
    @SerializedName("food")
    @Expose
    var food: Food? = null



}