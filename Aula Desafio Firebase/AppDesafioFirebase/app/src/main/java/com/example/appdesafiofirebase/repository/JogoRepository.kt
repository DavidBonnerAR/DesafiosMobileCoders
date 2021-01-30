package com.example.appdesafiofirebase.repository

import android.content.Context
import android.widget.Toast
import com.example.appdesafiofirebase.model.JogoModel
import com.google.firebase.database.*
import kotlinx.coroutines.delay
import java.util.*

class JogoRepository {
    fun addGame(ref: DatabaseReference, gameModel: JogoModel) {
        val path = gameModel.nome.toLowerCase(Locale.ROOT) + "_" + gameModel.ano
        val newGame = ref.child(path)
        newGame.setValue(gameModel)
    }

    fun editGame(ref: DatabaseReference, gameModel: JogoModel, refUser: DatabaseReference){
        ref.removeValue()
        addGame(refUser, gameModel)
    }

    suspend fun getGames(
        ref: DatabaseReference,
        context: Context,
        list: MutableList<JogoModel>
    ): MutableList<JogoModel> {

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list.clear()
                for (dataSnapshot1 in dataSnapshot.children) {
                    val game: JogoModel? = dataSnapshot1.getValue(JogoModel::class.java)
                    list.add(game!!)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Erro na lista", Toast.LENGTH_SHORT).show()
            }
        })
        delay(1500)
        return list
    }

    fun addUser(userId: String, databse: FirebaseDatabase): DatabaseReference {
        return databse.getReference(userId)
    }

    suspend fun searchByName(nome: String, ref: DatabaseReference, list: MutableList<JogoModel>, context: Context): MutableList<JogoModel> {
        val queryCamp = "nome"

        val query = ref.child(nome.toLowerCase(Locale.ROOT)).orderByChild(queryCamp).equalTo(nome.toLowerCase(
            Locale.ROOT))

        query.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                list.clear()
                for (dataSnapshot1 in snapshot.children) {
                    val game: JogoModel? = dataSnapshot1.getValue(JogoModel::class.java)
                    list.add(game!!)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Erro na lista", Toast.LENGTH_SHORT).show()
            }
        })
        delay(1500)
        return list
    }
}