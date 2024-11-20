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
import com.example.aquasmart10.model.modelKolam
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
import com.example.aquasmart10.viewmodel.KolamViewModel


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