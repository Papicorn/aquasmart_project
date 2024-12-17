package com.aquanusa.aquasmart.view.kelola.ikan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aquanusa.aquasmart.R

@Composable
fun KematianIkanScreen() {
    val openAlertDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .background(Color(0xFF8BA3FC))
                .width(150.dp)
                .height(25.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-25).dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFEFF6FC)
            ),
            shape = MaterialTheme.shapes.extraLarge
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 17.dp, end = 17.dp, top = 25.dp, bottom = 78.dp)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    item {
                        Text(
                            "Total Kematian Ikan",
                            fontWeight = FontWeight.Normal,
                            fontSize = 20.sp,
                        )
                        Text(
                            "28 Ikan",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp,
                        )
                        Row{
                            Text(
                                "dari ",
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp
                            )
                            Text(
                                "2 Kolam",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 15.sp,
                            )
                            Text(
                                " aktif",
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                            )
                        }
                        Spacer(modifier = Modifier.padding(vertical = 5.dp))
                        Text(
                            text = "Sabtu, 23 November 2024",
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.padding(vertical = 3.dp))
                        Column {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(130.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                shape = MaterialTheme.shapes.large
                            ) {
                                Box(
                                    modifier = Modifier.padding(17.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.fillMaxHeight(),
                                        verticalArrangement = Arrangement.SpaceBetween
                                    ) {

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(
                                                text = buildAnnotatedString {
                                                    append("Kematian Ikan ")
                                                    withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold)) {
                                                        append("x20")
                                                    }
                                                },
                                                fontSize = 18.sp
                                            )
                                            Text(
                                                text = "11:58:16",
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.ExtraBold
                                            )
                                        }

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.Bottom
                                        ) {
                                            Column {
                                                Text(
                                                    text = buildAnnotatedString {
                                                        append("Kolam :")
                                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                            append(" A-A1")
                                                        }
                                                    },
                                                    fontSize = 13.sp,
                                                    color = Color.Black
                                                )
                                                Spacer(modifier = Modifier.padding(vertical = 1.dp))
                                                Text(
                                                    text = buildAnnotatedString {
                                                        append("Jenis Ikan")
                                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                            append(" Nila Merah")
                                                        }
                                                    },
                                                    fontSize = 13.sp,
                                                    color = Color.Black
                                                )
                                            }
                                            Row {
                                                IconButton(
                                                    onClick = { openAlertDialog.value = true },
                                                    modifier = Modifier
                                                        .size(40.dp)
                                                        .padding(end = 4.dp),
                                                ) {
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.sampah),
                                                        contentDescription = "Trash",
                                                        modifier = Modifier
                                                            .size(28.dp)
                                                            .padding(start = 6.dp),
                                                        tint = Color(0xFFEC221F)
                                                    )
                                                }
                                                IconButton(
                                                    onClick = {

                                                    }, modifier = Modifier.size(40.dp)
                                                ) {
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.edit),
                                                        contentDescription = "Edit",
                                                        modifier = Modifier
                                                            .size(28.dp)
                                                            .padding(start = 6.dp),
                                                        tint = Color(0XFF2C793E)
                                                    )
                                                }
                                            }
                                        }

                                    }

                                    if (openAlertDialog.value) {
                                        AlertDialog(
                                            containerColor = Color.White,
                                            onDismissRequest = {
                                                openAlertDialog.value = false
                                            },
                                            title = {
                                                Column(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Text(
                                                        text = "Notifikasi",
                                                        textAlign = TextAlign.Center
                                                    )
                                                }
                                            },
                                            text = {
                                                Text(
                                                    text = "Anda yakin ingin mengahpus data ini?",
                                                    modifier = Modifier.fillMaxWidth(),
                                                    textAlign = TextAlign.Center
                                                )
                                            },
                                            confirmButton = {
                                                Row(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.SpaceEvenly
                                                ) {
                                                    TextButton(
                                                        onClick = {
                                                            openAlertDialog.value = false
                                                        },
                                                        modifier = Modifier.background(
                                                            Color.Red,
                                                            shape = RoundedCornerShape(8.dp)
                                                        )
                                                    ) {
                                                        Text(
                                                            "Hapus",
                                                            color = Color.White
                                                        )
                                                    }
                                                    TextButton(
                                                        onClick = {
                                                            openAlertDialog.value = false
                                                        },
                                                        modifier = Modifier.background(
                                                            Color.Black,
                                                            shape = RoundedCornerShape(8.dp)
                                                        )
                                                    ) {
                                                        Text(
                                                            "Batal",
                                                            color = Color.White
                                                        )
                                                    }
                                                }
                                            })
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.padding(vertical = 8.dp))
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(130.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                shape = MaterialTheme.shapes.large
                            ) {
                                Box(
                                    modifier = Modifier.padding(17.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.fillMaxHeight(),
                                        verticalArrangement = Arrangement.SpaceBetween
                                    ) {

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(
                                                text = buildAnnotatedString {
                                                    append("Kematian Ikan ")
                                                    withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold)) {
                                                        append("x20")
                                                    }
                                                },
                                                fontSize = 18.sp
                                            )
                                            Text(
                                                text = "11:58:16",
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.ExtraBold
                                            )
                                        }

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.Bottom
                                        ) {
                                            Column {
                                                Text(
                                                    text = buildAnnotatedString {
                                                        append("Kolam :")
                                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                            append(" A-A1")
                                                        }
                                                    },
                                                    fontSize = 13.sp,
                                                    color = Color.Black
                                                )
                                                Spacer(modifier = Modifier.padding(vertical = 1.dp))
                                                Text(
                                                    text = buildAnnotatedString {
                                                        append("Jenis Ikan")
                                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                            append(" Nila Merah")
                                                        }
                                                    },
                                                    fontSize = 13.sp,
                                                    color = Color.Black
                                                )
                                            }
                                            Row {
                                                IconButton(
                                                    onClick = { openAlertDialog.value = true },
                                                    modifier = Modifier
                                                        .size(40.dp)
                                                        .padding(end = 4.dp),
                                                ) {
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.sampah),
                                                        contentDescription = "Trash",
                                                        modifier = Modifier
                                                            .size(28.dp)
                                                            .padding(start = 6.dp),
                                                        tint = Color(0xFFEC221F)
                                                    )
                                                }
                                                IconButton(
                                                    onClick = {
                                                        //                                                    navController.navigate(Routes.EditKolamScreen)
                                                    }, modifier = Modifier.size(40.dp)
                                                ) {
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.edit),
                                                        contentDescription = "Edit",
                                                        modifier = Modifier
                                                            .size(28.dp)
                                                            .padding(start = 6.dp),
                                                        tint = Color(0XFF2C793E)
                                                    )
                                                }
                                            }
                                        }

                                    }

                                    if (openAlertDialog.value) {
                                        AlertDialog(
                                            containerColor = Color.White,
                                            onDismissRequest = {
                                                openAlertDialog.value = false
                                            },
                                            title = {
                                                Column(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Text(
                                                        text = "Notifikasi",
                                                        textAlign = TextAlign.Center
                                                    )
                                                }
                                            },
                                            text = {
                                                Text(
                                                    text = "Anda yakin ingin mengahpus data ini?",
                                                    modifier = Modifier.fillMaxWidth(),
                                                    textAlign = TextAlign.Center
                                                )
                                            },
                                            confirmButton = {
                                                Row(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.SpaceEvenly
                                                ) {
                                                    TextButton(
                                                        onClick = {
                                                            openAlertDialog.value = false
                                                        },
                                                        modifier = Modifier.background(
                                                            Color.Red,
                                                            shape = RoundedCornerShape(8.dp)
                                                        )
                                                    ) {
                                                        Text(
                                                            "Hapus",
                                                            color = Color.White
                                                        )
                                                    }
                                                    TextButton(
                                                        onClick = {
                                                            openAlertDialog.value = false
                                                        },
                                                        modifier = Modifier.background(
                                                            Color.Black,
                                                            shape = RoundedCornerShape(8.dp)
                                                        )
                                                    ) {
                                                        Text(
                                                            "Batal",
                                                            color = Color.White
                                                        )
                                                    }
                                                }
                                            })
                                    }
                                }
                            }
                        }

                        Spacer(modifier = Modifier.padding(vertical = 13.dp))
                        Text(
                            text = "Jumat, 22 November 2024",
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.padding(vertical = 3.dp))
                        Column {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(130.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                shape = MaterialTheme.shapes.large
                            ) {
                                Box(
                                    modifier = Modifier.padding(17.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.fillMaxHeight(),
                                        verticalArrangement = Arrangement.SpaceBetween
                                    ) {

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(
                                                text = buildAnnotatedString {
                                                    append("Kematian Ikan ")
                                                    withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold)) {
                                                        append("x20")
                                                    }
                                                },
                                                fontSize = 18.sp
                                            )
                                            Text(
                                                text = "11:58:16",
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.ExtraBold
                                            )
                                        }

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.Bottom
                                        ) {
                                            Column {
                                                Text(
                                                    text = buildAnnotatedString {
                                                        append("Kolam :")
                                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                            append(" A-A1")
                                                        }
                                                    },
                                                    fontSize = 13.sp,
                                                    color = Color.Black
                                                )
                                                Spacer(modifier = Modifier.padding(vertical = 1.dp))
                                                Text(
                                                    text = buildAnnotatedString {
                                                        append("Jenis Ikan")
                                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                            append(" Nila Merah")
                                                        }
                                                    },
                                                    fontSize = 13.sp,
                                                    color = Color.Black
                                                )
                                            }
                                            Row {
                                                IconButton(
                                                    onClick = { openAlertDialog.value = true },
                                                    modifier = Modifier
                                                        .size(40.dp)
                                                        .padding(end = 4.dp),
                                                ) {
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.sampah),
                                                        contentDescription = "Trash",
                                                        modifier = Modifier
                                                            .size(28.dp)
                                                            .padding(start = 6.dp),
                                                        tint = Color(0xFFEC221F)
                                                    )
                                                }
                                                IconButton(
                                                    onClick = {
                                                        //                                                    navController.navigate(Routes.EditKolamScreen)
                                                    }, modifier = Modifier.size(40.dp)
                                                ) {
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.edit),
                                                        contentDescription = "Edit",
                                                        modifier = Modifier
                                                            .size(28.dp)
                                                            .padding(start = 6.dp),
                                                        tint = Color(0XFF2C793E)
                                                    )
                                                }
                                            }
                                        }

                                    }

                                    if (openAlertDialog.value) {
                                        AlertDialog(
                                            containerColor = Color.White,
                                            onDismissRequest = {
                                                openAlertDialog.value = false
                                            },
                                            title = {
                                                Column(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Text(
                                                        text = "Notifikasi",
                                                        textAlign = TextAlign.Center
                                                    )
                                                }
                                            },
                                            text = {
                                                Text(
                                                    text = "Anda yakin ingin mengahpus data ini?",
                                                    modifier = Modifier.fillMaxWidth(),
                                                    textAlign = TextAlign.Center
                                                )
                                            },
                                            confirmButton = {
                                                Row(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.SpaceEvenly
                                                ) {
                                                    TextButton(
                                                        onClick = {
                                                            openAlertDialog.value = false
                                                        },
                                                        modifier = Modifier.background(
                                                            Color.Red,
                                                            shape = RoundedCornerShape(8.dp)
                                                        )
                                                    ) {
                                                        Text(
                                                            "Hapus",
                                                            color = Color.White
                                                        )
                                                    }
                                                    TextButton(
                                                        onClick = {
                                                            openAlertDialog.value = false
                                                        },
                                                        modifier = Modifier.background(
                                                            Color.Black,
                                                            shape = RoundedCornerShape(8.dp)
                                                        )
                                                    ) {
                                                        Text(
                                                            "Batal",
                                                            color = Color.White
                                                        )
                                                    }
                                                }
                                            })
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.padding(vertical = 8.dp))
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(130.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                shape = MaterialTheme.shapes.large
                            ) {
                                Box(
                                    modifier = Modifier.padding(17.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.fillMaxHeight(),
                                        verticalArrangement = Arrangement.SpaceBetween
                                    ) {

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(
                                                text = buildAnnotatedString {
                                                    append("Kematian Ikan ")
                                                    withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold)) {
                                                        append("x20")
                                                    }
                                                },
                                                fontSize = 18.sp
                                            )
                                            Text(
                                                text = "11:58:16",
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.ExtraBold
                                            )
                                        }

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.Bottom
                                        ) {
                                            Column {
                                                Text(
                                                    text = buildAnnotatedString {
                                                        append("Kolam :")
                                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                            append(" A-A1")
                                                        }
                                                    },
                                                    fontSize = 13.sp,
                                                    color = Color.Black
                                                )
                                                Spacer(modifier = Modifier.padding(vertical = 1.dp))
                                                Text(
                                                    text = buildAnnotatedString {
                                                        append("Jenis Ikan")
                                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                            append(" Nila Merah")
                                                        }
                                                    },
                                                    fontSize = 13.sp,
                                                    color = Color.Black
                                                )
                                            }
                                            Row {
                                                IconButton(
                                                    onClick = { openAlertDialog.value = true },
                                                    modifier = Modifier
                                                        .size(40.dp)
                                                        .padding(end = 4.dp),
                                                ) {
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.sampah),
                                                        contentDescription = "Trash",
                                                        modifier = Modifier
                                                            .size(28.dp)
                                                            .padding(start = 6.dp),
                                                        tint = Color(0xFFEC221F)
                                                    )
                                                }
                                                IconButton(
                                                    onClick = {
                                                        //                                                    navController.navigate(Routes.EditKolamScreen)
                                                    }, modifier = Modifier.size(40.dp)
                                                ) {
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.edit),
                                                        contentDescription = "Edit",
                                                        modifier = Modifier
                                                            .size(28.dp)
                                                            .padding(start = 6.dp),
                                                        tint = Color(0XFF2C793E)
                                                    )
                                                }
                                            }
                                        }

                                    }

                                    if (openAlertDialog.value) {
                                        AlertDialog(
                                            containerColor = Color.White,
                                            onDismissRequest = {
                                                openAlertDialog.value = false
                                            },
                                            title = {
                                                Column(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Text(
                                                        text = "Notifikasi",
                                                        textAlign = TextAlign.Center
                                                    )
                                                }
                                            },
                                            text = {
                                                Text(
                                                    text = "Anda yakin ingin mengahpus data ini?",
                                                    modifier = Modifier.fillMaxWidth(),
                                                    textAlign = TextAlign.Center
                                                )
                                            },
                                            confirmButton = {
                                                Row(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.SpaceEvenly
                                                ) {
                                                    TextButton(
                                                        onClick = {
                                                            openAlertDialog.value = false
                                                        },
                                                        modifier = Modifier.background(
                                                            Color.Red,
                                                            shape = RoundedCornerShape(8.dp)
                                                        )
                                                    ) {
                                                        Text(
                                                            "Hapus",
                                                            color = Color.White
                                                        )
                                                    }
                                                    TextButton(
                                                        onClick = {
                                                            openAlertDialog.value = false
                                                        },
                                                        modifier = Modifier.background(
                                                            Color.Black,
                                                            shape = RoundedCornerShape(8.dp)
                                                        )
                                                    ) {
                                                        Text(
                                                            "Batal",
                                                            color = Color.White
                                                        )
                                                    }
                                                }
                                            })
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.padding(vertical = 8.dp))
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(130.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                shape = MaterialTheme.shapes.large
                            ) {
                                Box(
                                    modifier = Modifier.padding(17.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.fillMaxHeight(),
                                        verticalArrangement = Arrangement.SpaceBetween
                                    ) {

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text(
                                                text = buildAnnotatedString {
                                                    append("Kematian Ikan ")
                                                    withStyle(style = SpanStyle(fontWeight = FontWeight.ExtraBold)) {
                                                        append("x20")
                                                    }
                                                },
                                                fontSize = 18.sp
                                            )
                                            Text(
                                                text = "11:58:16",
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.ExtraBold
                                            )
                                        }

                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.Bottom
                                        ) {
                                            Column {
                                                Text(
                                                    text = buildAnnotatedString {
                                                        append("Kolam :")
                                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                            append(" A-A1")
                                                        }
                                                    },
                                                    fontSize = 13.sp,
                                                    color = Color.Black
                                                )
                                                Spacer(modifier = Modifier.padding(vertical = 1.dp))
                                                Text(
                                                    text = buildAnnotatedString {
                                                        append("Jenis Ikan")
                                                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                            append(" Nila Merah")
                                                        }
                                                    },
                                                    fontSize = 13.sp,
                                                    color = Color.Black
                                                )
                                            }
                                            Row {
                                                IconButton(
                                                    onClick = { openAlertDialog.value = true },
                                                    modifier = Modifier
                                                        .size(40.dp)
                                                        .padding(end = 4.dp),
                                                ) {
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.sampah),
                                                        contentDescription = "Trash",
                                                        modifier = Modifier
                                                            .size(28.dp)
                                                            .padding(start = 6.dp),
                                                        tint = Color(0xFFEC221F)
                                                    )
                                                }
                                                IconButton(
                                                    onClick = {
                                                        //                                                    navController.navigate(Routes.EditKolamScreen)
                                                    }, modifier = Modifier.size(40.dp)
                                                ) {
                                                    Icon(
                                                        painter = painterResource(id = R.drawable.edit),
                                                        contentDescription = "Edit",
                                                        modifier = Modifier
                                                            .size(28.dp)
                                                            .padding(start = 6.dp),
                                                        tint = Color(0XFF2C793E)
                                                    )
                                                }
                                            }
                                        }

                                    }

                                    if (openAlertDialog.value) {
                                        AlertDialog(
                                            containerColor = Color.White,
                                            onDismissRequest = {
                                                openAlertDialog.value = false
                                            },
                                            title = {
                                                Column(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Text(
                                                        text = "Notifikasi",
                                                        textAlign = TextAlign.Center
                                                    )
                                                }
                                            },
                                            text = {
                                                Text(
                                                    text = "Anda yakin ingin mengahpus data ini?",
                                                    modifier = Modifier.fillMaxWidth(),
                                                    textAlign = TextAlign.Center
                                                )
                                            },
                                            confirmButton = {
                                                Row(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.SpaceEvenly
                                                ) {
                                                    TextButton(
                                                        onClick = {
                                                            openAlertDialog.value = false
                                                        },
                                                        modifier = Modifier.background(
                                                            Color.Red,
                                                            shape = RoundedCornerShape(8.dp)
                                                        )
                                                    ) {
                                                        Text(
                                                            "Hapus",
                                                            color = Color.White
                                                        )
                                                    }
                                                    TextButton(
                                                        onClick = {
                                                            openAlertDialog.value = false
                                                        },
                                                        modifier = Modifier.background(
                                                            Color.Black,
                                                            shape = RoundedCornerShape(8.dp)
                                                        )
                                                    ) {
                                                        Text(
                                                            "Batal",
                                                            color = Color.White
                                                        )
                                                    }
                                                }
                                            })
                                    }
                                }
                            }
                        }



                        Spacer(modifier = Modifier.padding(vertical = 48.dp))
                    }
                }
            }
        }
    }
}