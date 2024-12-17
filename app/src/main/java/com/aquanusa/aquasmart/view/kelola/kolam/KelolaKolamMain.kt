package com.aquanusa.aquasmart.view.kelola.kolam

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aquanusa.aquasmart.R
import com.aquanusa.aquasmart.view.custom.LoadingScreen
import com.aquanusa.aquasmart.viewmodel.autentikasi.PoolViewModel
import com.aquanusa.aquasmart.viewmodel.ikan.ViewModelIkan

@Composable
fun KelolaKolamMain(
    newParamsKolam: (String) -> Unit,
    newScreen: (String) -> Unit,
    screenNow: (String),
    newBack: (String) -> Unit,
    vmkolam: PoolViewModel = viewModel(),
    vmikan: ViewModelIkan = viewModel()
) {

    LaunchedEffect(Unit) {
        vmkolam.getPools()
        vmikan.jumlahIkan()
    }

    //  ikan //
    val jumlahNilaMerah = vmikan._listIkan.sumOf { it.jumlah_nila_merah }
    val jumlahNilaHitam = vmikan._listIkan.sumOf { it.jumlah_nila_hitam }
    val jumlahIkan = jumlahNilaHitam + jumlahNilaMerah

    val poolist = vmkolam.poolList
    val jumlah_kolam = poolist.size

    val ikanList = vmikan._listIkan

//    VAL & VAR
    val openAlertDialog = remember { mutableStateOf(false) }
//    END VAL & VAR
    Log.d("DEBUGGGG IKAN", ikanList.toString())

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
//        Box(
//            modifier = Modifier
//                .background(Color(0xFF8BA3FC))
//                .width(150.dp)
//                .height(50.dp)
//        )
        Card(
            modifier = Modifier
                .fillMaxSize(),
//                .offset(y = (-50).dp),
//                .padding(top = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFEFF6FC)
            ),
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 17.dp, end = 17.dp, top = 25.dp, bottom = 103.dp)
            ) {
                Column {
                    if (!vmikan.isLoading) {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            item {
                                Text(
                                    text = "Total Ikan Keseluruhan",
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 20.sp,
                                    color = Color.Black
                                )

                                if (!vmikan.isLoading) {
                                    Text(
                                        text = "$jumlahIkan ekor",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp,
                                        color = Color.Black
                                    )
                                } else {
                                    CircularProgressIndicator(color = Color(0xFFCBCBCB))
                                }
                                Text(
                                    text = buildAnnotatedString {
                                        append("Dari ")
                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                            if (!vmkolam.isLoading) {
                                                append("$jumlah_kolam kolam")
                                            } else {
                                                CircularProgressIndicator(color = Color(0xFFCBCBCB))
                                            }
                                        }
                                        append(" tersedia")
                                    },
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 15.sp,
                                    color = Color.Black
                                )
                                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                            }
                            items(poolist) { kolam ->
                                val jumlahIkannya by remember(ikanList, kolam.id_kolam) {
                                    derivedStateOf {
                                        ikanList.filter { it.id_kolam == kolam.id_kolam }
                                            .sumOf { it.jumlah_nila_merah + it.jumlah_nila_hitam }
                                    }
                                }
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(155.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color.White),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                ) {
                                    Box(
                                        modifier = Modifier.padding(17.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Column(
                                                modifier = Modifier.fillMaxHeight(),
                                                verticalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Row(
                                                    verticalAlignment = Alignment.Bottom,
                                                ) {
                                                    Text(
                                                        text = "${kolam.nama_awalan_kolam}-${kolam.nama_kolam}",
                                                        fontWeight = FontWeight.ExtraBold,
                                                        fontSize = 18.sp
                                                    )
                                                    Spacer(modifier = Modifier.padding(horizontal = 6.dp))
                                                    Text(
                                                        text = kolam.status,
                                                        fontSize = 13.sp,
                                                        color = if (kolam.status == "aktif") Color.Green else Color.Red,
                                                        modifier = Modifier.padding(bottom = 1.dp)
                                                    )
                                                }
                                                Column {
                                                    Text(
                                                        text = buildAnnotatedString {
                                                            append("Diameter :")
                                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                                append(" ${kolam.diameter} Meter")
                                                            }
                                                        },
                                                        fontSize = 13.sp,
                                                        color = Color.Black
                                                    )
                                                    Spacer(modifier = Modifier.padding(vertical = 1.dp))
                                                    Text(
                                                        text = buildAnnotatedString {
                                                            append("Kedalaman :")
                                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                                append(" ${kolam.kedalaman} Meter")
                                                            }
                                                        },
                                                        fontSize = 13.sp,
                                                        color = Color.Black
                                                    )
                                                    Spacer(modifier = Modifier.padding(vertical = 1.dp))
                                                    Text(
                                                        text = buildAnnotatedString {
                                                            append("pH air:")
                                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                                append(" ${kolam.ph_air}")
                                                            }
                                                        },
                                                        fontSize = 14.sp,
                                                        color = Color.Black
                                                    )
                                                }
                                            }
                                            Column(
                                                modifier = Modifier.fillMaxHeight(),
                                                horizontalAlignment = Alignment.End,
                                                verticalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Text(
                                                    text = buildAnnotatedString {
                                                        append("$jumlahIkannya/")
                                                        withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold)) {
                                                            append("${kolam.kapasitas}")
                                                        }
                                                    },
                                                    fontSize = 13.sp,
                                                    modifier = Modifier.padding(top = 4.dp)
                                                )
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
                                                            newParamsKolam("${kolam.id_kolam}")
                                                            newBack(screenNow)
                                                            newScreen("edit_kolam")
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
                                                            text = "Anda yakin ingin menghapus data ini?",
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
                                }
                                Spacer(modifier = Modifier.padding(vertical = 8.dp))

                            }
                            item {
                                Spacer(modifier = Modifier.padding(vertical = 48.dp))
                            }
                        }
                    } else {
                        LoadingScreen()
                    }
                }
            }
        }
    }
}