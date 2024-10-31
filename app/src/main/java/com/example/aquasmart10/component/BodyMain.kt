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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aquasmart10.R

@Composable
fun BodyMain() {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold)
    )

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
                                elevation = 12.dp,
                                ambientColor = Color.Black.copy(alpha = 0.2f),
                                spotColor = Color.Black.copy(alpha = 0.5f)
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
                                        modifier = Modifier
                                            .size(24.dp)
                                            .padding(end = 6.dp)
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
                                    color = Color(0xFF5E7BF9),
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
                                elevation = 12.dp,
                                ambientColor = Color.Black.copy(alpha = 0.2f),
                                spotColor = Color.Black.copy(alpha = 0.5f)
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
                                        painter = painterResource(id = R.drawable.img),
                                        contentDescription = "Kolam",
                                        modifier = Modifier
                                            .size(24.dp)
                                            .padding(end = 6.dp)
                                    )
                                    Text(
                                        text = "Kolam",
                                        fontFamily = customFontFamily,
                                        fontSize = 20.sp,
                                        color = Color.Black,
                                        modifier = Modifier.padding(bottom = 8.dp)
                                    )
                                }
                                Text(
                                    text = "3",
                                    fontSize = 30.sp,
                                    color = Color(0xFF5E7BF9),
                                    fontFamily = customFontFamily
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
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 4.dp)
                            .shadow(
                                elevation = 12.dp,
                                ambientColor = Color.Black.copy(alpha = 0.2f),
                                spotColor = Color.Black.copy(alpha = 0.5f)
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
                                        contentDescription = "Pakan",
                                        modifier = Modifier
                                            .size(24.dp)
                                            .padding(end = 6.dp)
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
                                    color = Color(0xFF5E7BF9)
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
                                elevation = 12.dp,
                                ambientColor = Color.Black.copy(alpha = 0.2f),
                                spotColor = Color.Black.copy(alpha = 0.5f)
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
                                        painter = painterResource(id = R.drawable.img_4),
                                        contentDescription = "Notif",
                                        modifier = Modifier
                                            .size(24.dp)
                                            .padding(end = 6.dp)
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
                                    color = Color(0xFF5E7BF9)
                                )
                            }
                        }
                    }
                }

                // Card 5
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .padding(vertical = 10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .fillMaxHeight()
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
                                text = "Hari ini",
                                fontSize = 20.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            LazyColumn (
                                verticalArrangement = Arrangement.spacedBy(12.dp),
                                modifier = Modifier.fillMaxWidth()
                            ){
                                //Card pengingat terdekat
                                item {
                                    Card(
                                        colors = CardDefaults.cardColors(
                                            containerColor = Color(0xFFEFF6FC),
                                        ),
                                        modifier = Modifier
                                            .size(width = 350.dp, height = 50.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(horizontal = 15.dp, vertical = 15.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = "Beri pakan Kolam A1",
                                            )
                                            Text(
                                                text = "08.00 WIB",
                                            )
                                        }
                                    }
                                }
                                // Loop 5 card pengingat terdekat
                                items (5) { index ->
                                    Card(
                                        colors = CardDefaults.cardColors(
                                            containerColor = Color(0xFFEFF6FC),
                                        ),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(55.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(horizontal = 15.dp, vertical = 15.dp),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = "Panen kolam A5",
                                            )
                                            Text(
                                                text = "08.00 WIB",
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                // Card 6 (Dokumentasi)
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(vertical = 10.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Dokumentasi",
                            fontSize = 20.sp,
                            fontFamily = customFontFamily,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 12.dp)
                        )

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            val images = listOf(
                                R.drawable.img_5,
                                R.drawable.img_6,
                                R.drawable.img_5,
                                R.drawable.img_6
                            )

                            items(images) { imageRes ->
                                Card(
                                    modifier = Modifier
                                        .height(160.dp)
                                        .width(300.dp)
                                        .shadow(
                                            elevation = 4.dp,
                                            shape = RoundedCornerShape(8.dp)
                                        ),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = imageRes),
                                        contentDescription = "Dokumentasi",
                                        modifier = Modifier.fillMaxSize(),
                                        contentScale = ContentScale.Crop
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}