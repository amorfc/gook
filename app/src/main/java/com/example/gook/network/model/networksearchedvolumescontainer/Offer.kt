package com.example.gook.network.model.networksearchedvolumescontainer

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Offer(
        val finskyOfferType: Int = 0,
        val listPrice: ListPrice = ListPrice(),
        val retailPrice: RetailPrice = RetailPrice()
)