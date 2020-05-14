package com.inved.freezdge.recipes.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.storage.FirebaseStorage
import com.inved.freezdge.R
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.database.FavouritesRecipes_
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.GlideUtils
import com.mikepenz.fastadapter.FastAdapter
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor

class ViewHolderRecipesDatabase (view: View) : FastAdapter.ViewHolder<Recipes>(view){

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
    private var imageOwner: ImageView =
        view.findViewById(R.id.owner_image)
    var proportionText: TextView =
        view.findViewById(R.id.fragment_recipes_list_item_matching)
    override fun bindView(item: Recipes, payloads: MutableList<Any>) {

        label.text = item.recipeTitle

        if(item.totalrecipeTime.isNullOrEmpty()){
            preparationTime.text = App.resource().getString(R.string.recipe_list_item_no_time_known)
        }else{
            preparationTime.text = item.preparationTime
        }

        cuisineType.text= item.cuisineType?.let { domain.uppercaseFirstCaracter(it) }
        if(item.dishType.equals("Main course",true)){
            dishType.text=App.resource().getString(R.string.array_filter_plat)
        }else{
            dishType.text= item.dishType?.let { domain.uppercaseFirstCaracter(it) }
        }

        if(item.recipeCalories.isNullOrEmpty()){
            kcal.text = App.resource().getString(R.string.recipe_list_item_kcal_notknow)
        }else{
            kcal.text = item.recipeCalories
        }

        val proportionInPercent:Int= domain.ingredientsFavouriteMatchingMethod(item.recipeIngredients)

        proportionText.text="$proportionInPercent %"

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

        val storage = FirebaseStorage.getInstance()
        val gsReference = item.recipePhotoUrl?.let { storage.getReferenceFromUrl(it) }
        GlideUtils.loadPhotoWithGlide(gsReference,null,imageItem)

        val gsReferenceOwner = item.recipePhotoUrlOwner?.let { storage.getReferenceFromUrl(it) }
        GlideUtils.loadPhotoWithGlideCircleCrop(gsReferenceOwner,imageOwner)

        if(isRecipeIdIsPresent(item.id.toString())!!){
            imageFavourite.setImageResource(R.drawable.ic_favorite_selected_24dp)
        }else{
            imageFavourite.setImageResource(R.drawable.ic_favorite_not_selected_24dp)
        }

    }

    override fun unbindView(item: Recipes) {
        label.text = null
        preparationTime.text = null
        proportionText.text = null
        kcal.text = null
        imageItem.setImageDrawable(null)
    }

    private fun getFavouritesRecipesBox(): Box<FavouritesRecipes> {
        val boxStore: BoxStore = App.ObjectBox.boxStore
        return boxStore.boxFor()

    }

    private fun isRecipeIdIsPresent(recipeId:String?):Boolean? {
        val favouritesRecipes: FavouritesRecipes? =
            getFavouritesRecipesBox()
                .query().equal(FavouritesRecipes_.recipeId, recipeId)
                .build().findUnique()
        return favouritesRecipes!=null
    }
}