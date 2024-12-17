package com.aquanusa.aquasmart.viewmodel.ikan

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.aquanusa.aquasmart.api.RetrofitInstance.api
import com.aquanusa.aquasmart.model.ikan.ModelIkan
import kotlinx.coroutines.launch

class ViewModelIkan(
    application: Application
) : AndroidViewModel(application) {
    private val sharedPreferences = getApplication<Application>()
        .getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

    private fun getToken(): String? {
        return sharedPreferences.getString("TOKEN_KEY", null)
    }

    val _listIkan = mutableStateListOf<ModelIkan>()
    val ikanbyId = mutableStateListOf<ModelIkan>()

    private val _errorMessage = mutableStateOf("")

    private val _isLoading = mutableStateOf(false)
    val isLoading: Boolean by _isLoading

    fun jumlahIkan() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _listIkan.clear()
                val token = getToken()
                if (!token.isNullOrEmpty()) {
                    val response = api.getIkan("Bearer $token")
                    if (response.status == "success") {
                        _listIkan.addAll(response.data)
                        Log.d("Jumlah Rows Ikan", "Successfully loaded ${response.data.size}")
                    } else {
                        _errorMessage.value = "Failed to load stok ikan"
                        Log.d("Jumlah Rows Ikan error", "Failed loaded ikan ${response.status}")
                    }
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "Unknown error occurred"
                Log.e("Ikan Error", "Error fetching Ikan", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getStokById(id_kolam: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                ikanbyId.clear()
                val token = getToken()
                if (!token.isNullOrEmpty()) {
                    val response = api.getStokById("Bearer $token", id_kolam)
                    if (response.status == "success") {
                        ikanbyId.addAll(response.data)
                        Log.d("Jumlah Rows Ikan", "Successfully loaded ${response.data.size}")
                    } else {
                        _errorMessage.value = "Failed to load stok ikan"
                        Log.d("Jumlah Rows Ikan error", "Failed loaded ikan ${response.status}")
                    }
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "Unknown error occurred"
                Log.e("Ikan Error", "Error fetching Ikan", e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}