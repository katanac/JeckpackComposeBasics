package com.example.jetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jetpackcompose.Router.*

@Composable
fun ScreenOne(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(Modifier.align(Alignment.Center), verticalArrangement = Arrangement.Center) {
            Text(text = "Pantalla #1", color = Color.White, modifier = Modifier.padding(10.dp))
            Button(onClick = { navigationController.navigate(Screen2.routerNav) }) {
                Text(text = "Nav Pantalla #2")
            }

            Button(onClick = { navigationController.navigate(Screen3.routerNav) }) {
                Text(text = "Nav Pantalla #3")
            }
        }

    }
}


@Composable
fun ScreenTwo(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Column(Modifier.align(Alignment.Center), verticalArrangement = Arrangement.Center) {
            Text(text = "Pantalla #2", modifier = Modifier.padding(10.dp))
            Button(onClick = { navigationController.navigate(Screen1.routerNav) }) {
                Text(text = "Nav Pantalla #1")
            }

            Button(onClick = { navigationController.navigate(Screen3.routerNav) }) {
                Text(text = "Nav Pantalla #3")
            }
        }
    }
}


@Composable
fun ScreenThree(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Column(Modifier.align(Alignment.Center), verticalArrangement = Arrangement.Center) {
            Text(text = "Pantalla #3", modifier = Modifier.padding(10.dp))
            Button(onClick = { navigationController.navigate(Screen1.routerNav) }) {
                Text(text = "Nav Pantalla #1")
            }

            Button(onClick = { navigationController.navigate(Screen2.routerNav) }) {
                Text(text = "Nav Pantalla #2")
            }


            Button(onClick = { navigationController.navigate(Screen4.createRoute("TatDev 1")) }) {
                Text(text = "Nav Pantalla #4")
            }
        }
    }
}


@Composable
fun ScreenFourRequireParameter(navigationController: NavHostController, name: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Column(Modifier.align(Alignment.Center), verticalArrangement = Arrangement.Center) {
            Text(text = name, modifier = Modifier.padding(10.dp))

            Button(onClick = { navigationController.navigate(Screen3.routerNav) }) {
                Text(text = "Nav Pantalla #3")
            }

            Button(onClick = { navigationController.navigate(Screen5.createRoute("TatDev 2")) }) {
                Text(text = "Nav Pantalla #5")
            }
        }
    }
}


@Composable
fun ScreenFiveOptionalParameter(navigationController: NavHostController, name: String?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Column(Modifier.align(Alignment.Center), verticalArrangement = Arrangement.Center) {
            Text(text = name!!, modifier = Modifier.padding(10.dp))

            Button(onClick = { navigationController.navigate(Screen3.routerNav) }) {
                Text(text = "Nav Pantalla #3")
            }
        }
    }
}
