package com.example.jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class Dialogs : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var show by remember { mutableStateOf(false) }

                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Button(onClick = { show = true }) {
                            Text(text = "Mostar dialogo")
                        }


                        DialogGeneric(
                            show = show,
                            onDismiss = { show = false },
                            onConfirm = { Log.i("CONFIRMO", "CONFIRMO!!!!!!!") })
                    }
                }
            }
        }
    }
}

@Composable
fun DialogGeneric(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {

    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Titulo dialogo") },
            text = { Text(text = "des del dialog :)") },
            confirmButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Cancelar")
                }
            },
            dismissButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Ok")
                }
            })
    }
}


@Composable
fun DialogAvanceTitleGeneric(title: String) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, start = 10.dp)
    )
}


@Composable
fun ItemGeneric(contac: String, @DrawableRes imag: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = imag), contentDescription = "Imagen de contacto",
            modifier = Modifier
                .padding(10.dp)
                .size(50.dp)
                .clip(CircleShape)
        )
        Text(text = contac, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(5.dp))

    }
}

@Composable
fun DialogAvanceGeneric(show: Boolean, onDismiss: () -> Unit) {

    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .padding(4.dp)
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                DialogAvanceTitleGeneric(title = "Contacts")
                ItemGeneric("contacto 1", R.drawable.avatar)
                ItemGeneric("contacto 2", R.drawable.avatar)
                ItemGeneric("agregar contacto", R.drawable.add)

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    JetpackComposeTheme {

        var show by remember { mutableStateOf(false) }
        var showDialogA by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                Button(onClick = { show = true }) {
                    Text(text = "Mostar dialogo generico")
                }
            }

            Box {
                Button(onClick = { showDialogA = true }) {
                    Text(text = "Mostar dialogo avance")
                }
            }
        }



        DialogGeneric(
            show = show,
            onDismiss = { show = false },
            onConfirm = { Log.i("CONFIRMO", "CONFIRMO!!!!!!!") })

        DialogAvanceGeneric(
            show = showDialogA,
            onDismiss = { show = false })

    }
}