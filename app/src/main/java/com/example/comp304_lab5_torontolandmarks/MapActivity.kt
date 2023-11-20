package com.example.comp304_lab5_torontolandmarks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.UiSettings
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapActivity : AppCompatActivity() {
    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync { googleMap ->
            val selectedLandmark = intent.getSerializableExtra("selectedLandmark") as? Landmark
            if (selectedLandmark != null) {
                setupMap(selectedLandmark, googleMap)
            } else {
                // Handle the case when no landmark is selected
                Toast.makeText(this, "Error: No landmark selected.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupMap(landmark: Landmark, googleMap: GoogleMap) {
        val location = LatLng(landmark.lat, landmark.long)
        googleMap.addMarker(MarkerOptions().position(location).title(landmark.name))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 10f))

        // Enable zoom controls
        val uiSettings: UiSettings = googleMap.uiSettings
        uiSettings.isZoomControlsEnabled = true
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }
}
