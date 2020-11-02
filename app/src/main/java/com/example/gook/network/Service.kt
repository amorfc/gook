package com.example.gook.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.io.IOException

const val api_key = "AIzaSyBeLN67NyIppTq8tgNsMA1imRtahNk_c0Y"
const val base_url = "https://www.googleapis.com//books/v1/"

private val interceptor: Interceptor = Interceptor {chain ->
    var request = chain.request()
    val url  = request.url().newBuilder().addQueryParameter("key", api_key).build()
    request = request.newBuilder().url(url).build()
    return@Interceptor chain.proceed(request)
}

private val httpClient = OkHttpClient.Builder().addNetworkInterceptor(interceptor).build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

interface Service {

    @GET("volumes/{volumeId}")
    fun getVolume(
            @Path("volumeId") volumeId: String): Deferred<NetworkVolume>

    @GET("volumes")
    fun getSearchedVolumes(
            @Query("q") query: String
    ): Deferred<SearchedVolumesContainer>

}

object Network {

    private val retrofit = Retrofit.Builder()
        .client(httpClient)
        .baseUrl(base_url)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val googleBookApi = retrofit.create(Service::class.java)
}
