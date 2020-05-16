package com.inved.freezdge.utils

import android.content.Context
import android.content.res.ColorStateList
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.database.Ingredients

class ChipUtil {

    // put a different color to chip according to ingredient type (Creamery, Fruit & vegetables, epicerie, fish, or meat)
    fun handleChipColor(myresult: Ingredients, chip: Chip,context: Context) {
        if (myresult.typeIngredient.equals(context.getString(R.string.ingredient_type_cream))) {
            chip.chipBackgroundColor = context.let {
                ContextCompat.getColor(
                    it, R.color.colorCream
                )
            }.let { ColorStateList.valueOf(it) }
        }
        if (myresult.typeIngredient.equals(context.getString(R.string.ingredient_type_fruits_vegetables))) {
            chip.chipBackgroundColor = context.let {
                ContextCompat.getColor(
                    it, R.color.colorVegetables
                )
            }.let { ColorStateList.valueOf(it) }
        }
        if (myresult.typeIngredient.equals(context.getString(R.string.ingredient_type_epicerie))) {
            chip.chipBackgroundColor = context.let {
                ContextCompat.getColor(
                    it, R.color.colorEpicerie
                )
            }.let { ColorStateList.valueOf(it) }
        }
        if (myresult.typeIngredient.equals(context.getString(R.string.ingredient_type_fish))) {
            chip.chipBackgroundColor = context.let {
                ContextCompat.getColor(
                    it, R.color.colorFish
                )
            }.let { ColorStateList.valueOf(it) }
        }
        if (myresult.typeIngredient.equals(context.getString(R.string.ingredient_type_meat))) {
            chip.chipBackgroundColor = context.let {
                ContextCompat.getColor(
                    it, R.color.colorMeat
                )
            }.let { ColorStateList.valueOf(it) }
        }

    }

}