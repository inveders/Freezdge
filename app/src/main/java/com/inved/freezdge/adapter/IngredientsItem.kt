package com.inved.freezdge.adapter

import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.inved.freezdge.R
import com.inved.freezdge.model.IngredientsModel
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class IngredientsItem : AbstractItem<IngredientsItem.ViewHolderIngredients>() {

    var model: IngredientsModel? =null

    /** defines the type defining this item. must be unique. preferably an id */
    override val type: Int
        get() = R.id.ingredient_list_row_id

    /** defines the layout which will be used for this item in the list  */
    override val layoutRes: Int
        get() = R.layout.item_ingredients_list

    override fun getViewHolder(v: View): ViewHolderIngredients {
        return ViewHolderIngredients(v)
    }


    class ViewHolderIngredients(val view: View) : FastAdapter.ViewHolder<IngredientsItem>(view) {

        var label: TextView = view.findViewById(R.id.item_ingredients_list_textview)
        var imageFood: ImageView = view.findViewById(R.id.item_ingredients_list_image_ingredient_image)
        var imageSelection: ImageButton = view.findViewById(R.id.item_ingredients_list_image_favorite_selected_or_not_imageview)

        override fun bindView(item: IngredientsItem, payloads: MutableList<Any>) {
            label.text = item.model?.name
            Glide.with(view.context).load(item.model?.photoUrl).into(imageFood)

            if(item.model?.isSelected== false){
                imageSelection.setImageResource(R.drawable.ic_add_ingredient_selected_24dp)
            }else{
                imageSelection.setImageResource(R.drawable.ic_remove_ingredient_not_selected_24dp)
            }

            imageSelection.setOnClickListener {

                if (imageSelection.getTag()==1) {

                    imageSelection.setImageResource(R.drawable.ic_add_ingredient_selected_24dp)
                    imageSelection.tag = 0

                } else{
                    imageSelection.setImageResource(R.drawable.ic_remove_ingredient_not_selected_24dp)
                    imageSelection.tag = 1

                }
            }

        }

        override fun unbindView(item: IngredientsItem) {
            label.text = null
            imageFood.setImageURI(null)
        }
    }

}