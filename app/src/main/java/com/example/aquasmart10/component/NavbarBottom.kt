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
import com.example.aquasmart10.R


data class BottomNavigation(
    val title: String,
    val iconRes: Int
)

val items = listOf(
    BottomNavigation(
        title = "Beranda",
        iconRes = R.drawable.home
    ),
    BottomNavigation(
        title = "Kelola",
        iconRes = R.drawable.kelola
    ),
    BottomNavigation(
        title = "Profile",
        iconRes = R.drawable.profile
    )
)

@Preview
@Composable
fun BottomNavigationBar() {

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
                    onClick = {},
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