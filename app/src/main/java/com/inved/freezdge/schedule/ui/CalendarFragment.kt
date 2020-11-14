package com.inved.freezdge.schedule.ui

import android.os.Bundle
import android.view.*
import com.inved.freezdge.R
import com.inved.freezdge.databinding.ActivityMainBinding
import com.inved.freezdge.databinding.FragmentCalendarBinding
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

    private var searchItem: MenuItem?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        searchItem = menu.findItem(R.id.searchItem)
        searchItem?.isVisible = isFavouriteSearchButtonShowed
        val clearIngredientItem = menu.findItem(R.id.clearIngredientItem)
        val likeItem = menu.findItem(R.id.likeItem)
        clearIngredientItem.isVisible = false
        likeItem.isVisible = false

        return super.onPrepareOptionsMenu(menu)
    }
}