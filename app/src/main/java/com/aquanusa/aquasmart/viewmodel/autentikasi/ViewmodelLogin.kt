import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aquanusa.aquasmart.api.RetrofitInstance
import com.aquanusa.aquasmart.api.RetrofitInstance.api
import com.aquanusa.aquasmart.model.LoginRequest
import com.aquanusa.aquasmart.model.ResponseApi
import com.aquanusa.aquasmart.model.pengguna.ModelPengguna
import com.aquanusa.aquasmart.viewmodel.autentikasi.LoginState
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.io.IOException

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    val isLoggedOut =  mutableStateOf(false)

    private val _errorMessage = mutableStateOf("")

    private val _token = MutableStateFlow<String?>(null)
    val token: StateFlow<String?> = _token.asStateFlow()

    private val _kolamState = mutableStateOf<List<ModelKolam>>(emptyList())
    val kolamState: State<List<ModelKolam>> get() = _kolamState

    // Tipe state yang menyimpan data pengguna sebagai list
    private val _userState = MutableStateFlow<List<ModelPengguna>>(emptyList())
    val userState: StateFlow<List<ModelPengguna>> = _userState

    private val _isLoading = mutableStateOf(true)
    val isLoading: Boolean by _isLoading

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading

            if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
                _loginState.value =
                    LoginState.Error("Kolom Username dan Password tidak boleh kosong!")
                return@launch
            }

            try {
                val response = api.login(LoginRequest(email, password))

                if (response.status) {
                    Log.d("debug", response.toString())
                    _token.value = response.token
                    saveToken(response.token.toString(), response.data.id_pengguna)
                    _loginState.value = LoginState.Success
                } else {
                    null
                }

            } catch (e: HttpException) {
                val errorBody = e.response()?.errorBody()?.string()
                val errorResponse = errorBody?.let {
                    Gson().fromJson(it, ResponseApi::class.java)
                }
                val errorMessage = errorResponse?.message ?: "Unknown Error"
                _loginState.value = LoginState.Error(errorMessage.toString())
            }
        }
    }

    private fun saveToken(token: String, id_pengguna: Int) {
        val sharedPreferences =
            getApplication<Application>().getSharedPreferences(
                "AppPreferences",
                Context.MODE_PRIVATE
            )
        val editor = sharedPreferences.edit()

        val currentTime = System.currentTimeMillis()
        val expiryTime = currentTime + 3000000
//        val expiryTime = currentTime + 10000

        val token = _token.value
        if (!token.isNullOrEmpty()) {
            editor.putString("TOKEN_KEY", token)
            editor.putLong("TOKEN_EXPIRY", expiryTime)
            editor.putInt("ID_PENGGUNA", id_pengguna)
            editor.apply()
        }

        val savedToken = sharedPreferences.getString("TOKEN_KEY", null)
        Log.d("SharedPreferences", "Saved Token: $savedToken \n dengan waktu $expiryTime \n pada nama $id_pengguna")
    }

    fun getDataPengguna() {
        val sharedPreferences = getApplication<Application>().getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("TOKEN_KEY", null)
        val idPengguna = sharedPreferences.getInt("ID_PENGGUNA", 0)

        Log.d("debug id Pengguna", idPengguna.toString())

        viewModelScope.launch{
//            _userState.clear()
            _isLoading.value = true
            _loginState.value = LoginState.Loading
            val headerToken = "Bearer $token"

            try {
                val response = api.getPengguna(headerToken, idPengguna)

                if (response.status == "success") {
                    Log.d("debug Pengguna", response.toString())
//                    _userState.addAll(response.data)
                    _userState.value = response.data
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "Unknown error occurred"
                Log.e("Gagal Ambil Pengguna", "Error fetching pools", e)
            } finally {
                Log.e("getdatapengguna", "ada error di sini")
                _isLoading.value = false
            }
        }
    }

    fun getToken(): String? {
        val sharedPreferences = getApplication<Application>().getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        val token = sharedPreferences.getString("TOKEN_KEY", null)
        val expiryTime = sharedPreferences.getLong("TOKEN_EXPIRY", 0)

        val currentTime = System.currentTimeMillis()
        return if (token != null && currentTime < expiryTime) {
            token // Token valid
        } else {
            // Token kedaluwarsa, hapus dari SharedPreferences
            clearToken()
            null
        }
    }

    fun clearToken() {
        val sharedPreferences = getApplication<Application>().getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.remove("TOKEN_KEY")
        editor.remove("TOKEN_EXPIRY")
        editor.apply()

        Log.d("SharedPreferences", "Token expired and removed.")
    }

    fun logout() {
        _token.value = null
        getApplication<Application>().getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
            .edit()
            .remove("TOKEN_KEY")
            .apply()
//        _loginState.value = LoginState.LoggedOut
        isLoggedOut.value = true
    }
}