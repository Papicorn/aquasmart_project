package com.aquanusa.aquasmart.partials.kelola

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aquanusa.aquasmart.R

@Composable
fun HeaderKelola(screenNow: (String), newScreen: (String) -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF5E7BF9)),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TextButton(
            onClick = {
                newScreen("kelola")
            }, modifier = Modifier
                .weight(1f)
                .background(
                    if (
                        screenNow == "kelola" ||
                        screenNow == "kelola_stok_ikan" ||
                        screenNow == "kelola_jadwal_panen" ||
                        screenNow == "kelola_kematian_ikan"
                        ) Color(0xFF8BA3FC)
                    else Color.Transparent
                )
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
                Text(
                    "Ikan",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }

        TextButton(
            onClick = {
                newScreen("kelola_kolam")
            }, modifier = Modifier
                .weight(1f)
                .background(
                    if (screenNow == "kelola_kolam") Color(0xFF8BA3FC)
                    else Color.Transparent
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "Kolam",
                    modifier = Modifier.size(18.dp),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Kolam",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }

        TextButton(
            onClick = {
                newScreen("kelola_pakan")
            }, modifier = Modifier
                .weight(1f)
                .background(
                    if (
                        screenNow == "kelola_pakan" ||
                        screenNow == "kelola_jadwal_pakan" ||
                        screenNow == "kelola_stok_pakan" ||
                        screenNow == "kelola_dosis_pakan"
                        ) Color(0xFF8BA3FC)
                    else Color.Transparent
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.img_2),
                    contentDescription = "Pakan",
                    modifier = Modifier.size(18.dp),
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Pakan",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}