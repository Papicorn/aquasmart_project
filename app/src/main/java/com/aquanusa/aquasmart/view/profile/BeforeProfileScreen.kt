package com.aquanusa.aquasmart.view.profile

import android.content.Intent
import android.net.Uri
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
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
import com.aquanusa.aquasmart.viewmodel.autentikasi.LoginState

@Composable
fun BeforeProfileScreen(
    navController: NavController,
    newScreen: (String) -> Unit,
    backNew: (String) -> Unit,
    screenNow: (String),
    viewModel: LoginViewModel = viewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.getDataPengguna()
    }

    val dataPengguna = viewModel.userState.collectAsState().value
    val pengguna = dataPengguna.firstOrNull()

    val openAlertDialog = remember { mutableStateOf(false) }

//    val loginState by viewModel.loginState.collectAsState()
    val isLoggedOut by viewModel.isLoggedOut
    val context = LocalContext.current

    if (isLoggedOut) {
        val context = LocalContext.current
        LaunchedEffect(Unit) {
            navController.navigate("Login") {
                popUpTo("Before Profile") { inclusive = true }
                Toast.makeText(
                    context,
                    "Sesi anda telah habis, silahkan masuk kembali!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

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
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(75.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.editprofile),
                                    contentDescription = "Profile Awal",
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .size(80.dp)
                                )
                                Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                                Column(
                                    modifier = Modifier.fillMaxHeight(),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    pengguna?.let {
                                        Text(
                                            it.nama_lengkap,
                                            fontSize = 25.sp,
                                            fontWeight = FontWeight.Bold,
                                        )
                                        Text(
                                            it.role,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Normal
                                        )
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))

                            Column {

                                Text(
                                    text = "Akun",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Black,
                                    modifier = Modifier
                                        .padding(bottom = 0.dp, start = 10.dp)
                                )
                                Card(
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(0xFFFFFFFF),
                                    ),
                                    onClick = {
                                        backNew(screenNow)
                                        newScreen("profile_show_profile")
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 10.dp)
                                        .height(55.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxSize(),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.profile),
                                            contentDescription = "profile",
                                            colorFilter = ColorFilter.tint(Color.Black),
                                            modifier = Modifier
                                                .size(35.dp)
                                                .padding(start = 16.dp)
                                        )
                                        Text(
                                            "Edit Profile",
                                            fontSize = 16.sp,
                                            fontWeight = FontWeight.Normal,
                                            modifier = Modifier
                                                .padding(16.dp)
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.padding(vertical = 50.dp))

                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(bottom = 50.dp),
                                    verticalArrangement = Arrangement.Bottom,

                                    ) {
                                    Spacer(modifier = Modifier.height(0.dp))
                                    //card info
                                    Text(
                                        text = "Info Lainnya",
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Normal,
                                        color = Color.Black,
                                        modifier = Modifier
                                            .padding(bottom = 0.dp, start = 10.dp)
                                    )

                                    Card(
                                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                        colors = CardDefaults.cardColors(
                                            containerColor = Color(0xFFFFFFFF),
                                        ),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 10.dp)
                                            .height(55.dp)
                                            .clickable {
                                                Toast
                                                    .makeText(
                                                        context,
                                                        "Versi 1.0.0",
                                                        Toast.LENGTH_LONG
                                                    )
                                                    .show()
                                            }
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.img_8),
                                                contentDescription = "Back",
                                                tint = Color.Black.copy(alpha = 0.7f),
                                                modifier = Modifier
                                                    .size(40.dp)
                                                    .padding(start = 16.dp)
                                            )
                                            Text(
                                                "Versi 1.0.0",
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Normal,
                                                color = Color.Black.copy(alpha = 0.7f),
                                                modifier = Modifier
                                                    .padding(16.dp)
                                            )

                                        }
                                    }
                                    Spacer(modifier = Modifier.height(0.dp))
                                    /// card beri nilai
                                    Card(
                                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                        colors = CardDefaults.cardColors(
                                            containerColor = Color(0xFFFFFFFF),
                                        ),
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 20.dp)
                                            .height(55.dp)
                                            .clickable{
                                                val intent = Intent(Intent.ACTION_VIEW).apply {
                                                    data = Uri.parse("https://www.youtube.com")
                                                    flags = Intent.FLAG_ACTIVITY_NEW_TASK
                                                }
                                                context.startActivity(intent)
                                            }
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.img_7),
                                                contentDescription = "Back",
                                                tint = Color.Black.copy(alpha = 0.5f),
                                                modifier = Modifier
                                                    .size(40.dp)
                                                    .padding(start = 16.dp)
                                            )
                                            Text(
                                                "Beri Nilai",
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Normal,
                                                color = Color.Black.copy(alpha = 0.5f),
                                                modifier = Modifier
                                                    .padding(16.dp)
                                            )
                                            Spacer(modifier = Modifier.weight(1f))
                                            Icon(
                                                painter = painterResource(id = R.drawable.img_10),
                                                contentDescription = "Back",
                                                tint = Color.Black.copy(alpha = 0.5f),
                                                modifier = Modifier
                                                    .size(24.dp)
                                                    .padding(end = 16.dp)

                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(20.dp))
                                    //card keluar
                                    Card(
                                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                        colors = CardDefaults.cardColors(
                                            containerColor = Color(0xFFFFFFFF),
                                        ),
                                        onClick = { openAlertDialog.value = true },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(55.dp)
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxSize(),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Logout,
                                                contentDescription = "Back",
                                                tint = Color.Red,
                                                modifier = Modifier
                                                    .size(40.dp)
                                                    .padding(start = 16.dp)
                                            )
                                            Text(
                                                "Keluar",
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Normal,
                                                color = Color.Red,
                                                modifier = Modifier
                                                    .padding(16.dp)
                                            )
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
                                                        Icon(
                                                            imageVector = Icons.Default.Logout,
                                                            contentDescription = "logout",
                                                            tint = Color.Black,
                                                            modifier = Modifier
                                                                .size(70.dp)
                                                        )
                                                    }
                                                },
                                                text = {
                                                    Text(
                                                        text = "Apakah kamu yakin akan keluar?",
                                                        modifier = Modifier.fillMaxWidth(),
                                                        textAlign = TextAlign.Center,
                                                    )
                                                },
                                                confirmButton = {
                                                    Row(
                                                        modifier = Modifier.fillMaxWidth(),
                                                        horizontalArrangement = Arrangement.SpaceEvenly
                                                    ) {
                                                        TextButton(
                                                            onClick = {
                                                                viewModel.logout()
                                                            },
                                                            modifier = Modifier
                                                                .background(
                                                                    Color.Red,
                                                                    shape = RoundedCornerShape(8.dp)
                                                                )
                                                        ) {
                                                            Text(
                                                                "Keluar",
                                                                color = Color.White
                                                            )
                                                        }
                                                        TextButton(
                                                            onClick = {
                                                                openAlertDialog.value = false
                                                            },
                                                            modifier = Modifier
                                                                .background(
                                                                    Color.Black,
                                                                    shape = RoundedCornerShape(8.dp)
                                                                )
                                                        ) {
                                                            Text(
                                                                "Batal",
                                                                color = Color.White,
                                                            )
                                                        }
                                                    }
                                                }
                                            )
                                        }
                                    }
                                    Spacer(modifier = Modifier.height(38.dp))
                                    Text(
                                        text = buildAnnotatedString {
                                            append("Tentang ")
                                            withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold)) {
                                                append("AquaSmart")
                                            }
                                        },
                                        fontWeight = FontWeight.Medium,
                                        fontSize = 15.sp,
                                        color = Color.Black
                                    )
                                    Spacer(modifier = Modifier.height(8.dp))
                                    Text(
                                        text = "Pengelolaan perikanan secara digital yang menyederhanakan proses pengelolaan stok ikan, perkembangan ikan serta pemberian pakan secara lebih efisien dan terstruktur.",
                                        fontSize = 12.sp,
                                        color = Color.Black.copy(alpha = 0.3f)
                                    )
                                    Spacer(modifier = Modifier.height(15.dp))
                                    Text(
                                        text = "Copyright (c) 2024 AquaNusa",
                                        fontSize = 12.sp,
                                        color = Color.Gray,
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
