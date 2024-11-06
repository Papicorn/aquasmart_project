package com.example.aquasmart10.view

import com.example.aquasmart10.R
import com.example.aquasmart10.component.HeaderKelola
import com.example.aquasmart10.component.KolamIkanBody
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.aquasmart10.component.BottomNavigationBar
import androidx.compose.material3.FabPosition
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aquasmart10.Routes
import com.example.aquasmart10.component.NavbarTop

@Composable
fun KolamIkanScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Routes.TambahKolamScreen) },
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
        },
        floatingActionButtonPosition = FabPosition.End
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFF5E7BF9))
        ) {
            NavbarTop(navController)
            HeaderKelola(navController, currentTab = "Kolam")
            KolamIkanBody(navController)
        }
    }
}
