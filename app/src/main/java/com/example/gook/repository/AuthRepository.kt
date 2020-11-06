package com.example.gook.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gook.R
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth

enum class RegisterStatus { LOADING , DONE , ERROR }

class AuthRepository() {

    private val _fireBaseAuthResult = MutableLiveData<LoginResult>()
    val fireBaseAuthResult: LiveData<LoginResult> = _fireBaseAuthResult

    private val _registerStatus = MutableLiveData<RegisterStatus>()
    val registerStatus: LiveData<RegisterStatus> = _registerStatus

    fun registerUser(email: String, password: String){

        _registerStatus.value = RegisterStatus.LOADING

        try {

            FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener { registerResult ->

                        if(registerResult.isSuccessful){

                            _fireBaseAuthResult.postValue(LoginResult(success = registerResult.result?.user))
                            _registerStatus.postValue(RegisterStatus.DONE)

                        }else{

                            _fireBaseAuthResult.postValue(LoginResult(error = R.string.username_or_password_isNotValid))
                            _registerStatus.postValue(RegisterStatus.ERROR)
                            Log.i("AuthRepository",registerResult.exception?.message.toString())

                        }

                    }

        }catch (e: FirebaseException){

            Log.i("AuthRepository",e.message.toString())
            _fireBaseAuthResult.postValue(LoginResult(error = R.string.username_or_password_isNotValid))

        }


    }
}

