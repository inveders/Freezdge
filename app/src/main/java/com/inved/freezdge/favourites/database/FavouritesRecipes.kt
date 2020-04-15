package com.inved.freezdge.favourites.database

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.inved.freezdge.R
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.GlideApp
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.kotlin.boxFor

@Entity
class FavouritesRecipes(
    @Id
    var id: Long = 0,
    var recipeId: String? = null,
    var recipeTitle: String? = null,
    var recipeCalories: String? = null,
    var recipeTime: String? = null,
    var recipeUrl: String? = null,
    var recipePhotoUrl: String? = null,
    var recipeIngredients: String? = null
) : AbstractItem<FavouritesRecipes.ViewHolderFavouritesRecipes>() {

    /** defines the type defining this item. must be unique. preferably an id */
    override val type: Int
        get() = R.id.recipe_list_row_id

    /** defines the layout which will be used for this item in the list  */
    override val layoutRes: Int
        get() = R.layout.item_recipes_list

    override fun getViewHolder(v: View): ViewHolderFavouritesRecipes {
        return ViewHolderFavouritesRecipes(
            v
        )
    }


    class ViewHolderFavouritesRecipes(val view: View) :
        FastAdapter.ViewHolder<FavouritesRecipes>(view) {

        var label: TextView = view.findViewById(R.id.fragment_recipes_list_item_label)
        var preparationTime: TextView =
            view.findViewById(R.id.fragment_recipes_list_item_preparation_time_text)
        var kcal: TextView = view.findViewById(R.id.fragment_recipes_list_item_kcal)
        var imageItem: ImageView = view.findViewById(R.id.fragment_recipes_list_item_image)
        var imageFavourite: ImageView =
            view.findViewById(R.id.fragment_recipe_list_favorite_selected_or_not)

        override fun bindView(item: FavouritesRecipes, payloads: MutableList<Any>) {
            label.text = item.recipeTitle
            preparationTime.text = item.recipeTime
            kcal.text = item.recipeCalories


            GlideApp.with(App.applicationContext())
                .load(item.recipePhotoUrl)
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
}