package com.example.footprint.views

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences: SharedPreferences = getSharedPreferences("AppPrefs", MODE_PRIVATE)
        val isAuthenticated = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isAuthenticated) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        } else {

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        finish()
    }
}
