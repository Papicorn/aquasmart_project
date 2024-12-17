package com.aquanusa.aquasmart.view.kelola.pakan

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.aquanusa.aquasmart.R
import com.aquanusa.aquasmart.viewmodel.pakan.ViewModelPakan

@Composable
fun KelolaPakanMain(
    newScreen: (String) -> Unit,
    backNew: (String) -> Unit,
    screenNow: (String)
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            Box(
                modifier = Modifier
                    .background(Color(0xFF8BA3FC))
                    .width(150.dp)
                    .height(50.dp)
            )
        }
        Card(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-50).dp),
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
                    Text(
                        "Kelola Pakan",
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.padding(vertical = 6.dp))
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(13.dp)
                    ) {
                        item {
                            Card(
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xFFFFFFFF),
                                ),
                                onClick = {
                                    backNew(screenNow)
                                    newScreen("kelola_jadwal_pakan")
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(55.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.jadwalpakan),
                                        contentDescription = "Jadwal Pemberian Pakan",
                                        modifier = Modifier
                                            .size(35.dp)
                                            .padding(start = 16.dp)
                                    )
                                    Text(
                                        "Jadwal Pemberian Pakan",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Normal,
                                        modifier = Modifier
                                            .padding(16.dp)
                                    )
                                }
                            }
                        }
                        item {
                            Card(
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xFFFFFFFF),
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(55.dp),
                                onClick = {
                                    backNew(screenNow)
                                    newScreen("kelola_stok_pakan")
                                },

                                ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.stokpakan),
                                        contentDescription = "stok pakan",
                                        modifier = Modifier
                                            .size(35.dp)
                                            .padding(start = 16.dp)
                                    )
                                    Text(
                                        "Stok Pakan",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Normal,
                                        modifier = Modifier
                                            .padding(16.dp)
                                    )
                                }
                            }
                        }
                        item {
                            Card(
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xFFFFFFFF),
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(55.dp),
                                onClick = {
                                    backNew(screenNow)
                                    newScreen("kelola_dosis_pakan")
                                },
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.penghitungdosis),
                                        contentDescription = "hitung dosis",
                                        modifier = Modifier
                                            .size(35.dp)
                                            .padding(start = 16.dp)
                                    )
                                    Text(
                                        "Penghitung Dosis Pakan",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Normal,
                                        modifier = Modifier
                                            .padding(16.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}