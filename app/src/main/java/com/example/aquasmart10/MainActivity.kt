package com.example.aquasmart10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquasmart10.ui.theme.AquaSmart10Theme

@Composable
fun MainTopBar(modifier: Modifier = Modifier) {
    Column {
        Row {
            Image(
                painter = painterResource(R.drawable.img_background),
                contentDescription = "Background"
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AquaSmart10Theme {
        MainTopBar()
    }
}