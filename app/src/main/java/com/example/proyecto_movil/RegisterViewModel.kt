package com.example.proyecto_movil

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto_movil.data.User
import com.example.proyecto_movil.data.UserDao
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.UUID

class RegisterViewModel(
    private val dao: UserDao
) : ViewModel(){
    var state by mutableStateOf(RegisterState())
        private set

    init{
        viewModelScope.launch {
            dao.getAllUsers().collectLatest {
                state = state.copy(
                    users = it
                )
            }
        }
    }

    fun changeName (name: String){
        state = state.copy(
            userName = name
        )
    }

    fun changeEmail(email: String){
        state = state.copy(
            userEmail = email
        )
    }
    fun changeLastName (lastname: String){
        state = state.copy(
            userLastname = lastname
        )
    }

    fun changPhone (phone : String){
        state = state.copy(
            userPhone = phone
        )
    }

    fun changePassword (password : String){
        state = state.copy(
            userPassword = password
        )
    }

    fun createUser(){
        val user =  User(UUID.randomUUID().toString(),state.userName,state.userEmail,state.userLastname,state.userPhone,state.userPassword)
        viewModelScope.launch {
            dao.insertUser(user)
        }


    }
}