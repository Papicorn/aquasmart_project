package com.aquanusa.aquasmart.partials

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aquanusa.aquasmart.R
import com.aquanusa.aquasmart.condition.BackCondition
import com.aquanusa.aquasmart.view.kelola.ikan.StokIkanScreen

@Composable
fun NavbarTop(
    navController: NavController,
    titleScreen: String,
    screenNow: (String),
    newScreen: (String) -> Unit,
    backTo: (String),
    backNew: (String) -> Unit,
    viewModel: LoginViewModel = viewModel()
) {
    val token = viewModel.getToken()

    val back = remember { mutableStateOf<Boolean>(false) }

    if (token == null) {
        val context = LocalContext.current
        navController.navigate("Login") {
            popUpTo("Login") { inclusive = true }
            Toast.makeText(
                context,
                "Sesi anda telah habis, silahkan masuk kembali!",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    // BACK CONDITION
    BackCondition(back = { backVal -> back.value = backVal }, screenNow)

    Log.d("back nya", backTo)

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color(0xFF5E7BF9))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 17.dp, end = 17.dp, top = 35.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (back.value == true) {
                    Column {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start,
                            modifier = Modifier.padding(bottom = 14.dp, top = 13.dp)
                        ) {
                            IconButton(onClick = {
                                if (screenNow == backTo && screenNow == "kelola_stok_ikan") {
                                    newScreen("kelola")
                                } else if (screenNow == backTo && screenNow == "kelola_jadwal_panen") {
                                    newScreen("kelola")
                                } else if (screenNow == backTo && screenNow == "kelola_kematian_ikan") {
                                    newScreen("kelola")
                                } else if (screenNow == backTo && screenNow == "kelola_jadwal_pakan") {
                                    newScreen("kelola_pakan")
                                } else if (screenNow == backTo && screenNow == "kelola_stok_pakan") {
                                    newScreen("kelola_pakan")
                                } else {
                                    newScreen(backTo)
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Kembali",
                                    tint = Color(0xffffffff),
                                    modifier = Modifier.size(35.dp)
                                )
                            }
                            Text(
                                text = titleScreen,
                                fontSize = 23.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White
                            )
                        }
                    }
                } else {
                    Column {
                        Icon(
                            painter = painterResource(id = R.drawable.logo_aquasmart2),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                                .height(35.dp),
                            tint = Color.White
                        )
                    }
                }
                Column {
                    Icon(
                        painter = painterResource(id = R.drawable.notifikasi_icon),
                        contentDescription = "Email",
                        tint = Color.White,
                        modifier = Modifier
                            .size(25.dp)
                            .clickable {
                                if (screenNow == "pengingat") {
                                    backNew(backTo)
                                } else {
                                    backNew(screenNow)
                                }
                                newScreen("pengingat")
                            }
                    )
                }
            }
        }
    }
}