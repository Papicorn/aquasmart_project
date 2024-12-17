package com.aquanusa.aquasmart.model.pengguna

data class ApiResponsePengguna<T>(
    val status: String,
    val data: T
)

data class ModelPengguna(
    val id_pengguna: Int,
    val nama_lengkap: String,
    val email: String,
    val password: String,
    val lokasi_bioflok: String,
    val role: String
)