package com.example.aquasmart10.component

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aquasmart10.R
import androidx.compose.material3.Icon
import androidx.navigation.NavController


@Composable
fun JadwalPakanBody(navController: NavController) {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFEFF6FC))
                .padding(20.dp)
        ) {
            item {
                Column {
                    Text(
                        text = "Pengingat Pakan",
                        fontFamily = customFontFamily,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Column(
                        modifier = Modifier
                            .padding(top = 20.dp)
                    ) {
                        Text(
                            text = "Hari Ini (3)",
                            fontFamily = customFontFamily,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black
                        )

                        //Card 1
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp),
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
                                            text = buildAnnotatedString {
                                                append("Beri pakan kolam ")
                                                withStyle(style = SpanStyle(
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Black,
                                                    fontSize = 14.sp)
                                                ) {
                                                    append("A-A1")
                                                }
                                            },
                                            fontFamily = customFontFamily,
                                            fontWeight = FontWeight.Normal,
                                            fontSize = 16.sp,
                                            color = Color.Black
                                        )
                                        Text(
                                            text = buildAnnotatedString {
                                                append("249/")
                                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                    append("300")
                                                }
                                            },
                                            fontFamily = customFontFamily,
                                            fontSize = 14.sp,
                                            color = Color.Black
                                        )
                                    }
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 10.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.Bottom
                                    ) {
                                        Text(
                                            text = buildAnnotatedString {
                                                append("PH air (sore) :")
                                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                    append(" 8")
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
                                            verticalAlignment = Alignment.Top
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.img_10),
                                                contentDescription = "icon ceklis",
                                                modifier = Modifier
                                                    .size(24.dp),
                                                tint = Color.Black
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))
                                            
                                            Icon(
                                                painter = painterResource(R.drawable.img_8),
                                                contentDescription = "icon hapus",
                                                modifier = Modifier
                                                    .size(24.dp),
                                                tint = Color.Red
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))

                                            Icon(
                                                painter = painterResource(R.drawable.img_7),
                                                contentDescription = "icon edit",
                                                modifier = Modifier
                                                    .size(24.dp),
                                                tint = Color(0xFF2C793E)
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))
                                        }

                                    }
                                    Text(
                                        text = buildAnnotatedString {
                                            append("Diameter :")
                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                append(" 10 Meter")
                                            }
                                        },
                                        fontFamily = customFontFamily,
                                        fontSize = 14.sp,
                                        color = Color.Black,
                                        modifier = Modifier
                                    )
                                }
                            }
                        }

                        //Card 2
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp),
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
                                            text = buildAnnotatedString {
                                                append("Beri pakan kolam ")
                                                withStyle(style = SpanStyle(
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Black,
                                                    fontSize = 14.sp)
                                                ) {
                                                    append("A-A1")
                                                }
                                            },
                                            fontFamily = customFontFamily,
                                            fontWeight = FontWeight.Normal,
                                            fontSize = 16.sp,
                                            color = Color.Black
                                        )
                                        Text(
                                            text = buildAnnotatedString {
                                                append("249/")
                                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                    append("300")
                                                }
                                            },
                                            fontFamily = customFontFamily,
                                            fontSize = 14.sp,
                                            color = Color.Black
                                        )
                                    }
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 10.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.Bottom
                                    ) {
                                        Text(
                                            text = buildAnnotatedString {
                                                append("PH air (sore) :")
                                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                    append(" 8")
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
                                            verticalAlignment = Alignment.Top
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.img_10),
                                                contentDescription = "icon ceklis",
                                                modifier = Modifier
                                                    .size(24.dp),
                                                tint = Color.Black
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))

                                            Icon(
                                                painter = painterResource(R.drawable.img_8),
                                                contentDescription = "icon hapus",
                                                modifier = Modifier
                                                    .size(24.dp),
                                                tint = Color.Red
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))

                                            Icon(
                                                painter = painterResource(R.drawable.img_7),
                                                contentDescription = "icon edit",
                                                modifier = Modifier
                                                    .size(24.dp),
                                                tint = Color(0xFF2C793E)
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))
                                        }

                                    }
                                    Text(
                                        text = buildAnnotatedString {
                                            append("Diameter :")
                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                append(" 10 Meter")
                                            }
                                        },
                                        fontFamily = customFontFamily,
                                        fontSize = 14.sp,
                                        color = Color.Black,
                                        modifier = Modifier
                                    )
                                }
                            }
                        }

                        //Card 3
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 20.dp),
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
                                            text = buildAnnotatedString {
                                                append("Beri pakan kolam ")
                                                withStyle(style = SpanStyle(
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color.Black,
                                                    fontSize = 14.sp)
                                                ) {
                                                    append("A-A1")
                                                }
                                            },
                                            fontFamily = customFontFamily,
                                            fontWeight = FontWeight.Normal,
                                            fontSize = 16.sp,
                                            color = Color.Black
                                        )
                                        Text(
                                            text = buildAnnotatedString {
                                                append("249/")
                                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                    append("300")
                                                }
                                            },
                                            fontFamily = customFontFamily,
                                            fontSize = 14.sp,
                                            color = Color.Black
                                        )
                                    }
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 10.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.Bottom
                                    ) {
                                        Text(
                                            text = buildAnnotatedString {
                                                append("PH air (sore) :")
                                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                    append(" 8")
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
                                            verticalAlignment = Alignment.Top
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.img_10),
                                                contentDescription = "icon ceklis",
                                                modifier = Modifier
                                                    .size(24.dp),
                                                tint = Color.Black
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))

                                            Icon(
                                                painter = painterResource(R.drawable.img_8),
                                                contentDescription = "icon hapus",
                                                modifier = Modifier
                                                    .size(24.dp),
                                                tint = Color.Red
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))

                                            Icon(
                                                painter = painterResource(R.drawable.img_7),
                                                contentDescription = "icon edit",
                                                modifier = Modifier
                                                    .size(24.dp),
                                                tint = Color(0xFF2C793E)
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))
                                        }

                                    }
                                    Text(
                                        text = buildAnnotatedString {
                                            append("Diameter :")
                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                append(" 10 Meter")
                                            }
                                        },
                                        fontFamily = customFontFamily,
                                        fontSize = 14.sp,
                                        color = Color.Black,
                                        modifier = Modifier
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
