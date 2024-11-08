package com.example.proyecto_movil.core.navigation

import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyecto_movil.HomeScreen
import com.example.proyecto_movil.LoginScreen
import com.example.proyecto_movil.LoginViewModel
import com.example.proyecto_movil.PropertyViewModel
import com.example.proyecto_movil.RegisterScreen
import com.example.proyecto_movil.RegisterViewModel

@Composable
fun NavigationWrapper (viewModel: RegisterViewModel, viewModel1: LoginViewModel, viewModel2: PropertyViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login){
        composable<Login> {

            LoginScreen(
                navigateToHome = {navController.navigate(Home)},
                navigateToRegister = {navController.navigate(Register)},
                viewModel = viewModel1
            )
        }

        composable<Register> {

            RegisterScreen(
                navigateToLogin = { navController.navigate(Login) },
                viewModel = viewModel
            )
        }

        composable<Home> {
            HomeScreen(
                viewModel = viewModel2
            )
        }
    }

}