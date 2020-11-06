package com.inved.freezdge.utils.enumtype

import com.inved.freezdge.R
import com.inved.freezdge.utils.App

enum class IngredientsType(val typeName:String){
    CREAMERY(App.appContext.getString(R.string.ingredient_type_cream)),
    FRUITS_VEGETABLES(App.appContext.getString(R.string.ingredient_type_fruits_vegetables)),
    FISH(App.appContext.getString(R.string.ingredient_type_fish)),
    MEAT(App.appContext.getString(R.string.ingredient_type_meat)),
    EPICERIE(App.appContext.getString(R.string.ingredient_type_epicerie)),
}