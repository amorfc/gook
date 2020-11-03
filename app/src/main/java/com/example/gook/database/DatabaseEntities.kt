package com.example.gook.database

import android.content.Context
import androidx.room.*
import com.example.gook.network.model.networksearchedvolumescontainer.*

private lateinit var INSTANCE: VolumeDatabase

@Database(entities = [DatabaseSearchedVolumeModel::class],version = 1)
abstract class VolumeDatabase: RoomDatabase(){

        abstract var  searchedVolumeDao: SearchedVolumeDao

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


@Entity(tableName = "databaseSearchedVolume")
data class DatabaseSearchedVolumeModel(
        @PrimaryKey
        val bookId: String = "",
        val accessInfo: AccessInfo = AccessInfo(),
        val etag: String = "",
        val kind: String = "",
        val saleInfo: SaleInfo = SaleInfo(),
        val searchInfo: SearchInfo = SearchInfo(),
        val selfLink: String = "",
        val volumeInfo: VolumeInfo = VolumeInfo()
)