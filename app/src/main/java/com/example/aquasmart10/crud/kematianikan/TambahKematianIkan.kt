package com.example.aquasmart10.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aquasmart10.R
import com.example.aquasmart10.Routes
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TambahKematianIkan(navController: NavController) {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )

    val listKolam = listOf("Kolam A-A1", "Kolam B-B1")
    var selectedTextKolam by remember { mutableStateOf("-- Pilih Kolam --") }
    var isExpandedKolam by remember { mutableStateOf(false) }

    val listJenis = listOf("Nila Hitam", "Nila Merah")
    var selectedTextJenis by remember { mutableStateOf("-- Pilih Jenis --") }
    var isExpandedJenis by remember { mutableStateOf(false) }


    var submittedValueJumlahKematianIkan by remember { mutableStateOf("") }

    var submittedValueLampiranKematianIkan by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current
    var intValueJumlah by remember { mutableStateOf("") }
    var intValueLampiranKematianIkan by remember { mutableStateOf("") }

    // Data Pickers
    var showDatePickerTanggalKematian by remember { mutableStateOf(false) }
    var selectedDateKematianIkan by remember { mutableStateOf("") }
    var selectedDateKematianIkanTambah by remember { mutableStateOf<Long?>(null) }
    var selectedDatePanenTambah by remember { mutableStateOf<Long?>(null) }



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
            Text(
                "Tambah Kematian Ikan",
                fontFamily = customFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(top = 16.dp, start = 25.dp)
            )
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
                        ExposedDropdownMenuBox(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            expanded = isExpandedKolam,
                            onExpandedChange = { isExpandedKolam = !isExpandedKolam }
                        ) {
                            TextField(
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth(),
                                value = selectedTextKolam,
                                onValueChange = {},
                                readOnly = true,
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Color.White,
                                    focusedContainerColor = Color.White,
                                ),
                                textStyle = TextStyle(fontFamily = customFontFamily, fontSize = 16.sp),
                                shape = RoundedCornerShape(12.dp),
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedKolam)
                                }
                            )
                            ExposedDropdownMenu(
                                expanded = isExpandedKolam,
                                onDismissRequest = { isExpandedKolam = false },
                                modifier = Modifier.background(Color.White)
                            ) {
                                listKolam.forEachIndexed { index, text ->
                                    DropdownMenuItem(
                                        modifier = Modifier.fillMaxWidth(),
                                        text = {
                                            Text(
                                                text = text,
                                                fontSize = 14.sp,
                                                fontFamily = customFontFamily
                                            )
                                        },
                                        onClick = {
                                            selectedTextKolam = listKolam[index]
                                            isExpandedKolam = false
                                        },
                                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        ExposedDropdownMenuBox(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp),
                            expanded = isExpandedJenis,
                            onExpandedChange = { isExpandedJenis = !isExpandedJenis }
                        ) {
                            TextField(
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth(),
                                value = selectedTextJenis,
                                onValueChange = {},
                                readOnly = true,
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Color.White,
                                    focusedContainerColor = Color.White,
                                ),
                                textStyle = TextStyle(fontSize = 16.sp, fontFamily = customFontFamily),
                                shape = RoundedCornerShape(12.dp),
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedJenis)
                                }
                            )
                            ExposedDropdownMenu(
                                expanded = isExpandedJenis,
                                onDismissRequest = { isExpandedJenis = false },
                                modifier = Modifier.background(Color.White)
                            ) {
                                listJenis.forEachIndexed { index, text ->
                                    DropdownMenuItem(
                                        modifier = Modifier.fillMaxWidth(),
                                        text = {
                                            Text(
                                                text = text,
                                                fontSize = 16.sp,
                                                fontFamily = customFontFamily
                                            )
                                        },
                                        onClick = {
                                            selectedTextJenis = listJenis[index]
                                            isExpandedJenis = false
                                        },
                                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .clickable { showDatePickerTanggalKematian = true },
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = if (selectedDateKematianIkan.isEmpty()) "Tanggal" else selectedDateKematianIkan,
                                fontFamily = customFontFamily,
                                fontSize = 16.sp,
                                color = Color.Black,
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(
                                onClick = { showDatePickerTanggalKematian = true },
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.CalendarMonth,
                                    contentDescription = "Edit",
                                    tint = Color.Black
                                )
                            }
                        }
                    }
                    // Jadi disini tanggal tebar gabisa duluan dibanding tanggal panen
                    if (showDatePickerTanggalKematian) {
                        DatePickerRIP(
                            onDateSelected = { dateInMillis ->
                                dateInMillis?.let {
                                    if (selectedDatePanenTambah != null && it > selectedDatePanenTambah!!) {
                                        // Beri pesan kesalahan atau peringatan kepada pengguna
                                    } else {
                                        selectedDateKematianIkanTambah = it
                                        selectedDateKematianIkan = SimpleDateFormat(
                                            "dd/MM/yyyy",
                                            Locale.getDefault()
                                        ).format(it)
                                    }
                                }
                                showDatePickerTanggalKematian = false
                            },
                            onDismiss = { showDatePickerTanggalKematian = false }
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    //Hanya bisa input angka
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        TextField(
                            value = intValueJumlah,
                            onValueChange = { intValueJumlah = it },
                            label = {
                                Text(
                                    text = "Jumlah",
                                    fontFamily = customFontFamily
                                )
                            },
                            placeholder = { Text("Isi Jumlah Kematian Ikan") },
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
                                keyboardType = KeyboardType.Number,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(onDone = {
                                submittedValueJumlahKematianIkan = intValueJumlah
                                focusManager.clearFocus()
                            })
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    ) {
                        TextField(
                            value = intValueLampiranKematianIkan,
                            onValueChange = { intValueLampiranKematianIkan = it },
                            label = {
                                Text(
                                    text = "Lampiran",
                                    fontFamily = customFontFamily
                                )
                            },
                            placeholder = { Text("Isi lampiran disini") },
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
                                submittedValueLampiranKematianIkan = intValueLampiranKematianIkan
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
                                navController.navigate(Routes.KematianIkanActivity)
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E7BF9))
                        ) {
                            Text("Tambah", fontWeight = FontWeight.SemiBold, fontFamily = customFontFamily)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerRIP(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}
