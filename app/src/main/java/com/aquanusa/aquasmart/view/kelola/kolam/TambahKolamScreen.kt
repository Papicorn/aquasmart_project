package com.aquanusa.aquasmart.view.kelola.kolam

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
import androidx.compose.foundation.layout.wrapContentWidth
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
fun TambahKolamScreen() {
    //    VAL VAR
    val focusManager = LocalFocusManager.current

    var awalanKolam by remember { mutableStateOf("") }
    var awalanKolamsub by remember { mutableStateOf("") }

    var namaKolam by remember { mutableStateOf("") }
    var namaKolamsub by remember { mutableStateOf("") }

    var kapasitas by remember { mutableStateOf("") }
    var kapasitassub by remember { mutableStateOf("") }

    var diameter by remember { mutableStateOf("") }
    var diametersub by remember { mutableStateOf("") }

    var kedalaman by remember { mutableStateOf("") }
    var kedalamansub by remember { mutableStateOf("") }

    var phAir by remember { mutableStateOf("") }
    var phAirsub by remember { mutableStateOf("") }
//    END VAL VAR

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
                                "Tambah Kolam",
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
                                        value = awalanKolam,
                                        label = { Text("Nama awalan kolam") },
                                        onValueChange = { awalanKolam = it },
                                        colors = TextFieldDefaults.colors(
                                            unfocusedContainerColor = Color.White,
                                            focusedContainerColor = Color.White,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent
                                        ),
                                        textStyle = TextStyle(fontSize = 16.sp),
                                        shape = RoundedCornerShape(15.dp),
                                        keyboardActions = KeyboardActions(onDone = {
                                            awalanKolamsub = awalanKolam
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
                                        value = namaKolam,
                                        label = { Text("Nama kolam") },
                                        onValueChange = { namaKolam = it },
                                        colors = TextFieldDefaults.colors(
                                            unfocusedContainerColor = Color.White,
                                            focusedContainerColor = Color.White,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent
                                        ),
                                        textStyle = TextStyle(fontSize = 16.sp),
                                        shape = RoundedCornerShape(15.dp),
                                        keyboardActions = KeyboardActions(onDone = {
                                            namaKolamsub = namaKolam
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
                                        value = kapasitas,
                                        label = { Text("Kapasitas") },
                                        onValueChange = { kapasitas = it },
                                        colors = TextFieldDefaults.colors(
                                            unfocusedContainerColor = Color.White,
                                            focusedContainerColor = Color.White,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent
                                        ),
                                        textStyle = TextStyle(fontSize = 16.sp),
                                        shape = RoundedCornerShape(15.dp),
                                        keyboardActions = KeyboardActions(onDone = {
                                            kapasitassub = kapasitas
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
                                            value = diameter,
                                            label = { Text("Diameter") },
                                            onValueChange = { diameter = it },
                                            colors = TextFieldDefaults.colors(
                                                unfocusedContainerColor = Color.White,
                                                focusedContainerColor = Color.White,
                                                unfocusedIndicatorColor = Color.Transparent,
                                                focusedIndicatorColor = Color.Transparent
                                            ),
                                            textStyle = TextStyle(fontSize = 16.sp),
                                            shape = RoundedCornerShape(15.dp),
                                            keyboardActions = KeyboardActions(onDone = {
                                                diametersub = diameter
                                                focusManager.clearFocus()
                                            })
                                        )
                                        Box(
                                            modifier = Modifier
                                                .background(Color.LightGray)
                                                .wrapContentWidth()
                                                .padding(vertical = 18.dp, horizontal = 18.dp)
                                                .fillMaxHeight(),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "Meter",
                                                color = Color.Black,
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
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
                                            value = kedalaman,
                                            label = { Text("Kedalaman") },
                                            onValueChange = { kedalaman = it },
                                            colors = TextFieldDefaults.colors(
                                                unfocusedContainerColor = Color.White,
                                                focusedContainerColor = Color.White,
                                                unfocusedIndicatorColor = Color.Transparent,
                                                focusedIndicatorColor = Color.Transparent
                                            ),
                                            textStyle = TextStyle(fontSize = 16.sp),
                                            shape = RoundedCornerShape(15.dp),
                                            keyboardActions = KeyboardActions(onDone = {
                                                kedalamansub = kedalaman
                                                focusManager.clearFocus()
                                            })
                                        )
                                        Box(
                                            modifier = Modifier
                                                .background(Color.LightGray)
                                                .wrapContentWidth()
                                                .padding(vertical = 18.dp, horizontal = 18.dp)
                                                .fillMaxHeight(),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                text = "Meter",
                                                color = Color.Black,
                                                fontSize = 18.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
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
                                        value = phAir,
                                        label = { Text("pH Air") },
                                        onValueChange = { phAir = it },
                                        colors = TextFieldDefaults.colors(
                                            unfocusedContainerColor = Color.White,
                                            focusedContainerColor = Color.White,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent
                                        ),
                                        textStyle = TextStyle(fontSize = 16.sp),
                                        shape = RoundedCornerShape(15.dp),
                                        keyboardActions = KeyboardActions(onDone = {
                                            phAirsub = phAir
                                            focusManager.clearFocus()
                                        })
                                    )
                                }

                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp),
                                    horizontalArrangement = Arrangement.End
                                ) {
                                    Button(
                                        onClick = {
//                                            navController.navigate("Kelola Kolam")
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