package com.example.gook.network.model.networksearchedvolumescontainer

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkSearchedVolumesConatiner(
        val items: List<NetworkSearchedVolume> = listOf(),
        val kind: String = "",
        val totalItems: Int = 0
)