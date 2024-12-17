package com.aquanusa.aquasmart.model.ikan

data class ApiResponseIkan<T>(
    val status: String,
    val data: T
)

data class ModelIkan(
    val id_stok: Int,
    val id_kolam: Int,
    val tgl_tebar: String,
    val tgl_panen: String,
    val jumlah_nila_merah: Int,
    val jumlah_nila_hitam: Int,
    val berat: Float,
    val lampiran: String
)
