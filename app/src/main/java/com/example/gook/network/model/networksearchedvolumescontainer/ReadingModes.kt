package com.example.gook.network.model.networksearchedvolumescontainer

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReadingModes(
    val image: Boolean = false,
    val text: Boolean = false
)