package com.inved.freezdge.favourites.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.storage.FirebaseStorage
import com.inved.freezdge.R
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.database.FavouritesRecipes_
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.GlideUtils
import com.mikepenz.fastadapter.FastAdapter
import io.objectbox.kotlin.boxFor

class ViewHolderFavouritesRecipes(val view: View) :
    FastAdapter.ViewHolder<FavouritesRecipes>(view) {

    var domain=Domain()
    var label: TextView = view.findViewById(R.id.title)
    var preparationTime: TextView =
        view.findViewById(R.id.fragment_recipes_list_item_preparation_time_text)
    private var kcal: TextView = view.findViewById(R.id.description)
    var cuisineType: TextView = view.findViewById(R.id.fragment_recipes_list_cuisine_type)
    var dishType: TextView = view.findViewById(R.id.fragment_recipes_list_dish_type)
    private var imageItem: ImageView = view.findViewById(R.id.image)
    var imageFavourite: ImageView =
        view.findViewById(R.id.favorite_image)
    private var proportionText: TextView =
        view.findViewById(R.id.fragment_recipes_list_item_matching)
    override fun bindView(item: FavouritesRecipes, payloads: MutableList<Any>) {
        label.text = item.recipeTitle

        if(item.recipeTime.isNullOrEmpty()){
            preparationTime.text = App.resource().getString(R.string.recipe_list_item_no_time_known)
        }else{
            preparationTime.text = item.recipeTime
        }

        if(item.recipeCalories.isNullOrEmpty()){
            kcal.text = App.resource().getString(R.string.recipe_list_item_kcal_notknow)
        }else{
            kcal.text = item.recipeCalories
        }

        // we calcul the proportion of ingredients matching between our selected ingredients and the ingredients in the recipe.
        val proportionInPercent:Int= domain.ingredientsFavouriteMatchingMethod(item.recipeIngredients)
        proportionText.text=App.resource().getString(R.string.recipe_matching_percent,proportionInPercent)

        cuisineType.text= item.cuisineType?.let { domain.uppercaseFirstCaracter(it) }
        if(item.dishType.equals("Main course")){
            dishType.text=App.resource().getString(R.string.array_filter_plat)
        }else{
            dishType.text= item.dishType?.let { domain.uppercaseFirstCaracter(it) }
        }

        // We attribute different color according to the matching value
        when (proportionInPercent) {
            in 80..99 -> {
                proportionText.setBackgroundResource(R.drawable.border_green)
            }
            in 50..70 -> {
                proportionText.setBackgroundResource(R.drawable.border_orange)
            }
            in 0..49 -> {
                proportionText.setBackgroundResource(R.drawable.border_red)
            }
        }

        if(item.recipePhotoUrl?.contains("freezdge",true)==true){
            val storage = FirebaseStorage.getInstance()
            // Create a reference to a file from a Google Cloud Storage URI
            val gsReference = item.recipePhotoUrl?.let { storage.getReferenceFromUrl(it) }
            GlideUtils.loadPhotoWithGlide(gsReference,null,imageItem)
        }else{
            GlideUtils.loadPhotoWithGlideCenterCropUrl(item.recipePhotoUrl,imageItem)
        }

        // We detect if the recipe is in our favourite and update UI according to
        if(item.recipeId?.let { isRecipeIdIsPresent(it) }==true){
            imageFavourite.setImageResource(R.drawable.ic_favorite_selected_24dp)
        }else{
            imageFavourite.setImageResource(R.drawable.ic_favorite_not_selected_24dp)
        }
    }

    override fun unbindView(item: FavouritesRecipes) {
        label.text = null
        preparationTime.text = null
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