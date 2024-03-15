package com.example.cse3200_midtermtimerapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cse3200_midtermtimerapp.screens.CenterScreen
import com.example.cse3200_midtermtimerapp.screens.LeftScreen
import com.example.cse3200_midtermtimerapp.screens.MainScreen
import com.example.cse3200_midtermtimerapp.screens.RightScreen
import com.example.cse3200_midtermtimerapp.screens.ScreenRoutes
import com.example.cse3200_midtermtimerapp.timers.CenterScreenViewModel
import com.example.cse3200_midtermtimerapp.timers.LeftScreenViewModel
import com.example.cse3200_midtermtimerapp.timers.RightScreenViewModel

@Composable
fun Navigation(leftViewModel: LeftScreenViewModel, centerViewModel: CenterScreenViewModel, rightViewModel: RightScreenViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenRoutes.MainScreen.route) {
        composable(route = ScreenRoutes.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = ScreenRoutes.LeftScreen.route) {
            LeftScreen(name = "LEFT", leftViewModel)
        }
        composable(route = ScreenRoutes.CenterScreen.route) {
            CenterScreen(name = "LEFT", centerViewModel)
        }
        composable(route = ScreenRoutes.RightScreen.route) {
            RightScreen(name = "RIGHT", rightViewModel)
        }
    }
}