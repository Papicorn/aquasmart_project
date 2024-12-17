package com.example.aquasmart10.api

import android.content.Context

class AuthRepository(private val context: Context) {
    // Fungsi untuk menyimpan token
    fun saveToken(token: String) {
        val sharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("JWT_TOKEN", token)
        editor.apply()
    }

    // Fungsi untuk mengambil token
    fun getToken(): String? {
        val sharedPreferences = context.getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getString("JWT_TOKEN", null)
    }
}
