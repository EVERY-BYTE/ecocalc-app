package com.example.footprint.ui.theme
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.footprint.HomeFragment
import com.example.footprint.ProfileFragment
import com.example.footprint.SettingsFragment

class TabAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    private val fragmentList = listOf(
        HomeFragment(),
        ProfileFragment(),
        SettingsFragment()
    )

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]
}
