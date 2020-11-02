package com.example.gook.network


import com.squareup.moshi.Json

data class NetworkVolume(
    @Json(name = "accessInfo")
    val accessInfo: AccessInfo,
    @Json(name = "etag")
    val etag: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "kind")
    val kind: String,
    @Json(name = "layerInfo")
    val layerInfo: LayerInfo,
    @Json(name = "saleInfo")
    val saleInfo: SaleInfo,
    @Json(name = "selfLink")
    val selfLink: String,
    @Json(name = "volumeInfo")
    val volumeInfo: VolumeInfo
) {
    data class AccessInfo(
        @Json(name = "accessViewStatus")
        val accessViewStatus: String,
        @Json(name = "country")
        val country: String,
        @Json(name = "embeddable")
        val embeddable: Boolean,
        @Json(name = "epub")
        val epub: Epub,
        @Json(name = "pdf")
        val pdf: Pdf,
        @Json(name = "publicDomain")
        val publicDomain: Boolean,
        @Json(name = "quoteSharingAllowed")
        val quoteSharingAllowed: Boolean,
        @Json(name = "textToSpeechPermission")
        val textToSpeechPermission: String,
        @Json(name = "viewability")
        val viewability: String,
        @Json(name = "webReaderLink")
        val webReaderLink: String
    ) {
        data class Epub(
            @Json(name = "isAvailable")
            val isAvailable: Boolean
        )

        data class Pdf(
            @Json(name = "isAvailable")
            val isAvailable: Boolean
        )
    }

    data class LayerInfo(
        @Json(name = "layers")
        val layers: List<Layer>
    ) {
        data class Layer(
            @Json(name = "layerId")
            val layerId: String,
            @Json(name = "volumeAnnotationsVersion")
            val volumeAnnotationsVersion: String
        )
    }

    data class SaleInfo(
        @Json(name = "country")
        val country: String,
        @Json(name = "isEbook")
        val isEbook: Boolean,
        @Json(name = "saleability")
        val saleability: String
    )

    data class VolumeInfo(
        @Json(name = "allowAnonLogging")
        val allowAnonLogging: Boolean,
        @Json(name = "authors")
        val authors: List<String>,
        @Json(name = "averageRating")
        val averageRating: Int,
        @Json(name = "canonicalVolumeLink")
        val canonicalVolumeLink: String,
        @Json(name = "contentVersion")
        val contentVersion: String,
        @Json(name = "description")
        val description: String,
        @Json(name = "dimensions")
        val dimensions: Dimensions,
        @Json(name = "imageLinks")
        val imageLinks: ImageLinks,
        @Json(name = "infoLink")
        val infoLink: String,
        @Json(name = "language")
        val language: String,
        @Json(name = "maturityRating")
        val maturityRating: String,
        @Json(name = "pageCount")
        val pageCount: Int,
        @Json(name = "panelizationSummary")
        val panelizationSummary: PanelizationSummary,
        @Json(name = "previewLink")
        val previewLink: String,
        @Json(name = "printType")
        val printType: String,
        @Json(name = "printedPageCount")
        val printedPageCount: Int,
        @Json(name = "publishedDate")
        val publishedDate: String,
        @Json(name = "publisher")
        val publisher: String,
        @Json(name = "ratingsCount")
        val ratingsCount: Int,
        @Json(name = "readingModes")
        val readingModes: ReadingModes,
        @Json(name = "title")
        val title: String
    ) {
        data class Dimensions(
            @Json(name = "height")
            val height: String
        )

        data class ImageLinks(
            @Json(name = "smallThumbnail")
            val smallThumbnail: String,
            @Json(name = "thumbnail")
            val thumbnail: String
        )

        data class PanelizationSummary(
            @Json(name = "containsEpubBubbles")
            val containsEpubBubbles: Boolean,
            @Json(name = "containsImageBubbles")
            val containsImageBubbles: Boolean
        )

        data class ReadingModes(
            @Json(name = "image")
            val image: Boolean,
            @Json(name = "text")
            val text: Boolean
        )
    }
}