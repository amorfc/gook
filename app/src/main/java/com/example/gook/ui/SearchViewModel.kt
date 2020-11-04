package com.example.gook.ui

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gook.domain.model.domainsearchedvolume.SearchedVolume
import com.example.gook.repository.VolumesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

enum class SearchedStatus { LOADING , DONE , ERROR}

class SearchViewModel(val app: Application) : ViewModel() {
    // TODO: Implement the ViewModel

    val viewModelJob = Job()
    val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)
//    val database: VolumeDatabase = getDatabaseInstance(app)
    val volumesRepository = VolumesRepository()

    val _searchedStatus = MutableLiveData<SearchedStatus?>()
    val searchedStatus: LiveData<SearchedStatus?>
        get() = _searchedStatus

    val searchedVolumeList: LiveData<List<SearchedVolume>> = volumesRepository.searchedVolumeModelList

    fun getSearchedVolumes(query: String){
        viewModelScope.launch {

            try {
                _searchedStatus.value = SearchedStatus.LOADING
                volumesRepository.getSearchedVolumes(query = query)
                _searchedStatus.value = SearchedStatus.DONE
            }catch (t: Throwable){
                _searchedStatus.value = SearchedStatus.ERROR
                throw t
            }
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