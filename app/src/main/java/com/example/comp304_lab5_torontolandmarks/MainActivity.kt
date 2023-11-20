package com.example.comp304_lab5_torontolandmarks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import com.example.comp304_lab5_torontolandmarks.LandmarkTypesActivity
import com.example.comp304_lab5_torontolandmarks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var skyline: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        skyline = findViewById(R.id.main_image)
        button = findViewById(R.id.button)

        button.visibility = View.INVISIBLE

        // Handler to introduce a 3-second delay
        Handler(Looper.getMainLooper()).postDelayed({
            button.visibility = View.VISIBLE
            showButton()
        }, 2000)
    }
    private fun showButton() {

        // Once the button is shown, set its click listener to navigate to LandmarkTypesActivity
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, LandmarkTypesActivity::class.java)
            startActivity(intent)
        }
    }
}


