package com.inved.freezdge.recipes.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.inved.freezdge.R
import com.inved.freezdge.favourites.database.FavouritesRecipes
import com.inved.freezdge.favourites.database.FavouritesRecipes_
import com.inved.freezdge.recipes.model.Hit
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.adapters.ItemFilter
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.kotlin.boxFor
import kotlin.math.roundToInt


class ViewHolderRecipesRetrofit(view: View) : FastAdapter.ViewHolder<Hit>(view) {

    var label: TextView = view.findViewById(R.id.title)
    var preparationTime: TextView =
        view.findViewById(R.id.fragment_recipes_list_item_preparation_time_text)
    private var kcal: TextView = view.findViewById(R.id.description)
    private var cuisineType: TextView = view.findViewById(R.id.fragment_recipes_list_cuisine_type)
    private var dishType: TextView = view.findViewById(R.id.fragment_recipes_list_dish_type)
    private var imageItem: ImageView = view.findViewById(R.id.image)
    var imageFavourite: ImageView =
        view.findViewById(R.id.favorite_image)
    private var proportionText: TextView =
        view.findViewById(R.id.fragment_recipes_list_item_matching)

    override fun bindView(item: Hit, payloads: MutableList<Any>) {

        label.text = item.recipe?.label
        preparationTime.text=Domain.preparationTime(item.recipe?.totalTime)

        cuisineType.text= item.recipe?.cuisineType?.get(0)?.let { Domain.uppercaseFirstCaracter(it) }
        if(item.recipe?.dishType?.get(0).equals("Main course",true)){
            dishType.text=App.resource().getString(R.string.array_filter_plat)
        }else{
            dishType.text= item.recipe?.dishType?.get(0)?.let { Domain.uppercaseFirstCaracter(it) }
        }

        kcal.text = item.recipe?.calories?.div(10)?.roundToInt().toString()

        val proportionInPercent:Int=Domain.ingredientsMatchingMethod(item.recipe?.ingredientLines)
        proportionText.text="$proportionInPercent %"

        when (proportionInPercent) {
            in 80..99 -> {
                proportionText.setBackgroundResource(R.drawable.border_green)
            }
            in 50..79 -> {
                proportionText.setBackgroundResource(R.drawable.border_orange)
            }
            in 0..49 -> {
                proportionText.setBackgroundResource(R.drawable.border_red)
            }
        }

        Domain.loadPhotoWithGlideCenterCropUrl(item.recipe?.image,imageItem)

        if(isRecipeIdIsPresent(item.recipe?.uri)!!){
            imageFavourite.setImageResource(R.drawable.ic_favorite_selected_24dp)
        }else{
            imageFavourite.setImageResource(R.drawable.ic_favorite_not_selected_24dp)
        }

    }

    override fun unbindView(item: Hit) {
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

        return if(recipeId!=null){
            val favouritesRecipes: FavouritesRecipes? =
                getFavouritesRecipesBox()
                    .query().equal(FavouritesRecipes_.recipeId, recipeId)
                    .build().findUnique()
            favouritesRecipes!=null
        }else{
            false
        }
    }

}

