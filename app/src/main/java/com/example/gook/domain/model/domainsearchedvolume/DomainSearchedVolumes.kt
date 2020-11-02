package com.example.gook.domain.model.domainsearchedvolume

data class DomainSearchedVolumes(
        val items: List<SearchedVolume> = listOf(),
        val kind: String = "",
        val totalItems: Int = 0
)