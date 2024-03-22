package com.example.dntylancar.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceBuilder {

    companion object {
        private const val BASE_URL = "https://0fb0-182-253-126-7.ngrok-free.app/"

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun createService(): ApiService {
            return getRetrofit().create(ApiService::class.java)
        }
    }
}


