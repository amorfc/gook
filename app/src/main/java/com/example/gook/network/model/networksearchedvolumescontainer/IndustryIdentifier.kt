package com.example.gook.network.model.networksearchedvolumescontainer

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IndustryIdentifier(@JsonClass(generateAdapter = true)

                              val identifier: String = "",
    val type: String = ""
)