package com.aquanusa.aquasmart.view.kelola.pakan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aquanusa.aquasmart.R
import com.aquanusa.aquasmart.viewmodel.pakan.ViewModelPakan

@Composable
fun StokPakanScreen(vmpakan: ViewModelPakan = viewModel()) {
    val listPakan = vmpakan._listPakan

    LaunchedEffect(Unit) {
        vmpakan.getPakan()
    }

    val jumlah_pakan = listPakan.size
    val jumlahPakan = vmpakan._listPakan.sumOf { it.stok_pakan }

    val openAlertDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.End
    ) {

        Box(
            modifier = Modifier
                .background(Color(0xFF8BA3FC))
                .width(150.dp)
                .height(25.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-25).dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFEFF6FC)
            ),
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 17.dp, end = 17.dp, top = 25.dp, bottom = 78.dp)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(1) {
                        Text(
                            "Total stok keseluruhan",
                            fontWeight = FontWeight.Normal,
                            fontSize = 20.sp,
                        )
                        Text(
                            "$jumlahPakan Kilogram",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                        )
                        Row {
                            Text(
                                "dari",
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp
                            )
                            Text(
                                " $jumlah_pakan Jenis Pakan",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 16.sp,
                            )
                            Text(
                                " tersedia",
                                fontSize = 16.sp,
                            )
                        }
                        Spacer(modifier = Modifier.padding(vertical = 8.dp))
                    }
                    items(listPakan) { pakan ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(130.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                            shape = MaterialTheme.shapes.large
                        ) {
                            Box(
                                modifier = Modifier.padding(17.dp)
                            ) {
                                Column(
                                    modifier = Modifier.fillMaxHeight(),
                                    verticalArrangement = Arrangement.SpaceBetween
                                ) {

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(
                                            text = pakan.nama_pakan,
                                            fontWeight = FontWeight.ExtraBold,
                                            fontSize = 18.sp
                                        )
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = "${pakan.stok_pakan}kg",
                                                fontSize = 13.sp
                                            )
                                        }
                                    }

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.Bottom
                                    ) {
                                        Column {
                                            Text(
                                                text = buildAnnotatedString {
                                                    append("Jenis :")
                                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                        append(" ${pakan.jenis_pakan}")
                                                    }
                                                },
                                                fontSize = 13.sp,
                                                color = Color.Black
                                            )
                                            Spacer(modifier = Modifier.padding(vertical = 1.dp))
                                            Text(
                                                text = buildAnnotatedString {
                                                    append("Penggunaan :")
                                                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                        append(" 1,5kg")
                                                    }
                                                },
                                                fontSize = 13.sp,
                                                color = Color.Black
                                            )
                                        }
                                        Row {
                                            IconButton(
                                                onClick = { openAlertDialog.value = true },
                                                modifier = Modifier
                                                    .size(40.dp)
                                                    .padding(end = 4.dp),
                                            ) {
                                                Icon(
                                                    painter = painterResource(id = R.drawable.sampah),
                                                    contentDescription = "Trash",
                                                    modifier = Modifier
                                                        .size(28.dp)
                                                        .padding(start = 6.dp),
                                                    tint = Color(0xFFEC221F)
                                                )
                                            }
                                            IconButton(
                                                onClick = {
//                                                    navController.navigate("Edit Stok Pakan")
                                                }, modifier = Modifier.size(40.dp)
                                            ) {
                                                Icon(
                                                    painter = painterResource(id = R.drawable.edit),
                                                    contentDescription = "Edit",
                                                    modifier = Modifier
                                                        .size(28.dp)
                                                        .padding(start = 6.dp),
                                                    tint = Color(0XFF2C793E)
                                                )
                                            }
                                        }
                                    }

                                }

                                if (openAlertDialog.value) {
                                    AlertDialog(
                                        containerColor = Color.White,
                                        onDismissRequest = {
                                            openAlertDialog.value = false
                                        },
                                        title = {
                                            Column(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                Text(
                                                    text = "Notifikasi",
                                                    textAlign = TextAlign.Center
                                                )
                                            }
                                        },
                                        text = {
                                            Text(
                                                text = "Anda yakin ingin mengahpus data ini?",
                                                modifier = Modifier.fillMaxWidth(),
                                                textAlign = TextAlign.Center
                                            )
                                        },
                                        confirmButton = {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceEvenly
                                            ) {
                                                TextButton(
                                                    onClick = {
                                                        openAlertDialog.value = false
                                                    },
                                                    modifier = Modifier.background(
                                                        Color.Red,
                                                        shape = RoundedCornerShape(8.dp)
                                                    )
                                                ) {
                                                    Text(
                                                        "Hapus",
                                                        color = Color.White
                                                    )
                                                }
                                                TextButton(
                                                    onClick = {
                                                        openAlertDialog.value = false
                                                    },
                                                    modifier = Modifier.background(
                                                        Color.Black,
                                                        shape = RoundedCornerShape(8.dp)
                                                    )
                                                ) {
                                                    Text(
                                                        "Batal",
                                                        color = Color.White
                                                    )
                                                }
                                            }
                                        })
                                }
                            }
                        }
                        Spacer(modifier = Modifier.padding(vertical = 8.dp))
                    }
                }
            }
        }
    }
}