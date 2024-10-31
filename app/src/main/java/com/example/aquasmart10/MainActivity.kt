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
import com.example.aquasmart10.component.TambahStokIkan

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        installSplashScreen()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Routes.BerandaActivity,
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
                    route = Routes.BerandaActivity,
                    enterTransition = { EnterTransition.None },
                    exitTransition = { ExitTransition.None }
                ) {
                    BerandaActivity(navController)
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
            }
        }
    }
}