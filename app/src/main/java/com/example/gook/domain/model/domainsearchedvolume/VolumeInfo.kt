package com.example.gook.domain.model.domainsearchedvolume

data class VolumeInfo(
    val allowAnonLogging: Boolean = false,
    val authors: List<String> = listOf(),
    val averageRating: Double = 0.0,
    val canonicalVolumeLink: String = "",
    val categories: List<String> = listOf(),
    val contentVersion: String = "",
    val description: String = "",
    val imageLinks: ImageLinks = ImageLinks(),
    val industryIdentifiers: List<IndustryIdentifier> = listOf(),
    val infoLink: String = "",
    val language: String = "",
    val maturityRating: String = "",
    val pageCount: Int = 0,
    val panelizationSummary: PanelizationSummary = PanelizationSummary(),
    val previewLink: String = "",
    val printType: String = "",
    val publishedDate: String = "",
    val publisher: String = "",
    val ratingsCount: Int = 0,
    val readingModes: ReadingModes = ReadingModes(),
    val subtitle: String = "",
    val title: String = ""
)