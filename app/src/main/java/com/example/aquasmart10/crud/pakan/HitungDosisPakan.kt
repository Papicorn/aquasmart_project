package com.example.aquasmart10.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aquasmart10.R
import com.example.aquasmart10.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HitungDosisPakan(navController: NavController) {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold), Font(R.font.regular, FontWeight.Normal)
    )

    //Dropdown Pilih Kolam
    val listKolamHitungDosis = listOf("Kolam A-A1", "Kolam B-B1")
    var selectedTextHitungDosis by remember { mutableStateOf("-- Pilih Kolam --") }
    var isExpandedHitungDosis by remember { mutableStateOf(false) }

    //Dropdown Pilih Jenis
    val listJenisHitungDosis = listOf("Pelet Bagus", "Pelet Mantap")
    var selectedTextJenisHitungDosis by remember { mutableStateOf("-- Pilih Jenis --") }
    var isExpandedJenisHitungDosis by remember { mutableStateOf(false) }

    //Dropdown Biomasa
    val listBiomasa = listOf("1%", "3%", "6%")
    var selectedTextBiomasa by remember { mutableStateOf("-- Pilih Biomasa --") }
    var isExpandedBiomasa by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFEFF6FC),
                shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                IconButton(
                    onClick = { navController.navigate(Routes.KelolaPakanActivity) },
                    modifier = Modifier
                        .size(40.dp)
                        .padding(start = 25.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
                Text(
                    "Tambah Jadwal Panen",
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 25.dp)
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
                    // Dropdown Kolam
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        ExposedDropdownMenuBox(modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                            expanded = isExpandedHitungDosis,
                            onExpandedChange = { isExpandedHitungDosis = !isExpandedHitungDosis }) {
                            TextField(modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth(),
                                value = selectedTextHitungDosis,
                                onValueChange = {},
                                readOnly = true,
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Color.White,
                                    focusedContainerColor = Color.White,
                                ),
                                textStyle = TextStyle(fontSize = 16.sp, fontFamily = customFontFamily),
                                shape = RoundedCornerShape(12.dp),
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedHitungDosis)
                                })
                            ExposedDropdownMenu(
                                expanded = isExpandedHitungDosis,
                                onDismissRequest = { isExpandedHitungDosis = false },
                                modifier = Modifier.background(Color.White)
                            ) {
                                listKolamHitungDosis.forEachIndexed { index, text ->
                                    DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
                                        text = {
                                            Text(
                                                text = text,
                                                fontSize = 16.sp,
                                                fontFamily = customFontFamily
                                            )
                                        },
                                        onClick = {
                                            selectedTextHitungDosis = listKolamHitungDosis[index]
                                            isExpandedHitungDosis = false
                                        },
                                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    // Dropdown Jenis
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        ExposedDropdownMenuBox(modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                            expanded = isExpandedJenisHitungDosis,
                            onExpandedChange = {
                                isExpandedJenisHitungDosis = !isExpandedJenisHitungDosis
                            }) {
                            TextField(modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth(),
                                value = selectedTextJenisHitungDosis,
                                onValueChange = {},
                                readOnly = true,
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Color.White,
                                    focusedContainerColor = Color.White,
                                ),
                                textStyle = TextStyle(fontSize = 16.sp, fontFamily = customFontFamily),
                                shape = RoundedCornerShape(12.dp),
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedJenisHitungDosis)
                                })
                            ExposedDropdownMenu(
                                expanded = isExpandedJenisHitungDosis,
                                onDismissRequest = { isExpandedJenisHitungDosis = false },
                                modifier = Modifier.background(Color.White)
                            ) {
                                listJenisHitungDosis.forEachIndexed { index, text ->
                                    DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
                                        text = {
                                            Text(
                                                text = text,
                                                fontSize = 16.sp,
                                                fontFamily = customFontFamily
                                            )
                                        },
                                        onClick = {
                                            selectedTextJenisHitungDosis =
                                                listJenisHitungDosis[index]
                                            isExpandedJenisHitungDosis = false
                                        },
                                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    // Dropdown Biomasa
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        ExposedDropdownMenuBox(modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                            expanded = isExpandedBiomasa,
                            onExpandedChange = { isExpandedBiomasa = !isExpandedBiomasa }) {
                            TextField(modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth(),
                                value = selectedTextBiomasa,
                                onValueChange = {},
                                readOnly = true,
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Color.White,
                                    focusedContainerColor = Color.White,
                                ),
                                textStyle = TextStyle(fontSize = 16.sp, fontFamily = customFontFamily),
                                shape = RoundedCornerShape(12.dp),
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedBiomasa)
                                })
                            ExposedDropdownMenu(
                                expanded = isExpandedBiomasa,
                                onDismissRequest = { isExpandedBiomasa = false },
                                modifier = Modifier.background(Color.White)
                            ) {
                                listBiomasa.forEachIndexed { index, text ->
                                    DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
                                        text = {
                                            Text(
                                                text = text,
                                                fontSize = 16.sp,
                                                fontFamily = customFontFamily
                                            )
                                        },
                                        onClick = {
                                            selectedTextBiomasa = listBiomasa[index]
                                            isExpandedBiomasa = false
                                        },
                                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                    )
                                }
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {

                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E7BF9))
                        ) {
                            Text("Hitung", fontSize = 16.sp, fontFamily = customFontFamily, fontWeight = FontWeight.SemiBold)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 60.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "Jumlah pakan adalah",
                            fontFamily = customFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 25.sp,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                        Text(
                            "2 Kg",
                            fontFamily = customFontFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )
                        Text(
                            "Pelet Bagus",
                            fontFamily = customFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 25.sp
                        )
                    }
                }
            }
        }
    }
}

