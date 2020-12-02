package com.inved.freezdge.schedule.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.inved.freezdge.R
import com.inved.freezdge.databinding.ActivityMainBinding
import com.inved.freezdge.databinding.FragmentCalendarBinding
import com.inved.freezdge.schedule.viewmodel.DaySelectedViewModel
import com.inved.freezdge.uiGeneral.fragment.BaseFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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
    private var searchItem: MenuItem?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        daySelectedViewModel =
            ViewModelProviders.of(this).get(DaySelectedViewModel::class.java)
        setHasOptionsMenu(true)

    }

    override fun onResume() {
        super.onResume()
        val imm: InputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm.isAcceptingText) {
            Log.d("debago","Software Keyboard was shown")
            hideKeyboard()
        } else {
            Log.d("debago","Software Keyboard was not shown")
        }
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
            GlobalScope.launch(Dispatchers.Main) { updateGroceryList() }
            getCalendarRecipes(0)


        }

        builder?.setNegativeButton(android.R.string.no) { dialog, _ ->
            dialog.dismiss()
        }
        builder?.show()
    }

}