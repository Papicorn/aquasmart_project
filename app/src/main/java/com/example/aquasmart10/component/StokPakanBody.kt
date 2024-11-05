package com.example.aquasmart10.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.aquasmart10.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.width
import androidx.navigation.NavController

@Composable
fun StokIkanBody(navController: NavController) {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )
    Column(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 25.dp,
                    topEnd = 25.dp
                )
            )
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFEFF6FC))
                .padding(top = 30.dp, start = 20.dp, end = 20.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    Column {
                        Text(
                            text = "Total Stok Keseluruhan",
                            fontWeight = FontWeight.Normal,
                            fontFamily = customFontFamily,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Text(
                            text = "9 Kilogram",
                            fontWeight = FontWeight.Bold,
                            fontFamily = customFontFamily,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Text(
                            text = buildAnnotatedString {
                                append("Dari ")
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                    append("2 jenis pakan")
                                }
                                append(" tersedia")
                            },
                            fontFamily = customFontFamily,
                            fontSize = 16.sp,
                            color = Color.Black
                        )

                        // Card 1
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 25.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            Box{
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = "Pelet Bagus",
                                            fontFamily = customFontFamily,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 14.sp,
                                            color = Color.Black
                                        )
                                        Text(
                                            text = "5,5kg",
                                            fontFamily = customFontFamily,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 14.sp,
                                            color = Color.Black
                                        )
                                    }
                                    Text(
                                        text = buildAnnotatedString {
                                            append("Jenis :")
                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                append(" Pelet")
                                            }
                                        },
                                        fontFamily = customFontFamily,
                                        fontSize = 14.sp,
                                        modifier = Modifier.padding(top = 20.dp),
                                        color = Color.Black
                                    )
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = buildAnnotatedString {
                                                append("Penggunaan :")
                                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                    append(" 17,5kg")
                                                }
                                            },
                                            fontFamily = customFontFamily,
                                            fontSize = 14.sp,
                                            color = Color.Black
                                        )
                                        Row(
                                            modifier = Modifier
                                                .fillMaxHeight()
                                                .fillMaxWidth(),
                                            horizontalArrangement = Arrangement.End,
                                            verticalAlignment = Alignment.Bottom
                                        ) {
                                            Image(
                                                painter = painterResource(R.drawable.img_8),
                                                contentDescription = "icon hapus",
                                                modifier = Modifier
                                                    .size(24.dp)
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))

                                            Image(
                                                painter = painterResource(R.drawable.img_7),
                                                contentDescription = "icon edit",
                                                modifier = Modifier
                                                    .size(24.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        // Card 2
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 25.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                        ) {
                            Box{
                                Column(
                                    modifier = Modifier
                                        .padding(10.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = "Pelet Bagus",
                                            fontFamily = customFontFamily,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 14.sp,
                                            color = Color.Black
                                        )
                                        Text(
                                            text = "5,5kg",
                                            fontFamily = customFontFamily,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 18.sp,
                                            color = Color.Black
                                        )
                                    }
                                    Text(
                                        text = buildAnnotatedString {
                                            append("Jenis :")
                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                append(" Pelet")
                                            }
                                        },
                                        fontFamily = customFontFamily,
                                        fontSize = 14.sp,
                                        modifier = Modifier.padding(top = 20.dp),
                                        color = Color.Black
                                    )
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            text = buildAnnotatedString {
                                                append("Penggunaan :")
                                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                    append(" 17,5kg")
                                                }
                                            },
                                            fontFamily = customFontFamily,
                                            fontSize = 14.sp,
                                            color = Color.Black
                                        )
                                        Row(
                                            modifier = Modifier
                                                .fillMaxHeight()
                                                .fillMaxWidth(),
                                            horizontalArrangement = Arrangement.End,
                                            verticalAlignment = Alignment.Bottom
                                        ) {
                                            Image(
                                                painter = painterResource(R.drawable.img_8),
                                                contentDescription = "icon hapus",
                                                modifier = Modifier
                                                    .size(24.dp)
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))

                                            Image(
                                                painter = painterResource(R.drawable.img_7),
                                                contentDescription = "icon edit",
                                                modifier = Modifier
                                                    .size(24.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            Card(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 20.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = "iicon tambah",
                    modifier = Modifier
                        .padding(6.dp)
                        .size(60.dp)
                )
            }
        }
    }
}

