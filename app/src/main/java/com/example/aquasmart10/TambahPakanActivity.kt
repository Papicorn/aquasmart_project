package com.example.aquasmart10

import com.example.aquasmart10.component.TambahPakanBody

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.aquasmart10.component.BottomNavigationBar
import com.example.aquasmart10.component.SecondaryHeader
import com.example.aquasmart10.ui.theme.AquaSmart10Theme
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun TambahPakanScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFF5E7BF9))
        ) {
            SecondaryHeader(navController)
            TambahPakanBody(navController)
        }
    }
}