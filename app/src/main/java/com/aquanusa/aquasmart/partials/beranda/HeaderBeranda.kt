package com.aquanusa.aquasmart.partials.beranda

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aquanusa.aquasmart.R

@Composable
fun HeaderBeranda(
    vmlogin: LoginViewModel = viewModel()
) {
    // READ DATA //
    LaunchedEffect(Unit) {
        vmlogin.getDataPengguna()
    }
    // ~~~  Nama Pengguna  ~~~
    val dataPengguna = vmlogin.userState.collectAsState().value
    val pengguna = dataPengguna.firstOrNull()
    val namaPengguna = pengguna?.nama_lengkap
    val namaDepan = namaPengguna?.trim()?.split(" ")[0]

    // END READ DATA //

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color(0xFF5E7BF9))
                .padding(horizontal = 17.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = "Selamat Datang",
                        fontSize = 27.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Normal
                    )

//                    if (vmlogin.isLoading) {
//                        CircularProgressIndicator(color = Color.White)
//                    } else {
                        Text(
                            text = "$namaDepan",
                            fontSize = 42.sp,
                            color = Color.White,
//                        modifier = Modifier.padding(top = 5.dp, bottom = 25.dp),
                            fontWeight = FontWeight.Bold
                        )
//                    }
                }
                Column(
//                    modifier = Modifier.background(Color.Red)
                ) {
                    Image(
                        painter = painterResource(R.drawable.bapak),
                        contentDescription = "gambar",
                        modifier = Modifier
                            .size(120.dp)
                    )
                }
            }
        }
    }
}