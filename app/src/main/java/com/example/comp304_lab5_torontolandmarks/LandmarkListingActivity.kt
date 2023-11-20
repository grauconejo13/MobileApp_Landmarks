package com.example.comp304_lab5_torontolandmarks

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LandmarkListingActivity : AppCompatActivity() {

    companion object {
        const val LANDMARK_TYPE = "landmarkType"
    }

    private lateinit var landmarkListingAdapter: LandmarkListingAdapter
    private lateinit var tvNoLandmarksFound: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landmark_listing)

        tvNoLandmarksFound = findViewById(R.id.tvNoLandmarksFound)

        val selectedLandmarkType = intent.getStringExtra(LANDMARK_TYPE)

        val filteredLandmarks = Landmarks.LANDMARKS.filter { it.type == selectedLandmarkType }

        val recyclerView = findViewById<RecyclerView>(R.id.landmarkListView)
        val layoutManager = LinearLayoutManager(this)
        landmarkListingAdapter = LandmarkListingAdapter(filteredLandmarks)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = landmarkListingAdapter

        checkAndShowNoLandmarksMessage(filteredLandmarks)
    }

    private fun checkAndShowNoLandmarksMessage(landmarks: List<Landmark>) {
        tvNoLandmarksFound.visibility = if (landmarks.isEmpty()) TextView.VISIBLE else TextView.GONE
    }
}