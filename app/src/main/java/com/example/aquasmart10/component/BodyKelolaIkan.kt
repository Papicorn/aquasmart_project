package com.example.aquasmart10.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aquasmart10.R

@Composable
fun BodyKelolaIkan(){
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )

    Column(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 25.dp,
                    topEnd = 25.dp
                )
            )
            .background(color = Color(0xFFEFF6FC))
            .fillMaxSize()
    ) {
        Text("Kelola Ikan",
            fontFamily = customFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(top = 16.dp, start = 18.dp)
        )
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ){
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFFFFFF),
                ),
                modifier = Modifier
                    .size(width = 350.dp, height = 50.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.stokikan),
                        contentDescription = "Stok Ikan",
                        modifier = Modifier
                            .size(40.dp)
                            .padding(start = 16.dp)
                    )
                    Text(
                        "Stok Ikan",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFFFFFF),
                ),
                modifier = Modifier
                    .size(width = 350.dp, height = 50.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.jadwalpanen),
                        contentDescription = "Jadwal Panen",
                        modifier = Modifier
                            .size(40.dp)
                            .padding(start = 16.dp)
                    )
                    Text(
                        "Jadwal Panen",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFFFFFFF),
                ),
                modifier = Modifier
                    .size(width = 350.dp, height = 50.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ripikan),
                        contentDescription = "Kematian Ikan",
                        modifier = Modifier
                            .size(40.dp)
                            .padding(start = 16.dp)
                    )
                    Text(
                        "Kematian Ikan",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}
@Preview
@Composable
fun bodykelolaikan(){
    BodyKelolaIkan()
}