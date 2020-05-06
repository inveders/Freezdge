package com.inved.freezdge.ingredientslist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.inved.freezdge.ingredientslist.ui.TypeIngredientsFragment

class MyViewPageStateAdapter(fm: FragmentActivity): FragmentStateAdapter(fm){
    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        val fragment = TypeIngredientsFragment()
        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putInt("PositionViewpager", position)
        }
        return fragment
    }
}