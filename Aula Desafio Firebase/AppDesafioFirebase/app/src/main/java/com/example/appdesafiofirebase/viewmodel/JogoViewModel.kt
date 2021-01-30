package com.example.appdesafiofirebase.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.appdesafiofirebase.model.JogoModel
import com.example.appdesafiofirebase.repository.JogoRepository
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.Dispatchers

class JogoViewModel(private val repository: JogoRepository): ViewModel() {

    private var _gamesBeforeSearch = mutableListOf<JogoModel>()
    private var _games = mutableListOf<JogoModel>()

    fun addUser(userId: String, databse: FirebaseDatabase) = liveData(Dispatchers.IO){
        repository.addUser(userId, databse)
        emit(repository.addUser(userId, databse))
    }

    fun addGame(nome: String, data: String, description: String, imgURL: String, ref: DatabaseReference) = liveData(
        Dispatchers.IO) {
        repository.addGame(ref, JogoModel(nome, data, description, imgURL))
        emit(true)
    }

    fun editGame(nome: String, data: String, description: String, imgURL: String, ref: DatabaseReference, refUser: DatabaseReference) = liveData(
        Dispatchers.IO) {
        repository.editGame(ref, JogoModel(nome, data, description, imgURL), refUser)
        emit(true)
    }

    fun getGames(ref: DatabaseReference, context: Context, list: MutableList<JogoModel>) = liveData(
        Dispatchers.IO){
        val listGames = repository.getGames(ref, context, list)
        _games.addAll(listGames)
        emit(listGames as List<JogoModel>)
    }

    fun initialList() = _gamesBeforeSearch

    fun searchByName(string: String, context: Context, ref: DatabaseReference) = liveData(
        Dispatchers.IO){
        _gamesBeforeSearch = _games
        val response = repository.searchByName(string, ref, _games, context)
        emit(response)
    }


    class GameViewModelFactory(private val repository: JogoRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return JogoViewModel(repository) as T
        }
    }
}