package com.example.gook.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gook.database.VolumeDatabase
import com.example.gook.database.getDatabaseInstance
import com.example.gook.domain.model.domainsearchedvolume.SearchedVolume
import com.example.gook.repository.VolumesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class SearchViewModel(val app: Application) : ViewModel() {
    // TODO: Implement the ViewModel

    val viewModelJob = Job()
    val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    val database: VolumeDatabase = getDatabaseInstance(app)
    val volumesRepository = VolumesRepository(database)

    val searchedVolumeList: LiveData<List<SearchedVolume>> = volumesRepository.searchedVolumeModelList

    fun getSearchedVolumes(query: String){
        viewModelScope.launch {

            volumesRepository.getSearchedVolumes(query = query)
        }
    }

    class Factory(private val application: Application): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(SearchViewModel::class.java)){
                return SearchViewModel(application) as T
            }else{
                throw IllegalArgumentException("View model is not assignable")
            }
        }
    }
}