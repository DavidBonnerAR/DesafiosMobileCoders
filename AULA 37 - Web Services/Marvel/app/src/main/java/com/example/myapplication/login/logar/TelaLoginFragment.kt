package com.example.myapplication.login.logar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.main.MainActivity
import kotlinx.android.synthetic.main.fragment_tela_login.*

class TelaLoginFragment : Fragment() {
    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tela_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener {
            /*
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
                val navController = Navigation.findNavController(view)
                navController.navigate(R.id.action_loginFragment_to_menuFragment)
            }
            */
            val navController = Navigation.findNavController(view)
            navController.navigate(R.id.action_loginFragment_to_menuFragment)
        }

        btnCreateAccount.setOnClickListener {
            val navController = Navigation.findNavController(view)
            navController.navigate(R.id.action_loginFragment_to_telaCriarContaFragment)
        }
    }
}