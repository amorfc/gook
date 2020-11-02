package com.example.gook.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gook.network.model.networksearchedvolumescontainer.NetworkSearchedVolume

class VolumesRepository() {

    private val _searchedVolumes = MutableLiveData<List<NetworkSearchedVolume>>()
    val searchedVolume: LiveData<List<NetworkSearchedVolume>>
        get() = _searchedVolumes

    suspend fun getSearchedVolumes(query: String){



    }

}