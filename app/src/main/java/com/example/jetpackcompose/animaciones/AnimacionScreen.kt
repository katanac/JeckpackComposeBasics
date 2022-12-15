package com.example.jetpackcompose.animaciones

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateSizeAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlin.random.Random.Default.nextInt

@Composable
fun Animaciones() {
    Column {
        //  ColoAnimationSimple()
        //  VariableSizeAnimation()
        //  VisibilityAnimation()
        CrossfadeAnimation()

    }
}


@Composable
fun ColoAnimationSimple() {

    Column {
        var firtColor by rememberSaveable { mutableStateOf(false) }
        val color = if (firtColor) Color.Blue else Color.Red
        var secondColor by rememberSaveable { mutableStateOf(false) }
        var showImage by rememberSaveable { mutableStateOf(true) }
        val color2 by animateColorAsState(
            targetValue = if (secondColor) Color.Blue else Color.Red,
            animationSpec = tween(durationMillis = 1000),
            finishedListener = { showImage = !showImage }
        )


        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    color
                )
                .clickable { firtColor = !firtColor }
        )

        Spacer(modifier = Modifier.size(10.dp))

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(color2)
                .clickable { secondColor = !secondColor }
        )

        Spacer(modifier = Modifier.size(10.dp))

        if (showImage) {
            Image(
                painterResource(id = R.drawable.avatar),
                contentDescription = "imagen",
                modifier = Modifier.size(100.dp)
            )
        }

        Spacer(modifier = Modifier.size(10.dp))
    }

}


@Composable
fun VariableSizeAnimation() {

    var changeSize by rememberSaveable { mutableStateOf(true) }
    val sizeVariable = if (changeSize) 50.dp else 100.dp
    var showImage by rememberSaveable { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .size(sizeVariable)
            .background(Color.Gray)
            .clickable { changeSize = !changeSize }
    )


    var changeSize2 by rememberSaveable { mutableStateOf(true) }
    val sizeVariable2 by animateDpAsState(targetValue = if (changeSize2) 50.dp else 100.dp,
        animationSpec = tween(durationMillis = 500),
        finishedListener = { showImage = !showImage })

    Spacer(modifier = Modifier.size(10.dp))

    Box(
        modifier = Modifier
            .size(sizeVariable2)
            .background(Color.Gray)
            .clickable { changeSize2 = !changeSize2 }
    )

    Spacer(modifier = Modifier.size(10.dp))

    if (showImage) {
        Image(
            painterResource(id = R.drawable.avatar),
            contentDescription = "imagen",
            modifier = Modifier.size(100.dp)
        )
    }
}


@Composable
fun VisibilityAnimation() {

    var showImage by rememberSaveable { mutableStateOf(true) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = { showImage = !showImage }) {
            Text(text = "Mostrar/Ocultar")
        }

        Spacer(modifier = Modifier.size(10.dp))

        AnimatedVisibility(
            showImage,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Image(
                painterResource(id = R.drawable.avatar),
                contentDescription = "imagen",
                modifier = Modifier.size(100.dp)
            )
        }
    }

}


@Composable
fun CrossfadeAnimation() {
    var componettype: ComponentType by rememberSaveable { mutableStateOf(ComponentType.Text) }

    Column(Modifier.fillMaxSize()) {
        Button(onClick = { componettype = myCommponenteTypeRamdon() }) {
            Text(text = "Cambiar Componente")
        }

        Crossfade(targetState = componettype) {
            when (it) {
                ComponentType.Text -> Text(text = "Soy un text")
                ComponentType.Image -> Icon(Icons.Default.Home, contentDescription = "")
                ComponentType.Box -> Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(
                            Color.Gray
                        )
                )
                ComponentType.Error -> Text(text = "Soy un Error")
            }
        }
    }


}

fun myCommponenteTypeRamdon(): ComponentType {
    return when (nextInt(from = 0, until = 3)) {
        0 -> ComponentType.Text
        1 -> ComponentType.Box
        2 -> ComponentType.Image
        else -> ComponentType.Error
    }
}


enum class ComponentType() {
    Image, Text, Box, Error
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    JetpackComposeTheme {
        Animaciones()
    }
}