package com.aquanusa.aquasmart.view.kelola.pakan.edit.stok_pakan

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun EditStokPakanScreen(navController: NavController) {
    // VAL
    val focusManager = LocalFocusManager.current

    var jenisPakan by remember { mutableStateOf("Pelet") }
    var jenisPakansub by remember { mutableStateOf("") }

    var namaPakan by remember { mutableStateOf("Pelet Bagus") }
    var namaPakansub by remember { mutableStateOf("") }

    var stok by remember { mutableStateOf("5,5") }
    var stoksub by remember { mutableStateOf("") }
    // VAL

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
                                "Edit Stok Pakan",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Spacer(modifier = Modifier.padding(vertical = 6.dp))

                            Column {
                                Card(
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(
                                            0xFFFFFFFF
                                        )
                                    ),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                ) {
                                    TextField(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        value = jenisPakan,
                                        label = { Text("Jenis Pakan") },
                                        onValueChange = { jenisPakan = it },
                                        colors = TextFieldDefaults.colors(
                                            unfocusedContainerColor = Color.White,
                                            focusedContainerColor = Color.White,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent
                                        ),
                                        textStyle = TextStyle(fontSize = 16.sp),
                                        shape = RoundedCornerShape(15.dp),
                                        keyboardActions = KeyboardActions(onDone = {
                                            jenisPakansub = jenisPakan
                                            focusManager.clearFocus()
                                        })
                                    )
                                }

                                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                                Card(
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(
                                            0xFFFFFFFF
                                        )
                                    ),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                ) {
                                    TextField(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        value = namaPakan,
                                        label = { Text("Nama Pakan") },
                                        onValueChange = { namaPakan = it },
                                        colors = TextFieldDefaults.colors(
                                            unfocusedContainerColor = Color.White,
                                            focusedContainerColor = Color.White,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent
                                        ),
                                        textStyle = TextStyle(fontSize = 16.sp),
                                        shape = RoundedCornerShape(15.dp),
                                        keyboardActions = KeyboardActions(onDone = {
                                            namaPakansub = namaPakan
                                            focusManager.clearFocus()
                                        })
                                    )
                                }

                                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                                Card(
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(
                                            0xFFFFFFFF
                                        )
                                    ),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .fillMaxHeight(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        TextField(
                                            modifier = Modifier,
                                            //                                            .fillMaxWidth(),
                                            value = stok,
                                            label = { Text("Stok") },
                                            onValueChange = { stok = it },
                                            colors = TextFieldDefaults.colors(
                                                unfocusedContainerColor = Color.White,
                                                focusedContainerColor = Color.White,
                                                unfocusedIndicatorColor = Color.Transparent,
                                                focusedIndicatorColor = Color.Transparent
                                            ),
                                            textStyle = TextStyle(fontSize = 16.sp),
                                            shape = RoundedCornerShape(15.dp),
                                            keyboardActions = KeyboardActions(onDone = {
                                                stoksub = stok
                                                focusManager.clearFocus()
                                            })
                                        )
                                        Box(
                                            modifier = Modifier
                                                .background(Color.LightGray)
                                                .width(75.dp)
                                                .padding(vertical = 18.dp)
                                                .fillMaxHeight(),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "KG",
                                                color = Color.Black,
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold
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
                                            navController.navigate("Stok Pakan")
                                        },
                                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E7BF9))
                                    ) {
                                        Text("Tambah", fontWeight = FontWeight.SemiBold)
                                    }
                                }


                                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}