package com.example.digitalhousefoods

import android.content.Intent
import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.i
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista_restaurantes.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val fotoRestaurante1 = R.mipmap.splash
        val fotoRestaurante2 = R.mipmap.splash
        val fotoRestaurante3 = R.mipmap.splash
        val fotoRestaurante4 = R.mipmap.splash

        val meusRestaurantes = arrayListOf(
            Restaurante("Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "Fecha às 22:00", fotoRestaurante1),
            Restaurante("Aoyama - Moema","Alameda dos Arapanés, 532 - Moema","Fecha às 00:00", fotoRestaurante2),
            Restaurante("Outback - Moema","Av. Moaci, 187, 187 - Moema, São Paulo","Fecha às 00:00", fotoRestaurante3),
            Restaurante("Sí Señor!","Alameda Jauaperi, 626 - Moema","Fecha às 01:00", fotoRestaurante4)
        )
        val viewAdapter = RestaurantesAdapter(meusRestaurantes){
            var intent = Intent(this@HomeActivity, RestauranteDetalhes::class.java)
            intent.putExtra("NOMERESTAURANTE", it.nome)
            startActivity(intent)
        }
        val viewManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.listaRestaurantes)

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}