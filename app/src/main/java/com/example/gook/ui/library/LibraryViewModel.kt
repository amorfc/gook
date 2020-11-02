package com.example.gook.ui.library

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gook.network.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

class LibraryViewModel(val app: Application) : ViewModel() {

    val viewModelJob = Job()
    val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        viewModelScope.launch {

            val test = Network.googleBookApi.getVolume("s1gVAAAAYAAJ").await()
            Timber.i(test.toString())
        }
    }

    open class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LibraryViewModel::class.java)) {
                return LibraryViewModel(app) as T
            } else {
                throw IllegalArgumentException("ViewModel is not assignable")
            }
        }
    }
}