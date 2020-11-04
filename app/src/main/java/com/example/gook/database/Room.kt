package com.example.gook.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.gook.domain.model.domainsearchedvolume.SearchedVolume

private lateinit var INSTANCE: VolumeDatabase

@Database(entities = [DatabaseSearchedVolumeModel::class],version = 1)
@TypeConverters(RoomConverter::class)
abstract class VolumeDatabase: RoomDatabase(){

    abstract val  searchedVolumeDao: SearchedVolumeDao
    // abstarct val cannot be var anytime this gives as kapt error fckng kapt

}

fun getDatabaseInstance(context: Context): VolumeDatabase{
    synchronized(VolumeDatabase::class.java){

        if (!::INSTANCE.isInitialized){

            INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    VolumeDatabase::class.java,
                    "volumes"
            ).build()
            return INSTANCE
        }
        return INSTANCE
    }
}

@Dao
interface SearchedVolumeDao {

    @Query("select * from databaseSearchedVolume")
    fun getAllSearchedVolume(): LiveData<List<DatabaseSearchedVolumeModel>>

    @Query("DELETE FROM databaseSearchedVolume")
    fun deleteSearchedVolumeHistory()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg searchedVolumes: DatabaseSearchedVolumeModel)
}