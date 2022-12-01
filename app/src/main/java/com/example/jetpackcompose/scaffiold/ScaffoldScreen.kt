package com.example.jetpackcompose.scaffiold

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun ScaffoldGeneric() {

    val stateSacffold = rememberScaffoldState()
    val courotieScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopBar(onClickIcon = {
                courotieScope.launch {
                    stateSacffold.snackbarHostState.showSnackbar(
                        it,
                        "accion",
                        SnackbarDuration.Short
                    )
                }
            }, onClickDrawer = { courotieScope.launch { stateSacffold.drawerState.open() } })
        },
        scaffoldState = stateSacffold,
        bottomBar = { MyBottonBar() },
        floatingActionButton = { FloatingButton() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        drawerContent = { MyDrawer { courotieScope.launch { stateSacffold.drawerState.close() } } }
    ) {

    }
}


@Composable
fun MyTopBar(onClickIcon: (String) -> Unit, onClickDrawer: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Tool bar") },
        backgroundColor = Color.Gray,
        contentColor = Color.Black,
        navigationIcon = {
            IconButton(onClick = { onClickDrawer() }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {

            IconButton(onClick = { onClickIcon("Busco en app") }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Buscar")
            }
            IconButton(onClick = { onClickIcon("Clic en More") }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "mas")
            }
        })

}


@Composable
fun MyBottonBar() {
    BottomNavigation(backgroundColor = Color.Gray, contentColor = Color.White) {
        BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = "inicio")
        }, label = { Text(text = "Inicio") })

        BottomNavigationItem(selected = true, onClick = { /*TODO*/ }, icon = {
            Icon(imageVector = Icons.Default.AccountBox, contentDescription = "inicio")
        }, label = { Text(text = "Cuenta") })

        BottomNavigationItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(imageVector = Icons.Default.Person, contentDescription = "inicio")
        }, label = { Text(text = "Perfil") })
    }
}

@Composable
fun FloatingButton() {
    FloatingActionButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
    }
}


@Composable
fun MyDrawer(onCloseDrawer: () -> Unit) {
    Column {
        Text(
            text = "Opcion 1", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }
        )
        Text(
            text = "Opcion 2", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }
        )
        Text(
            text = "Opcion 3", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }
        )
        Text(
            text = "Opcion 4", modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clickable { onCloseDrawer() }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    JetpackComposeTheme {
        ScaffoldGeneric()
    }
}