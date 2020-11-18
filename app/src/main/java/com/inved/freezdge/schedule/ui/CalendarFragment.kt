package com.inved.freezdge.schedule.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.inved.freezdge.R
import com.inved.freezdge.databinding.ActivityMainBinding
import com.inved.freezdge.databinding.FragmentCalendarBinding
import com.inved.freezdge.schedule.viewmodel.DaySelectedViewModel
import com.inved.freezdge.uiGeneral.fragment.BaseFragment

class CalendarFragment: BaseFragment<FragmentCalendarBinding, ActivityMainBinding>() {
    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCalendarBinding {
        return FragmentCalendarBinding.inflate(inflater, container, false)
    }

    companion object{
        var isFavouriteSearchButtonShowed:Boolean=false
    }
    private lateinit var daySelectedViewModel: DaySelectedViewModel
    private var searchItem: MenuItem?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        daySelectedViewModel =
            ViewModelProviders.of(this).get(DaySelectedViewModel::class.java)
        setHasOptionsMenu(true)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        searchItem = menu.findItem(R.id.searchItem)
        searchItem?.isVisible = isFavouriteSearchButtonShowed
        val clearIngredientItem = menu.findItem(R.id.clearIngredientItem)
        val likeItem = menu.findItem(R.id.likeItem)
        clearIngredientItem.isVisible = true
        likeItem.isVisible = false

        clearIngredientItem.setOnMenuItemClickListener {
            launchAlertDialog()
            true
        }
        return super.onPrepareOptionsMenu(menu)
    }

    //launch dialog to choose if we really want to clear our ingredient list
    private fun launchAlertDialog() {
        val builder = context?.let { MaterialAlertDialogBuilder(it) }
        builder?.setTitle(getString(R.string.menu_bottom_calendar))
        builder?.setMessage(getString(R.string.dialog_question_clear_calendar))

        builder?.setPositiveButton(getString(R.string.Yes)) { _, _ ->
            Toast.makeText(
                activity,
                getString(R.string.calendar_list_clear), Toast.LENGTH_SHORT
            ).show()
            daySelectedViewModel.reinitCalendarValues()
        }

        builder?.setNegativeButton(android.R.string.no) { dialog, _ ->
            dialog.dismiss()
        }
        builder?.show()
    }

}