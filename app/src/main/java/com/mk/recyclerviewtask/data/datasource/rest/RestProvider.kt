package com.mk.recyclerviewtask.data.datasource.rest

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class RestProvider {

    fun getWebService(): WebService =
        Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BASE_URL)
            .build()
            .create(WebService::class.java)

    private companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}