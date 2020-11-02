package com.example.gook.network

import com.example.gook.domain.model.domainsearchedvolume.*
import com.example.gook.network.model.networksearchedvolumescontainer.NetworkSearchedVolumesConatiner


fun NetworkSearchedVolumesConatiner.asDomainModel():List<SearchedVolume>{

    return items.map {
        SearchedVolume(
             accessInfo = it.accessInfo,
                etag = it.etag,
                id = it.id,
                kind = it.kind,
                saleInfo = it.saleInfo,
                searchInfo = it.searchInfo,
                selfLink = it.selfLink,
                volumeInfo = it.volumeInfo
        )
    }
    }
}