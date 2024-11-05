package com.example.aquasmart10.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aquasmart10.R

@Composable
fun ButttonAdd(modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.img_9),
            contentDescription = "iicon tambah",
            modifier = Modifier
                .padding(6.dp)
                .size(60.dp)
        )
    }
}

@Preview
@Composable
fun ButtonAddPreview() {
    ButttonAdd()
}