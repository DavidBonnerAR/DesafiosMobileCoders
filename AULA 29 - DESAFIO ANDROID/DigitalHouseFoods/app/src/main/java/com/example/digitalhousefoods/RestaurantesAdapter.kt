package com.example.digitalhousefoods

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RestaurantesAdapter(private val dataSet: List<Restaurantes>, private val listener: (Restaurantes) -> Unit): RecyclerView.Adapter<RestaurantesViewHolder>() {

    //Usar xml como item de linha
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_restaurantes, parent, false)
        return RestaurantesViewHolder(view)
    }

    //Quantidade de itens
    override fun getItemCount() = dataSet.size

    //Quando chegar elemento novo, chamar para cada elemento
    override fun onBindViewHolder(holder: RestaurantesViewHolder, position: Int) {
        holder.bind(dataSet[position].nome)
        holder.itemView.setOnClickListener { listener(dataSet[position]) }
    }
}