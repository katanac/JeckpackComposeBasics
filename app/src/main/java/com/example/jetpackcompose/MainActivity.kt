package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyScreen()
                }
            }
        }
    }
}

@Composable
fun MyScreen() {
    Column(Modifier.fillMaxSize()) {
        Box(modifier = Modifier.background(Color.Blue).weight(1f).fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Texto1")
        }
        Row(
            Modifier
                .fillMaxSize()
                .background(Color.Red).weight(1f)
        ) {
            Box(
                modifier = Modifier.background(Color.DarkGray).fillMaxSize().weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Texto2")
            }

            Box(
                modifier = Modifier.background(Color.Cyan).fillMaxSize().weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Texto3")
            }

        }

        Box(
            modifier = Modifier.background(Color.Yellow).weight(1f).fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Texto4")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        MyScreen()
    }
}