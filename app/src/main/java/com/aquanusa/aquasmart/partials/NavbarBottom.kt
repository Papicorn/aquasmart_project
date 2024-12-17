package com.aquanusa.aquasmart.partials

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aquanusa.aquasmart.R

@Composable
fun BottomNavigation(
    navController: NavController,
    newScreen: (String) -> Unit,
    screenNow: (String),
    backNew: (String) -> Unit,
    backTo: (String)
) {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar(
        containerColor = Color(0xff5E7BF9),
        modifier = Modifier.fillMaxWidth()
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    painter = if (
                        screenNow == "beranda" ||
                        screenNow == "pengingat"
                    )
                        painterResource(id = R.drawable.beranda_icon_active) else painterResource(id = R.drawable.beranda_icon),
                    contentDescription = "Icon Beranda",
                    modifier = Modifier.size(23.dp)
                )
            },
            label = { Text("Beranda") },
            selected = currentRoute == "Beranda",
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                selectedIconColor = Color.White,
                selectedTextColor = Color.White
            ),
            onClick = {
                backNew(screenNow)
                newScreen("beranda")
            },
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = if (
                        screenNow == "kelola" ||
                        screenNow == "kelola_kolam" ||
                        screenNow == "kelola_pakan" ||
                        screenNow == "kelola_stok_ikan" ||
                        screenNow == "kelola_jadwal_panen" ||
                        screenNow == "kelola_kematian_ikan" ||
                        screenNow == "kelola_jadwal_pakan" ||
                        screenNow == "kelola_stok_pakan" ||
                        screenNow == "kelola_dosis_pakan" ||


                        screenNow == "tambah_stok_ikan" ||
                        screenNow == "tambah_jadwal_panen" ||
                        screenNow == "tambah_kematian_ikan" ||
                        screenNow == "tambah_kolam" ||
                        screenNow == "tambah_jadwal_pakan" ||
                        screenNow == "tambah_stok_pakan" ||

                        screenNow == "preview_stok_ikan" ||

                        screenNow == "edit_kolam"
                    )
                        painterResource(id = R.drawable.kelola_icon_active)
                    else painterResource(id = R.drawable.icon_kelola),

                    contentDescription = "Icon Kelola",
                    modifier = Modifier.size(23.dp)
                )
            },
            label = { Text("Kelola") },
            selected = currentRoute == "Kelola",
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                selectedIconColor = Color.White,
                selectedTextColor = Color.White
            ),
            onClick = {
                backNew(screenNow)
                newScreen("kelola")
            },
        )
        NavigationBarItem(
            icon = {
                Icon(
                    painter = if (
                        screenNow == "profile" ||
                        screenNow == "profile_show_profile" ||
                        screenNow == "profile_edit_profile"
                    )
                        painterResource(id = R.drawable.profilsetelahdiselect)
                    else
                        painterResource(id = R.drawable.profile_icon),
                    contentDescription = "Icon Profile",
                    modifier = Modifier.size(23.dp)
                )
            },
            label = { Text("Profile") },
            selected = currentRoute == "Before Profile",
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent,
                unselectedIconColor = Color.White,
                unselectedTextColor = Color.White,
                selectedIconColor = Color.White,
                selectedTextColor = Color.White
            ),
            onClick = {
                if (screenNow != "profile") {
                    backNew(screenNow)
                } else {
                    backNew(backTo)
                }
                newScreen("profile")
            },
        )
    }
}