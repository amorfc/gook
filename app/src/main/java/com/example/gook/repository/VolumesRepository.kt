package com.example.gook.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.gook.domain.model.domainsearchedvolume.SearchedVolume
import com.example.gook.network.Network
import com.example.gook.network.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VolumesRepository() {

    val _seachedVolumeList = MutableLiveData<List<SearchedVolume>>()
    val  searchedVolumeModelList: LiveData<List<SearchedVolume>>
        get() = _seachedVolumeList

    suspend fun getSearchedVolumes(query: String){
        withContext(Dispatchers.IO){

            val searchedVolumeResult = Network.googleBookApi.getSearchedVolumes(query).await()
            _seachedVolumeList.postValue(searchedVolumeResult.asDomainModel())
//            database.searchedVolumeDao.insertAll(*searchedVolumeResult.asDatabaseModel())
        }
    }

}