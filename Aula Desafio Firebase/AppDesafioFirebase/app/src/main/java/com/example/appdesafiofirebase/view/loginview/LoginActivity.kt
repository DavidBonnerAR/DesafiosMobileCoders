package com.example.appdesafiofirebase.view.loginview

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.appdesafiofirebase.Constantes
import com.example.appdesafiofirebase.R
import com.example.appdesafiofirebase.view.listajogosview.MainActivity
import com.example.appdesafiofirebase.view.createaccountview.CreateAccountActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val btnCreateAccount: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnCreateAccount) }
    private val btnLogin: MaterialButton by lazy { findViewById<MaterialButton>(R.id.btnLogin) }
    private val etEmail: TextInputEditText by lazy { findViewById<TextInputEditText>(R.id.editTextUserEmailLogin) }
    private val etSenha: TextInputEditText by lazy { findViewById<TextInputEditText>(R.id.editTextPasswordLogin) }
    private val checkBox: CheckBox by lazy { findViewById<CheckBox>(R.id.cbRemember) }

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()

        auth = Firebase.auth

        val prefs = getSharedPreferences(Constantes.APP_NAME, MODE_PRIVATE)
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean(Constantes.NOTIFICATION_PREFS, isChecked).apply()
        }

        btnCreateAccount.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val senha = etSenha.text.toString()
            login(email, senha)
        }
    }

    private fun validaCampos(email: String, senha: String): Boolean {
        return when {
            email.isEmpty() -> {
                etEmail.error = Constantes.ERRO_VAZIO
                false
            }
            senha.isEmpty() -> {
                etSenha.error = Constantes.ERRO_VAZIO
                false
            }
            else -> {
                true
            }
        }
    }

    private fun autenticarUsuario(email: String, senha: String) {
        auth.signInWithEmailAndPassword(email, senha).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser
                if (user!!.isEmailVerified) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else Toast.makeText(baseContext, "Valide seu email", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(baseContext, "Email e/ou senha incorretos", Toast.LENGTH_SHORT)
                    .show()
                etEmail.text!!.clear()
                etSenha.text!!.clear()
            }
        }
    }

    private fun login(email: String, senha: String) {
        if (validaCampos(email, senha)) {
            autenticarUsuario(email, senha)
        }
    }
}