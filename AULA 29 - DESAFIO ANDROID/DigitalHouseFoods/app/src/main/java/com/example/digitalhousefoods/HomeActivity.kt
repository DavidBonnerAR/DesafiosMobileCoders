package com.example.digitalhousefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val meusRestaurantes = arrayListOf(
            Restaurantes("Corujão Lanches"),
            Restaurantes("Regis Lanches"),
            Restaurantes("Xerifes Burguer"),
            Restaurantes("Cabana do Sol")
        )
        val viewAdapter = RestaurantesAdapter(meusRestaurantes){
            var intent = Intent(this@HomeActivity, RestauranteDetalhes::class.java)
            intent.putExtra("NOME", it.nome)
            startActivity(intent)
        }
        val viewManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.listaRestaurantes)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.HORIZONTAL))
        }
    }
}