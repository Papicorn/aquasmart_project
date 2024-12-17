data class ApiResponse<T>(
    val status: String,
    val data: T
)

data class ModelKolam(
    val id_kolam: Int,
    val lokasi_bioflok: String,
    val nama_awalan_kolam: String,
    val nama_kolam: String,
    val ph_air: Int,
    val kedalaman: Float,
    val diameter: Float,
    val kapasitas: Int,
    val status: String
)

data class ModelEditKolam(
    val lokasi_bioflok: String,
    val nama_awalan_kolam: String,
    val nama_kolam: String,
    val ph_air: Int,
    val kedalaman: Float,
    val diameter: Float,
    val kapasitas: Int,
    val status: String
)

data class EditKolamResponse(
    val status: String,
    val message: String
)
