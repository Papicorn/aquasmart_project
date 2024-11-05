package com.example.aquasmart10

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.aquasmart10.component.BottomNavigationBar
import com.example.aquasmart10.component.EditJadwalPakanBody
import com.example.aquasmart10.component.SecondaryHeader
import androidx.navigation.NavController



@Composable
fun EditJadwalPakanScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFF5E7BF9))
        ) {
            SecondaryHeader(navController)
            EditJadwalPakanBody(navController)

        }
    }
}