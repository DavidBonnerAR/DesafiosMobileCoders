package com.example.myapplication.menu.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.QuadrinhoModel

class MenuViewHolder(view: View): RecyclerView.ViewHolder(view) {
    //private val nomeQuadrinho: TextView = view.findViewById(R.id.txtNomePlaneta)
    private val fotoQuadrinho: ImageView = view.findViewById(R.id.imgQuadrinho)


    fun bind(quadrinhoModel: QuadrinhoModel){
        //nomeQuadrinho.text = quadrinhoModel.nome
        fotoQuadrinho.setImageResource(quadrinhoModel.imagem)
    }
}