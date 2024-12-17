import android.adservices.ondevicepersonalization.RequestToken
import android.provider.ContactsContract
import com.aquanusa.aquasmart.api.RetrofitInstance.api
import com.aquanusa.aquasmart.model.LoginRequest
import com.aquanusa.aquasmart.model.LoginResponse
import com.aquanusa.aquasmart.model.ikan.ApiResponseIkan
import com.aquanusa.aquasmart.model.ikan.ModelIkan
import com.aquanusa.aquasmart.model.pakan.ModelPakan
import com.aquanusa.aquasmart.model.pakan.ResponsePakan
import com.aquanusa.aquasmart.model.pengguna.ApiResponsePengguna
import com.aquanusa.aquasmart.model.pengguna.ModelPengguna
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface YourApiService {
    // USER
    @GET("users/{id_pengguna}")
    suspend fun getPengguna(
        @Header("Authorization") token: String,
        @Path("id_pengguna") id_pengguna: Int
    ): ApiResponsePengguna<List<ModelPengguna>>

    @POST("users/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse

    // KOLAM
    @GET("kolam")
    suspend fun getPools(
        @Header("Authorization") token: String
    ): ApiResponse<List<ModelKolam>>

    @GET("kolam/{id_kolam}")
    suspend fun getKolamById(
        @Header("Authorization") token: String,
        @Path("id_kolam") id_kolam: String
    ): ApiResponse<List<ModelKolam>>

    @PUT("kolam/{id_kolam}")
    suspend fun editKolam(
        @Header("Authorization") token: String,
        @Path("id_kolam") id_kolam: String,
        @Body request: ModelEditKolam
    ): EditKolamResponse

    // PAKAN
    @GET("pakan")
    suspend fun getPakan(
        @Header("Authorization") token: String
    ): ResponsePakan<List<ModelPakan>>

    // IKAN
    @GET("stokikan")
    suspend fun getIkan(
        @Header("Authorization") token: String
    ): ApiResponseIkan<List<ModelIkan>>

    @GET("stokikan/{id_kolam}")
    suspend fun getStokById(
        @Header("Authorization") token: String,
        @Path("id_kolam") id_kolam: String
    ): ApiResponseIkan<List<ModelIkan>>


}