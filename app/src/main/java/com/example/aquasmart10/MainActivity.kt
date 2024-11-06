package com.example.aquasmart10

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition  // Tambahkan import ini
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aquasmart10.view.BerandaActivity
import com.example.aquasmart10.view.CoverScreen
import com.example.aquasmart10.view.EditIkanActivity
import com.example.aquasmart10.view.EditJadwalPakanActivity
import com.example.aquasmart10.view.EditJadwalPanenActivity
import com.example.aquasmart10.view.EditKematianIkanActivity
import com.example.aquasmart10.view.EditKolamScreen
import com.example.aquasmart10.view.EditPakanScreen
import com.example.aquasmart10.view.EditProfileActivity
import com.example.aquasmart10.view.HitungDosisPakanActivity
import com.example.aquasmart10.view.JadwalPakanScreen
import com.example.aquasmart10.view.KelolaActivity
import com.example.aquasmart10.view.KelolaPakanActivity
import com.example.aquasmart10.view.KematianIkanActivity
import com.example.aquasmart10.view.KolamIkanScreen
import com.example.aquasmart10.view.LoginScreen
import com.example.aquasmart10.view.NotifikasiActivity
import com.example.aquasmart10.view.OverviewProfileActivity
import com.example.aquasmart10.view.OverviewStokIkan
import com.example.aquasmart10.view.PengingatPakanActivity
import com.example.aquasmart10.view.PengingatPanenActivity
import com.example.aquasmart10.view.ProfileAwalActivity
import com.example.aquasmart10.view.StokIkanActivity
import com.example.aquasmart10.view.StokPakanActivity
import com.example.aquasmart10.view.TambahIkanActivity
import com.example.aquasmart10.view.TambahJadwalPakanActivity
import com.example.aquasmart10.view.TambahJadwalPanenActivity
import com.example.aquasmart10.view.TambahKematianIkanActivity
import com.example.aquasmart10.view.TambahKolamScreen
import com.example.aquasmart10.view.TambahPakanScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        actionBar?.hide()
        installSplashScreen()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Routes.CoverScreen,
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None }
            ) {
                composable(
                    route = Routes.BerandaActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    BerandaActivity(navController)
                }
                composable(
                    route = Routes.KelolaActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    KelolaActivity(navController)
                }
                composable(
                    route = Routes.EditKematianIkanActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    EditKematianIkanActivity(navController)
                }
                composable(
                    route = Routes.KelolaPakanActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    KelolaPakanActivity(navController)
                }
                composable(
                    route = Routes.StokIkanActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    StokIkanActivity(navController)
                }
                composable(
                    route = Routes.OverviewStokIkan,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    OverviewStokIkan(navController)
                }
                composable(
                    route = Routes.TambahIkanActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    TambahIkanActivity(navController)
                }
                composable(
                    route = Routes.EditIkanActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    EditIkanActivity(navController)
                }
                composable(
                    route = Routes.KematianIkanActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    KematianIkanActivity(navController)
                }
                composable(
                    route = Routes.TambahKematianIkanActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    TambahKematianIkanActivity(navController)
                }
                composable(
                    route = Routes.NotifikasiActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    NotifikasiActivity(navController)
                }
                composable(
                    route = Routes.PengingatPanenActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    PengingatPanenActivity(navController)
                }
                composable(
                    route = Routes.EditJadwalPanenActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    EditJadwalPanenActivity(navController)
                }
                composable(
                    route = Routes.TambahJadwalPanenActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    TambahJadwalPanenActivity(navController)
                }
                composable(
                    route = Routes.HitungDosisPakanActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    HitungDosisPakanActivity(navController)
                }
                composable(
                    route = Routes.ProfileAwalActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    ProfileAwalActivity(navController)
                }
                composable(
                    route = Routes.OverviewProfileActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    OverviewProfileActivity(navController)
                }
                composable(
                    route = Routes.EditProfileActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    EditProfileActivity(navController)
                }
                composable(
                    route = Routes.KolamIkanScreen,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    KolamIkanScreen(navController)
                }
                composable(
                    route = Routes.TambahKolamScreen,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    TambahKolamScreen(navController)
                }
                composable(
                    route = Routes.EditKolamScreen,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    EditKolamScreen(navController)
                }
                composable(
                    route = Routes.StokPakanActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    StokPakanActivity(navController)
                }
                composable(
                    route = Routes.EditPakanScreen,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    EditPakanScreen(navController)
                }
                composable(
                    route = Routes.TambahPakanScreen,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    TambahPakanScreen(navController)
                }
                composable(
                    route = Routes.JadwalPakanScreen,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    JadwalPakanScreen(navController)
                }
                composable(
                    route = Routes.PengingatPakanActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    PengingatPakanActivity(navController)
                }
                composable(
                    route = Routes.EditJadwalPakanActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    EditJadwalPakanActivity(navController)
                }
                composable(
                    route = Routes.TambahJadwalPakanActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    TambahJadwalPakanActivity(navController)
                }
                composable(
                    route = Routes.LoginScreen,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    LoginScreen(navController)
                }
                composable(
                    route = Routes.CoverScreen,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    CoverScreen(navController)
                }
            }
        }
    }
}