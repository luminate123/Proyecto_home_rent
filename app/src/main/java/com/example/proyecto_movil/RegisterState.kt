package com.example.proyecto_movil

import com.example.proyecto_movil.data.Property
import com.example.proyecto_movil.data.User

data class RegisterState (
    val users : List<User> = emptyList(),
    val userName: String = "",
    val userEmail: String = "",
    val userLastname : String = "",
    val userPhone : String = "",
    val userPassword : String = "",
    val userId: String? = null
)

data class LoginState(
    val email: String = "",
    val password : String = "",
    val isLoading: Boolean = false,
    val errorMessage: String? = null
)


