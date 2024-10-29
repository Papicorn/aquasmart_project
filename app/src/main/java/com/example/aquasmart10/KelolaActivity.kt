package com.example.aquasmart10

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.aquasmart10.component.BodyKelolaIkan
import com.example.aquasmart10.component.BodyMain
import com.example.aquasmart10.component.Header
import com.example.aquasmart10.component.HeaderKelola
import com.example.aquasmart10.component.NavbarBottom
import com.example.aquasmart10.component.NavbarTop

@Composable
fun KelolaActivity(navController: NavController) {
    Scaffold(
        bottomBar = {
            NavbarBottom(navController)
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFF5E7BF9))
        ) {
            NavbarTop()
            HeaderKelola()
            BodyKelolaIkan()
        }
    }
}
