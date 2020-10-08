package com.inved.freezdge.favourites.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.favourites.adapter.SelectDayItem
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.ChipsDayType
import com.inved.freezdge.utils.Domain
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.GenericItem
import com.mikepenz.fastadapter.adapters.GenericItemAdapter

class SelectDayDialog : DialogFragment() {

    companion object {
        const val TAG = "DAY"

        private const val KEY_DAY = "dayParam"

        //To pass args to our dialog
        @JvmStatic
        fun newInstance(param1: String?) =
            SelectDayDialog().apply {
                arguments = Bundle().apply {
                    putString(KEY_DAY, param1)
                }
            }
    }

    var domain = Domain()

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
        handleSelectedDay(selectedDay)

        cancelButton?.setOnClickListener {
            cancelButton?.startAnimation(domain.animation())
            dialog?.dismiss()
        }

        return view
    }

    private fun handleSelectedDay(selectedDay: String?) {
        var position: Int? = 0
        when {
            selectedDay?.contains(App.appContext.getString(R.string.lunch), true) == true -> {
                position = ChipsDayType.LUNCH.chipPosition
            }
            selectedDay?.contains(ChipsDayType.SNACK.name, true) == true -> {
                position = ChipsDayType.SNACK.chipPosition
            }
            selectedDay?.contains(ChipsDayType.DINNER.name, true) == true -> {
                position = ChipsDayType.DINNER.chipPosition
            }
        }
        setupRecyclerView(selectedDay, position)
    }

    private fun setupRecyclerView(selectedDay: String?, position: Int?) {

        itemAdapter.clear()
        recyclerView?.layoutManager =
            LinearLayoutManager(mContext, RecyclerView.VERTICAL, false)
        recyclerView?.isNestedScrollingEnabled = false
        //   fastAdapter?.onClickListener = this
        recyclerView?.adapter = fastAdapter

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
                    items.add(SelectDayItem().apply {
                        this.day = it
                        this.isChecked = true
                        this.selectedPosition = position
                    })
                }
            }
        }
        itemAdapter.add(items)
    }


    //Check photo before create (after click on publish button)
    private fun createPhotoPost(id: Int?) {

    }

}