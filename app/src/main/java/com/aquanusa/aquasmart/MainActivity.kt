package com.aquanusa.aquasmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.aquanusa.aquasmart.navigation.MainScreen
import com.aquanusa.aquasmart.ui.theme.AquasmartProjectBackupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            AquasmartProjectBackupTheme {
                MainScreen()
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AquasmartProjectBackupTheme {
        MainScreen()
    }
}