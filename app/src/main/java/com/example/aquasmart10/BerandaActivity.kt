package com.example.aquasmart10


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.aquasmart10.component.BodyMain
import com.example.aquasmart10.component.BottomNavigationBar
import com.example.aquasmart10.component.Header
import com.example.aquasmart10.component.NavbarBottom
import com.example.aquasmart10.ui.theme.AquaSmart10Theme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun BerandaActivity(navController: NavController){
    HomeScreen(navController)
}
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeScreen(navController: NavController) {
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
            Header()
            BodyMain(navController)
        }
    }
}
