package com.example.gook.network


import com.squareup.moshi.Json

data class SearchedVolumesContainer(
    @Json(name = "items")
    val searchedVolumes: List<SearchedVolume> = listOf(),
    @Json(name = "kind")
    val kind: String = "",
    @Json(name = "totalItems")
    val totalItems: Int = 0
) {
    data class SearchedVolume(
        @Json(name = "accessInfo")
        val accessInfo: AccessInfo = AccessInfo(),
        @Json(name = "etag")
        val etag: String = "",
        @Json(name = "id")
        val id: String = "",
        @Json(name = "kind")
        val kind: String = "",
        @Json(name = "saleInfo")
        val saleInfo: SaleInfo = SaleInfo(),
        @Json(name = "searchInfo")
        val searchInfo: SearchInfo = SearchInfo(),
        @Json(name = "selfLink")
        val selfLink: String = "",
        @Json(name = "volumeInfo")
        val volumeInfo: VolumeInfo = VolumeInfo()
    ) {
        data class AccessInfo(
            @Json(name = "accessViewStatus")
            val accessViewStatus: String = "",
            @Json(name = "country")
            val country: String = "",
            @Json(name = "embeddable")
            val embeddable: Boolean = false,
            @Json(name = "epub")
            val epub: Epub = Epub(),
            @Json(name = "pdf")
            val pdf: Pdf = Pdf(),
            @Json(name = "publicDomain")
            val publicDomain: Boolean = false,
            @Json(name = "quoteSharingAllowed")
            val quoteSharingAllowed: Boolean = false,
            @Json(name = "textToSpeechPermission")
            val textToSpeechPermission: String = "",
            @Json(name = "viewability")
            val viewability: String = "",
            @Json(name = "webReaderLink")
            val webReaderLink: String = ""
        ) {
            data class Epub(
                @Json(name = "acsTokenLink")
                val acsTokenLink: String = "",
                @Json(name = "downloadLink")
                val downloadLink: String = "",
                @Json(name = "isAvailable")
                val isAvailable: Boolean = false
            )

            data class Pdf(
                @Json(name = "acsTokenLink")
                val acsTokenLink: String = "",
                @Json(name = "downloadLink")
                val downloadLink: String = "",
                @Json(name = "isAvailable")
                val isAvailable: Boolean = false
            )
        }

        data class SaleInfo(
            @Json(name = "buyLink")
            val buyLink: String = "",
            @Json(name = "country")
            val country: String = "",
            @Json(name = "isEbook")
            val isEbook: Boolean = false,
            @Json(name = "listPrice")
            val listPrice: ListPrice = ListPrice(),
            @Json(name = "offers")
            val offers: List<Offer> = listOf(),
            @Json(name = "retailPrice")
            val retailPrice: RetailPrice = RetailPrice(),
            @Json(name = "saleability")
            val saleability: String = ""
        ) {
            data class ListPrice(
                @Json(name = "amount")
                val amount: Double = 0.0,
                @Json(name = "currencyCode")
                val currencyCode: String = ""
            )

            data class Offer(
                @Json(name = "finskyOfferType")
                val finskyOfferType: Int = 0,
                @Json(name = "listPrice")
                val listPrice: ListPrice = ListPrice(),
                @Json(name = "retailPrice")
                val retailPrice: RetailPrice = RetailPrice()
            ) {
                data class ListPrice(
                    @Json(name = "amountInMicros")
                    val amountInMicros: Int = 0,
                    @Json(name = "currencyCode")
                    val currencyCode: String = ""
                )

                data class RetailPrice(
                    @Json(name = "amountInMicros")
                    val amountInMicros: Int = 0,
                    @Json(name = "currencyCode")
                    val currencyCode: String = ""
                )
            }

            data class RetailPrice(
                @Json(name = "amount")
                val amount: Double = 0.0,
                @Json(name = "currencyCode")
                val currencyCode: String = ""
            )
        }

        data class SearchInfo(
            @Json(name = "textSnippet")
            val textSnippet: String = ""
        )

        data class VolumeInfo(
            @Json(name = "allowAnonLogging")
            val allowAnonLogging: Boolean = false,
            @Json(name = "authors")
            val authors: List<String> = listOf(),
            @Json(name = "averageRating")
            val averageRating: Double = 0.0,
            @Json(name = "canonicalVolumeLink")
            val canonicalVolumeLink: String = "",
            @Json(name = "categories")
            val categories: List<String> = listOf(),
            @Json(name = "contentVersion")
            val contentVersion: String = "",
            @Json(name = "description")
            val description: String = "",
            @Json(name = "imageLinks")
            val imageLinks: ImageLinks = ImageLinks(),
            @Json(name = "industryIdentifiers")
            val industryIdentifiers: List<IndustryIdentifier> = listOf(),
            @Json(name = "infoLink")
            val infoLink: String = "",
            @Json(name = "language")
            val language: String = "",
            @Json(name = "maturityRating")
            val maturityRating: String = "",
            @Json(name = "pageCount")
            val pageCount: Int = 0,
            @Json(name = "panelizationSummary")
            val panelizationSummary: PanelizationSummary = PanelizationSummary(),
            @Json(name = "previewLink")
            val previewLink: String = "",
            @Json(name = "printType")
            val printType: String = "",
            @Json(name = "publishedDate")
            val publishedDate: String = "",
            @Json(name = "publisher")
            val publisher: String = "",
            @Json(name = "ratingsCount")
            val ratingsCount: Int = 0,
            @Json(name = "readingModes")
            val readingModes: ReadingModes = ReadingModes(),
            @Json(name = "subtitle")
            val subtitle: String = "",
            @Json(name = "title")
            val title: String = ""
        ) {
            data class ImageLinks(
                @Json(name = "smallThumbnail")
                val smallThumbnail: String = "",
                @Json(name = "thumbnail")
                val thumbnail: String = ""
            )

            data class IndustryIdentifier(
                @Json(name = "identifier")
                val identifier: String = "",
                @Json(name = "type")
                val type: String = ""
            )

            data class PanelizationSummary(
                @Json(name = "containsEpubBubbles")
                val containsEpubBubbles: Boolean = false,
                @Json(name = "containsImageBubbles")
                val containsImageBubbles: Boolean = false
            )

            data class ReadingModes(
                @Json(name = "image")
                val image: Boolean = false,
                @Json(name = "text")
                val text: Boolean = false
            )
        }
    }
}