package com.example.gook.domain.model.domainsearchedvolume

import com.example.gook.network.model.networksearchedvolumescontainer.*
data class SearchedVolume(
        val accessInfo: AccessInfo,
        val etag: String = "",
        val id: String = "",
        val kind: String = "",
        val saleInfo: SaleInfo,
        val searchInfo: SearchInfo,
        val selfLink: String = "",
        val volumeInfo: VolumeInfo
)
