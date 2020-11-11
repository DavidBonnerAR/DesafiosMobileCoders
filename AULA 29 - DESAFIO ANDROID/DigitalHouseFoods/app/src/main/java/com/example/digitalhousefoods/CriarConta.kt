package com.example.digitalhousefoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_criar_conta.*
import kotlinx.android.synthetic.main.activity_main.*

class CriarConta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_conta)

        checkCerteza.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "Checkbox funciona", Toast.LENGTH_SHORT).show()
            btnSignUp.isEnabled = true
        }

        btnSignUp.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        btnVoltarLogIn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}