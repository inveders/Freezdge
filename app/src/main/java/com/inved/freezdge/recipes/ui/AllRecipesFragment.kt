package com.inved.freezdge.recipes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.airbnb.lottie.LottieAnimationView
import com.inved.freezdge.R
import com.inved.freezdge.uiGeneral.fragment.BaseFragment

class AllRecipesFragment: BaseFragment(){


    override fun getLayoutRes(): Int {
        return R.layout.fragment_all_recipes
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loader?.rootView?.findViewById<LottieAnimationView>(R.id.animation_view)
        loaderContainer?.rootView?.findViewById<FrameLayout>(R.id.animation_view_container)

        return super.onCreateView(inflater, container, savedInstanceState)


    }

    companion object{

        var loader: LottieAnimationView? = null
        var loaderContainer: FrameLayout? = null

        fun showLoadingIndicator() {
            loader?.post {
                loader!!.playAnimation()
                loaderContainer?.visibility = View.VISIBLE
            }
        }

        fun hideLoadingIndicator() {
            loader?.post {
                loader!!.pauseAnimation()
                loaderContainer?.visibility = View.GONE
            }
        }
    }

}