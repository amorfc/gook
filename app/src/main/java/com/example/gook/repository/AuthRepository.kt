package com.example.gook.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gook.R
import com.example.testlogin.ui.login.LoginResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

enum class RegisterStatus { LOADING , DONE , ERROR }

class AuthRepository() {

    private val _authenticatedUser = MutableLiveData<FirebaseUser?>()
    val authenticatedUser: LiveData<FirebaseUser?> = _authenticatedUser

    private val _fireBaseAuthResult = MutableLiveData<LoginResult>()
    val fireBaseAuthResult: LiveData<LoginResult> = _fireBaseAuthResult

    private val _registerStatus = MutableLiveData<RegisterStatus>()
    val registerStatus: LiveData<RegisterStatus> = _registerStatus

    fun registerUser(email: String, password: String){

        _registerStatus.value = RegisterStatus.LOADING

        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { registerResult ->

             if(registerResult.isSuccessful){

                 _fireBaseAuthResult.postValue(LoginResult(success = registerResult.result?.user))
                 _registerStatus.postValue(RegisterStatus.DONE)

             }else{

                 _fireBaseAuthResult.postValue(LoginResult(error = R.string.username_or_password_isNotValid))
                 _registerStatus.postValue(RegisterStatus.ERROR)

             }

            }
    }
}

