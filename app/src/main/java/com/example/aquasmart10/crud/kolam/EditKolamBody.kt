package com.example.aquasmart10.crud.kolam

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aquasmart10.R
import androidx.navigation.NavController
import com.example.aquasmart10.Routes

@Composable
fun EditKolamBody(navController: NavController) {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )

    var namaAwalanKolam by remember { mutableStateOf("") }
    var namaKolam by remember { mutableStateOf("") }
    var kapasitas by remember { mutableStateOf("") }
    var diameter by remember { mutableStateOf("") }
    var kedalaman by remember { mutableStateOf("") }
    var phAirPagi by remember { mutableStateOf("") }
    var phAirSore by remember { mutableStateOf("") }

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
                        text = "Edit Kolam",
                        fontFamily = customFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(bottom = 16.dp)

                    )

                    //kolom input 1
                    TextField(
                        value = namaAwalanKolam,
                        onValueChange = { namaAwalanKolam = it },
                        label = {
                            Text(
                                text = "Nama Awalan Kolam",
                                fontFamily = customFontFamily
                            )
                        },
                        placeholder = { Text("Edit nama awalan kolam") },
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
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    //kolom input 2
                    TextField(
                        value = namaKolam,
                        onValueChange = { namaKolam = it },
                        label = {
                            Text(
                                text = "Nama Kolam",
                                fontFamily = customFontFamily
                            )
                        },
                        placeholder = { Text("Edit nama Kolam") },
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
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    //kolom input 3
                    TextField(
                        value = kapasitas,
                        onValueChange = { kapasitas = it },
                        label = {
                            Text(
                                text = "Kapasitas",
                                fontFamily = customFontFamily
                            )
                        },
                        placeholder = { Text("Edit jumlah kapasitas") },
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
                        )
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    //kolom input 4
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = diameter,
                            onValueChange = { diameter = it },
                            label = {
                                Text(
                                    text = "Diameter",
                                    fontFamily = customFontFamily
                                )
                            },
                            placeholder = {
                                Text("Edit nilai diameter")
                            },
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
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
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
                                text = "meter",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontFamily = customFontFamily,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier

                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    //kolom input 5
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(IntrinsicSize.Min),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = kedalaman,
                            onValueChange = { kedalaman = it },
                            label = {
                                Text(
                                    text = "Kedalaman",
                                    fontFamily = customFontFamily
                                )
                            },
                            placeholder = {
                                Text("Edit nilai Kedalaman")
                            },
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
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
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
                                text = "meter",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontFamily = customFontFamily,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier

                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    TextField(
                        value = phAirPagi,
                        onValueChange = { phAirPagi = it },
                        label = {
                            Text(
                                text = "PH air ",
                                fontFamily = customFontFamily
                            )
                        },
                        placeholder = { Text("Edit PH air ") },
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
                        )
                    )

                    Button(
                        onClick = { navController.navigate(Routes.KolamIkanScreen) },
                        modifier = Modifier
                            .align(Alignment.End)
                            .padding(top = 20.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E7BF9))
                    ) {
                        Text(
                            text = "Simpan",
                            fontFamily = customFontFamily,
                            fontSize = 16.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(3.dp)
                        )
                    }
                }
            }
        }
    }
}

