package com.example.jetpackcompose.twit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.R
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

@Composable
fun TwitTemplate() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF161D26)),
    ) {
        Column {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(330.dp)
                    .background(Color(0xFF161D26))
            ) {

                IconAvatar(
                    Modifier
                        .fillMaxHeight()
                        .weight(1.1f)
                )
                DescriptionTwit(
                    Modifier
                        .fillMaxHeight()
                        .weight(5f)
                )


            }

            Divider(
                Modifier
                    .background(Color(0xFF59646F))
                    .height(1.dp)
                    .padding(horizontal = 10.dp)
            )
        }


    }
}

@Composable
fun IconAvatar(modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(com.example.jetpackcompose.R.drawable.profile),
            contentDescription = "profile",
            modifier = Modifier
                .padding(2.dp)
                .size(60.dp)
                .clip(CircleShape),
            alignment = Alignment.TopCenter
        )
    }

}

@Composable
fun DescriptionTwit(modifier: Modifier) {

    Box(
        modifier = modifier
            .padding(horizontal = 7.dp)
            .fillMaxSize()
    ) {
        Column() {
            Header()
            BodyTwit()
            FooterTwit()
        }
    }

}


@Composable
fun Header() {
    Row(Modifier.fillMaxWidth()) {
        Text(
            text = "Aris",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 18.sp,
            modifier = Modifier
        )
        Text(
            text = "@ArisDevs 4h",
            fontWeight = FontWeight.Light,
            color = Color.Gray,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(horizontal = 8.dp)

        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            imageVector = Icons.Default.MoreHoriz,
            contentDescription = "Icon more",
            tint = Color.White,
            modifier = Modifier
                .size(25.dp),
        )

    }

}


@Composable
fun BodyTwit() {

    Text(
        text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been",
        fontWeight = FontWeight.SemiBold,
        color = Color.White,
        fontSize = 18.sp,
    )

    Image(
        painterResource(id = com.example.jetpackcompose.R.drawable.profile),
        contentDescription = "image des twit",
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .height(200.dp)
            .padding(vertical = 5.dp),
        contentScale = ContentScale.Crop

    )
}


@Composable
fun FooterTwit() {
    var chat by rememberSaveable { mutableStateOf(false) }
    var rt by rememberSaveable { mutableStateOf(false) }
    var like by rememberSaveable { mutableStateOf(false) }
    Row(
        Modifier
            .padding(vertical = 8.dp)
    ) {


        SocialIcon(
            modifier = Modifier.weight(1f),
            unselectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chat),
                    contentDescription = "Icon more",
                    tint = Color(0xFF7E8B98)
                )
            },
            selectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chat_filled),
                    contentDescription = "Icon more",
                    tint = Color(0xFF7E8B98)
                )
            },
            isSelected = chat
        ) { chat = !chat }

        SocialIcon(
            modifier = Modifier.weight(1f),
            unselectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_rt),
                    contentDescription = "Icon more",
                    tint = Color(0xFF7E8B98)
                )
            },
            selectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_rt),
                    contentDescription = "Icon more",
                    tint = Color(0xFF4CAF50)
                )
            },
            isSelected = rt
        ) { rt = !rt }
        SocialIcon(
            modifier = Modifier.weight(1f),
            unselectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_like),
                    contentDescription = "Icon more",
                    tint = Color(0xFF7E8B98)
                )
            },
            selectedIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_like_filled),
                    contentDescription = "Icon more",
                    tint = Color(0xFF7E8B98)
                )
            },
            isSelected = like
        ) { like = !like }

    }


}

@Composable
fun SocialIcon(
    modifier: Modifier,
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val defaultValue = 1

    Row(
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ) {

        if (isSelected) {
            selectedIcon()
        } else {
            unselectedIcon()
        }

        Text(
            text = if (isSelected) (defaultValue + 1).toString() else defaultValue.toString(),
            color = Color(0xFF7E8B98),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp)
        )
    }

}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview2() {
    JetpackComposeTheme {
        TwitTemplate()
    }
}