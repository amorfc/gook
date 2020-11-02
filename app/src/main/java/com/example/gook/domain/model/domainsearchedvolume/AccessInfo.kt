package com.example.gook.domain.model.domainsearchedvolume

data class AccessInfo(
    val accessViewStatus: String = "",
    val country: String = "",
    val embeddable: Boolean = false,
    val epub: Epub = Epub(),
    val pdf: Pdf = Pdf(),
    val publicDomain: Boolean = false,
    val quoteSharingAllowed: Boolean = false,
    val textToSpeechPermission: String = "",
    val viewability: String = "",
    val webReaderLink: String = ""
)