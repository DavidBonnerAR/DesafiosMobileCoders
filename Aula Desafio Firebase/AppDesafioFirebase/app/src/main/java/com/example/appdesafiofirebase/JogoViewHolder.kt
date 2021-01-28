package com.example.appdesafiofirebase

import android.media.Image
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JogoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val nome: TextView = view.findViewById(R.id.txtNomeJogo)
    private val ano: TextView = view.findViewById(R.id.txtAnoJogo)
    private val imagem: ImageView = view.findViewById(R.id.imgJogo)

    fun bind(nomeJogo: String, anoJogo: String, imgJogo: Image){
        nome.text = nomeJogo
        ano.text = anoJogo
        imagem.drawable = imgJogo
    }
}