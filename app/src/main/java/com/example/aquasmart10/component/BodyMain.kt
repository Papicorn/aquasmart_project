package com.example.aquasmart10.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aquasmart10.R

val customFontFamily = FontFamily(
    Font(R.font.bold, FontWeight.Bold)
)

@Composable
fun BodyMain() {
    Column(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 25.dp,
                    topEnd = 25.dp
                )
            )
            .background(color = Color(0xFFEFF6FC))
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(10.dp)
        ) {
            items(1) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween // Mengatur jarak antar Card
                ) {
                    Card(
                        modifier = Modifier
                            .weight(1f) // Membuat card mengisi ruang yang tersedia
                            .padding(end = 4.dp), // Padding antara card
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = painterResource(id = R.drawable.stokikan), // Ganti dengan id drawable kamu
                                    contentDescription = "Ikon Stok Ikan",
                                    modifier = Modifier.size(24.dp) // Ukuran ikon
                                )
                                Text(
                                    text = "Stok Ikan",
                                    fontFamily = customFontFamily,
                                    fontSize = 20.sp,
                                    color = Color.Black,
                                    modifier = Modifier.padding(bottom = 8.dp) // Padding bawah untuk jarak
                                )
                                Text(
                                    text = "10.000",
                                    fontSize = 30.sp,
                                    color = Color.Blue,
                                    fontFamily = customFontFamily
                                )
                            }
                        }
                    }


                    Card(
                        modifier = Modifier
                            .weight(1f) // Membuat card mengisi ruang yang tersedia
                            .padding(end = 4.dp), // Padding antara card
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Text(
                                    text = "Card ${index * 2 + 1}",
                                    fontSize = 20.sp,
                                    color = Color.Black,
                                    modifier = Modifier.padding(bottom = 8.dp) // Padding bawah untuk jarak
                                )
                                Text(
                                    text = "10.000",
                                    fontSize = 30.sp,
                                    color = Color.Blue
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

