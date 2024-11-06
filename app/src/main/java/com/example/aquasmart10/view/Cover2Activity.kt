package com.example.aquasmart10.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aquasmart10.R
import com.example.aquasmart10.Routes
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

@Composable
fun CoverScreen(navController: NavController) {
    // Custom font family
    val customFontFamily = FontFamily(
        Font(R.font.bold, FontWeight.Bold),
        Font(R.font.regular, FontWeight.Normal)
    )

    // Pager state for image slider
    val pagerState = rememberPagerState(pageCount = { 3 })

    // Auto-sliding effect
    LaunchedEffect(Unit) {
        while (true) {
            yield()
            delay(3000)
            val nextPage = (pagerState.currentPage + 1) % 3
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF5E7BF9))
            .clip(
                RoundedCornerShape(
                    bottomStart = 25.dp,
                    bottomEnd = 25.dp
                )
            ),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image Slider dengan rounded bottom corners
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()  // Mengisi lebar penuh
                .aspectRatio(1f)
                .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))  // Rounded pada bottom saja
                .background(Color.White)
                .shadow(
                    4.dp,
                    RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp)
                )
        ) { page ->
            Image(
                painter = painterResource(
                    id = when (page) {
                        0 -> R.drawable.img_11
                        1 -> R.drawable.img_12
                        2 -> R.drawable.img_13
                        else -> R.drawable.img_11
                    }
                ),
                contentDescription = "Slide Image ${page + 1}",
                modifier = Modifier
                    .fillMaxSize()  // Mengisi seluruh ruang
                    .clip(RoundedCornerShape(bottomStart = 50.dp, bottomEnd = 50.dp))  // Menambahkan clip agar gambar ikut rounded
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        // Welcome Text
        Text(
            text = "Selamat datang\ndi AquaSmart!",
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Color.White,
            fontFamily = customFontFamily,
            fontWeight = FontWeight.Bold,
            style = TextStyle(lineHeight = 50.sp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Description Text
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Color.White,
            fontFamily = customFontFamily,
            fontWeight = FontWeight.Normal
        )

        // Login Button with effect
        val interactionSource = remember { MutableInteractionSource() }
        val isPressed by interactionSource.collectIsPressedAsState()

        Button(
            onClick = { navController.navigate(Routes.LoginScreen) },
            modifier = Modifier
                .padding(top = 24.dp, start = 30.dp, end = 30.dp)
                .fillMaxWidth()
                .shadow(6.dp, CircleShape),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isPressed) Color(0xFFE6E6E6) else Color.White
            ),
            interactionSource = interactionSource
        ) {
            Text(
                text = "Masuk",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF5E7BF9),
                modifier = Modifier.padding(vertical = 9.dp)
            )
        }
    }
}

