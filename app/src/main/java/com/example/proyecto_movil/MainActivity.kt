package com.example.proyecto_movil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.example.proyecto_movil.core.navigation.NavigationWrapper
import com.example.proyecto_movil.data.UserDatabase
import com.example.proyecto_movil.ui.theme.Proyecto_MovilTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Proyecto_MovilTheme {
                val database = Room.databaseBuilder(this, UserDatabase::class.java, "App_db").build()
                val dao = database.userDao
                val dao1 = database.propertiesDao

                // ViewModel for Register
                val viewModel by viewModels<RegisterViewModel>(factoryProducer = {
                    object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return RegisterViewModel(dao) as T
                        }
                    }
                })

                // ViewModel for Login
                val viewModel1 by viewModels<LoginViewModel>(factoryProducer = {
                    object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return LoginViewModel(dao) as T
                        }
                    }
                })

                val viewModel2 by viewModels<PropertyViewModel> ( factoryProducer = {
                    object : ViewModelProvider.Factory{
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return PropertyViewModel(dao1) as T
                        }
                    }
                })

                // Pass both ViewModels to NavigationWrapper
                NavigationWrapper(viewModel, viewModel1, viewModel2)
            }
        }
    }
}
