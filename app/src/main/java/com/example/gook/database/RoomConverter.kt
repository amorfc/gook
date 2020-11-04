package com.example.gook.database

import androidx.room.TypeConverter
import com.example.gook.network.model.networksearchedvolumescontainer.*
import com.google.gson.Gson

class RoomConverter {
    @TypeConverter
    fun fromAccessInfo(accessInfo: AccessInfo): String = Gson().toJson(accessInfo)

    @TypeConverter
    fun toAccessInfo(accessInfoString: String): AccessInfo = Gson().fromJson(accessInfoString,AccessInfo::class.java)

    @TypeConverter
    fun fromSaleInfo(saleInfo: SaleInfo): String = Gson().toJson(saleInfo)

    @TypeConverter
    fun toSaleInfo(saleInfoS: String): SaleInfo = Gson().fromJson(saleInfoS, SaleInfo::class.java)

    @TypeConverter
    fun fromSearchInfo(searchInfo: SearchInfo): String = Gson().toJson(searchInfo)

    @TypeConverter
    fun toSearchInfo(searchInfoS: String): SearchInfo = Gson().fromJson(searchInfoS, SearchInfo::class.java)

    @TypeConverter
    fun fromVolumeInfo(volumeInfo: VolumeInfo): String = Gson().toJson(volumeInfo)

    @TypeConverter
    fun toVolumeInfo(volumeInfoS: String): VolumeInfo = Gson().fromJson(volumeInfoS, VolumeInfo::class.java)
}