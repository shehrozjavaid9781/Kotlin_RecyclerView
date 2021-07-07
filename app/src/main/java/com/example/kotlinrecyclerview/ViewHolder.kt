package com.example.kotlinrecyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(itemView: View, val listener : CellClick) : RecyclerView.ViewHolder(itemView) {

    fun bindItems(user: User, position: Int) {

        val textViewName = itemView.findViewById(R.id.textViewUsername) as TextView
        val textViewAddress  = itemView.findViewById(R.id.textViewAddress) as TextView
        textViewName.text = user.name
        textViewAddress.text = user.address

        itemView.setOnClickListener {
            listener.onListener(user,position)
        }
    }
}