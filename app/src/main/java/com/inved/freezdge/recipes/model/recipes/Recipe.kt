package com.inved.freezdge.model.recipes

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Recipe {
    @SerializedName("uri")
    @Expose
    var uri: String? = null

    @SerializedName("label")
    @Expose
    var label: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @SerializedName("source")
    @Expose
    var source: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("shareAs")
    @Expose
    var shareAs: String? = null

    @SerializedName("yield")
    @Expose
    var yield: Double? = null

    @SerializedName("dietLabels")
    @Expose
    var dietLabels: List<String>? = null

    @SerializedName("healthLabels")
    @Expose
    var healthLabels: List<String>? = null

    @SerializedName("cautions")
    @Expose
    var cautions: List<String>? = null

    @SerializedName("ingredientLines")
    @Expose
    var ingredientLines: List<String>? = null

    @SerializedName("ingredients")
    @Expose
    var ingredients: List<Ingredient>? = null

    @SerializedName("calories")
    @Expose
    var calories: Double? = null

    @SerializedName("totalWeight")
    @Expose
    var totalWeight: Double? = null

    @SerializedName("totalTime")
    @Expose
    var totalTime: Double? = null

    @SerializedName("cuisineType")
    @Expose
    var cuisineType: List<String>? = null

    @SerializedName("mealType")
    @Expose
    var mealType: List<String>? = null

    @SerializedName("dishType")
    @Expose
    var dishType: List<String>? = null


}