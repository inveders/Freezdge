package com.inved.freezdge.recipes.view

import android.util.Log
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
import com.inved.freezdge.utils.GlideApp
import com.mikepenz.fastadapter.FastAdapter
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor

class ViewHolderRecipesDatabase (view: View) : FastAdapter.ViewHolder<Recipes>(view){

    var label: TextView = view.findViewById(R.id.title)
    var preparationTime: TextView =
        view.findViewById(R.id.fragment_recipes_list_item_preparation_time_text)
    var kcal: TextView = view.findViewById(R.id.description)
    var imageItem: ImageView = view.findViewById(R.id.image)
    var imageFavourite: ImageView =
        view.findViewById(R.id.favorite_image)
    var proportionText: TextView =
        view.findViewById(R.id.fragment_recipes_list_item_matching)
    override fun bindView(item: Recipes, payloads: MutableList<Any>) {

        label.text = item.recipeTitle
        preparationTime.text=item.totalrecipeTime

        if(item.recipeCalories.isNullOrEmpty()){
            kcal.text = App.resource().getString(R.string.recipe_list_item_kcal_notknow)
        }else{
            kcal.text = item.recipeCalories
        }

        val proportionInPercent:Int= Domain.ingredientsFavouriteMatchingMethod(item.recipeIngredients)
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
        // Create a reference to a file from a Google Cloud Storage URI
        val gsReference = item.recipePhotoUrl?.let { storage.getReferenceFromUrl(it) }
        GlideApp.with(App.applicationContext())
            .load(gsReference)
            .into(imageItem)

        if(isRecipeIdIsPresent(item.recipeTitle)!!){
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

    fun getFavouritesRecipesBox(): Box<FavouritesRecipes> {
        val boxStore: BoxStore = App.ObjectBox.boxStore
        return boxStore.boxFor()

    }

    fun isRecipeIdIsPresent(recipeId:String?):Boolean? {
        val favouritesRecipes: FavouritesRecipes? =
            getFavouritesRecipesBox()
                .query().equal(FavouritesRecipes_.recipeId, recipeId!!)
                .build().findUnique()
        return favouritesRecipes!=null
    }
}