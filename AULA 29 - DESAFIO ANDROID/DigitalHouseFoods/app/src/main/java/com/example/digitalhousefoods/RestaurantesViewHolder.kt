package com.example.digitalhousefoods

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RestaurantesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val nome: TextView = view.findViewById(R.id.txtNomeRestaurante)
    private val localizacao: TextView = view.findViewById(R.id.txtLocalizacaoRestaurante)
    private val horario: TextView = view.findViewById(R.id.txtHorarioRestaurante)
    private val imagem: ImageView = view.findViewById(R.id.imgFotoRestaurante)

    fun bind(restaurante: Restaurante){
        nome.text = restaurante.nome
        localizacao.text = restaurante.localizacao
        horario.text = restaurante.horario
        imagem.setImageResource(restaurante.imagem)

    }
}