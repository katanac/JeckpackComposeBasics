package com.example.jetpackcompose.model

import androidx.annotation.DrawableRes
import com.example.jetpackcompose.R

data class SuperHero(
    var name: String,
    @DrawableRes var image: Int,
    var realName: String,
    var publisher: String
)

fun getSuperHeros(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", R.drawable.spiderman, "Petter Parker", "Marvel"),
        SuperHero("Batman", R.drawable.batman, "Bruce Wayne", "DC"),
        SuperHero("Wolverine", R.drawable.logan, "James Howlett", "Marvel"),
        SuperHero("Thor", R.drawable.thor, "Thor Odison", "Marvel"),
        SuperHero("Flash", R.drawable.flash, "Jay Garrick", "DC"),
        SuperHero("Green Lantern", R.drawable.green_lantern, "Alan Scott", "DC"),
        SuperHero("Wonder Woman", R.drawable.wonder_woman, "Princesa Diana", "Marvel"),

        )
}