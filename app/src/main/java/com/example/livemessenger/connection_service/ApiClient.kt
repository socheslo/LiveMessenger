package com.example.livemessenger.connection_service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class ApiClient {
    private val BASE_URL = "https://localhost/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}