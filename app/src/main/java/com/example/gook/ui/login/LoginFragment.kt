package com.example.gook.ui.login

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.gook.R
import com.example.gook.databinding.LoginFragmentBinding
import com.example.gook.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.library_fragment.*
import kotlinx.android.synthetic.main.login_fragment.*
import kotlin.math.log


class LoginFragment : Fragment() {


    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding
    private lateinit var emailText:EditText
    private lateinit var passwordText:EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.login_fragment,container,false)
        emailText = binding.editTextEmail
        passwordText = binding.editTextPassword

        emailText.doAfterTextChanged {
            viewModel.registerValidation(
                it.toString(),
                passwordText.text.toString())
        }

        passwordText.doAfterTextChanged {
                viewModel.registerValidation(
                    emailText.text.toString(),
                    it.toString())
        }

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.fireBaseAuthResult.observe(viewLifecycleOwner, Observer {

            if (it.success != null){

                updateUiForLoggedInUser(it.success)

            }else if(it.error != null)
                showLoginFailed(it.error)

        })

        viewModel.loginFormState.observe(viewLifecycleOwner, Observer { loginFromState ->

            binding.registerButton.isEnabled = loginFromState.isDataValid

            if (loginFromState.usernameError != null) {

                emailText.error = getString(loginFromState.usernameError)

            } else if (loginFromState.passwordError != null) {

                passwordText.error = getString(loginFromState.passwordError)

            }

        })
    }
    private fun updateUiForLoggedInUser(loggedUser: FirebaseUser) {
        this.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToSearchFragment())
    }

    private fun showLoginFailed(error: Int) {
        Toast.makeText(context,error, Toast.LENGTH_LONG).show()
    }
}