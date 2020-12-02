package com.example.myapplication.menu

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.menu.adapter.MenuAdapter
import com.example.myapplication.model.QuadrinhoModel

class MenuFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fotoQuadrinhoUm = R.drawable.marvel

        val recyclerView = view.findViewById<RecyclerView>(R.id.listaQuadrinhos)
        var GridManager = GridLayoutManager(view.context, 3)
        recyclerView.apply{

            setHasFixedSize(true)

            layoutManager = GridManager

            adapter = MenuAdapter(
                listOf(
                QuadrinhoModel("Miranha", fotoQuadrinhoUm),
                QuadrinhoModel("Miranha", fotoQuadrinhoUm),
                QuadrinhoModel("Miranha", fotoQuadrinhoUm),
                QuadrinhoModel("Miranha", fotoQuadrinhoUm)
                )
            ){
                val navController = Navigation.findNavController(view)
                navController.navigate(R.id.action_menuFragment_to_detalhesQuadrinhosFragment)
            }
        }
    }
}