package com.example.aquasmart10.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.KeyboardType
import com.example.aquasmart10.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.Alignment
import androidx.navigation.NavController

@Composable
fun EditPakanBody(navController: NavController) {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )

    var jenisPakan by remember { mutableStateOf("") }
    var namaPakan by remember { mutableStateOf("") }
    var stok by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFEFF6FC))
                .padding(20.dp)

        ) {
            Column {
                Text(
                    text = "Edit Pakan",
                    fontFamily = customFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                TextField(
                    value = jenisPakan,
                    onValueChange = { jenisPakan = it },
                    label = {
                        Text(
                            text = "Jenis Pakan",
                            fontFamily = customFontFamily
                        ) },
                    placeholder = { Text("Edit jenis pakan") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp, shape = RoundedCornerShape(
                            topStart = 15.dp,
                            topEnd = 15.dp,
                            bottomStart = 15.dp,
                            bottomEnd = 15.dp)
                        ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                TextField(
                    value = namaPakan,
                    onValueChange = { namaPakan = it },
                    label = {
                        Text(
                            text = "Nama Pakan",
                            fontFamily = customFontFamily
                        ) },
                    placeholder = { Text("Edit nama pakan") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(4.dp, shape = RoundedCornerShape(
                            topStart = 15.dp,
                            topEnd = 15.dp,
                            bottomStart = 15.dp,
                            bottomEnd = 15.dp)
                        ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Min),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = stok,
                        onValueChange = { stok = it },
                        label = {
                            Text(
                                text = "Stok",
                                fontFamily = customFontFamily
                            ) },
                        placeholder = {
                            Text("Edit jumlah stok") },
                        modifier = Modifier
                            .weight(1f)
                            .shadow(4.dp, shape = RoundedCornerShape(
                                topStart = 15.dp,
                                bottomStart = 15.dp)
                            ),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )

                    Box(
                        modifier = Modifier
                            .shadow(5.dp, shape = RoundedCornerShape(
                                topEnd = 15.dp,
                                bottomEnd = 15.dp
                            ))
                            .background(Color.LightGray)
                            .padding(vertical = 12.dp, horizontal = 8.dp)
                            .width(75.dp)
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center

                    ) {
                        Text(
                            text = "kg",
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontFamily = customFontFamily,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier

                        )
                    }
                }
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 20.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E7BF9))
                ) {
                    Text(
                        text = "Simpan",
                        fontFamily = customFontFamily,
                        fontSize = 16.sp,
                        color = Color.White,
                        modifier = Modifier
                            .padding(3.dp)
                    )
                }
            }
        }
    }
}
