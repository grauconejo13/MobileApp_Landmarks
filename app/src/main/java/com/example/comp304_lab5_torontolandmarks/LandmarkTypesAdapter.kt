package com.example.comp304_lab5_torontolandmarks

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class LandmarkTypesAdapter(
    context: Context,
    private val landmarkTypes: Array<String>
) : ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, landmarkTypes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.text = landmarkTypes[position]
        return view
    }
}
