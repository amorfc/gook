package com.example.gook.network.model.networksearchedvolumescontainer

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageLinks(
    val smallThumbnail: String = "",
    val thumbnail: String = ""
)