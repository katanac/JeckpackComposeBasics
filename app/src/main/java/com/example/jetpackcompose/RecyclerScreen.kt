package com.example.jetpackcompose

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.model.SuperHero
import com.example.jetpackcompose.model.getSuperHeros
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import kotlinx.coroutines.launch

@Composable
fun RecyclerGeneric() {

    val list = listOf("rhcp", "mago de oz", "alice cooper", "Depeche Mode", "motorama")
    LazyColumn() {


        items(10) {
            Text(text = "Soy el item $it")
        }

        items(list) {
            Text(text = "Soy el item $it")
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Recycler() {
    val context = LocalContext.current
    val rrv = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val groupPubliseher: Map<String, List<SuperHero>> = getSuperHeros().groupBy { it.publisher }
    Column() {


        LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp), state = rrv) {

            groupPubliseher.forEach { (publisher, superHeros) ->

                stickyHeader {
                    Text(
                        text = publisher,
                        Modifier
                            .background(Color.Gray)
                            .height(260.dp),
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                items(superHeros) { superhero ->
                    ItemHero(superHero = superhero) {
                        Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
                    }
                }
            }


        }

        val showButton by remember {
            derivedStateOf { rrv.firstVisibleItemIndex > 0 }
        }

        if (showButton) {
            Button(
                onClick = { coroutineScope.launch { rrv.animateScrollToItem(0) } },
                Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Boton estado recycler")
            }
        }

    }

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Grid() {
    val context = LocalContext.current

    LazyVerticalGrid(cells = GridCells.Fixed(3), content = {
        items(getSuperHeros()) { superhero ->
            ItemHero(superHero = superhero) {
                Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
            }
        }
    })
}


@Composable
fun RecycerHeroes() {

    Column {

        Text(
            text = "Recycler Generico",
            Modifier
                .padding(15.dp)
                .align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )
        Recycler()
        Text(
            text = "Grid Generico", Modifier
                .padding(15.dp)
                .align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
        )

        Grid()
    }

}


@Composable
fun ItemHero(superHero: SuperHero, onItemSelect: (SuperHero) -> Unit) {

    Card(
        border = BorderStroke(3.dp, Color.Black), modifier = Modifier
            .width(200.dp)
            .padding(4.dp)
            .clickable { onItemSelect(superHero) }
    ) {
        Column(Modifier.padding(2.dp)) {
            Image(
                painterResource(id = superHero.image),
                contentDescription = "Heroe ${superHero.name}",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Text(
                text = superHero.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraLight,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Text(
                text = superHero.publisher,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraLight,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(horizontal = 10.dp)
            )

        }


    }
}


@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        // RecyclerGeneric()
        RecycerHeroes()
    }
}