package com.example.aquasmart10.crud.ikan

import androidx.compose.foundation.background
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun PengingatPanen(navController: NavController) {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold), Font(R.font.regular, FontWeight.Normal)
    )
    val openAlertDialog = remember { mutableStateOf(false) }
    val checked = remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFEFF6FC),
                shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 95.dp)
        ) {
            Text(
                "Pengingat Panen",
                fontFamily = customFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 16.dp, start = 25.dp)
            )
            Row(
                modifier = Modifier.padding(start = 25.dp, top = 16.dp)
            ) {
                Text(
                    "Hari ini",
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
                Text(
                    "(2)",
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp)
            ) {
                items(5) { index ->
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFFFFFFF),
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Row {
                                Text(
                                    "Panen Kolam A-A1",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = customFontFamily
                                )
                            }
                            Row(
                                modifier = Modifier.padding(top = 16.dp)
                            ) {
                                Text(
                                    "Jumlah Ikan :",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    fontFamily = customFontFamily
                                )
                                Text(
                                    "300",
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = customFontFamily,
                                    modifier = Modifier.padding(start = 4.dp)
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .padding(top = 4.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        "Jam :",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Normal,
                                        fontFamily = customFontFamily
                                    )
                                    Text(
                                        "16.30.00",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(start = 4.dp),
                                        fontFamily = customFontFamily
                                    )
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Checkbox(
                                        checked = checked.value,
                                        onCheckedChange = { checked.value = it },
                                        modifier = Modifier
                                            .size(30.dp)
                                            .padding(end = 4.dp)
                                    )
                                    IconButton(
                                        onClick = { openAlertDialog.value = true },
                                        modifier = Modifier
                                            .size(40.dp)
                                            .padding(end = 4.dp),
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.sampah),
                                            contentDescription = "Trash",
                                            modifier = Modifier
                                                .size(26.dp)
                                                .padding(start = 6.dp),
                                            tint = Color(0xFFEC221F)
                                        )
                                    }
                                    IconButton(
                                        onClick = {
                                            navController.navigate(Routes.EditJadwalPanenActivity)
                                        }, modifier = Modifier.size(40.dp)
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.edit),
                                            contentDescription = "Edit",
                                            modifier = Modifier
                                                .size(26.dp)
                                                .padding(start = 6.dp),
                                            tint = Color(0XFF2C793E)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (openAlertDialog.value) {
            AlertDialog(containerColor = Color.White, onDismissRequest = {
                openAlertDialog.value = false
            }, title = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Notifikasi",
                        fontFamily = customFontFamily,
                        textAlign = TextAlign.Center
                    )
                }
            }, text = {
                Text(
                    text = "Anda yakin ingin mengahpus data ini?",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontFamily = customFontFamily
                )
            }, confirmButton = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    TextButton(
                        onClick = {
                            openAlertDialog.value = false
                        },
                        modifier = Modifier.background(
                                Color.Red,
                                shape = RoundedCornerShape(8.dp)
                            )
                    ) {
                        Text("Hapus", color = Color.White, fontFamily = customFontFamily)
                    }
                    TextButton(
                        onClick = {
                            openAlertDialog.value = false
                        },
                        modifier = Modifier.background(
                                Color.Black,
                                shape = RoundedCornerShape(8.dp)
                            )
                    ) {
                        Text("Batal", color = Color.White, fontFamily = customFontFamily)
                    }
                }
            })
        }
    }
}