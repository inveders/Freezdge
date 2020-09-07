package com.inved.freezdge.recipes.view

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.inved.freezdge.R
import com.inved.freezdge.utils.App
import com.mikepenz.fastadapter.*
import com.mikepenz.fastadapter.expandable.items.AbstractExpandableItem


class DetailSummaryExpandableItem :
    AbstractExpandableItem<DetailSummaryExpandableItem.ViewHolder>(),
    IClickable<DetailSummaryExpandableItem>,
    ISubItem<DetailSummaryExpandableItem.ViewHolder> {

    private var mOnClickListener: ClickListener<DetailSummaryExpandableItem>? = null
    var title: String = ""

    @Suppress("SetterBackingFieldAssignment")
    override var onItemClickListener: ClickListener<DetailSummaryExpandableItem>? =
        { v: View?, adapter: IAdapter<DetailSummaryExpandableItem>, item: DetailSummaryExpandableItem, position: Int ->
            if (item.subItems.isNotEmpty()) {
                v?.findViewById<View>(R.id.plusImageView)?.let {
                    if (item.isExpanded) {
                        it.background=ContextCompat.getDrawable(
                            App.appContext,
                            R.drawable.ic_remove_ingredient_not_selected_24dp
                        )
                    } else {
                        it.background=ContextCompat.getDrawable(
                            App.appContext,
                            R.drawable.ic_add_ingredient_selected_24dp
                        )
                    }
                }

            }

            mOnClickListener?.invoke(v, adapter, item, position) ?: true
        }
        set(onClickListener) {
            this.mOnClickListener = onClickListener // on purpose
        }

    override var onPreItemClickListener: ClickListener<DetailSummaryExpandableItem>?
        get() = null
        set(_) {}

    override var isSelectable: Boolean = false

    override val layoutRes: Int
        get() = R.layout.item_recipe_detail_list_expandable_group

    override val type: Int
        get() = R.id.item_order_detail_expandable_group

    override fun getViewHolder(v: View): ViewHolder {
        return ViewHolder(v)
    }

    class ViewHolder(val view: View) : FastAdapter.ViewHolder<DetailSummaryExpandableItem>(view) {

        private var item: DetailSummaryExpandableItem? = null
        private val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        private val imageView = view.findViewById<View>(R.id.plusImageView)

        override fun bindView(item: DetailSummaryExpandableItem, payloads: MutableList<Any>) {
            this.item = item

            if(item.isExpanded){
                          imageView.background=ContextCompat.getDrawable(
                              App.appContext,
                              R.drawable.ic_remove_ingredient_not_selected_24dp
                          )
            }else{
                imageView.background=ContextCompat.getDrawable(
                    App.appContext,
                    R.drawable.ic_add_ingredient_selected_24dp
                )

            }
            item.title.let {
                this.titleTextView.text = it
            }
        }

        override fun unbindView(item: DetailSummaryExpandableItem) {
            this.titleTextView.text = null
            this.item = null
        }
    }
}