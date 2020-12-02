package com.inved.freezdge.utils

import android.util.DisplayMetrics
import android.view.animation.AlphaAnimation
import com.inved.freezdge.BuildConfig
import com.inved.freezdge.R
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.database.FavouritesRecipes_
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.database.IngredientsList
import com.inved.freezdge.ingredientslist.database.Ingredients_
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.onboarding.OnboardingActivity
import com.inved.freezdge.utils.enumtype.DayType
import com.inved.freezdge.utils.enumtype.DishType
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import java.security.SecureRandom
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.roundToInt

class Domain {

    fun animation(): AlphaAnimation {
        return AlphaAnimation(1f, 0.8f)
    }

    fun convertDpToPixel(dp: Int): Int {
        return (dp * (App.resource().displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
    }

    fun updateSharedPrefVersionName(){
        val editor = OnboardingActivity.sharedPrefVersionName.edit()
        editor.putString(OnboardingActivity.VERSION_APP_NAME, BuildConfig.VERSION_NAME)
        editor.apply()
    }

    fun updateSharedPrefFirstConnexion(bool:Boolean){
        val editor = OnboardingActivity.sharedPrefFirstConnexion.edit()
        editor.putBoolean(OnboardingActivity.FIRST_CONNEXION, bool)
        editor.apply()
    }

    fun updateUid(uid:String){
        val editor = OnboardingActivity.sharedPrefFirebaseUid.edit()
        editor.putString(OnboardingActivity.FIREBASE_UID,uid)
        editor.apply()
    }

    fun createRandomString(): String {
        val charLower = "abcdefghijklmnopqrstuvwxyz"
        val charUpper = charLower.toUpperCase(Locale.getDefault())
        val number = "0123456789"
        val lenghtWord = 20
        val dataForRandomString = charLower + charUpper + number
        val random = SecureRandom()

        val sb = java.lang.StringBuilder(lenghtWord)
        for (i in 0 until lenghtWord) {

            // 0-62 (exclusive), random returns 0-61
            val rndCharAt = random.nextInt(dataForRandomString.length)
            val rndChar = dataForRandomString[rndCharAt]

            // debug
            System.out.format("%d\t:\t%c%n", rndCharAt, rndChar)
            sb.append(rndChar)
        }
        return sb.toString()

    }

    // convert preparation time from double to string with % min or % h % min
    fun preparationTime(time: Int?): String? {
        if (time != null) {
            when {
                time == 0 -> {
                    return App.resource().getString(R.string.recipe_list_item_no_time_known)
                }
                time < 60 -> {
                    return App.resource()
                        .getString(R.string.recipe_list_item_time_min, time)
                }
                else -> {
                    val hours: Int = time / 60 //since both are ints, you get an int

                    val minutes: Int = time % 60
                    return if (minutes == 0) {
                        App.resource()
                            .getString(R.string.recipe_list_item_time_hours, hours)
                    } else {
                        App.resource()
                            .getString(R.string.recipe_list_item_time_min_hours, hours, minutes)
                    }

                }
            }
        } else {
            return App.resource().getString(R.string.recipe_list_item_no_time_known)
        }

    }

    fun handleDishType(dishType:String?):String{
        when (dishType) {
            DishType.MAIN_COURSE.dishName -> {
                return App.resource().getString(R.string.array_filter_plat)
            }
            DishType.STARTER.dishName -> {
                return App.resource().getString(R.string.array_filter_entry)
            }
            DishType.COCKTAIL.dishName -> {
                return App.resource().getString(R.string.array_filter_cocktail)
            }
            DishType.DESSERT.dishName -> {
                return App.resource().getString(R.string.array_filter_dessert)
            }
            else -> return App.resource().getString(R.string.array_filter_other)

        }
    }


    //return matching pourcent
    fun getMatchingValue(
        ingredientsViewModel: IngredientsViewModel,
        list: MutableList<IngredientsList>?
    ): Int {

        val numberIngredientsForRecipe=list?.size
        var numberIngredientInMyFreezdge=0
        list?.forEach {
            if(ingredientsViewModel.getIngredientById(it.ingredientsId)?.selectedIngredient==true){
                numberIngredientInMyFreezdge += 1
            }
        }

        return proportionCalcul(numberIngredientInMyFreezdge.toDouble(), numberIngredientsForRecipe?.toDouble())
    }

    // split ingredient line in list of String to manipulate
    fun retrieveListFromString(input: String?): List<String> {
        return ArrayList(
            listOf(
                *input?.split(",")!!.toTypedArray()
            )
        )
    }

    // split ingredient line in list of String to manipulate
    fun retrieveStringFromListString(listString : ArrayList<String>?): String? {
        return listString?.joinToString(", ")
    }

    // split ingredient line in list of String to manipulate without space
    fun retrieveStringFromListStringWithoutSpace(listString : ArrayList<String>?): String? {
        return listString?.joinToString(",")
    }

    // find wich ingredients are in recipes and not in my fridge and add them to the grocery list
    fun missingIngredients(ingredientsList: MutableList<IngredientsList>): ArrayList<String>?{

        val missingIngredientsList:ArrayList<String> = arrayListOf()
        ingredientsList.forEach {
            val ingredients = it.ingredientsId?.let { it1 -> getIngredient(it1) }
            ingredients?.let { myIngredient->
                if(!myIngredient.selectedIngredient){
                    myIngredient.name?.let { it1 -> missingIngredientsList.add(it1) }
                }
            }
        }

        return missingIngredientsList
    }


    //pure calcul
    fun proportionCalcul(nbIngredientInFridge: Double, nbIngredientInRecipe: Double?): Int {
        return if(nbIngredientInRecipe==0.0 || nbIngredientInRecipe==null){
            0
        }else{
            val n: Int = ((nbIngredientInFridge / nbIngredientInRecipe) * 100).roundToInt()
            val pourcent: Int
            pourcent = if (((n + 4) / 5 * 5) < 100) {
                ((n + 4) / 5 * 5)
            } else {
                100
            }
            pourcent
        }

    }

    // find wich ingredients are in recipes and not in my fridge and add them to the grocery list
    fun correspondanceCalculForGrocery(input: String, isFavouriteAdd: Boolean?) {

        for (i in getAllIngredientNotSelected()) {
            var count = 0

            if (i.name?.let {nameIngredient-> input.contains(nameIngredient, true) }==true) {

                if (input.indexOf(i.name.toString(),0,true) >= 0) {
                    isFavouriteAdd?.let { i.name?.let { it1 -> i.nameEnglish?.let { it2 ->
                        updateItemForGroceryList(it1, it,
                            it2
                        )
                    } } }
                    count = count.plus(1)
                }


            }

            if (count == 0) {
                if (i.nameEnglish?.let { input.contains(it, true) }==true) {
                    isFavouriteAdd?.let { i.name?.let { it1 ->
                        i.nameEnglish?.let { it2 ->
                            updateItemForGroceryList(
                                it1, it, it2
                            )
                        }
                    } }
                }
            }

        }

    }

    private fun getIngredientsBox(): Box<Ingredients> {
        val boxStore: BoxStore = App.ObjectBox.boxStore
        return boxStore.boxFor()
    }


    private fun getIngredient(ingredientId:Long): Ingredients? {
        return getIngredientsBox()
                .query().equal(Ingredients_.fixedId, ingredientId)
                .build().findUnique()

    }


    private fun getAllIngredientNotSelected(): List<Ingredients> {
        // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
        return getIngredientsBox()
            .query().equal(Ingredients_.selectedIngredient, false).order(Ingredients_.name)
            .build().find()
    }

    //add ingredients in my grocery list
    fun updateItemForGroceryList(name: String, bool: Boolean, nameEnglish: String) {
        // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
        updateIngredientSelectedForGroceryByName(name, bool)
        if (!bool) {
            isIngredientPresentInFavoriteRecipeUpdateGrocery(name, nameEnglish)
        }
    }


    private fun updateIngredientSelectedForGroceryByName(name: String?, bool: Boolean) {

        if (name != null) {
            val ingredient: Ingredients? =
                App.ObjectBox.boxStore.boxFor<Ingredients>().query().equal(Ingredients_.name, name)
                    .build().findUnique()
            ingredient?.grocerySelectedIngredient = bool
            if (ingredient != null)
                App.ObjectBox.boxStore.boxFor<Ingredients>().put(ingredient)
        }

    }

    // for each recipes in favourite database, check if the given ingredient is contained in, if yes add it in the grocery list
    private fun isIngredientPresentInFavoriteRecipeUpdateGrocery(
        ingredientNameFrench: String,
        ingredientNameEnglish: String
    ) {

        for (i in App.ObjectBox.boxStore.boxFor<FavouritesRecipes>().query()
            .order(FavouritesRecipes_.id).build().find()) {
            if (i.recipeIngredients?.contains(ingredientNameFrench, true)==true) {

                updateItemForGroceryList(ingredientNameFrench, true, ingredientNameEnglish)
            }

            if (i.recipeIngredients?.contains(ingredientNameEnglish, true)==true) {

                updateItemForGroceryList(ingredientNameFrench, true, ingredientNameEnglish)
            }
        }

    }

    fun handleSelectedDay(day: Long?): String? {
        when {
            day== DayType.MONDAY.day -> {
                return DayType.MONDAY.dayName
            }
            day== DayType.TUESDAY.day -> {
                return DayType.TUESDAY.dayName
            }
            day== DayType.WEDNESDAY.day -> {
                return DayType.WEDNESDAY.dayName
            }
            day== DayType.THURSDAY.day -> {
                return DayType.THURSDAY.dayName
            }
            day== DayType.FRIDAY.day -> {
                return DayType.FRIDAY.dayName
            }
            day== DayType.SATURDAY.day -> {
                return DayType.SATURDAY.dayName
            }
            day== DayType.SUNDAY.day -> {
                return DayType.SUNDAY.dayName
            }
            else -> return null
        }

    }

}