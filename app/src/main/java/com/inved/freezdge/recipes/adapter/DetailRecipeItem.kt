package com.inved.freezdge.recipes.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.storage.FirebaseStorage
import com.inved.freezdge.R
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.GlideUtils
import com.inved.freezdge.utils.NetworkUtils
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem


open class DetailRecipeItem: AbstractItem<DetailRecipeItem.ViewHolder>() {
    var recipe: Recipes?=null

    override val layoutRes: Int
        get() = R.layout.item_detail_recipe

    override val type: Int
        get() = R.id.item_detail_recipe

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<DetailRecipeItem>(view) {

        var recipeOwnerImage : ImageView= view.findViewById(R.id.activity_recipe_detail_photo_owner)
        private var recipeNumberPerson: TextView = view.findViewById(R.id.activity_recipe_detail_number_person_image_text)
        private var recipeKcal: TextView = view.findViewById(R.id.activity_recipe_detail_kcal_image_text)
        private var recipeDetailPhoto : ImageView= view.findViewById(R.id.activity_recipe_detail_photo)
        var recipeTotalTime : TextView= view.findViewById(R.id.activity_recipe_total_time)
        private var recipePrepCookTime: TextView = view.findViewById(R.id.activity_recipe_detail_time_image_text)
        var recipeTitle : TextView= view.findViewById(R.id.activity_recipe_detail_name)
        var domain = Domain()

        override fun bindView(item: DetailRecipeItem, payloads: MutableList<Any>) {

            recipeTitle.text = item.recipe?.recipeTitle
            recipePrepCookTime.text = App.applicationContext().getString(
                R.string.recipe_detail_item_detail_time,
                domain.preparationTime(item.recipe?.preparationTime),
                domain.preparationTime(item.recipe?.cookedTime)
            )
            recipeTotalTime.text =
                App.applicationContext().getString(R.string.recipe_detail_item_total_time, domain.preparationTime(item.recipe?.totalrecipeTime))
            val kcal: String? = if (item.recipe?.recipeCalories?.isEmpty() == true) {
                App.applicationContext().getString(R.string.recipe_list_item_kcal_notknow)
            } else {
                item.recipe?.recipeCalories
            }
            recipeKcal.text = App.applicationContext().getString(R.string.recipe_detail_item_kcal, kcal)
            recipeNumberPerson.text =
                App.applicationContext().getString(R.string.recipe_detail_item_number_person, item.recipe?.numberPersons)

            if (NetworkUtils.isNetworkAvailable(App.applicationContext())) {
                val storage = FirebaseStorage.getInstance()
                // Create a reference to a file from a Google Cloud Storage URI
                val gsReference = item.recipe?.recipePhotoUrl?.let { storage.getReferenceFromUrl(it) }
                GlideUtils.loadPhotoWithGlide(gsReference, null, recipeDetailPhoto)

                val gsReferenceOwner = item.recipe?.recipePhotoUrlOwner?.let { storage.getReferenceFromUrl(it) }
                GlideUtils.loadPhotoWithGlideCircleCrop(gsReferenceOwner, recipeOwnerImage)
            }

        }

        override fun unbindView(item: DetailRecipeItem) {

        }


    }
}