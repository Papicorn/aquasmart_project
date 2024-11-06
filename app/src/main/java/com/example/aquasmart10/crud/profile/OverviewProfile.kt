package com.example.aquasmart10.crud.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aquasmart10.R
import com.example.aquasmart10.Routes
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn

@Composable
fun OverviewProfile(navController: NavController) {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(start = 40.dp)
                    .offset(y = 40.dp)
                    .clip(MaterialTheme.shapes.medium)
            ) {
                IconButton(
                    onClick = { navController.navigate(Routes.ProfileAwalActivity) },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrowback),
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    "Budi Wahyudi",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = customFontFamily,
                    color = Color.White
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                // SUSAH BANGET SUMPAH INI
                Column(
                    modifier = Modifier
                        .clip(object : Shape {
                            override fun createOutline(
                                size: Size,
                                layoutDirection: LayoutDirection,
                                density: Density
                            ): Outline {
                                val path = Path().apply {
                                    // Mulai dari sudut kiri bawah
                                    moveTo(0f, size.height)
                                    // Garis ke bawah kanan
                                    lineTo(size.width, size.height)
                                    // Garis ke sudut kanan atas
                                    lineTo(size.width, size.height * 0.2f)
                                    // Setengah lingkaran melengkung ke atas
                                    arcTo(
                                        rect = Rect(
                                            left = 0f,
                                            top = -size.height / 3,
                                            right = size.width,
                                            bottom = size.height * 0.3f
                                        ),
                                        startAngleDegrees = 0f,
                                        sweepAngleDegrees = 180f,
                                        forceMoveTo = false
                                    )
                                    close()
                                }
                                return Outline.Generic(path)
                            }
                        })
                        .background(color = Color(0xFFEFF6FC))
                        .fillMaxSize()
                ) {

                    Spacer(modifier = Modifier.height(10.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 250.dp)
                            .padding(horizontal = 16.dp)
                    ) {
                        Card(
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFFFFFFF),
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.profile),
                                        contentDescription = "nama",
                                        tint = Color.Black,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Text(
                                        "Budi Wahyudi",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Normal,
                                        fontFamily = customFontFamily
                                    )
                                }
                            }
                        }
                        Card(
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFFFFFFF),
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .padding(top = 6.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.LocationOn,
                                        contentDescription = "Alamat",
                                        tint = Color.Black,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Text(
                                        "Tunas Regency",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Normal,
                                        fontFamily = customFontFamily
                                    )
                                }
                            }
                        }
                        Card(
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                            colors = CardDefaults.cardColors(
                                containerColor = Color(0xFFFFFFFF),
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .padding(top = 6.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Email,
                                        contentDescription = "email",
                                        tint = Color.Black,
                                        modifier = Modifier.size(24.dp)
                                    )
                                    Spacer(modifier = Modifier.width(16.dp))
                                    Text(
                                        "budii@gmail.com",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Normal,
                                        fontFamily = customFontFamily
                                    )
                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Button(
                                onClick = {
                                    navController.navigate(Routes.EditProfileActivity)
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(
                                        0xFF5E7BF9
                                    )
                                )
                            ) {
                                Text("Edit Profile", fontWeight = FontWeight.SemiBold, fontFamily = customFontFamily)
                            }
                        }
                    }
                }
                // INI AGHHH SUSAH BAT
                Image(
                    painter = painterResource(id = R.drawable.editprofile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(150.dp)
                        .align(Alignment.TopCenter)
                        .offset(y = 100.dp)
                        .clip(MaterialTheme.shapes.medium)
                )
            }
        }
    }
}