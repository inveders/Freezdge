package com.inved.freezdge.ingredientslist.adapter

import android.content.Context
import android.transition.TransitionManager
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import com.google.android.material.chip.ChipGroup
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.database.Ingredients
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.ChipUtil
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.eventbus.ChipClickEvent
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import org.greenrobot.eventbus.EventBus


class GroceryItem : AbstractItem<GroceryItem.ViewHolder>() {

    var ingredientTypeName:String? =null
    var ingredientsByType:MutableList<Ingredients>? = null
    var context : Context? =null

    override val layoutRes: Int
        get() = R.layout.item_grocery

    override val type: Int
        get() = R.id.item_grocery

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<GroceryItem>(view) {

        var groceryTextView : TextView = view.findViewById(R.id.title)
        var chipGroup : ChipGroup = view.findViewById(R.id.chipGroup)
        val chipUtil = ChipUtil()

        override fun bindView(item: GroceryItem, payloads: MutableList<Any>) {

            groceryTextView.text = item.ingredientTypeName

            chipGroup.removeAllViews()
            item.ingredientsByType?.forEach { myresult->
                val chip = Chip(chipGroup.context)
                val chipDrawable = ChipDrawable.createFromAttributes(
                    chipGroup.context,
                    null,
                    0,
                    R.style.Widget_MaterialComponents_Chip_Entry
                )
                chip.setChipDrawable(chipDrawable)
                chip.text = myresult.name

                chipUtil.handleChipColor(myresult, chip, App.applicationContext())
                chip.closeIcon = App.appContext.let {
                    ContextCompat.getDrawable(
                        App.appContext as Context,
                        R.drawable.ic_clear_grey_24dp
                    )
                }
                // Set chip close icon click listener
                chip.setOnCloseIconClickListener {
                    launchAlertDialog(chipGroup, chip,item)
                }
                chip.isClickable = true
                chipGroup.addView(chip)
            }

        }

        override fun unbindView(item: GroceryItem) {
                groceryTextView.text = null
        }

        // when we want to delete a ingredient from grocery list, a dialog is launch before delete,and
        // if yes the ingredient is added in ingredient list and delete from grocery list
        private fun launchAlertDialog(chipFromGroup: ChipGroup, chip: Chip,item:GroceryItem) {

            val builder = item.context?.let { MaterialAlertDialogBuilder(it) }
            builder?.setTitle(App.appContext.getString(R.string.menu_grocery_list))
            if(chipFromGroup.checkedChipIds.size==0){
                builder?.setMessage(App.appContext.getString(R.string.dialog_question_grocery))
            }else{
                builder?.setMessage(App.appContext.getString(R.string.dialog_question_grocery_multiple_ingredients))
            }

            val chipgroupText :ArrayList<String> = arrayListOf()

            val ids = chipFromGroup.checkedChipIds
            for (id in ids) {
                val myChip: Chip = chipGroup.findViewById(id)
                chipgroupText.add(myChip.text.toString())
            }
            var removedIngredients : String?=null
            removedIngredients = if(chipgroupText.isNullOrEmpty()){
                chip.text.toString()
            }else{
                Domain().retrieveStringFromListString(chipgroupText)
            }


            builder?.setPositiveButton(App.appContext.getString(R.string.Yes)) { _, _ ->
                Toast.makeText(
                    App.appContext,
                    App.appContext.getString(R.string.grocery_list_removed, removedIngredients),
                    Toast.LENGTH_SHORT
                ).show()

                chipgroupText.forEach {
                    EventBus.getDefault().post(ChipClickEvent(it))
                }
                TransitionManager.beginDelayedTransition(chipGroup)
                if(ids.size==0){
                    chipGroup.removeView(chip)
                    EventBus.getDefault().post(ChipClickEvent(chip.text.toString()))
                }else{
                    for (id in ids) {
                        val newChip: Chip = chipGroup.findViewById(id)
                        chipGroup.removeView(newChip)
                    }
                }

            }

            builder?.setNegativeButton(android.R.string.no) { dialog, _ ->
                dialog.dismiss()
            }
            builder?.show()
        }


    }
}