package com.example.appdesafiofirebase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val dataSet: List<Jogo>, private val listener: (Jogo) -> Unit): RecyclerView.Adapter<JogoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return JogoViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: JogoViewHolder, position: Int) {
        holder.bind(dataSet[position].nome, dataSet[position].ano, dataSet[position].image)
        holder.itemView.setOnClickListener { listener(dataSet[position]) }

    }
}