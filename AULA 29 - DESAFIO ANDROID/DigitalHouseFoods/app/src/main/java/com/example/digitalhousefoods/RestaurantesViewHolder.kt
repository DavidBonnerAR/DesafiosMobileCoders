package com.example.digitalhousefoods

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val nome: TextView = view.findViewById(R.id.txtNomeRestaurante)
    private val localizacao: TextView = view.findViewById(R.id.txtLocalizacaoRestaurante)
    private val horario: TextView = view.findViewById(R.id.txtHorarioRestaurante)

    fun bind(nomeRestaurante: String, localizacaoRestaurante: String, horarioRestaurante: String){
        nome.text = nomeRestaurante
        localizacao.text = localizacaoRestaurante
        horario.text = horarioRestaurante
    }
}