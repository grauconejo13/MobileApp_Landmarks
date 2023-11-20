package com.example.comp304_lab5_torontolandmarks

import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.io.IOException

class LandmarkListingAdapter(private val landmarks: List<Landmark>) :
    RecyclerView.Adapter<LandmarkListingAdapter.LandmarkViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandmarkViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_landmark, parent, false)
        return LandmarkViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LandmarkViewHolder, position: Int) {
        val currentLandmark = landmarks[position]
        holder.bind(currentLandmark)
    }

    override fun getItemCount(): Int {
        return landmarks.size
    }

    inner class LandmarkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val landmarkNameTextView: TextView = itemView.findViewById(R.id.tvName)
        private val landmarkAddressTextView: TextView = itemView.findViewById(R.id.tvAddress)
        private val landmarkImageView: ImageView = itemView.findViewById(R.id.ivImage)

        fun bind(landmark: Landmark) {
            landmarkNameTextView.text = landmark.name
            landmarkAddressTextView.text = landmark.address

            // Load the image from the URL with retry logic
            loadImageWithRetry(landmark.image, landmarkImageView)

            landmarkImageView.setOnClickListener {
                openGoogleMaps(landmark)
            }
        }

        private fun openGoogleMaps(landmark: Landmark) {
            val intent = Intent(itemView.context, MapActivity::class.java)
            intent.putExtra("selectedLandmark", landmark)
            itemView.context.startActivity(intent)
        }


        private fun loadImageWithRetry(url: String, imageView: ImageView) {
            val picasso = Picasso.get()

            val callback = object : Callback {
                override fun onSuccess() {
                    // Image loaded successfully
                }

                override fun onError(e: Exception?) {
                    // Error loading image, handle retry logic here
                    if (e is IOException) {
                        // Retry loading the image after a delay
                        Handler(Looper.getMainLooper()).postDelayed({
                            picasso.load(url)
                                .resize(
                                    500,
                                    500
                                ) // Replace with the desired dimensions of the ImageView
                                .centerCrop()
                                .placeholder(R.drawable.placeholder_image)
                                .error(R.drawable.ic_error_placeholder)
                                .into(imageView, this)
                        }, 3000) // Retry after 3 seconds (adjust the delay as needed)
                    } else {
                        Log.e("Picasso", "Error loading image: ${e?.message}")
                    }
                }
            }

            try {
                picasso.load(url)
                    .resize(500, 500) // Replace with the desired dimensions of the ImageView
                    .centerCrop()
                    .placeholder(R.drawable.placeholder_image)
                    .error(R.drawable.ic_error_placeholder)
                    .into(imageView, callback)
            } catch (e: Exception) {
                Log.e("Picasso", "Error loading image: ${e.message}")
            }
        }
    }
}