package com.inved.freezdge.utils

import android.graphics.drawable.Drawable
import android.util.DisplayMetrics
import android.util.Log
import android.view.animation.AlphaAnimation
import android.widget.ImageView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.firebase.storage.StorageReference
import com.inved.freezdge.R
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.database.FavouritesRecipes_
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.ingredientslist.database.Ingredients_
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import java.security.SecureRandom
import java.util.*
import kotlin.math.roundToInt

class Domain {


        private var nbIngredientInRecipe: Double = 0.0
        private var nbIngredientInFridge: Double = 0.0

        fun animation():AlphaAnimation{
           return AlphaAnimation(1f, 0.8f)
        }

        fun uppercaseFirstCaracter(name:String):String{
            val s1 = name.substring(0, 1).toUpperCase()
            return s1 + name.substring(1)
        }

        fun convertDpToPixel(dp: Int): Int {
            return (dp * (App.resource().displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
        }

        fun createRandomString(): String {
            val CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz"
            val CHAR_UPPER = CHAR_LOWER.toUpperCase()
            val NUMBER = "0123456789"
            val LENGHT = 20
            val DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER
            val random = SecureRandom()

            val sb = java.lang.StringBuilder(LENGHT)
            for (i in 0 until LENGHT) {

                // 0-62 (exclusive), random returns 0-61
                val rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length)
                val rndChar = DATA_FOR_RANDOM_STRING[rndCharAt]

                // debug
                System.out.format("%d\t:\t%c%n", rndCharAt, rndChar)
                sb.append(rndChar)
            }
            return sb.toString()

        }

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
            }else{
                val noTime:String=App.resource().getString(R.string.recipe_list_item_no_time_known)
                return noTime
            }

        }


        fun ingredientsFavouriteMatchingMethod(input: String?): Int {

            initNumberIngredientsFromString(input)

            return correspondanceCalcul(input)

        }


        fun ingredientsMatchingMethod(input: List<String?>?): Int {

            initNumberIngredients(input)

            if (input == null || input.isEmpty()) {
                return 0
            } else {
                val sb = StringBuilder()
                for (i in input.indices) {
                    sb.append(input[i])

                    // if not the last item
                    if (i != input.size - 1) {
                        sb.append(",")
                    }
                }

                return correspondanceCalcul(sb.toString())
            }

        }

        fun initNumberIngredients(input: List<String?>?) {
            //init ingredient number for recipe
            if (input != null) {
                nbIngredientInRecipe = input.size.toDouble()
            }

            if (input != null) {
                if (input.contains("water") || input.contains("eau")) {
                    nbIngredientInRecipe = nbIngredientInRecipe.minus(1)
                }
            }

            nbIngredientInFridge = 0.0
          //  Log.d("debago", "1. number ingredient in recipe is $nbIngredientInRecipe")

        }

        fun retrieveListFromString(input: String?): List<String> {
            return ArrayList(
                listOf(
                    *input!!.split(",").toTypedArray()
                )
            )
        }


        fun initNumberIngredientsFromString(input: String?) {
            //init ingredient number for recipe from favourite string
            val poiList = ArrayList(
                Arrays.asList(
                    *input!!.split(",").toTypedArray()
                )
            )

            nbIngredientInRecipe = poiList.size.toDouble()



            if (poiList.contains("water") || poiList.contains("eau")) {
                nbIngredientInRecipe = nbIngredientInRecipe?.minus(1)
            }

            if (poiList.contains("salt") || poiList.contains("sel")) {
                nbIngredientInRecipe = nbIngredientInRecipe?.minus(1)
            }


            nbIngredientInFridge = 0.0
          //  Log.d("debago", "1. number ingredient in recipe is $nbIngredientInRecipe")

        }

        private fun proportionCalcul(nbIngredientInFridge: Double, nbIngredientInRecipe: Double): Int {
            val n: Int = ((nbIngredientInFridge / nbIngredientInRecipe) * 100).roundToInt()
            val pourcent:Int
            pourcent = if(((n + 4) / 5 * 5)<100){
                ((n + 4) / 5 * 5)
            }else{
                100
            }
            return pourcent
        }

        private fun correspondanceCalcul(input: String?): Int {

          //  Log.d("debago", "2. input is $input")
            for (i in getAllIngredientBySelected()) {
                var count: Int = 0
                if (i.name?.let { input?.contains(it, true) }!!) {
                  //  Log.d("debago", "3. input contains ${i.name}")
                    nbIngredientInFridge = nbIngredientInFridge.plus(1)
                    count = count.plus(1)
                }

                //TODO
                if (count == 0) {
                    if (i.nameEnglish?.let { input?.contains(it, true) }!!) {
                     //   Log.d("debago", "3. input contains ${i.nameEnglish}")
                        nbIngredientInFridge = nbIngredientInFridge.plus(1)
                    }
                }

            }
          //  Log.d("debago", "4. ingredients in fridge is $nbIngredientInFridge")
            return if (nbIngredientInFridge != 0.0 && nbIngredientInRecipe != 0.0) {
                proportionCalcul(nbIngredientInFridge, nbIngredientInRecipe)
            } else {
                0
            }
        }

        fun correspondanceCalculForGrocery(input: String, isFavouriteAdd: Boolean) {

          //  Log.d("debago", "2. GROCERY input is $input")
            for (i in getAllIngredientNotSelected()) {
                var count: Int = 0
                if (i.name?.let { input.contains(it, true) }!!) {
                //    Log.d("debago", "3. GROCERY french input contains ${i.name}")
                    updateItemForGroceryList(i.name!!, isFavouriteAdd, i.nameEnglish!!)
                    count = count.plus(1)
                }

                //TODO
                if (count == 0) {
                    if (i.nameEnglish?.let { input.contains(it, true) }!!) {
                     //   Log.d("debago", "3. GROCERY english input contains ${i.nameEnglish}")
                        updateItemForGroceryList(i.name!!, isFavouriteAdd, i.nameEnglish!!)
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

        fun updateItemForGroceryList(name: String, bool: Boolean, nameEnglish: String) {
            // query all notes, sorted a-z by their text (http://greenrobot.org/objectbox/documentation/queries/)
          //  Log.d("debago","GROCERY update item for grocery list $name")
            updateIngredientSelectedForGroceryByName(name, bool)
            if(!bool){
                isIngredientPresentInFavoriteRecipeUpdateGrocery(name, nameEnglish)
            }


        }

        fun updateIngredientSelectedForGroceryByName(name: String?,bool:Boolean) {

            if(name!=null){
                val ingredient:Ingredients? =
                    App.ObjectBox.boxStore.boxFor<Ingredients>().query().equal(Ingredients_.name,name).build().findUnique()
                ingredient?.grocerySelectedIngredient = bool
                if(ingredient!=null)
                    App.ObjectBox.boxStore.boxFor<Ingredients>().put(ingredient)
            }

        }




        fun isIngredientPresentInFavoriteRecipeUpdateGrocery(ingredientNameFrench: String,ingredientNameEnglish: String){

            for(i in App.ObjectBox.boxStore.boxFor<FavouritesRecipes>().query().order(FavouritesRecipes_.id).build().find()){
                if (i.recipeIngredients?.let { it.contains(ingredientNameFrench, true) }!!) {

                    updateItemForGroceryList(ingredientNameFrench, true,ingredientNameEnglish)
                }

                if (i.recipeIngredients?.let { it.contains(ingredientNameEnglish, true) }!!) {

                    updateItemForGroceryList(ingredientNameFrench, true,ingredientNameEnglish)
                }
            }

        }




}