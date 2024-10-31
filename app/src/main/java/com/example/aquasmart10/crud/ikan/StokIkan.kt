package com.example.aquasmart10.crud.ikan

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aquasmart10.R
import com.example.aquasmart10.Routes

@Composable
fun StokIkan(navController: NavController) {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )
    val openAlertDialog = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFEFF6FC), shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                "Total ikan keseluruhan",
                fontFamily = customFontFamily,
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 16.dp, start = 25.dp)
            )
            Text(
                "600 Ekor",
                fontFamily = customFontFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(start = 25.dp)
            )
            Row(
                modifier = Modifier.padding(start = 25.dp)
            ) {
                Text(
                    "dari",
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp
                )
                Text(
                    "2",
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
                Text(
                    "kolam",
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            ) {
                item {
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFFFFFFF),
                        ),
                        onClick = {
                            navController.navigate(Routes.OverviewStokIkan)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Row {
                                Text(
                                    "A-A1",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Text(
                                        "Merah/Hitam :",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Normal
                                    )
                                    Text(
                                        "114/115",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 4.dp)
                                    )
                                }
                            }
                            Row(
                                modifier = Modifier.padding(top = 16.dp)
                            ) {
                                Text(
                                    "Tanggal tebar :",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal
                                )
                                Text(
                                    "21 October 2024",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 4.dp)
                                )
                            }
                            Row(
                                modifier = Modifier.padding(top = 16.dp)
                            ) {
                                Text(
                                    "Berat :",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal
                                )
                                Text(
                                    "1,5 kg/Ikan",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 4.dp)
                                )
                                Row (
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.End
                                ){
                                    IconButton(
                                        onClick = { openAlertDialog.value = true },
                                        modifier = Modifier.clickable { },
                                        content = {
                                            Icon(
                                                painter = painterResource(id = R.drawable.sampah),
                                                contentDescription = "Trash",
                                                modifier = Modifier.size(18.dp),
                                                tint = Color.Red
                                            )
                                        }
                                    )
                                    IconButton(
                                        onClick = {
                                            navController.navigate(Routes.EditIkanActivity)
                                        },
                                        modifier = Modifier.clickable { },
                                        content = {
                                            Icon(
                                                painter = painterResource(id = R.drawable.edit),
                                                contentDescription = "Edit",
                                                modifier = Modifier.size(18.dp),
                                                tint = Color.Green
                                            )
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }

        if (openAlertDialog.value) {
            AlertDialog(
                containerColor = Color.White,
                onDismissRequest = {
                    openAlertDialog.value = false
                },
                title = {
                    Text(text = "Konfirmasi Hapus")
                },
                text = {
                    Text(text = "Apakah Anda yakin ingin menghapus data ini?")
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            // Add your delete logic here
                            openAlertDialog.value = false
                        }
                    ) {
                        Text("Hapus", color = Color.Red)
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            openAlertDialog.value = false
                        }
                    ) {
                        Text("Batal", color = Color.Gray)
                    }
                }
            )
        }

        FloatingActionButton(
            onClick = { navController.navigate(Routes.TambahIkanActivity) },
            containerColor = Color(0xFFFFFFFF),
            contentColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 18.dp, bottom = 40.dp)
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }
    }
}