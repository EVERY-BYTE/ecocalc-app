package com.example.footprint.ui.theme
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.footprint.views.fragments.HomeFragment
import com.example.footprint.views.fragments.ProfileFragment
import com.example.footprint.views.fragments.SettingsFragment

class TabAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragmentList = listOf(
        HomeFragment(),
        ProfileFragment(),
        SettingsFragment()
    )

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]
}
