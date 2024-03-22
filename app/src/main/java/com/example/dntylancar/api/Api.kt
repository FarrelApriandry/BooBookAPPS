package com.example.dntylancar.api

import com.example.dntylancar.models.LoginRequest
import retrofit2.Call
import retrofit2.http.POST
import com.example.dntylancar.models.LoginResponse
import com.example.dntylancar.models.RegisterRequest
import com.example.dntylancar.models.RegisterResponse


import retrofit2.http.Body
interface ApiService {
    @POST("Login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>
    @POST("Register")
    fun register(@Body RegisterRequest: RegisterRequest): Call<RegisterResponse>
}

