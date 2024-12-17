package com.aquanusa.aquasmart.view.kelola.ikan.edit.kematian_ikan

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.aquanusa.aquasmart.view.kelola.ikan.add.kematian_ikan.DatePickerTambahKematian
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditKematianIkanScreen(navController: NavController) {
//    VAL VAR
    val focusManager = LocalFocusManager.current

    val list = listOf("Kolam A-A1", "Kolam B-B1")
    var selectedText by remember { mutableStateOf("") }
    var isExpanded by remember { mutableStateOf(false) }

    val listIkan = listOf("Nila Merah", "Nila Hitam")
    var selectedTextIkan by remember { mutableStateOf("") }
    var isExpandedIkan by remember { mutableStateOf(false) }

    var jumlahIkan by remember { mutableStateOf("") }
    var submitedJumlahIkan by remember { mutableStateOf("") }

    var catatan by remember { mutableStateOf("") }
    var submitedCatatan by remember { mutableStateOf("") }

    // Data Pickers
    var showPickerKematian by remember { mutableStateOf(false) }
    var selectedPickerKematian by remember { mutableStateOf("") }
    var selectedPickerKematian1 by remember { mutableStateOf<Long?>(null) }
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
                                "Edit Kematian Ikan Kolam A-A1",
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
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {
                                    ExposedDropdownMenuBox(modifier = Modifier
                                        .fillMaxWidth(),
                                        expanded = isExpandedIkan,
                                        onExpandedChange = {
                                            isExpandedIkan = !isExpandedIkan
                                        }) {
                                        TextField(
                                            modifier = Modifier
                                                .menuAnchor()
                                                .fillMaxWidth(),
                                            value = "Nila Merah",
                                            label = { Text("-- Pilih Jenis --") },
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
                                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedIkan)
                                            }
                                        )
                                        ExposedDropdownMenu(
                                            expanded = isExpandedIkan,
                                            onDismissRequest = { isExpandedIkan = false },
                                            modifier = Modifier.background(Color.White)
                                        ) {
                                            listIkan.forEachIndexed { index, text ->
                                                DropdownMenuItem(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    text = {
                                                        Text(
                                                            text = text,
                                                            fontSize = 16.sp
                                                        )
                                                    },
                                                    onClick = {
                                                        selectedTextIkan = listIkan[index]
                                                        isExpandedIkan = false
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
                                        .clickable { showPickerKematian = true },
                                ) {
                                    TextField(
                                        modifier = Modifier
                                            .fillMaxWidth(),
                                        value = "23/11/2024",
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
                                                    showPickerKematian = true
                                                }
                                            )
                                        }
                                    )
                                }
                                if (showPickerKematian) {
                                    DatePickerTambahKematian(
                                        onDateSelected = { dateInMillis ->
                                            dateInMillis?.let {
                                                if (selectedPickerKematian1 != null && it > selectedPickerKematian1!!) {
                                                    // Beri pesan kesalahan atau peringatan kepada pengguna
                                                } else {
                                                    selectedPickerKematian1 = it
                                                    selectedPickerKematian = SimpleDateFormat(
                                                        "dd/MM/yyyy",
                                                        Locale.getDefault()
                                                    ).format(it)
                                                }
                                            }
                                            showPickerKematian = false
                                        },
                                        onDismiss = { showPickerKematian = false }
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
                                            value = "20",
                                            label = { Text("Jumlah") },
                                            onValueChange = { jumlahIkan = it },
                                            colors = TextFieldDefaults.colors(
                                                unfocusedContainerColor = Color.White,
                                                focusedContainerColor = Color.White,
                                                unfocusedIndicatorColor = Color.Transparent,
                                                focusedIndicatorColor = Color.Transparent
                                            ),
                                            textStyle = TextStyle(fontSize = 16.sp),
                                            shape = RoundedCornerShape(15.dp),
                                            keyboardActions = KeyboardActions(onDone = {
                                                submitedJumlahIkan = jumlahIkan
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
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(
                                            0xFFFFFFFF
                                        )
                                    ),
                                    shape = RoundedCornerShape(12.dp),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                ) {
                                    TextField(
                                        value = catatan,
                                        onValueChange = { catatan = it },
                                        label = {
                                            Text(
                                                text = "Catatan...",
                                            )
                                        },
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
                                            submitedCatatan = catatan
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
                                            navController.navigate("Kematian Ikan")
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