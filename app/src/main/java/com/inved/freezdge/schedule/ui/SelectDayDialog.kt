package com.inved.freezdge.schedule.ui

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.viewmodel.IngredientsViewModel
import com.inved.freezdge.injection.Injection
import com.inved.freezdge.recipes.database.Recipes
import com.inved.freezdge.recipes.viewmodel.RecipeViewModel
import com.inved.freezdge.schedule.adapter.SelectDayItem
import com.inved.freezdge.schedule.adapter.SuggestionRecipeItem
import com.inved.freezdge.schedule.database.DaySelected
import com.inved.freezdge.schedule.model.DaySelectionModel
import com.inved.freezdge.schedule.viewmodel.DaySelectedViewModel
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import com.inved.freezdge.utils.enumtype.ChipsDayType
import com.inved.freezdge.utils.enumtype.DayType
import com.inved.freezdge.utils.eventbus.RefreshEvent
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.GenericItemAdapter
import com.mikepenz.fastadapter.listeners.addClickListener
import org.greenrobot.eventbus.EventBus

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
        private const val KEY_DAY_POS_RECYCLERVIEW = "positionRecyclerView"
        private const val KEY_DAY_RECIPE_ID = "recipeId"
        private const val KEY_SUGGESTION = "isSuggestion"
        private const val KEY_FROM_SEARCH_FILTER = "isFromSearchFilter"
        private const val KEY_DAY_SUGGESTION = "day_Suggestion"
        private const val KEY_LUNCH_OR_DINNER_SUGGESTION = "lunchOrDinner_Suggestion"
        var selectedDayList: MutableList<DaySelectionModel?>? = mutableListOf()
        private var dateSelectedListener: SelectDateListener? = null
        fun setSelectDateListener(callback: SelectDateListener) {
            dateSelectedListener = callback
        }

        //Viewmodel
        private var isNeedRefresh: Boolean = false
        private lateinit var daySelectedViewModel: DaySelectedViewModel
        private lateinit var recipeViewModel: RecipeViewModel
        private lateinit var ingredientsViewModel: IngredientsViewModel
        private var isSuggestion: Boolean? = false
        private var isFromSearchFilter: Boolean? = null

        //To pass args to our dialog
        @JvmStatic
        fun newInstance(
            param1: DaySelectionModel?,
            param2: Int?,
            param3: String?,
            param4: Boolean?
        ) =
            SelectDayDialog().apply {
                arguments = Bundle().apply {
                    if (param1 != null) {
                        if (param1.day != 0L) {
                            putBoolean(KEY_SUGGESTION, true)
                            param1.day?.let { putLong(KEY_DAY_SUGGESTION, it) }
                        }
                        if (param1.lunch != 0L) {
                            putInt(KEY_LUNCH_OR_DINNER_SUGGESTION, ChipsDayType.LUNCH.chipPosition)
                        }
                        if (param1.dinner != 0L) {
                            putInt(KEY_LUNCH_OR_DINNER_SUGGESTION, ChipsDayType.DINNER.chipPosition)
                        }
                    }
                    if (param2 != null) {
                        putInt(KEY_DAY_POS_RECYCLERVIEW, param2)
                    }
                    if (param4 != null) {
                        putBoolean(KEY_FROM_SEARCH_FILTER, param4)
                    }
                    putString(KEY_DAY_RECIPE_ID, param3)
                }
            }
    }

    val domain = Domain()
    private var itemPositionInRecyclerView: Int? = 0
    var recipeId: String? = null

    //UI
    private var validateButton: AppCompatButton? = null
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
        ingredientsViewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(IngredientsViewModel::class.java)
        recipeViewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(RecipeViewModel::class.java)
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
        isSuggestion = arguments?.getBoolean(KEY_SUGGESTION)
        isFromSearchFilter = arguments?.getBoolean(KEY_FROM_SEARCH_FILTER)
        setupRecyclerView()

        if (isSuggestion == true) {
            dialogTitle.let {
                it?.text = getString(R.string.recipe_suggestion_dialog)
            }
            validateButton.let {
                it?.visibility = View.INVISIBLE
            }
        } else {
            dialogTitle.let {
                it?.text = getString(R.string.day_dialog)
            }
        }

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
                    if (item.isOccuped == true) {
                        //todo show dialog and if true
                        this.dinner = item.dinnerId
                    } else {
                        this.dinner = 0L
                    }
                }
                isUpdateNecesary(clickedDay, ChipsDayType.LUNCH.chipPosition)

            }
        }

        fastAdapter.addClickListener({ vh: SelectDayItem.ViewHolder -> vh.dinnerChip }) { v: View, pos: Int, _: FastAdapter<GenericItem>, item: GenericItem ->
            if (item is SelectDayItem) {
                val clickedDay: DaySelectionModel? = DaySelectionModel().apply {
                    this.day = handleSelectedDay(item.day)
                    if (item.isOccuped == true) {
                        //todo show dialog and if true
                        this.lunch = item.lunchId
                    } else {
                        this.lunch = 0L
                    }
                    this.dinner = recipeId?.toLong()
                }
                isUpdateNecesary(clickedDay, ChipsDayType.DINNER.chipPosition)
            }
        }

        fastAdapter.addClickListener({ vh: SuggestionRecipeItem.ViewHolder -> vh.chooseButton }) { v: View, pos: Int, _: FastAdapter<GenericItem>, item: GenericItem ->
            if (item is SuggestionRecipeItem) {

                val clickedDay: DaySelectionModel? = DaySelectionModel().apply {
                    this.day = arguments?.getLong(KEY_DAY_SUGGESTION)
                    if (arguments?.getInt(KEY_LUNCH_OR_DINNER_SUGGESTION) == ChipsDayType.LUNCH.chipPosition) {
                        this.lunch = item.model?.fixedId
                        this.dinner =
                            day?.toInt()?.minus(1)?.let { selectedDayList?.get(it)?.dinner }
                    } else {
                        this.lunch = day?.toInt()?.minus(1)?.let { selectedDayList?.get(it)?.lunch }
                        this.dinner = item.model?.fixedId
                    }
                }
                arguments?.getInt(KEY_LUNCH_OR_DINNER_SUGGESTION)?.let {
                    isUpdateNecesary(
                        clickedDay,
                        it
                    )
                }
                dateSelectedListener?.onDateSelected(
                    selectedDayList,
                    itemPositionInRecyclerView,
                    item.model?.fixedId.toString()
                )
                dialog?.dismiss()

            }
        }
    }

    private fun fillSelectedDayList(result: MutableList<DaySelected>?) {
        selectedDayList?.clear()
        //fill selectedDayList with
        result?.forEach { res ->

            if (selectedDayList?.size?.compareTo(7) == -1) {

                selectedDayList?.add(DaySelectionModel().apply {
                    Log.d(
                        "debago",
                        "selected day list; day : ${res.fixedId}, lunch : ${res.lunch}, dinner : ${res.dinner}"
                    )
                    this.day = res.fixedId
                    this.lunch = res.lunch
                    this.dinner = res.dinner
                })
            }

        }
    }

    private fun fillDialog() {
        fillSelectedDayList(daySelectedViewModel.getSelectedDay())
        if (isSuggestion == true) {
            fillSuggestionRecyclerView()
        } else {
            fillChipEachDay()
        }
    }


    private fun fillChipEachDay() {
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
        daysOfWeek.forEachIndexed { index, it ->

            if (recipeId?.toLong() == selectedDayList?.get(index)?.lunch) {
                if (selectedDayList?.get(index)?.dinner != 0L) {
                    items.add(SelectDayItem().apply {
                        this.day = it
                        this.isChecked = true
                        this.isOccuped = true
                        this.lunchId = selectedDayList?.get(index)?.lunch
                        this.dinnerId = selectedDayList?.get(index)?.dinner
                        this.selectedPosition = ChipsDayType.LUNCH.chipPosition
                    })
                } else {
                    items.add(SelectDayItem().apply {
                        this.day = it
                        this.isChecked = true
                        this.lunchId = selectedDayList?.get(index)?.lunch
                        this.dinnerId = selectedDayList?.get(index)?.dinner
                        this.selectedPosition = ChipsDayType.LUNCH.chipPosition
                    })
                }
            } else if (recipeId?.toLong() == selectedDayList?.get(index)?.dinner) {
                if (selectedDayList?.get(index)?.lunch != 0L) {
                    items.add(SelectDayItem().apply {
                        this.day = it
                        this.isChecked = true
                        this.isOccuped = true
                        this.lunchId = selectedDayList?.get(index)?.lunch
                        this.dinnerId = selectedDayList?.get(index)?.dinner
                        this.selectedPosition = ChipsDayType.DINNER.chipPosition
                    })
                } else {
                    items.add(SelectDayItem().apply {
                        this.day = it
                        this.isChecked = true
                        this.lunchId = selectedDayList?.get(index)?.lunch
                        this.dinnerId = selectedDayList?.get(index)?.dinner
                        this.selectedPosition = ChipsDayType.DINNER.chipPosition
                    })
                }
            } else if (selectedDayList?.get(index)?.lunch != 0L && selectedDayList?.get(index)?.dinner != 0L) {
                items.add(SelectDayItem().apply {
                    this.day = it
                    this.isChecked = false
                    this.isOccuped = true
                    this.lunchId = selectedDayList?.get(index)?.lunch
                    this.dinnerId = selectedDayList?.get(index)?.dinner
                    this.selectedPosition = ChipsDayType.LUNCH.chipPosition
                    this.secondSelectedPosition = ChipsDayType.DINNER.chipPosition
                })
            } else if (selectedDayList?.get(index)?.lunch != 0L) {
                items.add(SelectDayItem().apply {
                    this.day = it
                    this.isChecked = false
                    this.isOccuped = true
                    this.lunchId = selectedDayList?.get(index)?.lunch
                    this.dinnerId = selectedDayList?.get(index)?.dinner
                    this.selectedPosition = ChipsDayType.LUNCH.chipPosition
                })
            } else if (selectedDayList?.get(index)?.dinner != 0L) {
                items.add(SelectDayItem().apply {
                    this.day = it
                    this.isChecked = false
                    this.isOccuped = true
                    this.lunchId = selectedDayList?.get(index)?.lunch
                    this.dinnerId = selectedDayList?.get(index)?.dinner
                    this.selectedPosition = ChipsDayType.DINNER.chipPosition
                })
            } else {
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
    }

    private fun fillSuggestionRecyclerView() {
        itemAdapter.clear()
        val items = mutableListOf<GenericItem>()
        val recipesList: MutableList<Recipes>? = mutableListOf()
        if (arguments?.getInt(KEY_LUNCH_OR_DINNER_SUGGESTION) == ChipsDayType.LUNCH.chipPosition) {
            recipeViewModel.getLunchSuggestionsRecipes(ingredientsViewModel.getIngredientsForFreezdgeList())
                ?.forEach {
                    recipesList?.add(it)
                }
        } else {
            recipeViewModel.getDinnerSuggestionsRecipes(ingredientsViewModel.getIngredientsForFreezdgeList())
                ?.forEach {
                    recipesList?.add(it)
                }
        }
        recipesList?.shuffle()
        defineMaxIteration(recipesList)?.let { max ->
            for (i in 0..max) {
                if (recipesList?.get(i) != null) {
                    items.add(SuggestionRecipeItem().apply {
                        this.model = recipesList[i]
                    })
                }
            }
        }
        itemAdapter.add(items)
    }

    private fun defineMaxIteration(recipesList: MutableList<Recipes>?): Int? {
        var max: Int? = 0
        recipesList?.let {
            max = if (it.size - 1 < 6) {
                it.size - 1
            } else {
                6
            }
        }
        return max
    }

    private fun isUpdateNecesary(clickedDay: DaySelectionModel?, isLunchOrDinner: Int) {
        isNeedRefresh = true
        selectedDayList?.forEach {
            if (it == clickedDay) {
                it.apply {
                    this?.day = 0
                    this?.lunch = 0L
                    this?.dinner = 0L
                }
            } else {
                if (it?.day == clickedDay?.day) {
                    if (it?.lunch == 0L && it.dinner == 0L) {
                        it.apply {
                            this.lunch = clickedDay?.lunch
                            this.dinner = clickedDay?.dinner
                        }
                    } else if (it?.lunch != 0L && clickedDay?.lunch != 0L || it?.dinner != 0L && clickedDay?.dinner != 0L) {
                        if (it?.lunch == clickedDay?.lunch && isLunchOrDinner == ChipsDayType.LUNCH.chipPosition) {
                            it.apply {
                                this?.lunch = 0L
                                this?.dinner = clickedDay?.dinner
                            }
                        } else if (it?.dinner == clickedDay?.dinner && isLunchOrDinner == ChipsDayType.DINNER.chipPosition) {
                            it.apply {
                                this?.lunch = clickedDay?.lunch
                                this?.dinner = 0L
                            }
                        } else {
                            it.apply {
                                this?.lunch = clickedDay?.lunch
                                this?.dinner = clickedDay?.dinner
                            }
                        }
                    } else {
                        it.apply {
                            this?.lunch = clickedDay?.lunch
                            this?.dinner = clickedDay?.dinner
                        }
                    }
                }
            }
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        if (isNeedRefresh) EventBus.getDefault().post(itemPositionInRecyclerView?.let {
            RefreshEvent(
                it, isFromSearchFilter
            )
        })
    }

}