package com.example.appdesafiofirebase.view.adapter

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appdesafiofirebase.R
import com.example.appdesafiofirebase.model.JogoModel
import com.squareup.picasso.Picasso

class JogoViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val imgGame = view.findViewById<ImageView>(R.id.imgJogo)
    private val nomeGame = view.findViewById<TextView>(R.id.txtNomeJogo)
    private val dataGame = view.findViewById<TextView>(R.id.txtAnoJogo)

    fun bind(gameModel: JogoModel) {
        nomeGame.text = gameModel.nome
        dataGame.text = gameModel.ano
        Picasso.get().load(gameModel.image).into(imgGame)
    }
}