package com.example.digitalhousefoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PratoDetalhes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prato_detalhes)

        val nome = intent.getStringExtra("NOMEPRATO")
        findViewById<TextView>(R.id.txtPratoNomeDetalhes).text = nome
    }
}