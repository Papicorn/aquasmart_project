package com.example.aquasmart10.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
                .padding(top = 20.dp, start = 20.dp, end = 20.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Card 1
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 4.dp)
                            .shadow(
                                elevation = 12.dp, // Tinggi bayangan
                                ambientColor = Color.Black.copy(alpha = 0.2f), // Warna bayangan ambient
                                spotColor = Color.Black.copy(alpha = 0.5f) // Warna bayangan spot
                            ),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Row {
                                    Image(
                                        painter = painterResource(id = R.drawable.img_3),
                                        contentDescription = "Ikon Stok Ikan",
                                        modifier = Modifier.size(24.dp).padding(end = 6.dp)
                                    )
                                    Text(
                                        text = "Stok Ikan",
                                        fontFamily = customFontFamily,
                                        fontSize = 20.sp,
                                        color = Color.Black,
                                        modifier = Modifier.padding(bottom = 8.dp)
                                    )
                                }
                                Text(
                                    text = "10.000",
                                    fontSize = 30.sp,
                                    color = Color.Blue,
                                    fontFamily = customFontFamily
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    // Card 2
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 4.dp)
                            .shadow(
                                elevation = 12.dp, // Tinggi bayangan
                                ambientColor = Color.Black.copy(alpha = 0.2f), // Warna bayangan ambient
                                spotColor = Color.Black.copy(alpha = 0.5f) // Warna bayangan spot
                            ),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = painterResource(id = R.drawable.img),
                                    contentDescription = "Ikon Total Kolam",
                                    modifier = Modifier.size(24.dp)
                                )
                                Text(
                                    text = "Total Kolam",
                                    fontSize = 20.sp,
                                    fontFamily = customFontFamily,
                                    color = Color.Black,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                                Text(
                                    text = "25",
                                    fontSize = 30.sp,
                                    fontFamily = customFontFamily,
                                    color = Color.Blue
                                )
                            }
                        }
                    }
                }

                // Card 3
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Card 3
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 4.dp)
                            .shadow(
                                elevation = 12.dp, // Tinggi bayangan
                                ambientColor = Color.Black.copy(alpha = 0.2f), // Warna bayangan ambient
                                spotColor = Color.Black.copy(alpha = 0.5f) // Warna bayangan spot
                            ),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Row {
                                    Image(
                                        painter = painterResource(id = R.drawable.img_2),
                                        contentDescription = "Ikon Pakan",
                                        modifier = Modifier.size(24.dp).padding(end = 6.dp)
                                    )
                                    Text(
                                        text = "Pakan",
                                        fontSize = 20.sp,
                                        fontFamily = customFontFamily,
                                        color = Color.Black,
                                        modifier = Modifier.padding(bottom = 8.dp)
                                    )
                                }
                                Text(
                                    text = "9 Kg",
                                    fontSize = 30.sp,
                                    fontFamily = customFontFamily,
                                    color = Color.Blue
                                )
                            }
                        }
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    // Card 4
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 4.dp)
                            .shadow(
                                elevation = 12.dp, // Tinggi bayangan
                                ambientColor = Color.Black.copy(alpha = 0.2f), // Warna bayangan ambient
                                spotColor = Color.Black.copy(alpha = 0.5f) // Warna bayangan spot
                            ),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Row {
                                    Image(
                                        painter = painterResource(id = R.drawable.img_4), // Sesuaikan id drawable
                                        contentDescription = "Ikon Card 4",
                                        modifier = Modifier.size(24.dp).padding(end = 6.dp)
                                    )
                                    Text(
                                        text = "Notifikasi",
                                        fontSize = 20.sp,
                                        fontFamily = customFontFamily,
                                        color = Color.Black,
                                        modifier = Modifier.padding(bottom = 8.dp)
                                    )
                                }
                                Text(
                                    text = "3",
                                    fontSize = 30.sp,
                                    fontFamily = customFontFamily,
                                    color = Color.Blue
                                )
                            }
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp) // Jarak antar Card di atas dan bawah
                ) {
                    // Card 5
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp), // Jarak bawah antara Card 5 dan Card 6
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp),
                            contentAlignment = Alignment.TopStart
                        ) {
                            Column {
                                Text(
                                    text = "Pengingat Terdekat",
                                    fontSize = 20.sp,
                                    fontFamily = customFontFamily,
                                    color = Color.Black,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                                Text(
                                    text = "Senin",
                                    fontSize = 20.sp,
                                    color = Color.Black,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                                }
                            }
                        }
                    }

                    // Card 6
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                Image(
                                    painter = painterResource(id = R.drawable.img_2),
                                    contentDescription = "Ikon Pakan",
                                    modifier = Modifier.size(24.dp)
                                )
                                Text(
                                    text = "Pakan",
                                    fontSize = 20.sp,
                                    fontFamily = customFontFamily,
                                    color = Color.Black,
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                                Text(
                                    text = "9 Kg",
                                    fontSize = 30.sp,
                                    fontFamily = customFontFamily,
                                    color = Color.Blue
                                )
                            }
                        }
                    }
                }
            }
        }
    }




