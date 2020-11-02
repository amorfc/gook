package com.example.gook.domain.model.domainsearchedvolume

data class Offer(
    val finskyOfferType: Int = 0,
    val listPrice: ListPrice = ListPrice(),
    val retailPrice: RetailPrice = RetailPrice()
)