package com.example.aquasmart10.component

import android.R.attr.onClick
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aquasmart10.R

@Composable
fun HeaderKelola() {
    var isClicked by remember { mutableStateOf(false) }

    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF5E7BF9)),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextButton(
                onClick = {
                },
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.img_3),
                        contentDescription = "Ikan",
                        modifier = Modifier.size(18.dp),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Ikan", color = Color.White, fontFamily = customFontFamily, fontWeight = FontWeight.Bold)
                }
            }
            TextButton(
                onClick = {
                },
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.kelolakolam),
                        contentDescription = "Kolam",
                        modifier = Modifier.size(18.dp),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Kolam", color = Color.White, fontFamily = customFontFamily, fontWeight = FontWeight.Bold)
                }
            }
            TextButton(
                onClick = {
                },
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.kelolapakan),
                        contentDescription = "Kolam",
                        modifier = Modifier.size(18.dp),
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Pakan", color = Color.White, fontFamily = customFontFamily, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
@Preview
@Composable
fun Kelola(){
    HeaderKelola()
}