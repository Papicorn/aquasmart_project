package com.aquanusa.aquasmart.view

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aquanusa.aquasmart.R
import com.aquanusa.aquasmart.navigation.MainScreen
import com.aquanusa.aquasmart.view.custom.LoadingScreen
import com.aquanusa.aquasmart.viewmodel.autentikasi.PoolViewModel
import com.aquanusa.aquasmart.viewmodel.ikan.ViewModelIkan
import com.aquanusa.aquasmart.viewmodel.pakan.ViewModelPakan
import kotlinx.coroutines.delay

@SuppressLint("SuspiciousIndentation")
@Composable
fun BerandaScreen(
    newScreen: (String) -> Unit,
    backNew: (String) -> Unit,
    screenNow: (String),
    vm: PoolViewModel = viewModel(),
    vmikan: ViewModelIkan = viewModel(),
    vmpakan: ViewModelPakan = viewModel()
) {

    // READ DATA //
    /////////////////////////   LOAD DATA   ////////////////////////
    LaunchedEffect(Unit) {
        vm.getPools()
        vmikan.jumlahIkan()
        vmpakan.getPakan()
    }
    /////////////////////////   END LOAD DATA   ////////////////////////

    // ~~~  Stok Pakan  ~~~
    val jumlahPakan = vmpakan._listPakan.sumOf { it.stok_pakan }

    // ~~~ Kolam ~~~
    val jumlahKolam = vm.poolList.size
    Log.d("kolam nya", vm.poolList.toString())

    // ~~~  Stok Ikan ~~~
    val stokIkanHitam = vmikan._listIkan.sumOf { it.jumlah_nila_hitam }
    val stokIkanMerah = vmikan._listIkan.sumOf { it.jumlah_nila_merah }
    val stokIkan = stokIkanMerah + stokIkanHitam
    // END READ DATA //

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize(),
//                .padding(bottom = 100.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFEFF6FC)
            ),
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 17.dp, end = 17.dp, top = 25.dp, bottom = 103.dp)
            ) {
//                if (!vm.isLoading) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                // Card 1
                                Card(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 4.dp)
                                        .shadow(
                                            elevation = 12.dp,
                                            ambientColor = Color.Black.copy(alpha = 0.2f),
                                            spotColor = Color.Black.copy(alpha = 0.5f)
                                        ),
                                    onClick = {
                                        backNew(screenNow)
                                        newScreen("kelola_stok_ikan")
                                              },
                                    colors = CardDefaults.cardColors(containerColor = Color.White),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(16.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                            Row {
                                                Image(
                                                    painter = painterResource(id = R.drawable.img_3),
                                                    contentDescription = "Ikon Stok Ikan",
                                                    modifier = Modifier
                                                        .size(22.dp)
                                                        .padding(end = 6.dp)
                                                )
                                                androidx.compose.material3.Text(
                                                    text = "Stok Ikan",
                                                    fontSize = 17.sp,
                                                    color = Color.Black,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(bottom = 8.dp)
                                                )
                                            }
                                            Text(
                                                text = "${stokIkan}",
                                                fontSize = 30.sp,
                                                color = Color(0xFF5E7BF9)
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.width(16.dp))
                                // Card 2
                                Card(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 4.dp)
                                        .shadow(
                                            elevation = 12.dp,
                                            ambientColor = Color.Black.copy(alpha = 0.2f),
                                            spotColor = Color.Black.copy(alpha = 0.5f)
                                        ),
                                    onClick = {
                                        backNew(screenNow)
                                        newScreen("kelola_kolam")
                                              },
                                    colors = CardDefaults.cardColors(containerColor = Color.White),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(16.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                            Row {
                                                Image(
                                                    painter = painterResource(id = R.drawable.img),
                                                    contentDescription = "Kolam",
                                                    modifier = Modifier
                                                        .size(22.dp)
                                                        .padding(end = 6.dp)
                                                )
                                                Text(
                                                    text = "Kolam",
                                                    fontSize = 17.sp,
                                                    color = Color.Black,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(bottom = 8.dp)
                                                )
                                            }
                                            Text(
                                                text = "${jumlahKolam}",
                                                fontSize = 30.sp,
                                                color = Color(0xFF5E7BF9)
                                            )
                                        }
                                    }
                                }
                            }
                            // Card 3
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Card(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 4.dp)
                                        .shadow(
                                            elevation = 12.dp,
                                            ambientColor = Color.Black.copy(alpha = 0.2f),
                                            spotColor = Color.Black.copy(alpha = 0.5f)
                                        ),
                                    onClick = {
                                        backNew(screenNow)
                                        newScreen("kelola_stok_pakan")
                                    },
                                    colors = CardDefaults.cardColors(containerColor = Color.White),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(16.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                            Row {
                                                Image(
                                                    painter = painterResource(id = R.drawable.img_2),
                                                    contentDescription = "Pakan",
                                                    modifier = Modifier
                                                        .size(22.dp)
                                                        .padding(end = 6.dp)
                                                )
                                                androidx.compose.material3.Text(
                                                    text = "Pakan",
                                                    fontSize = 17.sp,
                                                    color = Color.Black,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(bottom = 8.dp)
                                                )
                                            }
                                            androidx.compose.material3.Text(
                                                text = "${jumlahPakan} Kg",
                                                fontSize = 30.sp,
                                                color = Color(0xFF5E7BF9)
                                            )
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.width(16.dp))
                                // Card 4
                                Card(
                                    modifier = Modifier
                                        .weight(1f)
                                        .padding(end = 4.dp)
                                        .shadow(
                                            elevation = 12.dp,
                                            ambientColor = Color.Black.copy(alpha = 0.2f),
                                            spotColor = Color.Black.copy(alpha = 0.5f)
                                        ),
                                    onClick = {
                                        backNew(screenNow)
                                        newScreen("pengingat")
                                    },
                                    colors = CardDefaults.cardColors(containerColor = Color.White),
                                    elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(16.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                            Row {
                                                Image(
                                                    painter = painterResource(id = R.drawable.img_4),
                                                    contentDescription = "Notif",
                                                    modifier = Modifier
                                                        .size(22.dp)
                                                        .padding(end = 6.dp)
                                                )
                                                androidx.compose.material3.Text(
                                                    text = "Pengingat",
                                                    fontSize = 17.sp,
                                                    color = Color.Black,
                                                    fontWeight = FontWeight.Bold,
                                                    modifier = Modifier.padding(bottom = 8.dp)
                                                )
                                            }
                                            androidx.compose.material3.Text(
                                                text = "3",
                                                fontSize = 30.sp,
                                                color = Color(0xFF5E7BF9)
                                            )
                                        }
                                    }
                                }
                            }

                            // Card 5
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(400.dp)
                                    .padding(vertical = 10.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .fillMaxHeight()
                                        .padding(20.dp),
                                    contentAlignment = Alignment.TopStart
                                ) {
                                    Column {
                                        Text(
                                            text = "Pengingat Terdekat",
                                            fontSize = 20.sp,
                                            color = Color.Black,
                                            modifier = Modifier.padding(bottom = 8.dp)
                                        )
                                        Text(
                                            text = "Hari ini",
                                            fontSize = 20.sp,
                                            color = Color.Black,
                                            modifier = Modifier.padding(bottom = 8.dp)
                                        )
                                        LazyColumn(
                                            verticalArrangement = Arrangement.spacedBy(12.dp),
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            //Card pengingat terdekat
                                            item {
                                                Card(
                                                    colors = CardDefaults.cardColors(
                                                        containerColor = Color(0xFFEFF6FC),
                                                    ),
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .height(55.dp)
                                                ) {
                                                    Row(
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .padding(
                                                                horizontal = 15.dp,
                                                                vertical = 15.dp
                                                            ),
                                                        horizontalArrangement = Arrangement.SpaceBetween,
                                                        verticalAlignment = Alignment.CenterVertically
                                                    ) {
                                                        Text(
                                                            text = "Beri pakan Kolam A1",
                                                        )
                                                        Text(
                                                            text = "08.00 WIB",
                                                        )
                                                    }
                                                }
                                            }
                                            // Loop 5 card pengingat terdekat
                                            items(5) { index ->
                                                Card(
                                                    colors = CardDefaults.cardColors(
                                                        containerColor = Color(0xFFEFF6FC),
                                                    ),
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .height(55.dp)
                                                        .clickable {  }
                                                ) {
                                                    Row(
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .padding(
                                                                horizontal = 15.dp,
                                                                vertical = 15.dp
                                                            ),
                                                        horizontalArrangement = Arrangement.SpaceBetween,
                                                        verticalAlignment = Alignment.CenterVertically
                                                    ) {
                                                        Text(
                                                            text = "Panen kolam A5",
                                                        )
                                                        Text(
                                                            text = "08.00 WIB",
                                                        )
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            // Card 6 (Dokumentasi)
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(250.dp)
                                    .padding(vertical = 10.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(16.dp)
                                ) {
                                    Text(
                                        text = "Dokumentasi",
                                        fontSize = 20.sp,
                                        color = Color.Black,
                                        modifier = Modifier.padding(bottom = 12.dp)
                                    )

                                    LazyRow(
                                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        val images = listOf(
                                            R.drawable.img_5,
                                            R.drawable.img_6,
                                            R.drawable.img_5,
                                            R.drawable.img_6
                                        )

                                        items(images) { imageRes ->
                                            Card(
                                                modifier = Modifier
                                                    .height(160.dp)
                                                    .width(300.dp)
                                                    .shadow(
                                                        elevation = 4.dp,
                                                        shape = RoundedCornerShape(8.dp)
                                                    ),
                                                shape = RoundedCornerShape(8.dp)
                                            ) {
                                                Image(
                                                    painter = painterResource(id = imageRes),
                                                    contentDescription = "Dokumentasi",
                                                    modifier = Modifier.fillMaxSize(),
                                                    contentScale = ContentScale.Crop
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
//                } else {
//                    LoadingScreen()
//                }
            }
        }
    }
}