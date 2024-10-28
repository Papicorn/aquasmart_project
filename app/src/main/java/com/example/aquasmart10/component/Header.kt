package com.example.aquasmart10.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aquasmart10.R

data class HeaderIcon(
    val iconRes: Int,
    val contentDescription: String? = null
)

@Composable
fun Header() {
    var isClicked by remember { mutableStateOf(false) }
    val sambutan = "Selamat Datang,"
    var nama = "Hanif"

    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color(0xFF5E7BF9))
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.notif),
                contentDescription = "Notification Icon",
                modifier = Modifier
                    .padding()
                    .height(40.dp)
                    .size(20.dp)
                    .align(Alignment.TopEnd)
                    .clickable {
                        isClicked = !isClicked
                    },
                tint = Color.White
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column {
                Icon(
                    painter = painterResource(id = R.drawable.img_1),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .padding(vertical = 20.dp)
                        .height(35.dp),
                    tint = Color.White
                )

                Text(
                    text = sambutan,
                    fontSize = 25.sp,
                    fontFamily = customFontFamily,
                    color = Color.White,
                    fontWeight = FontWeight.Normal
                )

                Text(
                    text = nama,
                    fontSize = 40.sp,
                    fontFamily = customFontFamily,
                    color = Color.White,
                    modifier = Modifier.padding(top = 5.dp, bottom = 25.dp),
                    fontWeight = FontWeight.Bold
                )
            }

            Image(
                painter = painterResource(R.drawable.bapak),
                contentDescription = null,
                modifier = Modifier.scale(1.7f).padding(bottom = 20.dp, end = 13.dp)

            )
        }
    }
}