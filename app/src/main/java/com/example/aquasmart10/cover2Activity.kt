package com.example.aquasmart10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.aquasmart10.ui.theme.AquaSmart10Theme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aquasmart10.component.customFontFamily
import com.google.accompanist.pager.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

class cover2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AquaSmart10Theme {
                // A surface container using the 'background' color from the theme

                SetBarColor(color = MaterialTheme.colorScheme.background)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    cover2Screen()
                }
            }
        }
    }
    @Composable
    private fun SetBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = color
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun cover2Screen(modifier: Modifier = Modifier) {
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )

    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    // Untuk membuat slide bergeser otomatis
    LaunchedEffect(pagerState) {
        while (true) {
            yield()
            delay(3000) // Interval waktu perpindahan slide
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % 3 // Jumlah halaman gambar
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF5E7BF9)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPager(
            count = 3, // Jumlah gambar
            state = pagerState,
            modifier = Modifier
                .background(Color(0xFF5E7BF9))
                .aspectRatio(1 / 1f)
                .shadow(4.dp, RoundedCornerShape(
                    bottomStart = 50.dp,
                    bottomEnd = 50.dp
                ))
        ) { page ->
            Image(
                painter = painterResource(id = getImageForPage(page)), // Fungsi untuk mengambil gambar
                contentDescription = "Gambar Slide $page",
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1 / 1f),
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        // Teks Deskripsi
        Text(
            text = "Selamat datang\ndi AquaSmart!",
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 16.dp),
            color = Color.White,
            fontFamily = customFontFamily,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                lineHeight = 50.sp
            )
        )


        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua\n",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Color.White,
            fontFamily = customFontFamily,
            fontWeight = FontWeight.Normal
        )

        // Tombol Mulai
        Button(
            onClick = { /* Handle login */ },
            modifier = Modifier
                .padding(top = 24.dp, start = 30.dp, end = 30.dp)
                .fillMaxWidth()
                .shadow(6.dp,CircleShape),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White)
        ) {
            Text(
                text = "Masuk",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5E7BF9),
                modifier = Modifier
                    .padding(vertical = 9.dp)
            )
        }
    }
}

@Composable
fun getImageForPage(page: Int): Int {
    return when (page) {
        0 -> R.drawable.img_11 // Ganti dengan ID resource gambar
        1 -> R.drawable.img_12
        2 -> R.drawable.img_13
        else -> R.drawable.img_11
    }
}

@Preview
@Composable
private fun cover2ScreenPreview() {
    cover2Screen()
}
