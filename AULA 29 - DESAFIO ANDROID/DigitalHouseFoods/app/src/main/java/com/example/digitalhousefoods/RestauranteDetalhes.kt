package com.example.digitalhousefoods

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RestauranteDetalhes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante_detalhes)

        findViewById<ImageView>(R.id.imgViewBackRestaurante3).setOnClickListener {
            onBackPressed()
        }

        val nome = intent.getStringExtra("NOMERESTAURANTE")
        findViewById<TextView>(R.id.txtRestauranteNomeDetalhes).text = nome

        val listaPratos = arrayListOf(
            Prato("Salada com molho Gengibre ","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
            Prato("Salada com molho Gengibre ","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
            Prato("Salada com molho Gengibre ","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
            Prato("Salada com molho Gengibre ","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
            Prato("Salada com molho Gengibre ","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
            Prato("Salada com molho Gengibre ","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
            Prato("Salada com molho Gengibre ","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
            Prato("Salada com molho Gengibre ","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
            Prato("Salada com molho Gengibre ","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
            Prato("Salada com molho Gengibre ","Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.")
        )

        val viewAdapter = RestauranteDetalhesAdapter(listaPratos){
            var intent = Intent(this@RestauranteDetalhes, PratoDetalhes::class.java)
            intent.putExtra("NOMEPRATO", it.nome)
            intent.putExtra("DESCRICAOPRATO", it.descricao)
            startActivity(intent)
        }
        val viewManager = GridLayoutManager(this, 2)
        val recyclerView = findViewById<RecyclerView>(R.id.listaPratos)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}