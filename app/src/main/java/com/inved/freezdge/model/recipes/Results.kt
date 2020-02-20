package com.inved.freezdge.model.recipes

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.inved.freezdge.R
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.GlideApp
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class Results : AbstractItem<Results.ViewHolder>() {
    @SerializedName("q")
    @Expose
    var q: String? = null
    @SerializedName("from")
    @Expose
    var from: Int? = null
    @SerializedName("to")
    @Expose
    var to: Int? = null
    @SerializedName("more")
    @Expose
    var more: Boolean? = null
    @SerializedName("count")
    @Expose
    var count: Int? = null
    @SerializedName("hits")
    @Expose
    var hits: List<Hit>? = null

    ///////////////////////////


    /** defines the type defining this item. must be unique. preferably an id */
    override val type: Int
        get() = R.id.recipe_list_row_id

    /** defines the layout which will be used for this item in the list  */
    override val layoutRes: Int
        get() = R.layout.item_recipes_list

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(view: View) : FastAdapter.ViewHolder<Results>(view) {
        var label: TextView = view.findViewById(R.id.fragment_recipes_list_item_label)
        var preparationTime: TextView =
            view.findViewById(R.id.fragment_recipes_list_item_preparation_time_text)
        var kcal: TextView = view.findViewById(R.id.fragment_recipes_list_item_kcal)
        var imageItem: ImageView = view.findViewById(R.id.fragment_recipes_list_item_image)

        override fun bindView(item: Results, payloads: MutableList<Any>) {

            Log.d("debago", "item bindvIEW")
            for (i in item.hits!!.indices) {
                Log.d("debago", "item bindvIEW IN LOOP $i")
                label.text = item.hits?.get(i)?.recipe?.label
                preparationTime.text = item.hits?.get(i)?.recipe?.totalTime.toString()
                kcal.text = item.hits?.get(i)?.recipe?.calories.toString()

                GlideApp.with(App.applicationContext())
                    .load(item.hits?.get(i)?.recipe?.image)
                    .into(imageItem)


                Log.d("debago", "item bindvIEW IN LOOP ${item.hits?.get(i)?.recipe?.image}")


            }
            // imageItem.setImageURI() = item.kcal
        }

        override fun unbindView(item: Results) {
            label.text = null
            preparationTime.text = null
            kcal.text = null
            imageItem.setImageDrawable(null)
        }

    }


}