package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class CompontsJeckpack : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {


                    var stateCheckInfo by rememberSaveable { mutableStateOf(true) }

                    val checkInfo = CheckInfo(
                        "TATIS CHECK",
                        Checked = stateCheckInfo,
                        onCheckedChange = { myState -> stateCheckInfo = myState })
                    Greeting("Android")

                    CheckGeneric(checkInfo)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JetpackComposeTheme {

        Column(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
        ) {

            var stateCheckInfo by rememberSaveable { mutableStateOf(true) }

            val checkInfo = CheckInfo(
                "TATIS CHECK",
                Checked = stateCheckInfo,
                onCheckedChange = { myState -> stateCheckInfo = myState })

            BadgeBoxDemo()
            Greeting("Android")
            DropDownGeneric()
            ButtonGeneric()
            ImageGeneric()
            ImageGenericAdvance()
            IconGeneric()
            ProgressBarGeneric()
            SwitchGeneric()
            CheckGeneric(checkInfo)
            MyRadioButtonGroup()
            SliderGeneric()
            SliderGenericAdvance()
        }

    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ButtonGeneric() {

    var stateTextButton by remember { mutableStateOf("Hola ") }

    var statEnableButton by rememberSaveable { mutableStateOf(true) }

    Button(
        onClick = { statEnableButton = !statEnableButton },
        enabled = statEnableButton,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black,
            contentColor = Color.White
        ), border = BorderStroke(1.dp, Color.Magenta)
    ) {
        Text(text = stateTextButton)
    }
}


@Composable
fun ImageGeneric() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "desc ejemppllo"

    )
}


@Composable
fun ImageGenericAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "desc ejemppllo",
        modifier = Modifier
            .clip(
                CircleShape
            )
            .border(3.dp, Color.Magenta, CircleShape)
    )
}

@Composable
fun IconGeneric() {
    Icon(imageVector = Icons.Rounded.Delete, contentDescription = "icono", tint = Color.Cyan)
}

@Composable
fun ProgressBarGeneric() {
    var showLoading by rememberSaveable() { mutableStateOf(false) }
    var progressState by rememberSaveable { mutableStateOf(0f) }

    Column(
        Modifier.padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(strokeWidth = 7.dp, progress = progressState)
            LinearProgressIndicator(
                Modifier.padding(7.dp),
                color = Color.Black,
                backgroundColor = Color.Magenta
            )
            LinearProgressIndicator(
                progress = progressState,
                Modifier.padding(7.dp),
                color = Color.Black,
                backgroundColor = Color.Magenta,
            )


            Row(Modifier.padding(10.dp)) {
                Button(onClick = { progressState -= 0.1f }, Modifier.padding(5.dp)) {
                    Text(text = "Reducir progreso")
                }

                Button(onClick = { progressState += 0.1f }, Modifier.padding(5.dp)) {
                    Text(text = "Incrementar progreso")
                }
            }
        }

        Button(onClick = { showLoading = !showLoading }) {
            Text(text = "Mostrar progreso")
        }
    }
}

@Composable
fun SwitchGeneric() {
    var statesSwitch by rememberSaveable { mutableStateOf(false) }

    Switch(
        checked = statesSwitch,
        onCheckedChange = { statesSwitch = !statesSwitch },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Black,
            checkedThumbColor = Color.Red,
            checkedTrackColor = Color.Cyan,
            uncheckedTrackColor = Color.Magenta
        )
    )

    Divider(
        Modifier
            .fillMaxWidth()
            .padding(2.dp), color = Color.Black
    )

    Row(Modifier.padding(7.dp)) {
        Checkbox(
            checked = statesSwitch,
            onCheckedChange = { statesSwitch = !statesSwitch },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Black,
                uncheckedColor = Color.Red,
                checkmarkColor = Color.Blue
            )
        )
        Spacer(modifier = Modifier.width(2.dp))

        Text(text = "check", modifier = Modifier.padding(10.dp))
    }

}


@Composable
fun CheckGeneric(checkInfo: CheckInfo) {


    Row(Modifier.padding(7.dp)) {
        Checkbox(
            checked = checkInfo.Checked,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.Checked) },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Magenta,
                uncheckedColor = Color.Black,
                checkmarkColor = Color.Blue
            )
        )
        Spacer(modifier = Modifier.width(2.dp))

        Text(text = checkInfo.label, modifier = Modifier.padding(10.dp))
    }

}

@Composable
fun MyRadioButtonGroup() {
    var select by rememberSaveable { mutableStateOf("texto 1") }


    Column(Modifier.height(250.dp)) {
        Row {
            RadioButton(selected = select == "texto 1", onClick = { select = "texto 1" })
            Text(text = "texto 1", modifier = Modifier.padding(10.dp))
        }
        Row {
            RadioButton(selected = select == "texto 2", onClick = { select = "texto 2" })
            Text(text = "texto 2", modifier = Modifier.padding(10.dp))
        }
        Row {
            RadioButton(selected = select == "texto 3", onClick = { select = "texto 3" })
            Text(text = "texto 3", modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun BadgeBoxDemo() {
    BottomNavigation {
        BottomNavigationItem(
            icon = {
                BadgedBox(badge = { Badge { Text("8") } }) {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = "Notificaction"
                    )
                }

            },
            selected = false,
            onClick = {})
    }
}


@Composable
fun DropDownGeneric() {
    var expanded by remember { mutableStateOf(false) }
    val items = listOf("A", "B", "C", "D", "E", "F")
    val disabledValue = "B"
    var selectedIndex by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopStart)
    ) {
        Text(
            items[selectedIndex],
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { expanded = true })
                .background(
                    Color.Magenta
                )
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.Gray
                )
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(onClick = {
                    selectedIndex = index
                    expanded = false
                }) {
                    val disabledText = if (s == disabledValue) {
                        " (Disabled)"
                    } else {
                        ""
                    }
                    Text(text = s + disabledText)
                }
            }
        }
    }

}
