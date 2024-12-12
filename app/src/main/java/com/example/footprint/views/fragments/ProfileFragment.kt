package com.example.footprint.views.fragments

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.footprint.R
import com.example.footprint.views.LoginActivity

class ProfileFragment : Fragment(R.layout.fragment_profile) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editProfileButton: Button = view.findViewById(R.id.btn_edit_profile)
        val darkModeSwitch: Switch = view.findViewById(R.id.switch_dark_mode)
        val notificationSwitch: Switch = view.findViewById(R.id.switch_notification)
        val logoutButton: LinearLayout = view.findViewById(R.id.btn_logout) // Add logout button reference

        editProfileButton.setOnClickListener {
            Toast.makeText(context, "Edit Profile Clicked!", Toast.LENGTH_SHORT).show()
        }

        darkModeSwitch.setOnCheckedChangeListener { _, isChecked ->
            val mode = if (isChecked) "Dark Mode Enabled" else "Dark Mode Disabled"
            Toast.makeText(context, mode, Toast.LENGTH_SHORT).show()
        }

        notificationSwitch.setOnCheckedChangeListener { _, isChecked ->
            val mode = if (isChecked) "Notifications Enabled" else "Notifications Disabled"
            Toast.makeText(context, mode, Toast.LENGTH_SHORT).show()
        }

        logoutButton.setOnClickListener {
            val sharedPreferences: SharedPreferences = requireActivity().getSharedPreferences("AppPrefs", android.content.Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()


            val intent = Intent(requireActivity(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }
}
