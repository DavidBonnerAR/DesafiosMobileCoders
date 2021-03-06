package com.example.digitalhousefoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class PratoDetalhes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prato_detalhes)

        findViewById<ImageView>(R.id.imgViewBackRestaurante2).setOnClickListener {
            onBackPressed()
        }

        val nome = intent.getStringExtra("NOMEPRATO")
        val descricao = intent.getStringExtra("DESCRICAOPRATO")
        findViewById<TextView>(R.id.txtPratoNomeDetalhes).text = nome
        findViewById<TextView>(R.id.txtPratoDescricaoDetalhes).text = descricao
    }
}