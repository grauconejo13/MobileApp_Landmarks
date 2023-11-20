package com.example.comp304_lab5_torontolandmarks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class LandmarkTypesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landmark_types)

        val landmarkTypes = listOf("Old Building", "Attractions", "Museum", "Stadium")

        val landmarkTypeListView = findViewById<ListView>(R.id.landmarkTypeListView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkTypes)
        landmarkTypeListView.adapter = adapter

        landmarkTypeListView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val selectedLandmarkType = landmarkTypes[position]
                val intent = Intent(this, LandmarkListingActivity::class.java)
                intent.putExtra(LandmarkListingActivity.LANDMARK_TYPE, selectedLandmarkType)
                startActivity(intent)
            }
    }
}
