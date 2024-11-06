package com.example.aquasmart10.crud.pakan


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aquasmart10.R
import androidx.compose.material3.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.input.KeyboardType
import com.example.aquasmart10.ui.theme.AquaSmart10Theme
import java.text.SimpleDateFormat
import java.util.Locale
import androidx.navigation.NavController
import com.example.aquasmart10.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TambahJadwalPakanBody(navController: NavController) {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )

    var jenisPakan by remember { mutableStateOf("") }
    var namaPakan by remember { mutableStateOf("") }
    var stok by remember { mutableStateOf("") }

    //pilih kolam
    var isExpanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("--Pilih Kolam--") }
    val listKolam = listOf("Kolam 1", "kolam 2", "Kolam 3")

    //tentukan tanggal jadwal pakan
    var selectedDate by remember { mutableStateOf("Pilih Tanggal") }
    var showDateTanggalJadwalPakan by remember { mutableStateOf(false) }
    var selectedDateTanggalJadwalPakan by remember { mutableStateOf("") }
    var selectedDateTambahTanggalJadwalPakan by remember { mutableStateOf<Long?>(null) }

    //check box
    var isChecked by remember { mutableStateOf(false) }

    //dosis pakan
    var dosisPakan by remember { mutableStateOf("") }

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
                LazyColumn(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    item {

                        //pilih kolam
                        Card(
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            ExposedDropdownMenuBox(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),
                                expanded = isExpanded,
                                onExpandedChange = { isExpanded = !isExpanded }
                            ) {
                                TextField(
                                    modifier = Modifier
                                        .menuAnchor()
                                        .fillMaxWidth(),
                                    value = selectedOption,
                                    onValueChange = {},
                                    readOnly = true,
                                    colors = TextFieldDefaults.colors(
                                        unfocusedTextColor = Color.Black,
                                        focusedTextColor = Color.Black,
                                        focusedIndicatorColor = Color.Transparent,
                                        unfocusedIndicatorColor = Color.Transparent,
                                        unfocusedContainerColor = Color.White,
                                        focusedContainerColor = Color.White,
                                    ),
                                    shape = RoundedCornerShape(15.dp),
                                    trailingIcon = {
                                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                                    }
                                )
                                ExposedDropdownMenu(
                                    expanded = isExpanded,
                                    onDismissRequest = { isExpanded = false },
                                    modifier = Modifier
                                        .background(Color.White)
                                ) {
                                    listKolam.forEachIndexed { index, text ->
                                        DropdownMenuItem(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            text = {
                                                Text(
                                                    text = text,
                                                    fontSize = 14.sp,
                                                    fontFamily = customFontFamily,
                                                    color = Color.Black
                                                )
                                            },
                                            onClick = {
                                                selectedOption = listKolam[index]
                                                isExpanded = false
                                            },
                                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                        )
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        //tanggal jadwal pakan
                        Card(
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .clickable { showDateTanggalJadwalPakan = true },
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = if (selectedDateTanggalJadwalPakan.isEmpty()) "Tanggal Tebar" else selectedDateTanggalJadwalPakan,
                                    fontFamily = customFontFamily,
                                    fontSize = 14.sp,
                                    color = Color.Black,
                                    modifier = Modifier.weight(1f)
                                )
                                IconButton(
                                    onClick = { showDateTanggalJadwalPakan = true },
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.CalendarMonth,
                                        contentDescription = "icon tanggal",
                                        tint = Color.Black
                                    )
                                }
                            }
                        }
                        if (showDateTanggalJadwalPakan) {
                            DatePickerTambah(
                                onDateSelected = { dateInMillis ->
                                    dateInMillis?.let { date ->
                                        selectedDateTambahTanggalJadwalPakan = date // Mengatur tanggal terpilih
                                        selectedDateTanggalJadwalPakan = SimpleDateFormat(
                                            "dd/MM/yyyy",
                                            Locale.getDefault()
                                        ).format(dateInMillis)
                                    }
                                    showDateTanggalJadwalPakan = false
                                },
                                onDismiss = { showDateTanggalJadwalPakan = false }
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Ulang hari berikut nya?",
                                fontFamily = customFontFamily,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier
                                    .clickable { isChecked= !isChecked }
                            )
                            Checkbox(
                                checked = isChecked,
                                onCheckedChange = { isChecked = it },

                                )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TextField(
                                value = dosisPakan,
                                onValueChange = { dosisPakan = it },
                                label = {
                                    Text(
                                        text = "Dosis Pakan",
                                        fontFamily = customFontFamily
                                    )
                                },
                                placeholder = {
                                    Text("Masukkan nilai dosis pakan")
                                },
                                modifier = Modifier
                                    .height(50.dp)
                                    .shadow(4.dp, shape = RoundedCornerShape(
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
                                    text = "kg",
                                    color = Color.Black,
                                    fontSize = 18.sp,
                                    fontFamily = customFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier

                                )
                            }
                        }
                        Button(
                            onClick = { navController.navigate(Routes.PengingatPakanActivity) },
                            modifier = Modifier
                                .align(Alignment.End)
                                .padding(top = 20.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E7BF9))
                        ) {
                            Text(
                                text = "Tambah",
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerTambah(
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
