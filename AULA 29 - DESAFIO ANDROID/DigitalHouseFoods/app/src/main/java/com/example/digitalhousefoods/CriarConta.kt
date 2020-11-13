package com.example.digitalhousefoods

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_criar_conta.*
import kotlinx.android.synthetic.main.activity_main.*

class CriarConta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_criar_conta)

        findViewById<ImageView>(R.id.imgViewBackRestaurante).setOnClickListener {
            onBackPressed()
        }
        registrarConta()

    }
    private fun registrarConta() {
        btnSignUp.setOnClickListener {

            val nome = editTextCriarNome.editText?.text.toString()
            val email = editTextCriarEmail.editText?.text.toString()
            val senha = editTextCriarSenha.editText?.text.toString()
            val senhaRepetida = editTextCriarSenhaRepetir.editText?.text.toString()


            if (nome.isEmpty()) {
                editTextCriarNome.editText?.error = getString(R.string.empty_field)

            }else if(nome.length < 5) {
                editTextCriarNome.editText?.error = getString(R.string.curto_demais)

            } else if(email.isEmpty()) {
                editTextCriarEmail.editText?.error = getString(R.string.empty_field)

            }else if(email.length <= 10) {
                editTextCriarEmail.editText?.error = getString(R.string.curto_demais)

            }else if(senha.isEmpty() || senha.length < 8) {
                editTextCriarSenha.editText?.error = getString(R.string.empty_field)

            }else if(senha.length < 8) {
                editTextCriarSenha.editText?.error = getString(R.string.curto_demais)

            }else if(!senha.equals(senhaRepetida)) {
                editTextCriarSenhaRepetir.editText?.error = getString(R.string.senhas_diferentes)

            } else {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
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