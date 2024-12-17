package com.aquanusa.aquasmart.view.kelola.ikan

import android.annotation.SuppressLint
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
import androidx.compose.runtime.getValue
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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@SuppressLint("NewApi")
@Composable
fun StokIkanScreen(
    newScreen: (String) -> Unit,
    backNew: (String) -> Unit,
    screenNow: (String),
    newParams: (String) -> Unit,
    vmikan: ViewModelIkan = viewModel(),
    vmkolam: PoolViewModel = viewModel()
) {

    /////////////////////////   LOAD DATA   ////////////////////////
    LaunchedEffect(Unit) {
        vmikan.jumlahIkan()
        vmkolam.getPools()
    }

    //  ikan //
    val jumlahNilaMerah = vmikan._listIkan.sumOf { it.jumlah_nila_merah }
    val jumlahNilaHitam = vmikan._listIkan.sumOf { it.jumlah_nila_hitam }
    val jumlahIkan = jumlahNilaHitam + jumlahNilaMerah
    val listIkan = vmikan._listIkan

    // kolam //
    val jumlahKolam = vmkolam.poolList.size
    val poolList = vmkolam.poolList
    /////////////////////////   END LOAD DATA   ////////////////////////

    val openAlertDialog = remember { mutableStateOf(false) }
    val dialogAlert = remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize()
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
                if (!vmikan.isLoading) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        item {
                            Text(
                                "Total ikan keseluruhan",
                                fontWeight = FontWeight.Normal,
                                fontSize = 20.sp,
                            )
                            Text(
                                "$jumlahIkan Ekor",
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
                                    "$jumlahKolam",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(start = 5.dp)
                                )
                                Text(
                                    "kolam",
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 16.sp,
                                    modifier = Modifier.padding(start = 5.dp)
                                )
                            }
                            Spacer(modifier = Modifier.padding(vertical = 8.dp))
                        }
                        items(poolList) { kolam ->
                            val jumlahNilaHitam by remember(listIkan, kolam.id_kolam) {
                                derivedStateOf {
                                    listIkan.filter { it.id_kolam == kolam.id_kolam }
                                        .sumOf { it.jumlah_nila_hitam }
                                }
                            }

                            val jumlahNilaMerah by remember(listIkan, kolam.id_kolam) {
                                derivedStateOf {
                                    listIkan.filter { it.id_kolam == kolam.id_kolam }
                                        .sumOf { it.jumlah_nila_merah }
                                }
                            }

                            val tanggalTebar by remember(listIkan, kolam.id_kolam) {
                                derivedStateOf {
                                    listIkan.filter { it.id_kolam == kolam.id_kolam }
                                        .minOfOrNull { it.tgl_tebar }
                                }
                            }

                            val tanggalnya = remember { mutableStateOf<String?>(null) }

                            if (!tanggalTebar.isNullOrEmpty()) {
                                val tanggalFix =
                                    DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                                val formattedDate = LocalDateTime.parse(tanggalTebar, tanggalFix)
                                tanggalnya.value = DateTimeFormatter.ofPattern("dd MMMM yyyy")
                                    .format(formattedDate)
                            }

                            val beratIkan by remember(listIkan, kolam.id_kolam) {
                                derivedStateOf {
                                    listIkan.filter { it.id_kolam == kolam.id_kolam }
                                        .minOfOrNull { it.berat }
                                }
                            }

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(130.dp)
                                    .clickable {
                                        backNew(screenNow)
                                        newParams("${kolam.id_kolam}")
                                        newScreen("preview_stok_ikan")
                                               },
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
                                                text = "${kolam.nama_awalan_kolam}-${kolam.nama_kolam}",
                                                fontWeight = FontWeight.ExtraBold,
                                                fontSize = 18.sp
                                            )
                                            Row(
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = "Merah/Hitam : ",
                                                    fontSize = 13.sp
                                                )
                                                Text(
                                                    text = buildAnnotatedString {
                                                        append("$jumlahNilaMerah/")
                                                        append("$jumlahNilaHitam")
                                                    },
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
                                                        append("Tgl Tebar :")
                                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                            append(" ${tanggalnya.value ?: "belum diatur"}")
                                                        }
                                                    },
                                                    fontSize = 13.sp,
                                                    color = Color.Black
                                                )
                                                Spacer(modifier = Modifier.padding(vertical = 1.dp))
                                                Text(
                                                    text = buildAnnotatedString {
                                                        append("Berat :")
                                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                            append(" ${beratIkan ?: 0} kg/Ikan")
                                                        }
                                                    },
                                                    fontSize = 13.sp,
                                                    color = Color.Black
                                                )
                                            }
                                            Row {
                                                IconButton(
                                                    onClick = {
                                                        openAlertDialog.value = true
                                                              dialogAlert.value = kolam.id_kolam },
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
//                                                        navController.navigate("Edit Stok Ikan")
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

                                    if (openAlertDialog.value && dialogAlert.value == kolam.id_kolam) {
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
                        item{
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
