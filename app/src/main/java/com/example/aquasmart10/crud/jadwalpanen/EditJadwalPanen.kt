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
fun EditJadwalPanen(navController: NavController) {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold), Font(R.font.regular, FontWeight.Normal)
    )

    //Dropdown
    val listKolamEditJadwalPanen = listOf("Kolam A-A1", "Kolam B-B1")
    var selectedTextEditJadwalPanen by remember { mutableStateOf("-- Pilih Kolam --") }
    var isExpandedEditJadwalPanen by remember { mutableStateOf(false) }


    // Data Pickers
    var showDatePickerEditJadwalPanen by remember { mutableStateOf(false) }
    var selectedDateEditJadwalPanen by remember { mutableStateOf("") }
    var selectedDateEditJadwalPanen1 by remember { mutableStateOf<Long?>(null) }

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
                "Edit Jadwal Panen",
                fontFamily = customFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(top = 16.dp, start = 25.dp)
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
                        ExposedDropdownMenuBox(modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                            expanded = isExpandedEditJadwalPanen,
                            onExpandedChange = {
                                isExpandedEditJadwalPanen = !isExpandedEditJadwalPanen
                            }) {
                            TextField(modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth(),
                                value = selectedTextEditJadwalPanen,
                                onValueChange = {},
                                readOnly = true,
                                colors = TextFieldDefaults.colors(
                                    unfocusedContainerColor = Color.White,
                                    focusedContainerColor = Color.White,
                                ),
                                shape = RoundedCornerShape(12.dp),
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedEditJadwalPanen)
                                })
                            ExposedDropdownMenu(
                                expanded = isExpandedEditJadwalPanen,
                                onDismissRequest = { isExpandedEditJadwalPanen = false },
                                modifier = Modifier.background(Color.White)
                            ) {
                                listKolamEditJadwalPanen.forEachIndexed { index, text ->
                                    DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
                                        text = {
                                            Text(
                                                text = text,
                                                fontSize = 14.sp,
                                                fontFamily = customFontFamily
                                            )
                                        },
                                        onClick = {
                                            selectedTextEditJadwalPanen =
                                                listKolamEditJadwalPanen[index]
                                            isExpandedEditJadwalPanen = false
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
                            .clickable { showDatePickerEditJadwalPanen = true },
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = if (selectedDateEditJadwalPanen.isEmpty()) "Tanggal Tebar" else selectedDateEditJadwalPanen,
                                fontFamily = customFontFamily,
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier.weight(1f)
                            )
                            IconButton(
                                onClick = { showDatePickerEditJadwalPanen = true },
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
                    if (showDatePickerEditJadwalPanen) {
                        DatePickerEditJadwalPanen(onDateSelected = { dateInMillis ->
                            dateInMillis?.let {
                                if (selectedDateEditJadwalPanen1 != null && it > selectedDateEditJadwalPanen1!!) {
                                    // Beri pesan kesalahan atau peringatan kepada pengguna
                                } else {
                                    selectedDateEditJadwalPanen1 = it
                                    selectedDateEditJadwalPanen = SimpleDateFormat(
                                        "dd/MM/yyyy", Locale.getDefault()
                                    ).format(it)
                                }
                            }
                            showDatePickerEditJadwalPanen = false
                        }, onDismiss = { showDatePickerEditJadwalPanen = false })
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(
                            onClick = {
                                navController.navigate(Routes.PengingatPanenActivity)
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E7BF9))
                        ) {
                            Text("Simpan")
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerEditJadwalPanen(
    onDateSelected: (Long?) -> Unit, onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(onDismissRequest = onDismiss, confirmButton = {
        TextButton(onClick = {
            onDateSelected(datePickerState.selectedDateMillis)
            onDismiss()
        }) {
            Text("OK")
        }
    }, dismissButton = {
        TextButton(onClick = onDismiss) {
            Text("Cancel")
        }
    }) {
        DatePicker(state = datePickerState)

    }
}
