package com.example.desafiofirebase

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginFragment : Fragment() {
    private lateinit var mudarTabListener: IMudarTab
    private lateinit var minhaView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        minhaView = inflater.inflate(R.layout.fragment_login, container, false)

        minhaView.findViewById<MaterialButton>(R.id.btnLogin).setOnClickListener {
            if (validaEntradas(minhaView)){
                Toast.makeText(minhaView.context, "Login Realizado", Toast.LENGTH_LONG).show()
            }
        }

        minhaView.findViewById<TextInputEditText>(R.id.editTextUserNameLogin).addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                minhaView.findViewById<TextInputLayout>(R.id.txtUserNameLogin).error = ""
            }
        })

        minhaView.findViewById<TextInputEditText>(R.id.editTextPasswordLogin).addTextChangedListener(object :
            TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                minhaView.findViewById<TextInputLayout>(R.id.txtPasswordLogin).error = ""
            }
        })

        minhaView.findViewById<MaterialButton>(R.id.btnCreateAccount).setOnClickListener {
            mudarTabListener.mudarTab(LOGIN_FRAGMENT)
        }
        return minhaView
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        mudarTabListener = context as IMudarTab
    }

    fun validaEntradas(view: View): Boolean{
        var resultado = true

        val editUserName = view.findViewById<TextInputEditText>(R.id.editTextUserNameLogin)
        val editPassword = view.findViewById<TextInputEditText>(R.id.editTextPasswordLogin)

        if (editUserName.text?.isBlank()!!){
            view.findViewById<TextInputLayout>(R.id.txtUserNameLogin).error = "Username Vazio"
            resultado = false
        }
        if (editPassword.text?.isBlank()!!){
            view.findViewById<TextInputLayout>(R.id.txtPasswordLogin).error = "Senha vazia"
            resultado = false
        }

        return resultado
    }

    fun userNameAlterado(username: String) {
        val editUserName = minhaView.findViewById<TextInputEditText>(R.id.editTextUserNameLogin)
        editUserName.setText(username)
        val editPassword = minhaView.findViewById<TextInputEditText>(R.id.editTextPasswordLogin)
        editPassword.requestFocus()
    }
}