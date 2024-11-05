package com.example.aquasmart10.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aquasmart10.R
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun SecondaryHeader(navController: NavController) {
    var isClicked by remember { mutableStateOf(false) }
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF5E7BF9))
            .padding(horizontal = 20.dp, vertical = 30.dp)
    ){
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = "aquasmart logo",
                    modifier = Modifier
                        .height(35.dp),
                    tint = Color.White
                )
                Icon(
                    painter = painterResource(id = R.drawable.notif),
                    contentDescription = "Notification Icon",
                    modifier = Modifier
                        .padding()
                        .height(40.dp)
                        .size(24.dp)
                        .clickable { isClicked = !isClicked },
                    tint = Color.White
                )
            }
        }
    }
}

