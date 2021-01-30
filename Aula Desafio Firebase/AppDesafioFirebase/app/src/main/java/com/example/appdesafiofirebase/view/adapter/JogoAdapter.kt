package com.example.appdesafiofirebase.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appdesafiofirebase.R
import com.example.appdesafiofirebase.model.JogoModel

class JogoAdapter(
    private var _gameList: MutableList<JogoModel>,
    var listener: (JogoModel) -> Unit
) : RecyclerView.Adapter<JogoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return JogoViewHolder(view)
    }

    override fun getItemCount() = _gameList.size

    override fun onBindViewHolder(holder: JogoViewHolder, position: Int) {
        val item = _gameList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item) }
    }
}