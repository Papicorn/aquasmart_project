package com.aquanusa.aquasmart.viewmodel.pakan

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.aquanusa.aquasmart.api.RetrofitInstance.api
import com.aquanusa.aquasmart.model.pakan.ModelPakan
import kotlinx.coroutines.launch

class ViewModelPakan(
    application: Application
) : AndroidViewModel(application) {

    private val sharedPreferences = getApplication<Application>()
        .getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

    private fun getToken(): String? {
        return sharedPreferences.getString("TOKEN_KEY", null)
    }

    val _listPakan = mutableStateListOf<ModelPakan>()

    private val _errorMessage = mutableStateOf("")

    private val _isLoading = mutableStateOf(false)

    fun getPakan() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _listPakan.clear()
                val token = getToken()
                if (!token.isNullOrEmpty()) {
                    val response = api.getPakan("Bearer $token")
                    if (response.status == "success") {
                        _listPakan.addAll(response.data)
                        Log.d("Pakannya nih bos", "Successfully loaded ${response.data.size} pakan")
                    } else {
                        _errorMessage.value = "Failed to load pools"
                        Log.d("Pakannya error nih bos", "Failed loaded pakan ${response.status}")
                    }
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message ?: "Unknown error occurred"
                Log.e("PoolViewModel", "Error fetching pools", e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}