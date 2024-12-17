package com.aquanusa.aquasmart.model.pakan

data class ResponsePakan<T>(
    val status: String,
    val data: T
)

data class ModelPakan(
    val id_pakan: Int,
    val jenis_pakan: String,
    val nama_pakan: String,
    val stok_pakan: Double
)