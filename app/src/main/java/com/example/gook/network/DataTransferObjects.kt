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
//
//fun NetworkSearchedVolumesConatiner.asDatabaseModel(): Array<DatabaseSearchedVolumeModel>{
//    return items.map {
//        DatabaseSearchedVolumeModel(
//                bookId = it.id,
//                accessInfo = it.accessInfo,
//                etag = it.etag,
//                kind = it.kind,
//                saleInfo = it.saleInfo,
//                searchInfo = it.searchInfo,
//                selfLink = it.selfLink,
//                volumeInfo = it.volumeInfo
//        )
//    }.toTypedArray()
//}
//
//fun List<DatabaseSearchedVolumeModel>.asDomainModel():List<SearchedVolume>{
//    return map {
//        SearchedVolume(
//                accessInfo = it.accessInfo,
//                etag = it.etag,
//                id = it.bookId,
//                kind = it.kind,
//                saleInfo = it.saleInfo,
//                searchInfo = it.searchInfo,
//                selfLink = it.selfLink,
//                volumeInfo = it.volumeInfo
//        )
//    }
//}

