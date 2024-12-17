package com.aquanusa.aquasmart.view.kelola.pakan

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aquanusa.aquasmart.model.ikan.ModelIkan
import com.aquanusa.aquasmart.viewmodel.autentikasi.PoolViewModel
import com.aquanusa.aquasmart.viewmodel.ikan.ViewModelIkan
import com.aquanusa.aquasmart.viewmodel.pakan.ViewModelPakan

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PenghitungDosisPakan(
    vmkolam: PoolViewModel = viewModel(),
    vmpakan: ViewModelPakan = viewModel(),
    vmikan: ViewModelIkan = viewModel()
) {

    LaunchedEffect(Unit) {
        vmkolam.getPools()
        vmpakan.getPakan()
    }

    val context = LocalContext.current

    val openAlertDialog = remember { mutableStateOf<Boolean>(false) }

    //Dropdown Pilih Kolam
    val listKolamHitungDosis = vmkolam.poolList
    var selectedTextHitungDosis by remember { mutableStateOf("") }
    val id_kolamSelect = remember { mutableStateOf("") }
    var isExpandedHitungDosis by remember { mutableStateOf(false) }

    //Dropdown Pilih Jenis
    val listJenisHitungDosis = vmpakan._listPakan
    var selectedTextJenisHitungDosis by remember { mutableStateOf("") }
    val pakanSelect = remember { mutableStateOf("") }
    var isExpandedJenisHitungDosis by remember { mutableStateOf(false) }

    //Dropdown Biomasa
    val listBiomasa = listOf("1%", "3%", "6%")
    var selectedTextBiomasa by remember { mutableStateOf("") }
    var isExpandedBiomasa by remember { mutableStateOf(false) }

    val dosisAkhir = remember { mutableStateOf(0f) }
    val toastMessage = remember { mutableStateOf<String?>(null) }

    vmikan.getStokById(id_kolamSelect.value)
    fun getDataKolam(): ModelIkan? {
        val dataKolam = vmikan.ikanbyId.firstOrNull()
        return dataKolam
    }

    fun kalkulatorDosis(): Float {
        val ikanPilihan = vmikan.ikanbyId.firstOrNull()
        val biomasaSelect = when (selectedTextBiomasa) {
            "1%" -> 1f
            "3%" -> 3f
            "6%" -> 6f
            else -> 3f
        }

        Log.d("debugging dosis", ikanPilihan.toString())

        val beratPerIkan = ikanPilihan?.berat?.div(10)
        val jumlahIkan =
            (ikanPilihan?.jumlah_nila_hitam ?: 0) + (ikanPilihan?.jumlah_nila_merah ?: 0)
        val hasilKali = beratPerIkan?.times(jumlahIkan)
        val biomasa = biomasaSelect / 100f
        return hasilKali?.times(biomasa) ?: 0f
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.End
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
                        Column {
                            Text(
                                "Hitung Dosis Pakan",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                            Spacer(modifier = Modifier.padding(vertical = 8.dp))
                            Column {
                                Card(
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(
                                            0xFFFFFFFF
                                        )
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                ) {
                                    ExposedDropdownMenuBox(modifier = Modifier
                                        .fillMaxWidth(),
                                        expanded = isExpandedHitungDosis,
                                        onExpandedChange = {
                                            isExpandedHitungDosis = !isExpandedHitungDosis
                                        }) {
                                        TextField(modifier = Modifier
                                            .menuAnchor()
                                            .fillMaxWidth(),
                                            value = selectedTextHitungDosis,
                                            onValueChange = {},
                                            label = { Text("-- Pilih Kolam --") },
                                            readOnly = true,
                                            colors = TextFieldDefaults.colors(
                                                unfocusedContainerColor = Color.White,
                                                focusedContainerColor = Color.White,
                                                unfocusedIndicatorColor = Color.White,
                                                focusedIndicatorColor = Color.White,
                                                unfocusedTextColor = Color.Black,
                                                focusedTextColor = Color.Black
                                            ),
                                            textStyle = TextStyle(fontSize = 16.sp),
                                            shape = RoundedCornerShape(15.dp),
                                            trailingIcon = {
                                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedHitungDosis)
                                            }
                                        )
                                        ExposedDropdownMenu(
                                            expanded = isExpandedHitungDosis,
                                            onDismissRequest = { isExpandedHitungDosis = false },
                                            modifier = Modifier.background(Color.White)
                                        ) {
                                            listKolamHitungDosis.forEach { listKolam ->
                                                DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
                                                    text = {
                                                        Text(
                                                            text = "Kolam ${listKolam.nama_awalan_kolam}-${listKolam.nama_kolam}",
                                                            fontSize = 16.sp
                                                        )
                                                    },
                                                    onClick = {
                                                        id_kolamSelect.value =
                                                            listKolam.id_kolam.toString()
                                                        Log.d("id kolam", id_kolamSelect.value)
                                                        selectedTextHitungDosis =
                                                            "Kolam ${listKolam.nama_awalan_kolam}-${listKolam.nama_kolam}"
                                                        isExpandedHitungDosis = false
                                                        openAlertDialog.value = true
                                                    }
                                                )
                                            }
                                        }
                                    }
                                }

                                if (openAlertDialog.value) {
                                    val hasilGetData = getDataKolam()

                                    hasilGetData?.let { dataKolam ->
                                        val nama_kolam by remember(
                                            listKolamHitungDosis,
                                            dataKolam.id_kolam
                                        ) {
                                            derivedStateOf {
                                                listKolamHitungDosis.filter { it.id_kolam == dataKolam.id_kolam }
                                                    .minOfOrNull { it.nama_kolam }
                                            }
                                        }
                                        val awalan_nama_kolam by remember(
                                            listKolamHitungDosis,
                                            dataKolam.id_kolam
                                        ) {
                                            derivedStateOf {
                                                listKolamHitungDosis.filter { it.id_kolam == dataKolam.id_kolam }
                                                    .minOfOrNull { it.nama_awalan_kolam }
                                            }
                                        }
                                        val status by remember(
                                            listKolamHitungDosis,
                                            dataKolam.id_kolam
                                        ) {
                                            derivedStateOf {
                                                listKolamHitungDosis.filter { it.id_kolam == dataKolam.id_kolam }
                                                    .minOfOrNull { it.status }
                                            }
                                        }
                                        val kapasitas by remember(
                                            listKolamHitungDosis,
                                            dataKolam.id_kolam
                                        ) {
                                            derivedStateOf {
                                                listKolamHitungDosis.filter { it.id_kolam == dataKolam.id_kolam }
                                                    .minOfOrNull { it.kapasitas }
                                            }
                                        }
                                        val diameter by remember(
                                            listKolamHitungDosis,
                                            dataKolam.id_kolam
                                        ) {
                                            derivedStateOf {
                                                listKolamHitungDosis.filter { it.id_kolam == dataKolam.id_kolam }
                                                    .minOfOrNull { it.diameter }
                                            }
                                        }
                                        val kedalaman by remember(
                                            listKolamHitungDosis,
                                            dataKolam.id_kolam
                                        ) {
                                            derivedStateOf {
                                                listKolamHitungDosis.filter { it.id_kolam == dataKolam.id_kolam }
                                                    .minOfOrNull { it.kedalaman }
                                            }
                                        }
                                        val phAir by remember(
                                            listKolamHitungDosis,
                                            dataKolam.id_kolam
                                        ) {
                                            derivedStateOf {
                                                listKolamHitungDosis.filter { it.id_kolam == dataKolam.id_kolam }
                                                    .minOfOrNull { it.ph_air }
                                            }
                                        }

                                        val kolamTerisi =
                                            dataKolam.jumlah_nila_merah + dataKolam.jumlah_nila_hitam


                                        AlertDialog(
                                            containerColor = Color.White,
                                            onDismissRequest = { openAlertDialog.value = false },
                                            title = {
                                                Row(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.Center
                                                ) {
                                                    Text(
                                                        text = "Kolam $awalan_nama_kolam-$nama_kolam",
                                                        fontWeight = FontWeight.Bold,
                                                    )
                                                }
                                            },
                                            text = {
                                                Column {
                                                    Text(
                                                        text = buildAnnotatedString {
                                                            append("Status :")
                                                            if (status == "aktif") {
                                                                withStyle(
                                                                    style = SpanStyle(
                                                                        fontWeight = FontWeight.Bold,
                                                                        color = Color.Green
                                                                    )
                                                                ) {
                                                                    append(" $status")
                                                                }
                                                            } else {
                                                                withStyle(
                                                                    style = SpanStyle(
                                                                        fontWeight = FontWeight.Bold,
                                                                        color = Color.Red
                                                                    )
                                                                ) {
                                                                    append(" $status")
                                                                }
                                                            }
                                                        },
                                                    )
                                                    Text(
                                                        text = buildAnnotatedString {
                                                            append("Kapasitas :")
                                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                                append(" $kapasitas ikan")
                                                            }
                                                        },
                                                    )
                                                    Text(
                                                        text = buildAnnotatedString {
                                                            append("Terisi :")
                                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                                append(" $kolamTerisi ikan")
                                                            }
                                                        },
                                                    )
                                                    Text(
                                                        text = buildAnnotatedString {
                                                            append("Diameter :")
                                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                                append(" $diameter meter")
                                                            }
                                                        },
                                                    )
                                                    Text(
                                                        text = buildAnnotatedString {
                                                            append("Kedalaman :")
                                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                                append(" $kedalaman meter")
                                                            }
                                                        },
                                                    )
                                                    Text(
                                                        text = buildAnnotatedString {
                                                            append("pH air :")
                                                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                                                append(" $phAir")
                                                            }
                                                        },
                                                    )
                                                }
                                            },
                                            confirmButton = {
                                                Row(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalArrangement = Arrangement.Center
                                                ) {
                                                    TextButton(
                                                        onClick = {
                                                            openAlertDialog.value = false
                                                        },
                                                        modifier = Modifier
                                                            .background(
                                                                Color.Black,
                                                                shape = RoundedCornerShape(8.dp)
                                                            )
                                                    ) {
                                                        Text(
                                                            "Konfirmasi",
                                                            color = Color.White,
                                                        )
                                                    }
                                                }
                                            }
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                                Card(
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(
                                            0xFFFFFFFF
                                        )
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                ) {
                                    ExposedDropdownMenuBox(modifier = Modifier
                                        .fillMaxWidth(),
                                        expanded = isExpandedJenisHitungDosis,
                                        onExpandedChange = {
                                            isExpandedJenisHitungDosis = !isExpandedJenisHitungDosis
                                        }) {
                                        TextField(modifier = Modifier
                                            .menuAnchor()
                                            .fillMaxWidth(),
                                            value = selectedTextJenisHitungDosis,
                                            onValueChange = {},
                                            label = { Text("-- Pilih Pakan --") },
                                            readOnly = true,
                                            colors = TextFieldDefaults.colors(
                                                unfocusedContainerColor = Color.White,
                                                focusedContainerColor = Color.White,
                                                unfocusedIndicatorColor = Color.White,
                                                focusedIndicatorColor = Color.White,
                                                unfocusedTextColor = Color.Black,
                                                focusedTextColor = Color.Black
                                            ),
                                            textStyle = TextStyle(fontSize = 16.sp),
                                            shape = RoundedCornerShape(15.dp),
                                            trailingIcon = {
                                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedJenisHitungDosis)
                                            })
                                        ExposedDropdownMenu(
                                            expanded = isExpandedJenisHitungDosis,
                                            onDismissRequest = {
                                                isExpandedJenisHitungDosis = false
                                            },
                                            modifier = Modifier.background(Color.White)
                                        ) {
                                            listJenisHitungDosis.forEach { listPakan ->
                                                DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
                                                    text = {
                                                        Text(
                                                            text = listPakan.nama_pakan
                                                        )
                                                    },
                                                    onClick = {
                                                        pakanSelect.value =
                                                            listPakan.id_pakan.toString()
                                                        selectedTextJenisHitungDosis =
                                                            listPakan.nama_pakan
                                                        isExpandedJenisHitungDosis = false
                                                    }
                                                )
                                            }
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                                Card(
                                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(
                                            0xFFFFFFFF
                                        )
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                ) {
                                    ExposedDropdownMenuBox(modifier = Modifier
                                        .fillMaxWidth(),
                                        expanded = isExpandedBiomasa,
                                        onExpandedChange = {
                                            isExpandedBiomasa = !isExpandedBiomasa
                                        }) {
                                        TextField(modifier = Modifier
                                            .menuAnchor()
                                            .fillMaxWidth(),
                                            value = selectedTextBiomasa,
                                            label = { Text("-- Pilih Biomasa --") },
                                            onValueChange = {},
                                            readOnly = true,
                                            colors = TextFieldDefaults.colors(
                                                unfocusedContainerColor = Color.White,
                                                focusedContainerColor = Color.White,
                                                unfocusedIndicatorColor = Color.White,
                                                focusedIndicatorColor = Color.White,
                                                unfocusedTextColor = Color.Black,
                                                focusedTextColor = Color.Black
                                            ),
                                            textStyle = TextStyle(fontSize = 16.sp),
                                            shape = RoundedCornerShape(15.dp),
                                            trailingIcon = {
                                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedBiomasa)
                                            })
                                        ExposedDropdownMenu(
                                            expanded = isExpandedBiomasa,
                                            onDismissRequest = { isExpandedBiomasa = false },
                                            modifier = Modifier.background(Color.White)
                                        ) {
                                            listBiomasa.forEachIndexed { index, text ->
                                                DropdownMenuItem(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    text = {
                                                        Text(
                                                            text = text,
                                                            fontSize = 16.sp
                                                        )
                                                    },
                                                    onClick = {
                                                        selectedTextBiomasa = listBiomasa[index]
                                                        isExpandedBiomasa = false
                                                    },
                                                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 20.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Button(
                                    onClick = {
                                        if (!id_kolamSelect.value.isNullOrEmpty() &&
                                            !pakanSelect.value.isNullOrEmpty() &&
                                            !selectedTextBiomasa.isNullOrEmpty()
                                        ) {
                                            val hasilKalkulasi = kalkulatorDosis()
                                            dosisAkhir.value =
                                                "%.3f".format(hasilKalkulasi).toFloat()
                                            toastMessage.value = "Dosis Berhasil Dihitung"
                                        } else {
                                            toastMessage.value =
                                                "Lengkapi pilihan yang kosong terlebih dahulu!"
                                        }
                                    },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(
                                            0xFF5E7BF9
                                        )
                                    )
                                ) {
                                    Text(
                                        "Hitung",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.SemiBold
                                    )
                                }

                                toastMessage.value?.let { message ->
                                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                                }

                            }
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 60.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Jumlah Pakan Adalah",
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 25.sp,
                                    modifier = Modifier.padding(bottom = 15.dp)
                                )
                                if (dosisAkhir.value > 0f) {
                                    Text(
                                        "${dosisAkhir.value} Kg",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 30.sp,
                                        modifier = Modifier.padding(bottom = 8.dp)
                                    )
                                    Text(
                                        selectedTextJenisHitungDosis,
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 28.sp
                                    )
                                } else {
                                    Text(
                                        text = "0.0 Kg",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 30.sp
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
//
//@Preview
//@Composable
//fun scejreklr() {
//    PenghitungDosisPakan()
//}