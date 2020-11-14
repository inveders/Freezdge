package com.inved.freezdge.recipes.adapter

import android.content.Context
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.storage.FirebaseStorage
import com.inved.freezdge.R
import com.inved.freezdge.schedule.database.DaySelected
import com.inved.freezdge.recipes.model.ShowedRecipes
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.enumtype.ChipsDayType
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.GlideUtils
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlin.math.roundToInt

class ListRecipeItem : AbstractItem<ListRecipeItem.ViewHolder>(){

    var model:ShowedRecipes?=null
    var isReducedWidth: Boolean = false
    var selectedDay: DaySelected?=null
    var selectedPosition:Int?=0


    // defines the type defining this item. must be unique. preferably an id
    override val type: Int
        get() = R.id.recipe_list_database_row_id

    // defines the layout which will be used for this item in the list
    override val layoutRes: Int
        get() = if(isReducedWidth) R.layout.item_recipe_list_database_reduced_width else R.layout.item_recipes_list_database

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<ListRecipeItem>(view) {

        private var metrics = DisplayMetrics()

        private fun getDisplayMetrics() {
            val windowManager: WindowManager =
                view.context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            windowManager.defaultDisplay.getMetrics(metrics)
        }

        var domain= Domain()
        var label: TextView = view.findViewById(R.id.title)
        var preparationTime: TextView =
            view.findViewById(R.id.fragment_recipes_list_item_preparation_time_text)
        var cuisineType: TextView = view.findViewById(R.id.fragment_recipes_list_cuisine_type)
        var dishType: TextView = view.findViewById(R.id.fragment_recipes_list_dish_type)
        private var imageItem: ImageView = view.findViewById(R.id.image)
        private var dateSelectedText: TextView = view.findViewById(R.id.recipe_day_selected)
        var selectDateButton: ImageButton = view.findViewById(R.id.select_date_button)
        var imageFavourite: ImageView =
            view.findViewById(R.id.favorite_image)
        private var imageOwner: ImageView =
            view.findViewById(R.id.owner_image)
        var proportionText: TextView =
            view.findViewById(R.id.fragment_recipes_list_item_matching)

        override fun bindView(item: ListRecipeItem, payloads: MutableList<Any>) {

            if(item.isReducedWidth){
                getDisplayMetrics().also {
                    view.layoutParams.width =(metrics.widthPixels * 0.4).roundToInt()
                }
            }

            //handle selected day visibility and select date button visibility
            if(item.model?.isFavouriteRecipe==true){
                if(item.selectedDay!=null){
                    var isDinnerOrLunch:String?=""
                    if(item.selectedPosition == ChipsDayType.LUNCH.chipPosition){
                        isDinnerOrLunch = App.appContext.getString(R.string.lunch).decapitalize()
                    }else if (item.selectedPosition == ChipsDayType.DINNER.chipPosition){
                        isDinnerOrLunch = App.appContext.getString(R.string.dinner).decapitalize()
                    }
                    dateSelectedText.text = App.appContext.getString(R.string.recipe_list_item_day_scheduled,isDinnerOrLunch)
                }

            }else{
                dateSelectedText.visibility=View.INVISIBLE
            }

            label.text = item.model?.recipeTitle

            if(item.model?.totalrecipeTime.isNullOrEmpty()){
                preparationTime.text = App.resource().getString(R.string.recipe_list_item_no_time_known)
            }else{
                preparationTime.text = item.model?.totalrecipeTime
            }

            cuisineType.text= item.model?.cuisineType?.capitalize()
            dishType.text= domain.handleDishType(item.model?.dishType)

            // we calcul the proportion of ingredients matching between our selected ingredients and the ingredients in the recipe.
            val proportionInPercent:Int= domain.ingredientsFavouriteMatchingMethod(item.model?.recipeIngredients)

            proportionText.text=
                App.resource().getString(R.string.recipe_matching_percent,proportionInPercent)

            // We attribute different color according to the matching value
            when (item.model?.matchingValue) {
                in 80..100 -> {
                    proportionText.setBackgroundResource(R.drawable.border_green)
                }
                in 50..79 -> {
                    proportionText.setBackgroundResource(R.drawable.border_orange)
                }
                in 0..49 -> {
                    proportionText.setBackgroundResource(R.drawable.border_red)
                }
            }

            val storage = FirebaseStorage.getInstance()
            val gsReference = item.model?.recipePhotoUrl?.let { storage.getReferenceFromUrl(it) }
            // we show photo from our firebase storage
            GlideUtils.loadPhotoWithGlide(gsReference,null,imageItem)

            val gsReferenceOwner = item.model?.recipePhotoUrlOwner?.let { storage.getReferenceFromUrl(it) }
            GlideUtils.loadPhotoWithGlideCircleCrop(gsReferenceOwner,imageOwner)

            // We detect if the recipe is in our favourite and update UI according to
            if(item.model?.isFavouriteRecipe==true){
                imageFavourite.setImageResource(R.drawable.ic_favorite_selected_24dp)
            }else{
                imageFavourite.setImageResource(R.drawable.ic_favorite_not_selected_24dp)
            }
        }

        override fun unbindView(item: ListRecipeItem) {
            label.text = null
            preparationTime.text = null
            proportionText.text = null
            imageItem.setImageDrawable(null)
        }
    }
}