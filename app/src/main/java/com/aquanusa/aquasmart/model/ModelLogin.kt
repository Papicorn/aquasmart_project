package com.aquanusa.aquasmart.model

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val message: String?,
    val token: String?,
    val status: Boolean,
    val data: Pengguna
)

data class Pengguna(
    val id_pengguna: Int,
    val nama_lengkap: String
)