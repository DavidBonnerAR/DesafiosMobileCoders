package com.example.digitalhousefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RestauranteDetalhes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante_detalhes)

        val nome = intent.getStringExtra("NOMERESTAURANTE")
        findViewById<TextView>(R.id.txtRestauranteNomeDetalhes).text = nome

        val meusPratos = arrayListOf(
            Prato("Xtudo"),
            Prato("XBurguer"),
            Prato("Xbacon"),
            Prato("Xsalada"),
            Prato("Xsalada"),
            Prato("Xsalada"),
            Prato("Xsalada"),
            Prato("Xsalada"),
            Prato("Xsalada"),
            Prato("Xsalada")
        )
        val viewAdapter = RestauranteDetalhesAdapter(meusPratos){
            var intent = Intent(this@RestauranteDetalhes, PratoDetalhes::class.java)
            intent.putExtra("NOMEPRATO", it.nome)
            startActivity(intent)
        }
        val viewManager = GridLayoutManager(this, 2)
        val recyclerView = findViewById<RecyclerView>(R.id.listaPratos)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
        }
    }
}