package com.example.appdesafiofirebase.view.detalhesjogoview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.appdesafiofirebase.R
import com.example.appdesafiofirebase.view.adicionarjogoview.AdicionarJogoActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class DetalhesJogoActivity : AppCompatActivity() {

    private val btnEditarJogo: FloatingActionButton by lazy { findViewById<FloatingActionButton>(R.id.btnEditarJogo) }
    private val imgJogoDetalhes: ImageView by lazy { findViewById<ImageView>(R.id.imgJogoDetalhes) }
    private val nomeDetalhes: TextView by lazy { findViewById<TextView>(R.id.txtNomeJogoDetalhes) }
    private val nomeDetalhes2: TextView by lazy { findViewById<TextView>(R.id.txtNomeJogoDetalhes2) }
    private val anoDetalhes: TextView by lazy { findViewById<TextView>(R.id.txtAnoJogoDetalhes) }
    private val descricaoDetalhes: TextView by lazy { findViewById<TextView>(R.id.txtDescricaoDetalhes) }

    private lateinit var imgUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_jogo)

        val nome = intent.getStringExtra("NAME")
        val descricao = intent.getStringExtra("DESCRICAO")
        val data = intent.getStringExtra("LANCAMENTO")
        imgUrl = intent.getStringExtra("IMG_URL")!!

        btnEditarJogo.setOnClickListener {
            getGame(nome, data, descricao)
        }

        nomeDetalhes.text = nome
        nomeDetalhes2.text = nome
        anoDetalhes.text = data
        descricaoDetalhes.text = descricao
        Picasso.get().load(imgUrl).into(imgJogoDetalhes)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun getGame(nome: String?, data: String?, descricao: String?){
        val intent = Intent(this, AdicionarJogoActivity::class.java)
        intent.putExtra("NAMEA", nome)
        intent.putExtra("LANCAMENTOA", data)
        intent.putExtra("DESCRICAOA", descricao)
        intent.putExtra("URL", imgUrl)
        startActivity(intent)
        finish()
    }
}