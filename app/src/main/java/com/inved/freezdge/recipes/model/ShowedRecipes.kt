package com.inved.freezdge.recipes.model

import android.os.Parcel
import android.os.Parcelable

class ShowedRecipes() :Parcelable {
    var id: Long? = 0
    var favouriteId:Long?=0
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
    var selectedDay: Boolean = false

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Long::class.java.classLoader) as? Long
        favouriteId = parcel.readValue(Long::class.java.classLoader) as? Long
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
        selectedDay = parcel.readValue(Boolean::class.java.classLoader) as Boolean
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeValue(favouriteId)
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
        parcel.writeValue(selectedDay)
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