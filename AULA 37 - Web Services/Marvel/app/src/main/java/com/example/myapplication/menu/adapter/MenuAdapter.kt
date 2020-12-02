package com.example.myapplication.menu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.QuadrinhoModel

class MenuAdapter(private val quadrinhos: List<QuadrinhoModel>, private val listener: (QuadrinhoModel) -> Unit): RecyclerView.Adapter<MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_quadrinhos, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount() = quadrinhos.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(quadrinhos[position])
        holder.itemView.setOnClickListener {
            listener(quadrinhos[position])
        }
    }
}