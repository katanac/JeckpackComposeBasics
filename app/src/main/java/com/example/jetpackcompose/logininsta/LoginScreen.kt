package com.example.jetpackcompose.logininsta

import android.app.Activity
import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R

@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
    ) {
        Hearder(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
        Footer(Modifier.align(Alignment.BottomCenter))
    }

}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.size(20.dp))

        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = "Don´t have account?", fontSize = 12.sp,
                color = Color(0xFFB5B5B5)
            )
            Text(
                text = "Sing Up.",
                Modifier.padding(horizontal = 8.dp),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF4EA8E9)
            )
        }
        Spacer(modifier = Modifier.size(20.dp))
    }
}


@Composable
fun Hearder(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close app",
        modifier = modifier.clickable { activity.finish() })
}


@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var loginEnable by rememberSaveable { mutableStateOf(false) }

    Column(modifier = modifier.padding(10.dp)) {
        ImageHeader(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        TextFildEmail(email) { email = it }
        Spacer(modifier = Modifier.size(8.dp))
        TexFieldPassword(password) { password = it }
        Spacer(modifier = Modifier.size(8.dp))
        TextForgotten(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        ButtonLogin(validEmailAndPassword(email,password))
        Spacer(modifier = Modifier.size(16.dp))
        LoginOr()
        Spacer(modifier = Modifier.size(32.dp))
        SocialLogin()
    }
}


@Composable
fun TextForgotten(modifier: Modifier) {
    Text(
        text = "forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}

@Composable
fun ImageHeader(modifier: Modifier) {
    Image(
        painterResource(id = R.drawable.insta),
        contentDescription = "Logo ing",
        modifier = modifier
    )
}


@Composable
fun TextFildEmail(email: String, onChangeValue: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onChangeValue(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "email") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent

        )
    )
}

@Composable
fun TexFieldPassword(text: String, onChangeValue: (String) -> Unit) {
    var paswordVisibility by rememberSaveable { mutableStateOf(false) }
    TextField(
        value = text,
        onValueChange = { onChangeValue(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "Password") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent

        ),
        trailingIcon = {
            IconButton(onClick = { paswordVisibility = !paswordVisibility }) {
                Icon(
                    imageVector = if (paswordVisibility) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = "show password"
                )
            }
        },
        visualTransformation = if (paswordVisibility) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun ButtonLogin(loginEnable: Boolean) {
    Button(
        onClick = {}, enabled = loginEnable, modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF4EA8E9), disabledBackgroundColor = Color(
                0xFF82C4F3
            )
        ),
    ) {
        Text(
            text = "Log In",
            color = Color.White,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )

    }
}


@Composable
fun LoginOr() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5),
            modifier = Modifier
                .padding(16.dp)
        )
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}


@Composable
fun SocialLogin() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(id = R.drawable.fb),
            contentDescription = "Logo ing fb",
            Modifier.size(16.dp)
        )

        Text(
            text = "Continue as Katanac",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color(0xFF4EA8E9)
        )
    }
}


fun validEmailAndPassword(email: String, password: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 6
}