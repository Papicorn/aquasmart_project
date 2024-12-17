package com.aquanusa.aquasmart.viewmodel.autentikasi

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    object LoggedOut : LoginState()
    object Success : LoginState()
    data class Error(val message: String) : LoginState()
}