package com.example.jetpackcompose

import android.app.FragmentManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose.Router.*
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navigationController = rememberNavController()

                    NavHost(
                        navController = navigationController,
                        startDestination = Screen1.routerNav
                    ) {
                        composable(Screen1.routerNav) { ScreenOne(navigationController) }
                        composable(Screen2.routerNav) { ScreenTwo(navigationController) }
                        composable(Screen3.routerNav) { ScreenThree(navigationController) }
                        composable(Screen4.routerNav) { backStackEntry ->
                            ScreenFourRequireParameter(
                                navigationController,
                                backStackEntry.arguments?.getString("name")!!
                            )
                        }

                        composable(
                            Screen5.routerNav,
                            arguments = listOf(navArgument("name") { defaultValue = "juanpa" })
                        ) { backStackEntry ->
                            ScreenFiveOptionalParameter(
                                navigationController,
                                backStackEntry.arguments?.getString("name")!!
                            )
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
    }
}