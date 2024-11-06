package com.example.aquasmart10.crud.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aquasmart10.R
import com.example.aquasmart10.Routes

@Composable
fun ProfileAwal(navController: NavController) {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )
    val openAlertDialog = remember { mutableStateOf(false) }

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
        Row(
            modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.editprofile),
                contentDescription = "Profile Awal",
            )
            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    "Budi Wahyudi",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = customFontFamily
                )
                Text(
                    "Pengelola",
                    fontSize = 20.sp,
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.Normal
                )
            }
        }
        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        ) {
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFFFFFF),
                ),
                onClick = {
                    navController.navigate(Routes.OverviewProfileActivity)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
                    .height(55.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Stok Ikan",
                        colorFilter = ColorFilter.tint(Color.Black),
                        modifier = Modifier
                            .size(35.dp)
                            .padding(start = 16.dp)
                    )
                    Text(
                        "Edit Profile",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = customFontFamily,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFFFFFF),
                ),
                onClick = { openAlertDialog.value = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Logout,
                        contentDescription = "Back",
                        tint = Color.Red,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(start = 16.dp)
                    )
                    Text(
                        "Keluar",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = customFontFamily,
                        color = Color.Red,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
                if (openAlertDialog.value) {
                    AlertDialog(
                        containerColor = Color.White,
                        onDismissRequest = {
                            openAlertDialog.value = false
                        },
                        title = {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Logout,
                                    contentDescription = "logout",
                                    tint = Color.Black,
                                    modifier = Modifier
                                        .size(70.dp)
                                )
                            }
                        },
                        text = {
                            Text(
                                text = "Apakah kamu yakin akan keluar?",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontFamily = customFontFamily
                            )
                        },
                        confirmButton = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                TextButton(
                                    onClick = {
                                        openAlertDialog.value = false
                                    },
                                    modifier = Modifier
                                        .background(Color.Red, shape = RoundedCornerShape(8.dp))
                                ) {
                                    Text("Keluar", color = Color.White,  fontFamily = customFontFamily)
                                }
                                TextButton(
                                    onClick = {
                                        openAlertDialog.value = false
                                    },
                                    modifier = Modifier
                                        .background(Color.Black, shape = RoundedCornerShape(8.dp))
                                ) {
                                    Text("Batal", color = Color.White, fontFamily = customFontFamily)
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}