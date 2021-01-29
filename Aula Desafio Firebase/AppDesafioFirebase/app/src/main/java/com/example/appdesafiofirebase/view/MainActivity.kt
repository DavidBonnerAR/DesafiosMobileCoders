package com.example.appdesafiofirebase.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appdesafiofirebase.Adapter
import com.example.appdesafiofirebase.Jogo
import com.example.appdesafiofirebase.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img = getDrawable(R.drawable.kratos)

        val listaJogos = arrayListOf(
            Jogo("GOW", "2020", img!!),
            Jogo("GOW", "2021", img!!),
            Jogo("GOW", "2022", img!!),
            Jogo("GOW", "2023", img!!),
            Jogo("GOW", "2024", img!!),
            Jogo("GOW", "2025", img!!),
            Jogo("GOW", "2026", img!!),
            Jogo("GOW", "2027", img!!)
        )

        val viewManager = GridLayoutManager(this, 2)
        val recyclerView = findViewById<RecyclerView>(R.id.listaJogos)

        val viewAdapter = Adapter(listaJogos) {
            val intent = Intent(this, DetalhesJogoActivity::class.java)
            startActivity(intent)
        }

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        btnAdicionarJogo.setOnClickListener {
            val intent = Intent(this, AdicionarJogoActivity::class.java)
            startActivity(intent)
        }
    }
}