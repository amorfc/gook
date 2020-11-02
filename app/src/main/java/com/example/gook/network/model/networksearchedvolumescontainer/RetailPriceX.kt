package com.example.gook.network.model.networksearchedvolumescontainer

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RetailPriceX(
    val amount: Double = 0.0,
    val currencyCode: String = ""
)