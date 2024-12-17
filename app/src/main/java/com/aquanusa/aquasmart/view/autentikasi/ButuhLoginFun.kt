package com.aquanusa.aquasmart.view.autentikasi

import android.content.Context
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

@Composable
fun AuthenticatedNavigation(navController: NavController) {
    // Cek token yang tersimpan
    val sharedPreferences = LocalContext.current.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
    val token = sharedPreferences.getString("TOKEN_KEY", null)

    // Jika token ada, artinya sudah login, navigasi ke Beranda
    LaunchedEffect(token) {
        if (token.isNullOrEmpty()) {
            // Jika belum login, navigasi ke halaman Login
            navController.navigate("Login") {
                popUpTo("Login") { inclusive = true }
            }
        } else {
            // Jika sudah login, navigasi ke Beranda
            navController.navigate("Beranda") {
                popUpTo("Login") { inclusive = true }
            }
        }
    }
}
