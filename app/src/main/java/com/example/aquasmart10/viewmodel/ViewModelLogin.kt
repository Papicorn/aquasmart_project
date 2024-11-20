package com.example.aquasmart10.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aquasmart10.api.RetrofitInstance
import com.example.aquasmart10.model.LoginRequest
import com.example.aquasmart10.model.Pengguna
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    private val _user = MutableStateFlow<Pengguna?>(null)
    val user: StateFlow<Pengguna?> = _user.asStateFlow()

    private val _token = MutableStateFlow<String?>(null)
    val token: StateFlow<String?> = _token.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                val response = RetrofitInstance.api.login(LoginRequest(email, password))
                _token.value = response.token
                _user.value = response.user
                // Simpan token untuk penggunaan selanjutnya
                saveToken(response.token)
                _loginState.value = LoginState.Success
            } catch (e: Exception) {
                _loginState.value = LoginState.Error(e.message ?: "Unknown error")
            }
        }
    }

    private fun saveToken(token: String) {

    }
}
