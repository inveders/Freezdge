package com.inved.freezdge.favourites.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.inved.freezdge.R
import com.inved.freezdge.favourites.adapter.SelectDayItem
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.ChipsDayType
import com.inved.freezdge.utils.Domain
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.GenericItemAdapter
import com.mikepenz.fastadapter.listeners.addClickListener
import kotlinx.android.synthetic.main.fragment_my_ingredients_list.*

class SelectDayDialog : DialogFragment() {

    interface SelectDateListener {
        fun onDateSelected(
            selectedDayList: ArrayList<String>?,
            itemPosition: Int?,
            recipeId: String?
        )
    }

    companion object {
        const val TAG = "DAY"

        private const val KEY_DAY = "dayParam"
        private const val KEY_DAY_POS_RECYCLERVIEW = "positionRecyclerView"
        private const val KEY_DAY_RECIPE_ID = "recipeId"
        private var dateSelectedListener: SelectDateListener? = null
        fun setSelectDateListener(callback: SelectDateListener) {
            this.dateSelectedListener = callback
        }

        //To pass args to our dialog
        @JvmStatic
        fun newInstance(param1: String?, param2: Int?, param3: String?) =
            SelectDayDialog().apply {
                arguments = Bundle().apply {
                    putString(KEY_DAY, param1)
                    if (param2 != null) {
                        putInt(KEY_DAY_POS_RECYCLERVIEW, param2)
                    }
                    putString(KEY_DAY_RECIPE_ID, param3)
                }
            }
    }

    private val selectedDayList: ArrayList<String>? = arrayListOf()
    val domain = Domain()
    private var itemPositionInRecyclerView: Int? = 0
    var recipeId: String?=null

    //UI
    private var validateButton: TextView? = null
    private var dialogTitle: TextView? = null
    private var cancelButton: ImageButton? = null
    private lateinit var mContext: Context
    private var recyclerView: RecyclerView? = null
    private val itemAdapter = GenericItemAdapter()
    private var fastAdapter = FastAdapter.with(itemAdapter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullscreenDialogTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View =
            inflater.inflate(R.layout.dialog_select_day, container, false)
        mContext = App.applicationContext()
        dialogTitle = view.findViewById(R.id.dialogTitle)
        validateButton = view.findViewById(R.id.validate_button)
        cancelButton = view.findViewById(R.id.close_button)
        recyclerView = view.findViewById(R.id.recyclerview)

        val selectedDay: String? = arguments?.getString(KEY_DAY)
        itemPositionInRecyclerView = arguments?.getInt(KEY_DAY_POS_RECYCLERVIEW)

        if(!selectedDay.isNullOrEmpty()){
            val listToInsert = domain.retrieveListFromString(selectedDay)
            listToInsert.forEach {
                selectedDayList?.add(it)
            }
        }

        recipeId = arguments?.getString(KEY_DAY_RECIPE_ID)
        setupRecyclerView(selectedDay)

        cancelButton?.setOnClickListener {
            cancelButton?.startAnimation(domain.animation())
            dialog?.dismiss()
        }

        validateButton?.setOnClickListener {
            dateSelectedListener?.onDateSelected(
                selectedDayList,
                itemPositionInRecyclerView,
                recipeId
            )
            dialog?.dismiss()
        }

        return view
    }

    private fun handleSelectedDay(selectedDay: String?):Int {
        when {
            selectedDay?.contains(App.appContext.getString(R.string.lunch), true) == true -> {
                return ChipsDayType.LUNCH.chipPosition
            }
            selectedDay?.contains(ChipsDayType.SNACK.name, true) == true -> {
                return ChipsDayType.SNACK.chipPosition
            }
            selectedDay?.contains(ChipsDayType.DINNER.name, true) == true -> {
                return ChipsDayType.DINNER.chipPosition
            }
        }
        return 4
    }

    private fun setupRecyclerView(selectedDay: String?) {

        itemAdapter.clear()
        recyclerView?.layoutManager =
            LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        recyclerView?.isNestedScrollingEnabled = false
        recyclerView?.adapter = fastAdapter

        fastAdapter.addClickListener({ vh: SelectDayItem.ViewHolder -> vh.lunchChip }) { v: View, pos: Int, _: FastAdapter<GenericItem>, item: GenericItem ->
            if (item is SelectDayItem) {
                val chipText = view?.let { item.getViewHolder(it).lunchChip.text.toString() }
                if (selectedDayList?.contains("${item.day} $chipText") == true) {
                    selectedDayList.remove("${item.day} $chipText")
                } else {
                    selectedDayList?.add("${item.day} $chipText")
                }
            }
        }

        fastAdapter.addClickListener({ vh: SelectDayItem.ViewHolder -> vh.snackChip }) { v: View, pos: Int, _: FastAdapter<GenericItem>, item: GenericItem ->
            if (item is SelectDayItem) {
                val chipText = view?.let { item.getViewHolder(it).snackChip.text.toString() }
                if (selectedDayList?.contains("${item.day} $chipText") == true) {
                    selectedDayList.remove("${item.day} $chipText")
                } else {
                    selectedDayList?.add("${item.day} $chipText")
                }
            }
        }

        fastAdapter.addClickListener({ vh: SelectDayItem.ViewHolder -> vh.dinnerChip }) { v: View, pos: Int, _: FastAdapter<GenericItem>, item: GenericItem ->
            if (item is SelectDayItem) {
                val chipText = view?.let { item.getViewHolder(it).dinnerChip.text.toString() }
                if (selectedDayList?.contains("${item.day} $chipText") == true) {
                    selectedDayList.remove("${item.day} $chipText")
                } else {
                    selectedDayList?.add("${item.day} $chipText")
                }
            }
        }

        fillDialog(selectedDay)
    }


    //Check photo before create (after click on publish button)
    private fun fillDialog(selectedDay: String?) {
        val daysOfWeek: ArrayList<String> = arrayListOf(
            App.appContext.getString(R.string.monday),
            App.appContext.getString(R.string.tuesday),
            App.appContext.getString(R.string.wednesday),
            App.appContext.getString(R.string.thursday),
            App.appContext.getString(R.string.friday),
            App.appContext.getString(R.string.saturday),
            App.appContext.getString(R.string.sunday)
        )

        val items = mutableListOf<GenericItem>()
        daysOfWeek.forEach {
            if (selectedDay.isNullOrEmpty()) {
                items.add(SelectDayItem().apply {
                    this.day = it
                    this.isChecked = false
                })
            } else {
                if (selectedDay.contains(it, true)) {
                    selectedDayList?.forEach {day->
                        if (day.contains(it, true)) {
                            items.add(SelectDayItem().apply {
                                this.day = it
                                this.isChecked = true
                                this.selectedPosition = handleSelectedDay(day)
                            })
                        }
                    }
                }else{
                    items.add(SelectDayItem().apply {
                        this.day = it
                        this.isChecked = false
                        this.selectedPosition = 4
                    })
                }
            }
        }
        itemAdapter.add(items)
    }


}