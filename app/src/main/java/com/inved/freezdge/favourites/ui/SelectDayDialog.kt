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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.favourites.adapter.SelectDayItem
import com.inved.freezdge.favourites.model.DaySelectionModel
import com.inved.freezdge.favourites.viewmodel.DaySelectedViewModel
import com.inved.freezdge.injection.Injection
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.ChipUtil
import com.inved.freezdge.utils.enumtype.ChipsDayType
import com.inved.freezdge.utils.enumtype.DayType
import com.inved.freezdge.utils.Domain
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.GenericItemAdapter
import com.mikepenz.fastadapter.listeners.addClickListener

class SelectDayDialog : DialogFragment() {

    interface SelectDateListener {
        fun onDateSelected(
            selectedDayList: MutableList<DaySelectionModel?>?,
            itemPosition: Int?,
            recipeId: String?
        )
    }

    companion object {
        const val TAG = "DAY"

        private const val KEY_DAY = "dayParam"
        private const val KEY_DAY_POS_RECYCLERVIEW = "positionRecyclerView"
        private const val KEY_DAY_RECIPE_ID = "recipeId"
        var selectedDayList: MutableList<DaySelectionModel?>? = mutableListOf()
        private var dateSelectedListener: SelectDateListener? = null
        fun setSelectDateListener(callback: SelectDateListener) {
            this.dateSelectedListener = callback
        }

        //Viewmodel
        private lateinit var daySelectedViewModel: DaySelectedViewModel

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

    val domain = Domain()
    private var itemPositionInRecyclerView: Int? = 0
    var recipeId: String? = null

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
        initViewModel()
    }

    //INITIALIZATION
    private fun initViewModel() {
        val viewModelFactory = Injection.providesViewModelFactory(App.ObjectBox.boxStore)
        daySelectedViewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(DaySelectedViewModel::class.java)
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

        itemPositionInRecyclerView = arguments?.getInt(KEY_DAY_POS_RECYCLERVIEW)

        recipeId = arguments?.getString(KEY_DAY_RECIPE_ID)
        setupRecyclerView()

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

    private fun handleSelectedDay(day: String?): Long {
        when {
            day?.equals(DayType.MONDAY.dayName, true) == true -> {
                return DayType.MONDAY.day
            }
            day?.equals(DayType.TUESDAY.dayName, true) == true -> {
                return DayType.TUESDAY.day
            }
            day?.equals(DayType.WEDNESDAY.dayName, true) == true -> {
                return DayType.WEDNESDAY.day
            }
            day?.equals(DayType.THURSDAY.dayName, true) == true -> {
                return DayType.THURSDAY.day
            }
            day?.equals(DayType.FRIDAY.dayName, true) == true -> {
                return DayType.FRIDAY.day
            }
            day?.equals(DayType.SATURDAY.dayName, true) == true -> {
                return DayType.SATURDAY.day
            }
            day?.equals(DayType.SUNDAY.dayName, true) == true -> {
                return DayType.SUNDAY.day
            }
            else -> return 0
        }

    }

    private fun setupRecyclerView() {

        itemAdapter.clear()
        recyclerView?.layoutManager =
            LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        recyclerView?.isNestedScrollingEnabled = false
        recyclerView?.adapter = fastAdapter
        fillDialog()
        fastAdapter.addClickListener({ vh: SelectDayItem.ViewHolder -> vh.lunchChip }) { v: View, pos: Int, _: FastAdapter<GenericItem>, item: GenericItem ->
            if (item is SelectDayItem) {
                val clickedDay: DaySelectionModel? = DaySelectionModel().apply {
                    this.day = handleSelectedDay(item.day)
                    this.lunch = recipeId?.toLong()
                    if(item.isOccuped==true){
                        //todo show dialog and if true
                        this.dinner = item.dinnerId
                    }else{
                        this.dinner = 0L
                    }
                }
                isUpdateNecesary(clickedDay,ChipsDayType.LUNCH.chipPosition)

            }
        }

        fastAdapter.addClickListener({ vh: SelectDayItem.ViewHolder -> vh.dinnerChip }) { v: View, pos: Int, _: FastAdapter<GenericItem>, item: GenericItem ->
            if (item is SelectDayItem) {
                val clickedDay: DaySelectionModel? = DaySelectionModel().apply {
                    this.day = handleSelectedDay(item.day)
                    if(item.isOccuped==true){
                        //todo show dialog and if true
                        this.lunch = item.lunchId
                    }else{
                        this.lunch = 0L
                    }
                    this.dinner = recipeId?.toLong()
                }
                isUpdateNecesary(clickedDay,ChipsDayType.DINNER.chipPosition)
            }
        }
    }

    private fun fillDialog() {
        val daysOfWeek: ArrayList<String> = arrayListOf(
            App.appContext.getString(R.string.monday),
            App.appContext.getString(R.string.tuesday),
            App.appContext.getString(R.string.wednesday),
            App.appContext.getString(R.string.thursday),
            App.appContext.getString(R.string.friday),
            App.appContext.getString(R.string.saturday),
            App.appContext.getString(R.string.sunday)
        )
        daySelectedViewModel.getSelectedDay().observe(viewLifecycleOwner, Observer { result ->
            val items = mutableListOf<GenericItem>()

            //fill selectedDayList with
            result.forEach { res ->

                if(selectedDayList?.size?.compareTo(7)==-1){

                    selectedDayList?.add(DaySelectionModel().apply {
                        Log.d("debago","selected day list; day : ${res.id}, lunch : ${res.lunch}, dinner : ${res.dinner}")
                        this.day = res.id
                        this.lunch = res.lunch
                        this.dinner = res.dinner
                    })
                }

            }

            daysOfWeek.forEachIndexed { index, it ->

                if(recipeId?.toLong() == selectedDayList?.get(index)?.lunch){
                    if(selectedDayList?.get(index)?.dinner != 0L){
                        items.add(SelectDayItem().apply {
                            this.day = it
                            this.isChecked = true
                            this.isOccuped = true
                            this.lunchId = selectedDayList?.get(index)?.lunch
                            this.dinnerId = selectedDayList?.get(index)?.dinner
                            this.selectedPosition = ChipsDayType.LUNCH.chipPosition
                        })
                    }else{
                        items.add(SelectDayItem().apply {
                            this.day = it
                            this.isChecked = true
                            this.lunchId = selectedDayList?.get(index)?.lunch
                            this.dinnerId = selectedDayList?.get(index)?.dinner
                            this.selectedPosition = ChipsDayType.LUNCH.chipPosition
                        })
                    }
                }else if(recipeId?.toLong() == selectedDayList?.get(index)?.dinner){
                    if(selectedDayList?.get(index)?.lunch != 0L){
                        items.add(SelectDayItem().apply {
                            this.day = it
                            this.isChecked = true
                            this.isOccuped = true
                            this.lunchId = selectedDayList?.get(index)?.lunch
                            this.dinnerId = selectedDayList?.get(index)?.dinner
                            this.selectedPosition = ChipsDayType.DINNER.chipPosition
                        })
                    }else{
                        items.add(SelectDayItem().apply {
                            this.day = it
                            this.isChecked = true
                            this.lunchId = selectedDayList?.get(index)?.lunch
                            this.dinnerId = selectedDayList?.get(index)?.dinner
                            this.selectedPosition = ChipsDayType.DINNER.chipPosition
                        })
                    }
                }else if(selectedDayList?.get(index)?.lunch != 0L){
                    items.add(SelectDayItem().apply {
                        this.day = it
                        this.isChecked = false
                        this.isOccuped = true
                        this.lunchId = selectedDayList?.get(index)?.lunch
                        this.dinnerId = selectedDayList?.get(index)?.dinner
                        this.selectedPosition = ChipsDayType.LUNCH.chipPosition
                    })
                }else if(selectedDayList?.get(index)?.dinner != 0L){
                    items.add(SelectDayItem().apply {
                        this.day = it
                        this.isChecked = false
                        this.isOccuped = true
                        this.lunchId = selectedDayList?.get(index)?.lunch
                        this.dinnerId = selectedDayList?.get(index)?.dinner
                        this.selectedPosition = ChipsDayType.DINNER.chipPosition
                    })
                }else{
                    items.add(SelectDayItem().apply {
                        this.day = it
                        this.isChecked = false
                        this.lunchId = selectedDayList?.get(index)?.lunch
                        this.dinnerId = selectedDayList?.get(index)?.dinner
                        this.selectedPosition = ChipsDayType.NONE.chipPosition
                    })
                }
            }
            itemAdapter.add(items)
        })
    }

    private fun isUpdateNecesary(clickedDay: DaySelectionModel?, isLunchOrDinner:Int){
        Log.d("debago","selectedday list size is ${selectedDayList?.size}")
        selectedDayList?.forEach {
            if (it == clickedDay) {
                it.apply {
                    this?.day=0
                    this?.lunch=0L
                    this?.dinner=0L
                }
            } else {
                if(it?.day==clickedDay?.day){
                    if(it?.lunch==0L && it.dinner==0L){
                        it.apply {
                            this.lunch=clickedDay?.lunch
                            this.dinner=clickedDay?.dinner
                        }
                    }else if (it?.lunch!=0L && clickedDay?.lunch!=0L || it?.dinner!=0L && clickedDay?.dinner!=0L){
                        if(it?.lunch== clickedDay?.lunch && isLunchOrDinner==ChipsDayType.LUNCH.chipPosition){
                            it.apply {
                                this?.lunch=0L
                                this?.dinner=clickedDay?.dinner
                            }
                        }else if(it?.dinner==clickedDay?.dinner && isLunchOrDinner==ChipsDayType.DINNER.chipPosition){
                            it.apply {
                                this?.lunch=clickedDay?.lunch
                                this?.dinner=0L
                            }
                        } else{
                            it.apply {
                                this?.lunch=clickedDay?.lunch
                                this?.dinner=clickedDay?.dinner
                            }
                        }
                    }else {
                        it.apply {
                            this?.lunch=clickedDay?.lunch
                            this?.dinner=clickedDay?.dinner
                        }
                    }
                }
            }
        }
    }


}