package com.aquanusa.aquasmart.view.notifikasi

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aquanusa.aquasmart.R

@Composable
fun NotifikasiScreen() {
    val openAlertDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFEFF6FC)
            ),
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 17.dp, end = 17.dp, top = 25.dp, bottom = 103.dp)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    item {
                        Column {
                            Text(
                                "Notifikasi",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Spacer(modifier = Modifier.padding(vertical = 6.dp))

                            Column {
                                Card(
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(0xFFFFFFFF),
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight(),
                                    border = BorderStroke(1.dp, Color.Red)
                                ) {
                                    Column(
                                        modifier = Modifier.padding(16.dp)
                                    ) {
                                        Row {
                                            Image(
                                                painter = painterResource(id = R.drawable.alarm),
                                                contentDescription = "Notifikasi",
                                                modifier = Modifier.size(16.dp)
                                            )
                                            Text(
                                                "Reminder",
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(start = 6.dp)
                                            )
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.End
                                            ) {
                                                IconButton(
                                                    onClick = { openAlertDialog.value = true },
                                                    modifier = Modifier
                                                        .size(24.dp)
                                                        .padding(end = 4.dp),
                                                ) {
                                                    Icon(
                                                        imageVector = Icons.Default.MoreVert,
                                                        contentDescription = "Trash",
                                                        modifier = Modifier.size(18.dp),
                                                        tint = Color.Black
                                                    )
                                                }
                                            }
                                        }
                                        Row(
                                            modifier = Modifier.padding(top = 16.dp, end = 10.dp)
                                        ) {
                                            Text(
                                                "Jadwal panen hari ini pada jam 09.00 WIB di kolam A2 dan A4.",
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Normal
                                            )
                                        }
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(top = 20.dp, end = 12.dp)
                                                .align(AbsoluteAlignment.Right),
                                            horizontalArrangement = Arrangement.End,
                                        ) {
                                            Row {
                                                Text(
                                                    "Jum'at, 20 September 2024",
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight.Normal
                                                )
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
                                                Image(
                                                    imageVector = Icons.Default.Info,
                                                    contentDescription = "Info",
                                                    modifier = Modifier
                                                        .size(40.dp)
                                                        .padding(bottom = 8.dp)
                                                )
                                                Text(text = "Notifikasi")
                                            }
                                        }, text = {
                                            Text(
                                                text = "Jadwal panen hari ini pada jam 09.00 WIB di kolam A2 dan A4.",
                                                modifier = Modifier.fillMaxWidth(),
                                                textAlign = TextAlign.Center
                                            )
                                        }, confirmButton = {
                                            Box(
                                                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                                            ) {
                                                TextButton(
                                                    onClick = {
                                                        openAlertDialog.value = false
                                                    }, modifier = Modifier.background(
                                                        Color.Black, shape = RoundedCornerShape(8.dp)
                                                    )
                                                ) {
                                                    Text("Oke", color = Color.White)
                                                }
                                            }
                                        })
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