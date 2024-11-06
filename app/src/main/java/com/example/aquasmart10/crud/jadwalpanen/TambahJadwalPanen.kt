package com.example.aquasmart10.component

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
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
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TambahJadwalPanen(navController: NavController) {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )

    //Dropdown
    val listKolamTambahJadwalPanen = listOf("Kolam A-A1", "Kolam B-B1")
    var selectedTextTambahJadwalPanen by remember { mutableStateOf("-- Pilih Kolam --") }
    var isExpandedTambahJadwalPanen by remember { mutableStateOf(false) }


    // Data Pickers
    var showDatePickerTambahJadwalPanen by remember { mutableStateOf(false) }
    var selectedDateTambahJadwalPanen by remember { mutableStateOf("") }
    var selectedDateTambahJadwalPanen1 by remember { mutableStateOf<Long?>(null) }

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
                "Tambah Jadwal Panen",
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
                            expanded = isExpandedTambahJadwalPanen,
                            onExpandedChange = { isExpandedTambahJadwalPanen = !isExpandedTambahJadwalPanen }
                        ) {
                            TextField(
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth(),
                                value = selectedTextTambahJadwalPanen,
                                onValueChange = {},
                                readOnly = true,
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Color.White,
                                    focusedContainerColor = Color.White,
                                ),
                                textStyle = TextStyle(fontSize = 16.sp, fontFamily = customFontFamily),
                                shape = RoundedCornerShape(12.dp),
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedTambahJadwalPanen)
                                }
                            )
                            ExposedDropdownMenu(
                                expanded = isExpandedTambahJadwalPanen,
                                onDismissRequest = { isExpandedTambahJadwalPanen = false },
                                modifier = Modifier.background(Color.White)
                            ) {
                                listKolamTambahJadwalPanen.forEachIndexed { index, text ->
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
                                            selectedTextTambahJadwalPanen = listKolamTambahJadwalPanen[index]
                                            isExpandedTambahJadwalPanen = false
                                        },
                                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Tanggal Tebar
                    Card(
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .clickable { showDatePickerTambahJadwalPanen = true },
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = if (selectedDateTambahJadwalPanen.isEmpty()) "Tanggal Tebar" else selectedDateTambahJadwalPanen,
                                fontFamily = customFontFamily,
                                fontSize = 16.sp,
                                color = Color.Black,
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(
                                onClick = { showDatePickerTambahJadwalPanen = true },
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.CalendarMonth,
                                    contentDescription = "Edit",
                                    tint = Color.Black
                                )
                            }
                        }
                    }
                    if (showDatePickerTambahJadwalPanen) {
                        DatePickerTambahJadwalPanen(
                            onDateSelected = { dateInMillis ->
                                dateInMillis?.let {
                                    if (selectedDateTambahJadwalPanen1 != null && it > selectedDateTambahJadwalPanen1!!) {
                                        // Beri pesan kesalahan atau peringatan kepada pengguna
                                    } else {
                                        selectedDateTambahJadwalPanen1 = it
                                        selectedDateTambahJadwalPanen = SimpleDateFormat(
                                            "dd/MM/yyyy",
                                            Locale.getDefault()
                                        ).format(it)
                                    }
                                }
                                showDatePickerTambahJadwalPanen = false
                            },
                            onDismiss = { showDatePickerTambahJadwalPanen = false }
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(onClick = {
                            navController.navigate(Routes.PengingatPanenActivity)
                        },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E7BF9))
                        ) {
                            Text("Tambah", fontFamily = customFontFamily, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerTambahJadwalPanen(
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
