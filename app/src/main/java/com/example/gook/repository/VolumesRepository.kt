package com.example.gook.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.gook.domain.model.domainsearchedvolume.SearchedVolume
import com.example.gook.network.Network
import com.example.gook.network.asDomainModel
import com.example.gook.network.model.networksearchedvolumescontainer.NetworkSearchedVolume
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VolumesRepository() {

    private val _searchedVolumes = MutableLiveData<List<SearchedVolume>>()
    val searchedVolume: LiveData<List<SearchedVolume>>
        get() = _searchedVolumes

    suspend fun getSearchedVolumes(query: String){
        withContext(Dispatchers.Main){

            val searchedVolumeResult = Network.googleBookApi.getSearchedVolumes(query).await()

            _searchedVolumes.value = searchedVolumeResult.asDomainModel()

        }

    }

}