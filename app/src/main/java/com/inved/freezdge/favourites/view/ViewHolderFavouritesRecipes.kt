package com.inved.freezdge.favourites.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.inved.freezdge.R
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.database.FavouritesRecipes_
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.GlideApp
import com.mikepenz.fastadapter.FastAdapter
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor

class ViewHolderFavouritesRecipes(val view: View) :
    FastAdapter.ViewHolder<FavouritesRecipes>(view) {

    var label: TextView = view.findViewById(R.id.title)
    var preparationTime: TextView =
        view.findViewById(R.id.fragment_recipes_list_item_preparation_time_text)
    var kcal: TextView = view.findViewById(R.id.description)
    var imageItem: ImageView = view.findViewById(R.id.image)
    var imageFavourite: ImageView =
        view.findViewById(R.id.favorite_image)
    var proportionText: TextView =
        view.findViewById(R.id.fragment_recipes_list_item_matching)
    override fun bindView(item: FavouritesRecipes, payloads: MutableList<Any>) {
        label.text = item.recipeTitle
        preparationTime.text = item.recipeTime
        kcal.text = item.recipeCalories


        val proportionInPercent:Int= Domain.ingredientsFavouriteMatchingMethod(item.recipeIngredients)
        proportionText.text="$proportionInPercent %"

        if(proportionInPercent in 90..99){
            proportionText.setBackgroundResource(R.drawable.border_green)
        }else if (proportionInPercent in 50..94){
            proportionText.setBackgroundResource(R.drawable.border_orange)
        }else if (proportionInPercent in 0..49){
            proportionText.setBackgroundResource(R.drawable.border_red)
        }

        GlideApp.with(App.applicationContext())
            .load(item.recipePhotoUrl)
            .centerCrop()
            .into(imageItem)

        if(isRecipeIdIsPresent(item.recipeId)!!){
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