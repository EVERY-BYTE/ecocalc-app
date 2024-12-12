package com.example.footprint.views.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PersonalFragment()
            1 -> TravelFragment()
            2 -> WasteFragment()
            3 -> EnergyFragment()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}
