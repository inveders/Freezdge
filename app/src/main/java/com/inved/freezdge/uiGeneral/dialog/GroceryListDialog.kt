package com.inved.freezdge.uiGeneral.dialog

import android.content.Context
import android.content.DialogInterface
import android.graphics.Point
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.databinding.DialogGroceryListBinding
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsListViewModel
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.injection.Injection
import com.inved.freezdge.uiGeneral.adapter.CloseButtonItem
import com.inved.freezdge.uiGeneral.adapter.IngredientsListItem
import com.inved.freezdge.uiGeneral.adapter.TitleItem
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.eventbus.RefreshEvent
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.GenericItemAdapter
import com.mikepenz.fastadapter.listeners.addClickListener
import kotlinx.android.synthetic.main.dialog_grocery_list.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.greenrobot.eventbus.EventBus


class GroceryListDialog : DialogFragment() {

    companion object {
        //final values
        const val TAG = "INGREDIENT_LIST"
        private const val KEY_RECIPE_ID = "key_recipe_id"
        private const val KEY_INGREDIENT_LIST = "key_ingredient_list"
        private const val KEY_DAY_POS_RECYCLERVIEW = "positionRecyclerView"

        // to pass image url in tis dialog
        @JvmStatic
        fun newInstance(param1: ArrayList<String>, param2: Int, param3: Long?) =
            GroceryListDialog().apply {
                arguments = Bundle().apply {
                    putStringArrayList(KEY_INGREDIENT_LIST, param1)
                    putInt(KEY_DAY_POS_RECYCLERVIEW, param2)
                    if (param3 != null) {
                        putLong(KEY_RECIPE_ID, param3)
                    }
                }
            }
    }

    override fun onResume() {
        super.onResume()
        val window: Window? = dialog?.window
        val size = Point()

        val display: Display? = window?.windowManager?.defaultDisplay
        display?.getSize(size)

        val width: Int = size.x

        window?.setLayout((width * 0.9).toInt(), WindowManager.LayoutParams.WRAP_CONTENT)
        window?.setGravity(Gravity.CENTER)
    }

    //UI
    private var itemPositionInRecyclerView: Int? = 0
    private var isNeedRefresh: Boolean = false
    private lateinit var mContext: Context
    private lateinit var binding: DialogGroceryListBinding
    private val itemAdapter = GenericItemAdapter()
    private var fastAdapter = FastAdapter.with(itemAdapter)
    private lateinit var ingredientsViewModel: IngredientsViewModel
    private lateinit var ingredientsListViewModel: IngredientsListViewModel
    private lateinit var linearLayoutManager: LinearLayoutManager
    private var recipeId: Long? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (!::binding.isInitialized) {
            binding = DialogGroceryListBinding.inflate(inflater, container, false)
        }
        val viewModelFactory = Injection.providesViewModelFactory(App.ObjectBox.boxStore)
        ingredientsViewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(IngredientsViewModel::class.java)
        ingredientsListViewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(IngredientsListViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = App.applicationContext()
        val ingredientArrayList = arguments?.getStringArrayList(KEY_INGREDIENT_LIST)
        itemPositionInRecyclerView = arguments?.getInt(KEY_DAY_POS_RECYCLERVIEW)
        recipeId = arguments?.getLong(KEY_RECIPE_ID)
        fillDialog(recipeId)
    }


    // fill the dialog with the image we click on
    private fun fillDialog(recipeId: Long?) {
        val items = mutableListOf<GenericItem>()
        var count =0
        recipeId?.let { id ->
            ingredientsListViewModel.getIngredientListByRecipe(id)?.let {
                it.forEach { ingredientList ->
                    ingredientsViewModel.getIngredientById(ingredientList.ingredientsId)
                        ?.let { ingredient ->
                            if(!ingredient.selectedIngredient){
                                count =+ 1
                            }
                        }
                }
            }
        }

        if(count==0){
            items.add(IngredientsListItem().apply {
                this.ingredientText =
                    App.appContext.resources.getString(R.string.recipe_grocery_list_dialog_all_matching)
            })

        }else{
            recipeId?.let { id ->
                items.add(TitleItem().apply {
                })
                ingredientsListViewModel.getIngredientListByRecipe(id)?.let {
                    it.forEach { ingredientList ->
                        ingredientsViewModel.getIngredientById(ingredientList.ingredientsId)
                            ?.let { ingredient ->
                                if(!ingredient.selectedIngredient){
                                    items.add(IngredientsListItem().apply {
                                        this.ingredients = ingredient
                                    })
                                    count =+ 1
                                }

                            }
                    }
                }
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


        fastAdapter.addClickListener({ vh: IngredientsListItem.ViewHolder -> vh.imageSelection }) { v: View, pos: Int, _: FastAdapter<GenericItem>, item: GenericItem ->
            if (item is IngredientsListItem) {
                isNeedRefresh = true
                val bool: Boolean? =
                    ingredientsViewModel.isIngredientSelected(item.ingredients?.name)
                if (bool == true) {
                    item.getViewHolder(v).imageSelection?.setImageResource(R.drawable.ic_add_ingredient_selected_24dp)
                } else {
                    item.getViewHolder(v).imageSelection?.setImageResource(R.drawable.ic_remove_ingredient_not_selected_24dp)
                }
                GlobalScope.launch(Dispatchers.IO) {
                    item.ingredients?.let { ingredientsViewModel.updateIngredient(it) }
                    if (ingredientsViewModel.isIngredientSelectedInGrocery(item.ingredients?.name) == true) {
                        ingredientsViewModel.updateIngredientSelectedForGroceryByName(
                            item.ingredients?.name,
                            false
                        )
                    }
                }
                fastAdapter.notifyAdapterItemChanged(pos)
            }
        }

    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        if (isNeedRefresh) EventBus.getDefault().post(itemPositionInRecyclerView?.let {
            RefreshEvent(
                it
            )
        })
    }

}