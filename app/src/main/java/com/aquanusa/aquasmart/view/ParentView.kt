package com.aquanusa.aquasmart.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aquanusa.aquasmart.condition.BackCondition
import com.aquanusa.aquasmart.partials.BottomNavigation
import com.aquanusa.aquasmart.partials.NavbarTop
import com.aquanusa.aquasmart.partials.beranda.HeaderBeranda
import com.aquanusa.aquasmart.partials.kelola.HeaderKelola
import com.aquanusa.aquasmart.view.kelola.ikan.JadwalPanenScreen
import com.aquanusa.aquasmart.view.kelola.ikan.KelolaIkanMain
import com.aquanusa.aquasmart.view.kelola.ikan.KematianIkanScreen
import com.aquanusa.aquasmart.view.kelola.ikan.StokIkanScreen
import com.aquanusa.aquasmart.view.kelola.kolam.KelolaKolamMain
import com.aquanusa.aquasmart.view.kelola.pakan.JadwalPakanScreen
import com.aquanusa.aquasmart.view.kelola.pakan.KelolaPakanMain
import com.aquanusa.aquasmart.view.kelola.pakan.PenghitungDosisPakan
import com.aquanusa.aquasmart.view.kelola.pakan.StokPakanScreen
import com.aquanusa.aquasmart.view.notifikasi.NotifikasiScreen
import com.aquanusa.aquasmart.view.profile.BeforeProfileScreen
import com.aquanusa.aquasmart.view.profile.EditProfileScreen
import com.aquanusa.aquasmart.view.profile.ProfileScreen
import com.aquanusa.aquasmart.R
import com.aquanusa.aquasmart.view.error.NotFoundScreen
import com.aquanusa.aquasmart.view.kelola.ikan.add.jadwal_panen.TambahJadwalPanenScreen
import com.aquanusa.aquasmart.view.kelola.ikan.add.kematian_ikan.TambahKematianIkanScreen
import com.aquanusa.aquasmart.view.kelola.ikan.add.stok_ikan.TambahStokIkanScreen
import com.aquanusa.aquasmart.view.kelola.ikan.overview.OverviewStokIkan
import com.aquanusa.aquasmart.view.kelola.kolam.EditKolamScreen
import com.aquanusa.aquasmart.view.kelola.kolam.TambahKolamScreen
import com.aquanusa.aquasmart.view.kelola.pakan.add.jadwal_pakan.TambahJadwalPakanScreen
import com.aquanusa.aquasmart.view.kelola.pakan.add.stok_pakan.TambahStokPakanScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ParentView(navController: NavController) {

    //// ALL DATA ////
    val titleScreen = remember { mutableStateOf("Beranda") }

    val screenNow = remember { mutableStateOf("beranda") }

    val backTo = remember { mutableStateOf("beranda") }

    // Parameter //
    val paramsStokIkan = remember { mutableStateOf("") }
    val paramsKolam = remember { mutableStateOf("") }
    // End Parameter //
    //// END ALL DATA ////

    Scaffold(
        bottomBar = {
            BottomNavigation(
                navController,
                newScreen = { newScreen ->
                    screenNow.value = newScreen
                },
                screenNow.value,
                backNew = { backNew -> backTo.value = backNew },
                backTo.value
            )
        },

        floatingActionButton = {
            if (
                screenNow.value == "kelola_stok_ikan" ||
                screenNow.value == "kelola_jadwal_panen" ||
                screenNow.value == "kelola_kematian_ikan" ||
                screenNow.value == "kelola_kolam" ||
                screenNow.value == "kelola_jadwal_pakan" ||
                screenNow.value == "kelola_stok_pakan"
            ) {
                FloatingActionButton(
                    onClick = {
                        if (screenNow.value == "kelola_stok_ikan") {
                            backTo.value = screenNow.value
                            screenNow.value = "tambah_stok_ikan"
                        } else if (screenNow.value == "kelola_jadwal_panen") {
                            backTo.value = screenNow.value
                            screenNow.value = "tambah_jadwal_panen"
                        } else if (screenNow.value == "kelola_kematian_ikan") {
                            backTo.value = screenNow.value
                            screenNow.value = "tambah_kematian_ikan"
                        } else if (screenNow.value == "kelola_kolam") {
                            backTo.value = screenNow.value
                            screenNow.value = "tambah_kolam"
                        } else if (screenNow.value == "kelola_jadwal_pakan") {
                            backTo.value = screenNow.value
                            screenNow.value = "tambah_jadwal_pakan"
                        } else if (screenNow.value == "kelola_stok_pakan") {
                            backTo.value = screenNow.value
                            screenNow.value = "tambah_stok_pakan"
                        } else {
                            screenNow.value = "not_found"
                        }
                    },
                    modifier = Modifier
                        .size(60.dp)
                        .shadow(4.dp, shape = RoundedCornerShape(15.dp)),
                    containerColor = Color.White
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_9),
                        contentDescription = "icon add",
                        modifier = Modifier
                            .size(40.dp),
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Column(
            modifier = Modifier
                .background(Color(0xFF5E7BF9))
        ) {

            // NAVBAR TOP
            if (screenNow.value != "profile_show_profile") {
                NavbarTop(
                    navController,
                    titleScreen.value,
                    screenNow.value,
                    newScreen = { newScreen -> screenNow.value = newScreen },
                    backTo.value,
                    backNew = { backNew -> backTo.value = backNew })
            }


            // HEADER SPESIFIC SCREEN
            if (screenNow.value == "beranda") {
                HeaderBeranda()
            } else if (
                screenNow.value == "kelola" ||
                screenNow.value == "kelola_kolam" ||
                screenNow.value == "kelola_stok_ikan" ||
                screenNow.value == "kelola_pakan" ||
                screenNow.value == "kelola_jadwal_panen" ||
                screenNow.value == "kelola_kematian_ikan" ||
                screenNow.value == "kelola_jadwal_pakan" ||
                screenNow.value == "kelola_stok_pakan" ||
                screenNow.value == "kelola_dosis_pakan"
            ) {
                HeaderKelola(
                    screenNow.value,
                    newScreen = { newScreen -> screenNow.value = newScreen })
            }


            // KONDISI SCREEN
            if (screenNow.value == "beranda") {
                BerandaScreen(
                    newScreen = { newScreen -> screenNow.value = newScreen },
                    backNew = { backNew -> backTo.value = backNew },
                    screenNow.value
                )

            } else if (screenNow.value == "kelola") {           //// KELOLA SCREEN ////
                KelolaIkanMain(
                    newScreen = { newScreen -> screenNow.value = newScreen },
                    backNew = { backNew -> backTo.value = backNew },
                    screenNow.value
                )

            } else if (screenNow.value == "profile") {          //// PROFILE SCREEN ////
                titleScreen.value = "Profile"
                BeforeProfileScreen(
                    navController,
                    newScreen = { newScreen -> screenNow.value = newScreen },
                    backNew = { backNew -> backTo.value = backNew },
                    screenNow.value
                )

            } else if (screenNow.value == "profile_show_profile") {          //// PROFILE SCREEN ////
                ProfileScreen(
                    newScreen = { newScreen -> screenNow.value = newScreen },
                    backTo.value,
                    screenNow.value,
                    backNew = { backNew -> backTo.value = backNew }
                )

            } else if (screenNow.value == "profile_edit_profile") {
                titleScreen.value = "Edit Profile"
                EditProfileScreen()

            } else if (screenNow.value == "kelola_kolam") {     //// KELOLA SCREEN ////
                KelolaKolamMain(newParamsKolam = { newParamsKolam ->
                    paramsKolam.value = newParamsKolam
                }, newScreen = { newScreen -> screenNow.value = newScreen }, screenNow.value, newBack = { newBack -> backTo.value = newBack })

            } else if (screenNow.value == "kelola_pakan") {      //// KELOLA SCREEN ////
                KelolaPakanMain(
                    newScreen = { newScreen -> screenNow.value = newScreen },
                    backNew = { backNew -> backTo.value = backNew },
                    screenNow.value
                )

            } else if (screenNow.value == "kelola_stok_ikan") { //// KELOLA SCREEN ////
                titleScreen.value = "Stok Ikan"
                StokIkanScreen(
                    newScreen = { newScreen -> screenNow.value = newScreen },
                    backNew = { backNew -> backTo.value = backNew },
                    screenNow.value,
                    newParams = { newParams -> paramsStokIkan.value = newParams }
                )

            } else if (screenNow.value == "kelola_jadwal_panen") {   //// KELOLA SCREEN ////
                titleScreen.value = "Jadwal Panen"
                JadwalPanenScreen()

            } else if (screenNow.value == "kelola_kematian_ikan") {   //// KELOLA SCREEN ////
                titleScreen.value = "Kematian Ikan"
                KematianIkanScreen()

            } else if (screenNow.value == "kelola_jadwal_pakan") {   //// KELOLA SCREEN ////
                titleScreen.value = "Jadwal Pakan"
                JadwalPakanScreen()

            } else if (screenNow.value == "kelola_stok_pakan") {   //// KELOLA SCREEN ////
                titleScreen.value = "Stok Pakan"
                StokPakanScreen()

            } else if (screenNow.value == "kelola_dosis_pakan") {   //// KELOLA SCREEN ////
                titleScreen.value = "Dosis Pakan"
                PenghitungDosisPakan()

            } else if (screenNow.value == "pengingat") {    //// PENGINGAT SCREEN ////
                titleScreen.value = "Notifikasi"
                NotifikasiScreen()


                ///////////// TAMBAH SCREEN ////////////
            } else if (screenNow.value == "tambah_stok_ikan") {
                titleScreen.value = "Tambah Stok Ikan"
                TambahStokIkanScreen()

            } else if (screenNow.value == "tambah_kematian_ikan") {
                titleScreen.value = "Tambah Kematian Ikan"
                TambahKematianIkanScreen()

            } else if (screenNow.value == "tambah_kolam") {
                titleScreen.value = "Tambah Kolam"
                TambahKolamScreen()

            } else if (screenNow.value == "tambah_stok_pakan") {
                titleScreen.value = "Tambah Stok Pakan"
                TambahStokPakanScreen()

            } else if (screenNow.value == "tambah_jadwal_pakan") {
                titleScreen.value = "Tambah Jadwal Pakan"
                TambahJadwalPakanScreen()

            } else if (screenNow.value == "tambah_jadwal_panen") {
                titleScreen.value = "Tambah Jadwal Panen"
                TambahJadwalPanenScreen()


                ///////////// PREVIEW SCREEN ////////////
            } else if (screenNow.value == "preview_stok_ikan") {
                OverviewStokIkan(paramsStokIkan.value)


                ///////////// EDIT SCREEN ////////////
            } else if (screenNow.value == "edit_kolam") {
                titleScreen.value = "Edit Kolam"
                EditKolamScreen(paramsKolam.value, newScreen = { newScreen -> screenNow.value = newScreen })


            } else if (screenNow.value == "not_found") {
                NotFoundScreen(newScreen = { newScreen -> screenNow.value = newScreen })
            } else {
                NotFoundScreen(newScreen = { newScreen -> screenNow.value = newScreen })
            }


        }
    }
}