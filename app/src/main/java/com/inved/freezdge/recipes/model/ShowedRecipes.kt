package com.inved.freezdge.recipes.model

import android.os.Parcel
import android.os.Parcelable

class ShowedRecipes() :Parcelable {
    var id: Long = 0
    var recipeTitle: String? = null
    var recipeCalories: String? = null
    var totalrecipeTime: String? = null
    var cuisineType: String? = null
    var dishType: String? = null
    var recipePhotoUrl: String? = null
    var recipePhotoUrlOwner: String? = null
    var recipeUrlOwnerLink: String? = null
    var recipeIngredients: String? = null
    var matchingValue: Int = 0
    var isFavouriteRecipe:Boolean?=false
    var isAllRecipeFragment:Boolean?=false

    constructor(parcel: Parcel) : this() {
        id = parcel.readLong()
        recipeTitle = parcel.readString()
        recipeCalories = parcel.readString()
        totalrecipeTime = parcel.readString()
        cuisineType = parcel.readString()
        dishType = parcel.readString()
        recipePhotoUrl = parcel.readString()
        recipePhotoUrlOwner = parcel.readString()
        recipeUrlOwnerLink = parcel.readString()
        recipeIngredients = parcel.readString()
        matchingValue = parcel.readInt()
        isFavouriteRecipe = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        isAllRecipeFragment = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(recipeTitle)
        parcel.writeString(recipeCalories)
        parcel.writeString(totalrecipeTime)
        parcel.writeString(cuisineType)
        parcel.writeString(dishType)
        parcel.writeString(recipePhotoUrl)
        parcel.writeString(recipePhotoUrlOwner)
        parcel.writeString(recipeUrlOwnerLink)
        parcel.writeString(recipeIngredients)
        parcel.writeInt(matchingValue)
        parcel.writeValue(isFavouriteRecipe)
        parcel.writeValue(isAllRecipeFragment)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ShowedRecipes> {
        override fun createFromParcel(parcel: Parcel): ShowedRecipes {
            return ShowedRecipes(parcel)
        }

        override fun newArray(size: Int): Array<ShowedRecipes?> {
            return arrayOfNulls(size)
        }
    }

}