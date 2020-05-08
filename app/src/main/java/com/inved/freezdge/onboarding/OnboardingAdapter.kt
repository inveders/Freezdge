package com.inved.freezdge.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.inved.freezdge.R
import com.inved.freezdge.utils.App
import com.inved.freezdge.utils.GlideApp

class OnboardingAdapter(private val onboardingListItem: ArrayList<OnboardingItem>): RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    class OnboardingViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        private var textTitle:TextView?=itemView.findViewById(R.id.textTitle)
        private var textDescription:TextView?=itemView.findViewById(R.id.textDescription)
        private var imageOnboarding:ImageView?=itemView.findViewById(R.id.imageOnboarding)


        fun setOnboardingData(onboardingItem: OnboardingItem){
            textTitle?.text=onboardingItem.title
            textDescription?.text=onboardingItem.description
            imageOnboarding?.let {
                GlideApp.with(App.applicationContext())
                    .load(onboardingItem.image)
                    .centerCrop()
                    .into(it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        return OnboardingViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_container_onboarding, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return onboardingListItem.size
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.setOnboardingData(onboardingListItem[position])
    }


}