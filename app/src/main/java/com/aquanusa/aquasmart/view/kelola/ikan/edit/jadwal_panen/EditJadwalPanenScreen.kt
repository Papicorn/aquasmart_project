package com.aquanusa.aquasmart.view.kelola.ikan.edit.jadwal_panen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditJadwalPanenScreen(navController: NavController) {
//    VAL VAR
    val list = listOf("Kolam A-A1", "Kolam B-B1")
    var selectedText by remember { mutableStateOf("") }
    var isExpanded by remember { mutableStateOf(false) }

    // Data Pickers
    var showDatePickerJadwal by remember { mutableStateOf(false) }
    var selectedDateJadwal by remember { mutableStateOf("") }
    var selectedDateJadwal1 by remember { mutableStateOf<Long?>(null) }
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
                                "Edit Jadwal Panen Kolam A-A1",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Spacer(modifier = Modifier.padding(vertical = 6.dp))

                            Column {
                                Card(
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    ExposedDropdownMenuBox(modifier = Modifier
                                        .fillMaxWidth(),
                                        expanded = isExpanded,
                                        onExpandedChange = {
                                            isExpanded = !isExpanded
                                        }) {
                                        TextField(
                                            modifier = Modifier
                                                .menuAnchor()
                                                .fillMaxWidth(),
                                            value = "A-A1",
                                            label = { Text("-- Pilih Kolam --") },
                                            onValueChange = {},
                                            colors = TextFieldDefaults.colors(
                                                unfocusedContainerColor = Color.White,
                                                focusedContainerColor = Color.White,
                                                unfocusedIndicatorColor = Color.Transparent,
                                                focusedIndicatorColor = Color.Transparent
                                            ),
                                            textStyle = TextStyle(fontSize = 16.sp),
                                            shape = RoundedCornerShape(15.dp),
                                            trailingIcon = {
                                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                                            }
                                        )
                                        ExposedDropdownMenu(
                                            expanded = isExpanded,
                                            onDismissRequest = { isExpanded = false },
                                            modifier = Modifier.background(Color.White)
                                        ) {
                                            list.forEachIndexed { index, text ->
                                                DropdownMenuItem(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    text = {
                                                        Text(
                                                            text = text,
                                                            fontSize = 16.sp
                                                        )
                                                    },
                                                    onClick = {
                                                        selectedText = list[index]
                                                        isExpanded = false
                                                    },
                                                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                                )
                                            }
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
                                        .fillMaxWidth()
                                        .clickable { showDatePickerJadwal = true },
                                ) {
                                    TextField(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        value = "30/11/2024",
                                        label = { Text("-- Tanggal --") },
                                        onValueChange = {},
                                        readOnly = true,
                                        colors = TextFieldDefaults.colors(
                                            unfocusedContainerColor = Color.White,
                                            focusedContainerColor = Color.White,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent
                                        ),
                                        textStyle = TextStyle(fontSize = 16.sp),
                                        shape = RoundedCornerShape(15.dp),
                                        trailingIcon = {
                                            Icon(
                                                imageVector = Icons.Filled.CalendarMonth,
                                                contentDescription = "Edit",
                                                tint = Color.Black,
                                                modifier = Modifier.clickable {
                                                    showDatePickerJadwal = true
                                                }
                                            )
                                        }
                                    )
                                }
                                if (showDatePickerJadwal) {
                                    DatePickerEditJadwalPanen(
                                        onDateSelected = { dateInMillis ->
                                            dateInMillis?.let {
                                                if (selectedDateJadwal1 != null && it > selectedDateJadwal1!!) {
                                                    // Beri pesan kesalahan atau peringatan kepada pengguna
                                                } else {
                                                    selectedDateJadwal1 = it
                                                    selectedDateJadwal = SimpleDateFormat(
                                                        "dd/MM/yyyy",
                                                        Locale.getDefault()
                                                    ).format(it)
                                                }
                                            }
                                            showDatePickerJadwal = false
                                        },
                                        onDismiss = { showDatePickerJadwal = false }
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
                                            navController.navigate("Jadwal Panen")
                                        },
                                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E7BF9))
                                    ) {
                                        Text("Simpan", fontWeight = FontWeight.SemiBold)
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerEditJadwalPanen(
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