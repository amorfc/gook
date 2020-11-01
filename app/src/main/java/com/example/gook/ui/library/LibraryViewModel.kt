package com.example.gook.ui.library

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LibraryViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    open class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LibraryViewModel::class.java)) {
                return LibraryViewModel() as T
            } else {
                throw IllegalArgumentException("ViewModel is not assignable")
            }
        }
    }
}