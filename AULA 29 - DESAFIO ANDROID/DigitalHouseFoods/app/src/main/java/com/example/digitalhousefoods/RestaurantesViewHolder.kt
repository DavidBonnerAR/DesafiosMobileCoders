package com.example.digitalhousefoods

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val nome: TextView = view.findViewById(R.id.txtNomeRestaurante)

    fun bind(nomerRestaurante: String){
        nome.text = nomerRestaurante
    }
}