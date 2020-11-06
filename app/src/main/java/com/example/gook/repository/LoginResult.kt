package com.example.gook.repository

import com.google.firebase.auth.FirebaseUser

data class LoginResult(val success: FirebaseUser? = null,
                       val error: Int? = null)