package com.example.aquasmart10.crud.pakan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.KeyboardType
import com.example.aquasmart10.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.aquasmart10.Routes

@Composable
fun TambahPakanBody(navController: NavController) {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )

    var jenisPakan by remember { mutableStateOf("") }
    var namaPakan by remember { mutableStateOf("") }


    val focusManager = LocalFocusManager.current

    var submittedValueTambahPakanBody by remember { mutableStateOf("") }
    var intValueTambahJumlahStok by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFEFF6FC))
                .padding(20.dp)
        ) {
            Column {
                Text(
                    text = "Tambah Pakan",
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 16.dp)

                )

                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    TextField(
                        value = jenisPakan,
                        onValueChange = { jenisPakan = it },
                        label = {
                            Text(
                                text = "Jenis Pakan",
                                fontFamily = customFontFamily
                            )
                        },
                        placeholder = { Text("Masukkan Jenis Pakan Disini") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(
                                4.dp, shape = RoundedCornerShape(
                                    topStart = 15.dp,
                                    topEnd = 15.dp,
                                    bottomStart = 15.dp,
                                    bottomEnd = 15.dp
                                )
                            ),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(onDone = {
                            submittedValueTambahPakanBody = jenisPakan
                            focusManager.clearFocus()
                        })
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Card(
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    TextField(
                        value = namaPakan,
                        onValueChange = { namaPakan = it },
                        label = {
                            Text(
                                text = "Nama Pakan",
                                fontFamily = customFontFamily
                            )
                        },
                        placeholder = { Text("Masukkan Nama Pakan Disini") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .shadow(
                                4.dp, shape = RoundedCornerShape(
                                    topStart = 15.dp,
                                    topEnd = 15.dp,
                                    bottomStart = 15.dp,
                                    bottomEnd = 15.dp
                                )
                            ),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(onDone = {
                            submittedValueTambahPakanBody = namaPakan
                            focusManager.clearFocus()
                        })
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(7f)
                            .height(55.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TextField(
                                value = intValueTambahJumlahStok,
                                onValueChange = { intValueTambahJumlahStok = it },
                                label = {
                                    Text(
                                        text = "Stok",
                                        fontFamily = customFontFamily
                                    )
                                },
                                placeholder = { Text("Masukkan Jumlah Stok Ikan") },
                                modifier = Modifier
                                    .weight(1f)
                                    .shadow(
                                        4.dp, shape = RoundedCornerShape(
                                            topStart = 15.dp,
                                            bottomStart = 15.dp
                                        )
                                    ),
                                colors = TextFieldDefaults.colors(
                                    focusedContainerColor = Color.White,
                                    unfocusedContainerColor = Color.White,
                                    focusedIndicatorColor = Color.Transparent,
                                    unfocusedIndicatorColor = Color.Transparent,
                                    focusedTextColor = Color.Black,
                                    unfocusedTextColor = Color.Black
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number,
                                    imeAction = ImeAction.Done
                                ),
                                keyboardActions = KeyboardActions(onDone = {
                                    submittedValueTambahPakanBody = intValueTambahJumlahStok
                                    focusManager.clearFocus()
                                })
                            )
                            Box(
                                modifier = Modifier
                                    .shadow(
                                        5.dp, shape = RoundedCornerShape(
                                            topEnd = 15.dp,
                                            bottomEnd = 15.dp
                                        )
                                    )
                                    .background(Color.LightGray)
                                    .padding(vertical = 12.dp, horizontal = 8.dp)
                                    .width(75.dp)
                                    .fillMaxHeight(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "KG",
                                    color = Color.Black,
                                    fontSize = 18.sp,
                                    fontFamily = customFontFamily,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
                Button(
                    onClick = {
                        navController.navigate(Routes.StokPakanActivity)
                    },
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E7BF9))
                ) {
                    Text(
                        text = "Tambah",
                        fontFamily = customFontFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        modifier = Modifier
                            .padding(3.dp)
                    )
                }
            }
        }
    }
}
