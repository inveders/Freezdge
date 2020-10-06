package com.inved.freezdge.onboarding

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.inved.freezdge.R
import com.inved.freezdge.uiGeneral.activity.BaseActivity
import com.inved.freezdge.uiGeneral.activity.MainActivity
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.Domain
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : BaseActivity() {

    private lateinit var onboardingAdapter: OnboardingAdapter

    companion object {
        fun getLaunchIntent(from: Context) = Intent(from, OnboardingActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }

        private var PRIVATE_MODE = 0
        const val PREF_NAME = "ONBOARDING"
        const val VERSION_APP_NAME = "VERSION_APP_NAME"
        val sharedPrefVersionName: SharedPreferences =
            App.applicationContext().getSharedPreferences(VERSION_APP_NAME, PRIVATE_MODE)
        val sharedPref: SharedPreferences =
            App.applicationContext().getSharedPreferences(PREF_NAME, PRIVATE_MODE)
    }


    override fun getLayoutContentViewID(): Int {
        return R.layout.activity_onboarding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupOnaboardingItems()
        onboardingViewpager.adapter = onboardingAdapter
        setupOnboardingIndicator()
        onboardingViewpager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                setCurrentOnboardingIndicator(position)
            }
        })
        // handle click on next button
        buttonOnboardingAction.setOnClickListener {
                if (onboardingViewpager.currentItem + 1 < onboardingAdapter.itemCount) {
                    onboardingViewpager.currentItem = onboardingViewpager.currentItem + 1
                } else {
                    startActivity(Intent(this, MainActivity::class.java))
                    val editor = sharedPref.edit()
                    editor.putBoolean(PREF_NAME, true)
                    editor.apply()
                    finish()
                }
        }
    }

    // setup onboarding text and images for the four pages
    private fun setupOnaboardingItems() {

        val onboardingItemList: ArrayList<OnboardingItem> = arrayListOf()

        val onboardingItem1 =
            OnboardingItem(
                R.drawable.ic_onboarding1,
                getString(R.string.onboarding1_title),
                getString(R.string.onboarding1_description)
            )

        val onboardingItem2 = OnboardingItem(
            R.drawable.ic_onboarding2,
            getString(R.string.onboarding2_title),
            getString(R.string.onboarding2_description)
        )
        val onboardingItem3 = OnboardingItem(
            R.drawable.ic_onboarding3,
            getString(R.string.onboarding3_title),
            getString(R.string.onboarding3_description)
        )
        val onboardingItem4 = OnboardingItem(
            R.drawable.ic_onboarding4,
            getString(R.string.onboarding4_title),
            getString(R.string.onboarding4_description)
        )

        onboardingItem1.let { onboardingItemList.add(it) }
        onboardingItem2.let { onboardingItemList.add(it) }
        onboardingItem3.let { onboardingItemList.add(it) }
        onboardingItem4.let { onboardingItemList.add(it) }

        onboardingAdapter=OnboardingAdapter(onboardingItemList)

    }

    // indicator for pages of the onboarding
    private fun setupOnboardingIndicator() {

            val indicatorImage: Array<ImageView?>? = arrayOfNulls(onboardingAdapter.itemCount)
            val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(8, 0, 8, 0)

            if (indicatorImage != null) {
                for (i in indicatorImage.indices) {
                    indicatorImage[i] = ImageView(applicationContext)
                    indicatorImage[i]?.setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.onboarding_indicator_inactive
                        )
                    )
                    indicatorImage[i]?.layoutParams = layoutParams
                    layoutOnboardingIndicators.addView(indicatorImage[i])
                }


            }
    }

    // change indicator ui for current state
    fun setCurrentOnboardingIndicator(index: Int) {
        val childCount: Int = layoutOnboardingIndicators.childCount
        for (i in 0..childCount) {
            val imageView: ImageView? = layoutOnboardingIndicators.getChildAt(i) as ImageView?
            if (i == index) {
                imageView?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.onboarding_indicator_active
                    )
                )
            } else {
                imageView?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.onboarding_indicator_inactive
                    )
                )
            }
        }

            if (index == onboardingAdapter.itemCount - 1) {
                buttonOnboardingAction.text = getString(R.string.start)
            } else {
                buttonOnboardingAction.text = getString(R.string.next)
            }
    }

}