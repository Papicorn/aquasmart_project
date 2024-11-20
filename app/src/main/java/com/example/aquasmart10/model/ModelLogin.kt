package com.example.aquasmart10.model

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val message: String,
    val token: String,
    val user: Pengguna
)

data class Pengguna(
    val email: String,
    val password: String
)