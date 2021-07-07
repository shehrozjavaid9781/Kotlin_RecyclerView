package com.example.kotlinrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DetailFragment : Fragment() {
    var inputText: String? = ""
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v : View = inflater.inflate(R.layout.fragment_detail, container, false)

        val textViewName = v.findViewById(R.id.userName) as TextView
        inputText = arguments?.getString("input_txt")

        textViewName.text = inputText
        return v
    }
}