package com.example.digitalhousefoods

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestauranteDetalhesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val nome: TextView = view.findViewById(R.id.txtNomePrato)

    fun bind(nomePrato: String){
        nome.text = nomePrato
    }
}