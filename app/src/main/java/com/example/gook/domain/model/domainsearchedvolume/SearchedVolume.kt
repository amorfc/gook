package com.example.gook.domain.model.domainsearchedvolume

data class SearchedVolume(
        val accessInfo: com.example.gook.network.model.networksearchedvolumescontainer.AccessInfo,
        val etag: String = "",
        val id: String = "",
        val kind: String = "",
        val saleInfo: com.example.gook.network.model.networksearchedvolumescontainer.SaleInfo,
        val searchInfo: com.example.gook.network.model.networksearchedvolumescontainer.SearchInfo,
        val selfLink: String = "",
        val volumeInfo: com.example.gook.network.model.networksearchedvolumescontainer.VolumeInfo
)