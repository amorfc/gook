package com.example.gook.network.model.networksearchedvolumescontainer

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkSearchedVolume(
        val accessInfo: AccessInfo = AccessInfo(),
        val etag: String = "",
        val id: String = "",
        val kind: String = "",
        val saleInfo: SaleInfo = SaleInfo(),
        val searchInfo: SearchInfo = SearchInfo(),
        val selfLink: String = "",
        val volumeInfo: VolumeInfo = VolumeInfo()
)