package com.example.gook.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gook.domain.model.domainsearchedvolume.SearchedVolume


@Dao
interface SearchedVolumeDao {

    @Query("select * from databaseSearchedVolume")
    fun getSearchedVolume(): LiveData<List<DatabaseSearchedVolumeModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg searchedVolumes: DatabaseSearchedVolumeModel)
}