package com.example.gook.database

import android.content.Context
import androidx.room.*
import com.example.gook.network.model.networksearchedvolumescontainer.*




@Entity(tableName = "databaseSearchedVolume")
data class DatabaseSearchedVolumeModel constructor(
        @PrimaryKey
        val bookId: String,
        val accessInfo: AccessInfo = AccessInfo(),
        val etag: String,
        val kind: String,
        val saleInfo: SaleInfo = SaleInfo(),
        val searchInfo: SearchInfo = SearchInfo(),
        val selfLink: String,
        val volumeInfo: VolumeInfo = VolumeInfo()
)