package com.example.testlogin.ui.login

import com.google.firebase.auth.FirebaseUser

data class LoginResult(val success: FirebaseUser? = null,
                       val error: Int? = null)