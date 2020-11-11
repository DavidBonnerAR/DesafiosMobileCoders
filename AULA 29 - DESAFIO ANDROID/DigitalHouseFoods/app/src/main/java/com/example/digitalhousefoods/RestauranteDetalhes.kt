package com.example.digitalhousefoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RestauranteDetalhes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante_detalhes)

        val nome = intent.getStringExtra("NOME")

        findViewById<TextView>(R.id.txtRestauranteNomeDetalhes).text = nome
    }
}