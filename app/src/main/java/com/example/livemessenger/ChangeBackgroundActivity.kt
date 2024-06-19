

package com.example.livemessenger.settings

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.livemessenger.R

class ChangeBackgroundActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_background)

        sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE)
        val isDarkMode = sharedPreferences.getBoolean("DARK_MODE", false)

        val toggleThemeButton: Button = findViewById(R.id.ToggleThemeButton)
        toggleThemeButton.text = if (isDarkMode) "Switch to Light Mode" else "Switch to Dark Mode"

        toggleThemeButton.setOnClickListener {
            val editor = sharedPreferences.edit()
            if (isDarkMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor.putBoolean("DARK_MODE", false)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor.putBoolean("DARK_MODE", true)
            }
            editor.apply()
            recreate()
        }
    }
}
