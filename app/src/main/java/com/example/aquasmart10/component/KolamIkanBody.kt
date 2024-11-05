package com.example.aquasmart10.component

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
import androidx.compose.ui.Alignment
import androidx.compose.material3.Icon
import androidx.navigation.NavController

@Composable
fun KolamIkanBody(navController: NavController) {
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

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFEFF6FC))
                .padding(top = 25.dp, start = 20.dp, end = 20.dp, bottom = 100.dp)
        ) {
            LazyColumn(
                modifier = Modifier
            ) {
                item {
                    Column {
                        Text(
                            text = "Total Ikan Keseluruhan",
                            fontWeight = FontWeight.Normal,
                            fontFamily = customFontFamily,
                            fontSize = 20.sp,
                            color = Color.Black
                        )

                        Text(
                            text = "549 ekor",
                            fontWeight = FontWeight.Bold,
                            fontFamily = customFontFamily,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Text(
                            text = buildAnnotatedString {
                                append("Dari ")
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) { append("2 kolam")
                                }
                                append(" aktif") },
                            fontFamily = customFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 15.sp,
                            color = Color.Black)


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
                                            text = buildAnnotatedString {
                                                append("A-A1  ")
                                                withStyle(style = SpanStyle(
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color(0xFF00A603),
                                                    fontSize = 14.sp)
                                                ) {
                                                    append("Aktif")
                                                }
                                            },
                                            fontFamily = customFontFamily,
                                            fontWeight = FontWeight.Bold,
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
                                        modifier = Modifier.padding(top = 20.dp)
                                    )
                                    Text(
                                        text = buildAnnotatedString {
                                            append("Kedalaman :")
                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                append(" 5 Meter")
                                            }
                                        },
                                        fontFamily = customFontFamily,
                                        fontSize = 14.sp,
                                        color = Color.Black
                                    )
                                    Text(
                                        text = buildAnnotatedString {
                                            append("PH air (pagi) :")
                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                append(" 7")
                                            }
                                        },
                                        fontFamily = customFontFamily,
                                        fontSize = 14.sp,
                                        color = Color.Black
                                    )
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.Top
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
                                                painter = painterResource(R.drawable.img_8),
                                                contentDescription = "icon hapus",
                                                modifier = Modifier
                                                    .size(28.dp),
                                                tint = Color.Red
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))

                                            Icon(
                                                painter = painterResource(R.drawable.img_7),
                                                contentDescription = "icon edit",
                                                modifier = Modifier
                                                    .size(28.dp),
                                                tint = Color(0xFF2C793E)
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))
                                        }
                                    }
                                }
                            }
                        }

                        // Card 2
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
                                            text = buildAnnotatedString {
                                                append("A-A1  ")
                                                withStyle(style = SpanStyle(
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color(0xFF00A603),
                                                    fontSize = 14.sp,

                                                    ),) {
                                                    append("Aktif")
                                                }
                                            },
                                            fontFamily = customFontFamily,
                                            fontWeight = FontWeight.Bold,
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
                                        modifier = Modifier.padding(top = 20.dp)
                                    )
                                    Text(
                                        text = buildAnnotatedString {
                                            append("Kedalaman :")
                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                append(" 5 Meter")
                                            }
                                        },
                                        fontFamily = customFontFamily,
                                        fontSize = 14.sp,
                                        color = Color.Black
                                    )
                                    Text(
                                        text = buildAnnotatedString {
                                            append("PH air (pagi) :")
                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                append(" 7")
                                            }
                                        },
                                        fontFamily = customFontFamily,
                                        fontSize = 14.sp,
                                        color = Color.Black
                                    )
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.Top
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
                                            verticalAlignment = Alignment.Bottom
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.img_8),
                                                contentDescription = "icon hapus",
                                                modifier = Modifier
                                                    .size(28.dp),
                                                tint = Color.Red
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))

                                            Icon(
                                                painter = painterResource(R.drawable.img_7),
                                                contentDescription = "icon edit",
                                                modifier = Modifier
                                                    .size(28.dp),
                                                tint = Color(0xFF2C793E)
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))
                                        }
                                    }
                                }
                            }
                        }

                        //Card 3
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 25.dp, bottom = 25.dp),
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
                                                append("A-A1  ")
                                                withStyle(style = SpanStyle(
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color(0xFF00A603),
                                                    fontSize = 14.sp,

                                                    ),) {
                                                    append("Aktif")
                                                }
                                            },
                                            fontFamily = customFontFamily,
                                            fontWeight = FontWeight.Bold,
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
                                        modifier = Modifier.padding(top = 20.dp)
                                    )
                                    Text(
                                        text = buildAnnotatedString {
                                            append("Kedalaman :")
                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                append(" 5 Meter")
                                            }
                                        },
                                        fontFamily = customFontFamily,
                                        fontSize = 14.sp,
                                        color = Color.Black
                                    )
                                    Text(
                                        text = buildAnnotatedString {
                                            append("PH air (pagi) :")
                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                append(" 7")
                                            }
                                        },
                                        fontFamily = customFontFamily,
                                        fontSize = 14.sp,
                                        color = Color.Black
                                    )
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.Top
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
                                            verticalAlignment = Alignment.Bottom
                                        ) {
                                            Icon(
                                                painter = painterResource(R.drawable.img_8),
                                                contentDescription = "icon hapus",
                                                modifier = Modifier
                                                    .size(28.dp),
                                                tint = Color.Red
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))

                                            Icon(
                                                painter = painterResource(R.drawable.img_7),
                                                contentDescription = "icon edit",
                                                modifier = Modifier
                                                    .size(28.dp),
                                                tint = Color(0xFF2C793E)
                                            )

                                            Spacer(modifier = Modifier.width(14.dp))
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
