package com.inved.freezdge.uiGeneral.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.firebase.storage.FirebaseStorage
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.GlideUtils
import com.inved.freezdge.utils.NetworkUtils
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class IngredientsListItem : AbstractItem<IngredientsListItem.ViewHolder>() {

    var ingredients:Ingredients?=null
    var ingredientText:String?=null

    // defines the type defining this item. must be unique. preferably an id
    override val type: Int
        get() = R.id.ingredient_list_row_id

    // defines the layout which will be used for this item in the list
    override val layoutRes: Int
        get() = if (ingredientText!=null) R.layout.item_ingredient_list_dialog else R.layout.item_ingredients_list

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<IngredientsListItem >(view) {

        private lateinit var text: TextView
        private lateinit var label: TextView
        private var imageFood: ImageView?=null
        var imageSelection: ImageView?=view.findViewById(R.id.item_ingredients_list_image_favorite_selected_or_not_imageview)
        private lateinit var shimmer: ShimmerFrameLayout

        override fun bindView(item: IngredientsListItem, payloads: MutableList<Any>) {

            if(item.ingredientText!=null){
                text = view.findViewById(R.id.ingredient_name)
                text.text = item.ingredientText
            }else{
                label = view.findViewById(R.id.item_ingredients_list_textview)
                imageFood= view.findViewById(R.id.item_ingredients_list_image_ingredient_image)
                imageSelection =
                    view.findViewById(R.id.item_ingredients_list_image_favorite_selected_or_not_imageview)
                shimmer= view.findViewById(R.id.shimmer_view_container)
                label.text = item.ingredients?.name

                if (NetworkUtils.isNetworkAvailable(App.applicationContext())) {
                    val storage = FirebaseStorage.getInstance()
                    // Create a reference to a file from a Google Cloud Storage URI
                    val gsReference = item.ingredients?.photoUrl?.let { storage.getReferenceFromUrl(it) }
                    // we show an image from our own database in firebase storage
                    imageFood?.let {
                        GlideUtils.loadPhotoWithGlide(gsReference,shimmer,it)
                    }?:run{
                        shimmer.stopShimmer()
                    }
                }

                // if item is selected, we show a +, if not we show a minus
                if (item.ingredients?.selectedIngredient==false) {
                    imageSelection?.setImageResource(R.drawable.ic_add_ingredient_selected_24dp)
                } else {
                    imageSelection?.setImageResource(R.drawable.ic_remove_ingredient_not_selected_24dp)
                }
            }

        }

        override fun unbindView(item: IngredientsListItem) {
            if(item.ingredientText!=null){
                text.text = null
            }else{
                label.text = null
                imageFood?.setImageURI(null)
            }

        }
    }

}