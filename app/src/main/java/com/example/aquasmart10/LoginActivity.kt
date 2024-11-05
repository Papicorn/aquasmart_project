package com.example.aquasmart10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.clickable
import androidx.compose.material3.Checkbox
import androidx.compose.ui.tooling.preview.Preview
import com.example.aquasmart10.ui.theme.AquaSmart10Theme


class LoginPageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AquaSmart10Theme() {
                Surface (
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color(0xFFEFF6FC)
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val rememberMe = remember { mutableStateOf(false) }
    val image = painterResource(R.drawable.img_background)


    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 250.dp, start = 36.dp, end = 36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Masuk ke Akun Anda",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = username.value,
            onValueChange = { username.value = it },
            label = { Text("Username") },

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = CircleShape,
                    ambientColor = Color.Gray,
                    spotColor = Color.Black
                )
                .clip(CircleShape),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )

        TextField(
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
                .background(color = Color.White)
                .shadow(6.dp, CircleShape)
                .clip(CircleShape),
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = rememberMe.value,
                    onCheckedChange = { rememberMe.value = it }
                )
                Text(text = "Ingat Saya", modifier = Modifier.padding(start = 8.dp))
            }

            Text(
                text = "Lupa Kata Sandi?",
                color = Color.Blue,
                modifier = Modifier
                    .clickable { }
                    .padding(top = 13.dp)
            )
        }

        Button(
            onClick = { /* Handle login */ },
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth()
                .border(4.dp, color = Color(0xFF5E7BF9), CircleShape)
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

@Preview
@Composable
fun PreviewLoginScreen() {
    AquaSmart10Theme() {
        Surface (
            modifier = Modifier
                .fillMaxSize(),
            color = Color(0xFFEFF6FC)
        ) {
            LoginScreen()
        }
    }
}

