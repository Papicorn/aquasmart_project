package com.example.aquasmart10.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aquasmart10.R
import com.example.aquasmart10.Routes
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.sp

@Composable
fun NavbarBottom(navController: NavController) {
    BottomNavigationBar(navController)
}

data class BottomNavigation(
    val title: String,
    val iconRes: Int,
    val iconSelected: Int,
    val route: String
)

val items = listOf(
    BottomNavigation(
        title = "Beranda",
        iconRes = R.drawable.homesebelumdiselect,
        iconSelected = R.drawable.homesetelahdiselect,
        route = Routes.BerandaActivity
    ),
    BottomNavigation(
        title = "Kelola",
        iconRes = R.drawable.kelola,
        iconSelected = R.drawable.kelolasetelahdiselect,
        route = Routes.KelolaActivity
    ),
    BottomNavigation(
        title = "Profile",
        iconRes = R.drawable.profile,
        iconSelected = R.drawable.profilsetelahdiselect,
        route = Routes.ProfileAwalActivity
    )
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route

    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold)
    )

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        NavigationBar(
            containerColor = Color(0xFF5E7BF9),
            modifier = Modifier.height(80.dp)
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = {
                        if (currentRoute != item.route) {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationId)
                                launchSingleTop = true
                            }
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(
                                id = if (currentRoute == item.route) {
                                    item.iconSelected
                                } else {
                                    item.iconRes
                                }
                            ),
                            contentDescription = item.title,
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontFamily = customFontFamily,
                            color = Color.White,
                            fontWeight = if (currentRoute == item.route) {
                                FontWeight.Bold
                            } else {
                                FontWeight.Normal
                            },
                            fontSize = 12.sp
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent,
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White,
                        selectedIconColor = Color.White,
                        selectedTextColor = Color.White
                    ),
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}