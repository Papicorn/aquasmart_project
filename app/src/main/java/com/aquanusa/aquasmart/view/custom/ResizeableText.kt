package com.aquanusa.aquasmart.view.custom

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun ResizableText(
    text: String,
    modifier: Modifier = Modifier,
    maxFontSize: Float = 24f, // Ukuran maksimum font
    minFontSize: Float = 12f  // Ukuran minimum font
) {
    BoxWithConstraints(modifier = modifier) {
        // Gunakan scope BoxWithConstraints
        val maxWidthDp = maxWidth // Mendapatkan lebar dalam DP dari BoxWithConstraints
        val maxWidthPx = with(LocalDensity.current) { maxWidthDp.toPx() } // Konversi ke pixel

        val calculatedFontSize = remember(text, maxWidthPx) {
            // Hitung ukuran font berdasarkan panjang teks dan lebar kontainer
            val textLength = text.length
            val fontSize = maxWidthPx / (textLength * 8f) // Sesuaikan formula
            fontSize.coerceIn(minFontSize, maxFontSize) // Batasi ukuran font
        }

        Text(
            text = text,
            fontSize = calculatedFontSize.sp, // Terapkan ukuran font dinamis
            maxLines = 1, // Pastikan hanya satu baris
            overflow = TextOverflow.Ellipsis, // Tambahkan ellipsis jika teks terlalu panjang
            modifier = Modifier.fillMaxWidth()
        )
    }
}


