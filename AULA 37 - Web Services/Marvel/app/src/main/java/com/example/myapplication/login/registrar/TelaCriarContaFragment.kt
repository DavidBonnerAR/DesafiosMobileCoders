package com.example.myapplication.login.registrar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.main.MainActivity
import kotlinx.android.synthetic.main.fragment_tela_criar_conta.*


class TelaCriarContaFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_tela_criar_conta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSignUp.setOnClickListener {
            /*
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
                val navController = Navigation.findNavController(view)
                navController.navigate(R.id.action_loginFragment_to_menuFragment)
            }
            */
            val navController = Navigation.findNavController(view)
            navController.navigate(R.id.action_telaCriarContaFragment_to_menuFragment)

        }
    }
}