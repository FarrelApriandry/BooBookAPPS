package com.example.dntylancar.models

data class LoginRequest(
    val email: String ,
    val password: String
)

data class RegisterRequest(
    val nama: String,
    val nik: Int,
    val email: String,
    val password: String
)