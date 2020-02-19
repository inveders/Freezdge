package com.inved.freezdge.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.inved.freezdge.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem


open class RecipesRecyclerView : AbstractItem<RecipesRecyclerView.ViewHolder>() {
    var label: String? = null
    var preparationTime: String? = null
    var kcal: String? = null
    var imageUrl: String? = null
    //var category: SubCategory? = null

    /** defines the type defining this item. must be unique. preferably an id */
    override val type: Int
        get() = R.id.recipe_list_row_id

    /** defines the layout which will be used for this item in the list  */
    override val layoutRes: Int
        get() = R.layout.item_recipes_list

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<RecipesRecyclerView>(view) {
        var label: TextView = view.findViewById(R.id.fragment_recipes_list_item_label)
        var preparationTime: TextView = view.findViewById(R.id.fragment_recipes_list_item_preparation_time_text)
        var kcal: TextView = view.findViewById(R.id.fragment_recipes_list_item_kcal)
        var imageItem: ImageView = view.findViewById(R.id.fragment_recipes_list_item_image)

        override fun bindView(item: RecipesRecyclerView, payloads: MutableList<Any>) {
            label.text = item.label
            preparationTime.text = item.preparationTime
            kcal.text = item.imageUrl
          /*  item.category?.image?.let {
                GlideApp.with(this)
                    .load(it)
                    .into(imageItem)
            }*/
           // imageItem.setImageURI() = item.kcal
        }

        override fun unbindView(item: RecipesRecyclerView) {
            label.text = null
            preparationTime.text = null
            kcal.text = null
            imageItem.setImageDrawable(null)
        }


    }
}