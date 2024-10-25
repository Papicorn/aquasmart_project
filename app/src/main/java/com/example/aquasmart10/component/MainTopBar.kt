package com.example.aquasmart10.component

import com.example.aquasmart10.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainTopBar(modifier: Modifier = Modifier) {
        Column (
                modifier = Modifier
                        .fillMaxWidth(),
                horizontalAlignment = Alignment.
        ){
                Row {
                        Image(
                                painter = painterResource(R.drawable.img_1),
                                contentDescription = null
                        )

                        Icon(
                                modifier = Modifier,
                                imageVector = Icons.Default.Notifications,
                                contentDescription = "Notifikasi"

                        )
                }
        }
}

@Preview
@Composable
fun MainTopBarPreview() {
        MainTopBar()
}