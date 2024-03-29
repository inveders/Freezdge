package com.inved.freezdge.uiGeneral.dialog

import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.databinding.DialogGroceryListBinding
import com.inved.freezdge.uiGeneral.adapter.CloseButtonItem
import com.inved.freezdge.uiGeneral.adapter.IngredientsListItem
import com.inved.freezdge.uiGeneral.adapter.TitleItem
import com.inved.freezdge.utils.App
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.GenericItemAdapter
import com.mikepenz.fastadapter.listeners.addClickListener
import kotlinx.android.synthetic.main.dialog_grocery_list.*

class GroceryListDialog : DialogFragment() {

    companion object {
        //final values
        const val TAG = "INGREDIENT_LIST"
        private const val KEY_INGREDIENT_LIST = "key_ingredient_list"

        // to pass image url in tis dialog
        @JvmStatic
        fun newInstance(param1: ArrayList<String>) =
            GroceryListDialog().apply {
                arguments = Bundle().apply {
                    putStringArrayList(KEY_INGREDIENT_LIST, param1)
                }
            }
    }

    //UI
    private lateinit var mContext: Context
    private lateinit var binding : DialogGroceryListBinding
    private val itemAdapter = GenericItemAdapter()
    private var fastAdapter = FastAdapter.with(itemAdapter)
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!::binding.isInitialized) {
            binding = DialogGroceryListBinding.inflate(inflater, container, false)
        }

      //  dialog?.window?.setBackgroundDrawable(ColorDrawable(0))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = App.applicationContext()
        val ingredientArrayList = arguments?.getStringArrayList(KEY_INGREDIENT_LIST)

        fillDialog(ingredientArrayList)
    }


    // fill the dialog with the image we click on
    private fun fillDialog(ingredientsList:ArrayList<String>?) {
        val items = mutableListOf<GenericItem>()
        if(ingredientsList.isNullOrEmpty()){
            items.add(IngredientsListItem().apply {
                this.ingredientText = App.appContext.resources.getString(R.string.recipe_grocery_list_dialog_all_matching)
            })
        }else{
            items.add(TitleItem().apply {
            })
            ingredientsList?.forEach {
                items.add(IngredientsListItem().apply {
                    this.ingredientText = it
                })
            }
        }
        items.add(CloseButtonItem().apply {
        })
        setupRecyclerView(items)
    }

    // setup recycler view
    private fun setupRecyclerView(data: MutableList<GenericItem>) {

        recyclerview.layoutManager =
            LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        recyclerview.isNestedScrollingEnabled = false
        //   fastAdapter?.onClickListener = this
        fastAdapter = FastAdapter.with(itemAdapter)
        recyclerview.adapter = fastAdapter
        itemAdapter.clear()
        itemAdapter.add(data)

        fastAdapter.addClickListener({ vh: CloseButtonItem.ViewHolder -> vh.closeButton }) { v: View, pos: Int, _: FastAdapter<GenericItem>, item: GenericItem ->
            if (item is CloseButtonItem) {
                dialog?.dismiss()
            }
        }

    }

}