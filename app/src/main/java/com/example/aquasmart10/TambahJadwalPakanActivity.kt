package com.example.aquasmart10

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
import com.example.aquasmart10.component.BottomNavigationBar
import com.example.aquasmart10.component.SecondaryHeader
import com.example.aquasmart10.component.TambahJadwalPakanBody
import com.example.aquasmart10.component.TambahKolamBody
import com.example.aquasmart10.ui.theme.AquaSmart10Theme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class TambahJadwalPakanActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AquaSmart10Theme {
                // A surface container using the 'background' color from the theme

                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    TambahJadwalPakanScreen()
                }
            }
        }
    }
    @Composable
    private fun SetBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun TambahJadwalPakanScreen() {
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
            SecondaryHeader()
            TambahJadwalPakanBody()

        }
    }
}