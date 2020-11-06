package com.example.gook.viewmodel

import android.service.autofill.RegexValidator
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gook.R
import com.example.gook.repository.AuthRepository
import com.example.gook.repository.RegisterStatus
import com.example.gook.ui.login.Form
import com.example.testlogin.ui.login.LoginFormState
import com.example.testlogin.ui.login.LoginResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class LoginViewModel : ViewModel() {

    private val _form = MutableLiveData<Form>()
    val form: LiveData<Form> = _form


    private val authRepository = AuthRepository()

    val registerStatus: LiveData<RegisterStatus> = authRepository.registerStatus
    val fireBaseAuthResult: LiveData<LoginResult> = authRepository.fireBaseAuthResult

    private val _loginFormState = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginFormState


    fun registerUser(email: String, password: String) {

            authRepository.registerUser(email,password)

    }

    fun registerValidation(username: String,password: String) {

        if(!isUserNameValid(username)){

            _loginFormState.value = LoginFormState(usernameError = R.string.user_name_is_not_valid)

        }else if(!isPasswordValid(password)){

            _loginFormState.value = LoginFormState(passwordError = R.string.password_is_not_valid)

        }else{

            _loginFormState.value = LoginFormState(isDataValid = true)
            _form.value = Form(username,password)
        }

    }

    private fun isUserNameValid(email: String):Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean{
        return password.length > 5
    }
}

