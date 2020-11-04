package com.example.gook.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.gook.database.VolumeDatabase
import com.example.gook.domain.model.domainsearchedvolume.SearchedVolume
import com.example.gook.network.Network
import com.example.gook.network.asDatabaseModel
import com.example.gook.network.asDomainModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VolumesRepository(val database: VolumeDatabase) {

    val  searchedVolumeModelList: LiveData<List<SearchedVolume>> = Transformations.map(database.searchedVolumeDao.getAllSearchedVolume()){
    it.asDomainModel()
}

    suspend fun getSearchedVolumes(query: String){
        withContext(Dispatchers.IO){

            val searchedVolumeResult = Network.googleBookApi.getSearchedVolumes(query).await()
            database.searchedVolumeDao.deleteSearchedVolumeHistory()
            database.searchedVolumeDao.insertAll(*searchedVolumeResult.asDatabaseModel())
        }
    }

}