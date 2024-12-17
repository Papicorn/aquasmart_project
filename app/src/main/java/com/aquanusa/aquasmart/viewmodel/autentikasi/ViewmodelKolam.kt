package com.aquanusa.aquasmart.viewmodel.autentikasi

import ModelEditKolam
import ModelKolam
import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aquanusa.aquasmart.api.RetrofitInstance.api
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.lifecycle.AndroidViewModel

class PoolViewModel(application: Application) : AndroidViewModel(application) {
    private val _poolList = mutableStateListOf<ModelKolam>()
    private val _errorMessage = mutableStateOf("")
    val errorMessage: String by _errorMessage
    val poolList: List<ModelKolam> get() = _poolList

    private val _isLoading = mutableStateOf(false)
    val isLoading: Boolean by _isLoading

    private val _statusResponse = mutableStateOf("")
    val statusResponse: State<String> = _statusResponse

    // Akses SharedPreferences dari Application Context
    private val sharedPreferences = getApplication<Application>()
        .getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

    private fun getToken(): String? {
        // Ambil token dari SharedPreferences
        return sharedPreferences.getString("TOKEN_KEY", null)
    }

    fun getPools() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _poolList.clear()
                val token = getToken()
                if (token.isNullOrEmpty()) {
                    _errorMessage.value = "Token tidak tersedia, silakan login ulang."
                    return@launch
                }

                val response = api.getPools("Bearer $token")
                if (response.status == "success") {
                    _poolList.addAll(response.data)
                    Log.d("PoolViewModel", "Successfully loaded ${response.data.size} pools")
                } else {
                    _errorMessage.value = "Failed to load pools"
                    Log.w("PoolViewModel", "API returned non-success status: ${response.status}")
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "Unknown error occurred"
                Log.e("PoolViewModel", "Error fetching pools", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getPoolsById(id_kolam: (String)) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _poolList.clear()
                val token = getToken()
                if (token.isNullOrEmpty()) {
                    _errorMessage.value = "Token tidak tersedia, silakan login ulang."
                    return@launch
                }

                val response = api.getKolamById("Bearer $token", id_kolam)
                if (response.status == "success") {
                    _poolList.addAll(response.data)
                } else {
                    _errorMessage.value = "Failed to load pools"
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "Unknown error occurred"
                Log.e("PoolViewModel", "Error fetching pools", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun editKolamById(
        id_kolam: String,
        lokasi_bioflok: String,
        nama_awalan_kolam: String,
        nama_kolam: String,
        ph_air: Int,
        kedalaman: Float,
        diameter: Float,
        kapasitas: Int,
        status: String
    ) {
        viewModelScope.launch {
            _isLoading.value = true
            _statusResponse.value = ""
            try {
                val token = getToken()
                if (token.isNullOrEmpty()) {
                    _errorMessage.value = "Token tidak tersedia, silakan login ulang."
                    return@launch
                }

                val response = api.editKolam(
                    "Bearer $token",
                    id_kolam,
                    ModelEditKolam(
                        lokasi_bioflok,
                        nama_awalan_kolam,
                        nama_kolam,
                        ph_air,
                        kedalaman,
                        diameter,
                        kapasitas,
                        status
                    )
                )
                if (response.status == "success") {
                    _statusResponse.value = "success"
                    Log.d("PoolViewModel", _statusResponse.value)
                } else {
                    _errorMessage.value = "Failed edit kolam"
                    _statusResponse.value = "error"
                    Log.d("PoolViewModel", "failed not success")
                }
            } catch (e: Exception) {
                _statusResponse.value = "error"
                _errorMessage.value = e.message ?: "Unknown error occurred"
                Log.e("PoolViewModel", "Error fetching pools", e)
            } finally {
                _statusResponse.value = "success"
                _isLoading.value = false
            }
        }
    }
}
