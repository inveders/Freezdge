package com.inved.freezdge.ingredientslist.database

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.inved.freezdge.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id


@Entity
data class Ingredients(@Id var id: Long = 0,
                       var name: String? = null,
                       var typeIngredient: String? = null,
                       var photoUrl: String? = null,
                       var selectedIngredient: Boolean = false,
                       var grocerySelectedIngredient: Boolean = false): AbstractItem<Ingredients.ViewHolderIngredients>(){



    /** defines the type defining this item. must be unique. preferably an id */
    override val type: Int
    get() = R.id.ingredient_list_row_id

    /** defines the layout which will be used for this item in the list  */
    override val layoutRes: Int
    get() = R.layout.item_ingredients_list

    override fun getViewHolder(v: View): ViewHolderIngredients {
        return ViewHolderIngredients(
            v
        )
    }



    class ViewHolderIngredients(val view: View) : FastAdapter.ViewHolder<Ingredients>(view) {

        var label: TextView = view.findViewById(R.id.item_ingredients_list_textview)
        var imageFood: ImageView = view.findViewById(R.id.item_ingredients_list_image_ingredient_image)
        var imageSelection: ImageView = view.findViewById(R.id.item_ingredients_list_image_favorite_selected_or_not_imageview)

        override fun bindView(item: Ingredients, payloads: MutableList<Any>) {
            label.text = item.name
            Glide.with(view.context).load(item.photoUrl).into(imageFood)

            if(!item.selectedIngredient){
                imageSelection.setImageResource(R.drawable.ic_add_ingredient_selected_24dp)
            }else{
                imageSelection.setImageResource(R.drawable.ic_remove_ingredient_not_selected_24dp)
            }

        }

        override fun unbindView(item: Ingredients) {
            label.text = null
            imageFood.setImageURI(null)
        }

    }

}