package com.example.jetpackcompose

sealed class Router (val routerNav: String){

    object Screen1: Router("Screen 1")
    object Screen2: Router("Screen 2")
    object Screen3: Router("Screen 3")
    object Screen4: Router("Screen 4/{name}"){
        fun createRoute(name:String)="Screen 4/$name"
    }

    object Screen5: Router("Screen 5?name={name}"){
        fun createRoute(name:String)="Screen 5?name=$name"
    }
}