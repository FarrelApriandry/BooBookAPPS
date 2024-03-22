package com.example.dntylancar.models

data class LoginResponse(
    val success: Boolean,
    val message: String,
    val token: String
)