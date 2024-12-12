package com.example.footprint.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.footprint.R
import com.example.footprint.views.fragments.HomeFragment
import com.example.footprint.views.fragments.ProfileFragment
import com.example.footprint.views.fragments.ViewPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)
        bottomNavigationView = findViewById(R.id.bottom_navigation)

        // Setup ViewPager with Adapter
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        // Tab layout titles
        val tabTitles = arrayOf("Personal", "Travel", "Waste", "Energy")

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitles[position]
            tab.setIcon(getTabIcon(position)) // Set the tab icons here
        }.attach()

        // Set default tab
        viewPager.setCurrentItem(0, false)

        // Tab selection listener
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.icon?.mutate()?.setTint(
                    ContextCompat.getColor(this@HomeActivity, R.color.colorPrimary)
                )
                viewPager.currentItem = tab?.position ?: 0
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.icon?.mutate()?.setTint(
                    ContextCompat.getColor(this@HomeActivity, R.color.colorInactive)
                )
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        // Bottom Navigation Listener
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    tabLayout.visibility = android.view.View.VISIBLE // Show tab only for HomeFragment
                }
                R.id.nav_profile -> {
                    loadFragment(ProfileFragment())
                    tabLayout.visibility = android.view.View.GONE // Hide tab for other fragments
                }
            }
            true
        }

        // Load the default fragment (HomeFragment) initially
        loadFragment(HomeFragment())
        tabLayout.visibility = android.view.View.VISIBLE // Show tab for HomeFragment
    }

    // Method to load fragments dynamically
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    // Set the icon based on the tab position
    private fun getTabIcon(position: Int): Int {
        return when (position) {
            0 -> R.drawable.ic_person
            1 -> R.drawable.ic_travel
            2 -> R.drawable.ic_waste
            3 -> R.drawable.ic_energy
            else -> R.drawable.ic_person
        }
    }
}
