package com.example.gook.network.model.networksearchedvolumescontainer

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SaleInfo(
        val buyLink: String = "",
        val country: String = "",
        val isEbook: Boolean = false,
        val listPrice: ListPrice = ListPrice(),
        val offers: List<Offer> = listOf(),
        val retailPrice: RetailPrice = RetailPrice(),
        val saleability: String = ""
)