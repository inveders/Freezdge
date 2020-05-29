package com.inved.freezdge.utils

import android.util.DisplayMetrics
import android.view.animation.AlphaAnimation
import com.inved.freezdge.BuildConfig
import com.inved.freezdge.R
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.database.FavouritesRecipes_
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.database.Ingredients_
import com.inved.freezdge.onboarding.OnboardingActivity
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import java.security.SecureRandom
import java.util.*
import kotlin.math.roundToInt

class Domain {

    private var nbIngredientInRecipe: Double = 0.0
    private var nbIngredientInFridge: Double = 0.0

    fun animation(): AlphaAnimation {
        return AlphaAnimation(1f, 0.8f)
    }

    fun uppercaseFirstCharacter(name: String): String {
        val s1 = name.substring(0, 1).toUpperCase(Locale.getDefault())
        return s1 + name.substring(1)
    }

    fun convertDpToPixel(dp: Int): Int {
        return (dp * (App.resource().displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
    }

    fun updateSharedPrefVersionName(){
        val editor = OnboardingActivity.sharedPrefVersionName.edit()
        editor.putString(OnboardingActivity.VERSION_APP_NAME, BuildConfig.VERSION_NAME)
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
    fun preparationTime(time: Double?): String? {
        if (time != null) {
            when {
                time == 0.0 -> {
                    return App.resource().getString(R.string.recipe_list_item_no_time_known)
                }
                time <= 60.0 -> {
                    return App.resource()
                        .getString(R.string.recipe_list_item_time_min, time.roundToInt())
                }
                else -> {
                    val timeInt = time.toInt()
                    val hours: Int = timeInt / 60 //since both are ints, you get an int

                    val minutes: Int = timeInt % 60
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


    //return matching pourcent
    fun ingredientsFavouriteMatchingMethod(input: String?): Int {

        initNumberIngredientsFromString(input)

        return correspondanceCalcul(input)

    }


    fun ingredientsMatchingMethod(input: List<String?>?): Int {

        initNumberIngredients(input)

        return if (input == null || input.isEmpty()) {
            0
        } else {
            val sb = StringBuilder()
            for (i in input.indices) {
                sb.append(input[i])

                // if not the last item
                if (i != input.size - 1) {
                    sb.append(",")
                }
            }

            correspondanceCalcul(sb.toString())
        }

    }

    //init ingredient number for recipe calcul
    private fun initNumberIngredients(input: List<String?>?) {

        if (input != null) {
            nbIngredientInRecipe = input.size.toDouble()
        }

        if (input != null) {
            if (input.contains("water") || input.contains("eau")) {
                nbIngredientInRecipe = nbIngredientInRecipe.minus(1)
            }
        }

        nbIngredientInFridge = 0.0
    }

    // split ingredient line in list of String to manipulate
    fun retrieveListFromString(input: String?): List<String> {
        return ArrayList(
            listOf(
                *input?.split(",")!!.toTypedArray()
            )
        )
    }


    //count ingredients from list and remove water and salt from list it's all times ingredients
    private fun initNumberIngredientsFromString(input: String?) {
        //init ingredient number for recipe from favourite string
        val poiList = retrieveListFromString(input)

        nbIngredientInRecipe = poiList.size.toDouble()

        if (poiList.contains("water") || poiList.contains("eau")) {
            nbIngredientInRecipe = nbIngredientInRecipe.minus(1)
        }

        if (poiList.contains("salt") || poiList.contains("sel")) {
            nbIngredientInRecipe = nbIngredientInRecipe.minus(1)
        }

        nbIngredientInFridge = 0.0

    }

    //pure calcul
    fun proportionCalcul(nbIngredientInFridge: Double, nbIngredientInRecipe: Double): Int {
        val n: Int = ((nbIngredientInFridge / nbIngredientInRecipe) * 100).roundToInt()
        val pourcent: Int
        pourcent = if (((n + 4) / 5 * 5) < 100) {
            ((n + 4) / 5 * 5)
        } else {
            100
        }
        return pourcent
    }

    //calculate matching pourcent between my selected ingredients and ingredients in the recipe
    private fun correspondanceCalcul(input: String?): Int {

        for (i in getAllIngredientBySelected()) {
            var count = 0
            if (i.name?.let { input?.contains(it, true) }==true) {
                nbIngredientInFridge = nbIngredientInFridge.plus(1)
                count = count.plus(1)
            }

            if (count == 0) {
                if (i.nameEnglish?.let { input?.contains(it, true) }==true) {
                    nbIngredientInFridge = nbIngredientInFridge.plus(1)
                }
            }

        }
        return if (nbIngredientInFridge != 0.0 && nbIngredientInRecipe != 0.0) {
            proportionCalcul(nbIngredientInFridge, nbIngredientInRecipe)
        } else {
            0
        }
    }

    // find wich ingredients are in recipes and not in my fridge and add them to the grocery list
    fun correspondanceCalculForGrocery(input: String, isFavouriteAdd: Boolean?) {

        for (i in getAllIngredientNotSelected()) {
            var count = 0
            if (i.name?.let { input.contains(it, true) }==true) {
                isFavouriteAdd?.let { i.name?.let { it1 -> i.nameEnglish?.let { it2 ->
                    updateItemForGroceryList(it1, it,
                        it2
                    )
                } } }
                count = count.plus(1)
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

    private fun getAllIngredientBySelected(): List<Ingredients> {
        // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
        return getIngredientsBox()
            .query().equal(Ingredients_.selectedIngredient, true).order(Ingredients_.name)
            .build().find()
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

}