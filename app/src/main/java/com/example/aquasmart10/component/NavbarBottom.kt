package com.example.aquasmart10.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.aquasmart10.R
import com.example.aquasmart10.Routes

@Composable
fun NavbarBottom(navController: NavController){
    BottomNavigationBar(navController)
}
data class BottomNavigation(
    val title: String,
    val iconRes: Int,
    val route: String
)

val items = listOf(
    BottomNavigation(
        title = "Beranda",
        iconRes = R.drawable.home,
        route = Routes.BerandaActivity
    ),
    BottomNavigation(
        title = "Kelola",
        iconRes = R.drawable.kelola,
        route = Routes.KelolaActivity
    ),
    BottomNavigation(
        title = "Profile",
        iconRes = R.drawable.profile,
        route = Routes.BerandaActivity
    )
)
@Composable
fun BottomNavigationBar(navController: NavController) {

    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold)
    )
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        NavigationBar(
            containerColor = Color(0xFF5E7BF9)
        ) {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    selected = index == 0,
                    onClick = {
                        navController.navigate(item.route)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.iconRes),
                            contentDescription = item.title,
                            tint = Color.White
                        )
                    },
                    label = {
                        Text(
                            text = item.title,
                            fontFamily = customFontFamily,
                            color = Color.White
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color.Transparent, // No background color when selected
                        unselectedIconColor = Color.White,
                        unselectedTextColor = Color.White,
                        selectedIconColor = Color.White,
                        selectedTextColor = Color.White
                    )
                )
            }
        }
    }
}