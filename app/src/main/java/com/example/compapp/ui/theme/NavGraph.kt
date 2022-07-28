package com.example.compapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.compapp.FirstScreen
import com.example.compapp.Screen
import com.example.compapp.SecondScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    viewModelStoreOwner: ViewModelStoreOwner
){
    NavHost(navController = navController,
    startDestination = Screen.First.route){
        composable(
            route = Screen.First.route
        ){
            FirstScreen(viewModelStoreOwner = viewModelStoreOwner)
        }

        composable(route = Screen.Second.route){
            SecondScreen(viewModelStoreOwner = viewModelStoreOwner)
        }
    }
}