package com.example.aquasmart10.view

import com.example.aquasmart10.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.NavController
import com.example.aquasmart10.Routes
import androidx.compose.ui.text.input.VisualTransformation



@Composable
fun LoginScreen(navController: NavController) {
    // State declarations
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val rememberMe = remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    var submittedValueUsername by remember { mutableStateOf("") }
    var textValueUsername by remember { mutableStateOf("") }
    var submittedValuePassword by remember { mutableStateOf("") }
    var textValuePassword by remember { mutableStateOf("") }

    // Resources
    val image = painterResource(R.drawable.img_background)

    val passwordVisible = remember { mutableStateOf(false) }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEFF6FC))
    ) {
        // Background and Logo Layer
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(300.dp)
                    .offset(y = 0.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
        }

        // Content Layer
        androidx.compose.foundation.lazy.LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 36.dp)
                .padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Top Spacing
            item { Spacer(modifier = Modifier.height(250.dp)) }

            // Title
            item {
                Text(
                    text = "Masuk ke Akun Anda",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Username TextField
            item {
                TextField(
                    value = username.value,
                    onValueChange = { username.value = it },
                    label = { Text("Username") },
                    modifier = Modifier
                        .fillMaxWidth()
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
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onDone = {
                        submittedValueUsername = textValueUsername
                        focusManager.clearFocus()
                    })
                )
            }

            // Password TextField
            item {
                TextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    label = { Text("Password") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .shadow(6.dp, CircleShape)
                        .clip(CircleShape),
                    visualTransformation = if (passwordVisible.value)
                        VisualTransformation.None
                    else
                        PasswordVisualTransformation(),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(onDone = {
                        submittedValuePassword = textValuePassword
                        focusManager.clearFocus()
                    }),
                    trailingIcon = {
                        IconButton(
                            onClick = { passwordVisible.value = !passwordVisible.value }
                        ) {
                            Icon(
                                imageVector = if (passwordVisible.value)
                                    Icons.Default.Visibility
                                else
                                    Icons.Default.VisibilityOff,
                                contentDescription = if (passwordVisible.value)
                                    "Hide password"
                                else
                                    "Show password"
                            )
                        }
                    }
                )
            }

            // Remember Me and Forgot Password Row
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Checkbox(
                            checked = rememberMe.value,
                            onCheckedChange = { rememberMe.value = it }
                        )
                        Text(
                            text = "Ingat Saya",
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                    Text(
                        text = "Lupa Kata Sandi?",
                        color = Color.Blue,
                        modifier = Modifier.clickable { }
                    )
                }
            }

            // Login Button
            item {
                val interactionSource = remember { MutableInteractionSource() }
                val isPressed by interactionSource.collectIsPressedAsState()

                Button(
                    onClick = { navController.navigate(Routes.BerandaActivity) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(4.dp, color = Color(0xFF5E7BF9), CircleShape)
                        .shadow(6.dp, CircleShape),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isPressed) Color(0xFFE6E6E6) else Color.White,
                        contentColor = Color(0xFF5E7BF9)
                    ),
                    interactionSource = interactionSource
                ) {
                    Text(
                        text = "Masuk",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 9.dp)
                    )
                }
            }

            // Bottom Spacing
            item { Spacer(modifier = Modifier.height(16.dp)) }
        }
    }
}