package com.inved.freezdge.ingredientslist.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.inved.freezdge.R
import com.inved.freezdge.ingredientslist.view.MyViewPageStateAdapter
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import com.inved.freezdge.uiGeneral.activity.MainActivity


class SearchIngredientsActivity : BaseActivity(),ViewPager.OnPageChangeListener {

companion object{
    var currentPage:Int?=0
}

    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initToolbarBaseActivity(R.string.toolbar_search_ingredients)
        initViews()
        setStatePageAdapter()
        initTablayout()

    }

    private fun initTablayout() {
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
                val fm = supportFragmentManager
                val ft = fm.beginTransaction()
                val count = fm.backStackEntryCount
                if (count >= 1) {
                    supportFragmentManager.popBackStack()
                }
                ft.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
    }

    //INITIALIZATION

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

    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_search_ingredients
    }

    //TABLAYOUT

    private fun  initViews(){
        viewPager = findViewById(R.id.pager)
        tabLayout = findViewById(R.id.tabs)
    }

    private fun setStatePageAdapter(){
        val myViewPageStateAdapter = MyViewPageStateAdapter(supportFragmentManager)
        myViewPageStateAdapter.addFragment(CreamFragment(),getString(R.string.ingredient_type_cream))
        myViewPageStateAdapter.addFragment(FruitsVegetablesFragment(),getString(R.string.ingredient_type_fruits_vegetables_short))
        myViewPageStateAdapter.addFragment(EpicerieFragment(),getString(R.string.ingredient_type_epicerie))
        myViewPageStateAdapter.addFragment(FishFragment(),getString(R.string.ingredient_type_fish))
        myViewPageStateAdapter.addFragment(MeatFragment(),getString(R.string.ingredient_type_meat))
        viewPager.adapter=myViewPageStateAdapter
        tabLayout.setupWithViewPager(viewPager,true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tabLayout.getTabAt(0)?.icon = getDrawable(R.drawable.ic_cream)
            tabLayout.getTabAt(1)?.icon = getDrawable(R.drawable.ic_vegetable)
            tabLayout.getTabAt(2)?.icon = getDrawable(R.drawable.ic_epicerie)
            tabLayout.getTabAt(3)?.icon = getDrawable(R.drawable.ic_fish)
            tabLayout.getTabAt(4)?.icon = getDrawable(R.drawable.ic_bottom_meat)
        }else{
            tabLayout.getTabAt(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_cream)
            tabLayout.getTabAt(1)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_vegetable)
            tabLayout.getTabAt(2)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_epicerie)
            tabLayout.getTabAt(3)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_fish)
            tabLayout.getTabAt(4)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_bottom_meat)
        }

        viewPager.addOnPageChangeListener(this)



    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        currentPage = position//update current page
    }
}