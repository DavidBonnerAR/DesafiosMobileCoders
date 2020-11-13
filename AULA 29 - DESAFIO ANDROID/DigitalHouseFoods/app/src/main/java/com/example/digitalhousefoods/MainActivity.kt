package com.example.digitalhousefoods

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fazerLogin()
        criarConta()

    }

    private fun criarConta() {
        btnCreateAccount.setOnClickListener {
            val intent = Intent(this, CriarConta::class.java)
            startActivity(intent)
        }
    }

    private fun fazerLogin() {

        btnLogin.setOnClickListener {
            val email = editTextEmail.editText?.text.toString()
            val senha = editTextSenha.editText?.text.toString()


            if (email.isEmpty()) {
                editTextEmail.editText?.error = getString(R.string.empty_field)

            } else if(email.length <= 10) {
                editTextEmail.editText?.error = getString(R.string.curto_demais)

            } else if(senha.isEmpty()) {
                editTextSenha.editText?.error = getString(R.string.empty_field)

            }else if(senha.length < 8) {
                editTextSenha.editText?.error = getString(R.string.curto_demais)

            } else {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    //função para ocultar teclado com toque na tela
    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val v: View? = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    v.clearFocus()
                    val imm: InputMethodManager =
                        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

}