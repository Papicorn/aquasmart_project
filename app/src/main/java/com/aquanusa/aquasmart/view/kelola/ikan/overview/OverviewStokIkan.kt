package com.aquanusa.aquasmart.view.kelola.ikan.overview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aquanusa.aquasmart.view.kelola.ikan.add.stok_ikan.DatePickerTambahStokIkan
import com.aquanusa.aquasmart.view.kelola.ikan.edit.stok_ikan.DatePickerEdit
import com.aquanusa.aquasmart.viewmodel.autentikasi.PoolViewModel
import com.aquanusa.aquasmart.viewmodel.ikan.ViewModelIkan
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OverviewStokIkan(
    paramsStokIkan: (String),
    vmkolam: PoolViewModel = viewModel(),
    vmikan: ViewModelIkan = viewModel()
) {

    LaunchedEffect(Unit) {
        vmkolam.getPoolsById(paramsStokIkan)
        vmikan.getStokById(paramsStokIkan)
    }

    val kolam = vmkolam.poolList.firstOrNull()
    val ikan = vmikan._listIkan.firstOrNull()

    //    VAL VAR
    val list = listOf("Kolam A-A1", "Kolam B-B1")
    var selectedText by remember { mutableStateOf("Kolam ${kolam?.nama_awalan_kolam}-${kolam?.nama_kolam}") }
    var isExpanded by remember { mutableStateOf(false) }
    var textValue by remember { mutableStateOf("") }
    var submittedValue by remember { mutableStateOf("Kolam ${kolam?.nama_awalan_kolam}-${kolam?.nama_kolam}") }
    val focusManager = LocalFocusManager.current
    var intValue by remember { mutableStateOf("") }
    var intValueLampiran by remember { mutableStateOf("") }
    var intValueNilaHitam by remember { mutableStateOf("") }

    val pilihKolam = "Kolam ${kolam?.nama_awalan_kolam}-${kolam?.nama_kolam}"
    val tglTebar = ikan?.tgl_tebar.toString()
    val tglPanen = ikan?.tgl_panen.toString()
    val nilaMerah = ikan?.jumlah_nila_merah
    val nilaHitam = ikan?.jumlah_nila_hitam
    val berat = ikan?.berat

    // Data Pickers
    var showDatePickerTebar by remember { mutableStateOf(false) }
    var showDatePickerPanen by remember { mutableStateOf(false) }
    var selectedDateTebar by remember { mutableStateOf("") }
    var selectedDatePanen by remember { mutableStateOf("") }
    var selectedDateTebarTambah by remember { mutableStateOf<Long?>(null) }
    var selectedDatePanenTambah by remember { mutableStateOf<Long?>(null) }
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
                                "Overview Stok Ikan Kolam ${kolam?.nama_kolam}",
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
//                                            isExpanded = !isExpanded
                                        }) {
                                        TextField(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            value = pilihKolam,
                                            label = { Text("-- Pilih Kolam --") },
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
                                        .clickable { showDatePickerTebar = true },
                                ) {
                                    TextField(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        value = tglTebar,
                                        label = { Text("-- Tanggal Tebar --") },
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
//                                                    showDatePickerTebar = true
                                                }
                                            )
                                        }
                                    )
                                }
                                // Jadi disini tanggal tebar gabisa duluan dibanding tanggal panen
                                if (showDatePickerTebar) {
                                    DatePickerEdit(onDateSelected = { dateInMillis ->
                                        dateInMillis?.let {
                                            if (selectedDatePanenTambah != null && it > selectedDatePanenTambah!!) {
                                                // Beri pesan kesalahan atau peringatan kepada pengguna
                                            } else {
                                                selectedDateTebarTambah = it
                                                selectedDateTebar = SimpleDateFormat(
                                                    "dd/MM/yyyy", Locale.getDefault()
                                                ).format(it)
                                            }
                                        }
                                        showDatePickerTebar = false
                                    }, onDismiss = { showDatePickerTebar = false })
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
                                        .clickable { showDatePickerPanen = true },
                                ) {
                                    TextField(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        value = tglPanen,
                                        label = { Text("-- Tanggal Panen --") },
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
//                                                    showDatePickerPanen = true
                                                }
                                            )
                                        }
                                    )
                                }
                                // Jadi disini tanggal tebar gabisa duluan dibanding tanggal panen
                                if (showDatePickerPanen) {
                                    DatePickerTambahStokIkan(onDateSelected = { dateInMillis ->
                                        dateInMillis?.let {
                                            if (selectedDateTebarTambah != null && it < selectedDateTebarTambah!!) {
                                                // Beri pesan kesalahan atau peringatan kepada pengguna
                                            } else {
                                                selectedDatePanenTambah = it
                                                selectedDatePanen = SimpleDateFormat(
                                                    "dd/MM/yyyy", Locale.getDefault()
                                                ).format(it)
                                            }
                                        }
                                        showDatePickerPanen = false
                                    }, onDismiss = { showDatePickerPanen = false })
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
                                        value = nilaMerah.toString(),
                                        label = { Text("Nila Merah") },
                                        readOnly = true,
                                        onValueChange = { intValue = it },
                                        colors = TextFieldDefaults.colors(
                                            unfocusedContainerColor = Color.White,
                                            focusedContainerColor = Color.White,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent
                                        ),
                                        textStyle = TextStyle(fontSize = 16.sp),
                                        shape = RoundedCornerShape(15.dp),
                                        keyboardActions = KeyboardActions(onDone = {
                                            submittedValue = intValue
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
                                        value = nilaHitam.toString(),
                                        label = { Text("Nila Hitam") },
                                        readOnly = true,
                                        onValueChange = { intValueNilaHitam = it },
                                        colors = TextFieldDefaults.colors(
                                            unfocusedContainerColor = Color.White,
                                            focusedContainerColor = Color.White,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            focusedIndicatorColor = Color.Transparent
                                        ),
                                        textStyle = TextStyle(fontSize = 16.sp),
                                        shape = RoundedCornerShape(15.dp),
                                        keyboardActions = KeyboardActions(onDone = {
                                            submittedValue = intValueNilaHitam
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
                                            value = berat.toString(),
                                            label = { Text("Berat") },
                                            readOnly = true,
                                            onValueChange = { intValue = it },
                                            colors = TextFieldDefaults.colors(
                                                unfocusedContainerColor = Color.White,
                                                focusedContainerColor = Color.White,
                                                unfocusedIndicatorColor = Color.Transparent,
                                                focusedIndicatorColor = Color.Transparent
                                            ),
                                            textStyle = TextStyle(fontSize = 16.sp),
                                            shape = RoundedCornerShape(15.dp),
                                            keyboardActions = KeyboardActions(onDone = {
                                                submittedValue = intValue
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

                                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                                Card(
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF)),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                ) {
                                    TextField(
                                        value = intValueLampiran,
                                        onValueChange = { intValueLampiran = it },
                                        label = {
                                            Text(
                                                text = "Lampiran",
                                            )
                                        },
                                        placeholder = { Text("Isi lampiran disini") },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(vertical = 40.dp),
                                        colors = TextFieldDefaults.colors(
                                            focusedContainerColor = Color.White,
                                            unfocusedContainerColor = Color.White,
                                            focusedIndicatorColor = Color.Transparent,
                                            unfocusedIndicatorColor = Color.Transparent,
                                            focusedTextColor = Color.Black,
                                            unfocusedTextColor = Color.Black
                                        ),
                                        keyboardActions = KeyboardActions(onDone = {
                                            submittedValue = intValueLampiran
                                            focusManager.clearFocus()
                                        })
                                    )
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