package com.example.appdesafiofirebase.view.listajogosview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.appdesafiofirebase.view.adapter.JogoAdapter
import com.example.appdesafiofirebase.model.JogoModel
import com.example.appdesafiofirebase.R
import com.example.appdesafiofirebase.repository.JogoRepository
import com.example.appdesafiofirebase.view.adicionarjogoview.AdicionarJogoActivity
import com.example.appdesafiofirebase.view.detalhesjogoview.DetalhesJogoActivity
import com.example.appdesafiofirebase.view.salvarjogoview.SalvarJogoActivity
import com.example.appdesafiofirebase.viewmodel.JogoViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val searchView: SearchView by lazy { findViewById<SearchView>(R.id.txtSearchGames) }
    private val swipeRefreshLayout: SwipeRefreshLayout by lazy { findViewById<SwipeRefreshLayout>(R.id.swipeToRefresh) }

    private val recyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.listaJogos) }
    private val btnNewGame: FloatingActionButton by lazy { findViewById<FloatingActionButton>(R.id.btnAdicionarJogo) }

    private lateinit var _gameListAdapter: JogoAdapter
    private lateinit var _viewModel: JogoViewModel

    private lateinit var ref: DatabaseReference
    private var databse = FirebaseDatabase.getInstance()
    private lateinit var auth: FirebaseAuth

    private val _gameList = mutableListOf<JogoModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth
        ref = databse.getReference(auth.currentUser!!.uid)

        val manager = GridLayoutManager(this, 2)

        viewModelProvider()
        load()
        setUpNavigation()
        setUpRecyclerView(recyclerView, manager)
        getGames(ref, this, _gameList)


        btnNewGame.setOnClickListener {
            val intent = Intent(this,   SalvarJogoActivity::class.java)
            startActivity(intent)
        }


    }


    private fun load() {
        swipeRefreshLayout.setOnRefreshListener {
            SwipeRefreshLayout.OnRefreshListener {
                _gameList.clear()
            }
            getGames(ref, this@MainActivity, _gameList)
            swipeRefreshLayout.isRefreshing = false
            _gameListAdapter.notifyDataSetChanged()
        }
    }


    private fun getGames(ref: DatabaseReference, context: Context, list: List<JogoModel>) {
        _viewModel.getGames(ref, context, _gameList).observe(this) {
            list.let {_gameList.addAll(it)}
            _gameListAdapter.notifyDataSetChanged()
        }
    }

    private fun setUpRecyclerView(
        recyclerView: RecyclerView,
        viewLayoutManager: GridLayoutManager
    ) {
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewLayoutManager
            adapter = _gameListAdapter
        }
    }

    private fun setUpNavigation() {
        _gameListAdapter = JogoAdapter(_gameList) {
            val intent = Intent(this@MainActivity, DetalhesJogoActivity::class.java)
            intent.putExtra("NAME", it.nome)
            intent.putExtra("LANCAMENTO", it.ano)
            intent.putExtra("DESCRICAO", it.descricao)
            intent.putExtra("IMG_URL", it.image)
            startActivity(intent)
        }
    }

    private fun viewModelProvider() {
        _viewModel =
            ViewModelProvider(this, JogoViewModel.GameViewModelFactory(JogoRepository())).get(
                JogoViewModel::class.java
            )
    }

    private fun searchByName(){
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                _viewModel.searchByName(query!!, this@MainActivity, ref).observe(this@MainActivity) {
                    _gameList.clear()
                    getGames(ref, this@MainActivity, it)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if(newText.isNullOrEmpty()){
                    _gameList.clear()
                    getGames(ref, this@MainActivity, _viewModel.initialList())
                }
                return false
            }
        })
    }
}