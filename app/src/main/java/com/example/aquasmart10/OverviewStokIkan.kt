package com.example.aquasmart10

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.aquasmart10.component.HeaderKelola
import com.example.aquasmart10.component.NavbarBottom
import com.example.aquasmart10.component.NavbarTop
import com.example.aquasmart10.component.OverviewIkan

@Composable
fun OverviewStokIkan(navController: NavController) {
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
            HeaderKelola(navController)
            OverviewIkan(navController)
        }
    }
}
