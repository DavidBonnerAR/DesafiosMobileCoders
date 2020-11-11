package com.example.digitalhousefoods

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RestauranteDetalhesAdapter(private val dataSet: List<Prato>, private val listener: (Prato) -> Unit): RecyclerView.Adapter<RestauranteDetalhesViewHolder>() {

    //Usar xml como item de linha
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteDetalhesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_pratos, parent, false)
        return RestauranteDetalhesViewHolder(view)
    }

    //Quantidade de itens
    override fun getItemCount() = dataSet.size

    //Quando chegar elemento novo, chamar para cada elemento
    override fun onBindViewHolder(holder: RestauranteDetalhesViewHolder, position: Int) {
        holder.bind(dataSet[position].nome)
        holder.itemView.setOnClickListener { listener(dataSet[position]) }
    }
}