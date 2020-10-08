package com.inved.freezdge.recipes.adapter

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.storage.FirebaseStorage
import com.inved.freezdge.R
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.database.FavouritesRecipes_
import com.inved.freezdge.recipes.model.ShowedRecipes
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.GlideUtils
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import io.objectbox.kotlin.boxFor
import org.w3c.dom.Text

class ListRecipeItem : AbstractItem<ListRecipeItem.ViewHolder>(){

    var model:ShowedRecipes?=null

    // defines the type defining this item. must be unique. preferably an id
    override val type: Int
        get() = R.id.recipe_list_database_row_id

    // defines the layout which will be used for this item in the list
    override val layoutRes: Int
        get() = R.layout.item_recipes_list_database

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<ListRecipeItem>(view) {

        var domain= Domain()
        var label: TextView = view.findViewById(R.id.title)
        var preparationTime: TextView =
            view.findViewById(R.id.fragment_recipes_list_item_preparation_time_text)
        private var kcal: TextView = view.findViewById(R.id.description)
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

            //handle selected day visibility and select date button visibility
            if(item.model?.isFavouriteRecipe==true){
                selectDateButton.visibility=View.VISIBLE
                if(item.model?.selectedDay.isNullOrEmpty()){
                    dateSelectedText.visibility=View.INVISIBLE
                }else{
                    dateSelectedText.visibility=View.VISIBLE
                    dateSelectedText.text=item.model?.selectedDay
                }
            }else{
                dateSelectedText.visibility=View.INVISIBLE
                selectDateButton.visibility=View.INVISIBLE
            }

            label.text = item.model?.recipeTitle

            if(item.model?.totalrecipeTime.isNullOrEmpty()){
                preparationTime.text = App.resource().getString(R.string.recipe_list_item_no_time_known)
            }else{
                preparationTime.text = item.model?.totalrecipeTime
            }

            cuisineType.text= item.model?.cuisineType?.capitalize()
            dishType.text= domain.handleDishType(item.model?.dishType)

            if(item.model?.recipeCalories.isNullOrEmpty()){
                kcal.text = App.resource().getString(R.string.recipe_list_item_kcal_notknow)
            }else{
                kcal.text = item.model?.recipeCalories
            }

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
            kcal.text = null
            imageItem.setImageDrawable(null)
        }

        private fun isRecipeIdIsPresent(recipeId:String):Boolean {
            val favouritesRecipes: FavouritesRecipes? =
                App.ObjectBox.boxStore.boxFor<FavouritesRecipes>()
                    .query().equal(FavouritesRecipes_.recipeId, recipeId)
                    .build().findUnique()
            return favouritesRecipes!=null
        }
    }
}