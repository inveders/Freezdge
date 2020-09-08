package com.inved.freezdge.ingredientslist.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.view.MyViewPageStateAdapter
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import com.inved.freezdge.uiGeneral.activity.MainActivity
import com.inved.freezdge.uiGeneral.fragment.BaseFragment

class SearchIngredientsActivity : BaseActivity() {

    companion object {
        var currentPage: Int? = 0
    }

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    //define icons for the tablayout
    private val tabIcons: IntArray =
        intArrayOf(
            R.drawable.ic_cream,
            R.drawable.ic_vegetable,
            R.drawable.ic_epicerie,
            R.drawable.ic_fish,
            R.drawable.ic_bottom_meat
        )

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_search_ingredients
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_ingredients)
        initToolbarBaseActivity(R.string.toolbar_search_ingredients)
        initViews()
        setStatePageAdapter()
        initTabLayout()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("BACKPRESS", 1)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    //TABLAYOUT
    private fun initViews() {
        viewPager = findViewById(R.id.pager)
        tabLayout = findViewById(R.id.tabs)
    }

    // configure viewpager adapter
    private fun setStatePageAdapter() {
        val myViewPageStateAdapter = MyViewPageStateAdapter(this)
        viewPager.adapter = myViewPageStateAdapter
    }

    // init tablayout with icons
    private fun initTabLayout() {
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                tab.icon = getDrawable(tabIcons[position])
            } else {
                tab.icon =
                    ContextCompat.getDrawable(this, tabIcons[position])
            }
        }.attach()
    }
}