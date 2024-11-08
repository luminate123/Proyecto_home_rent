package com.example.proyecto_movil

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto_movil.data.UserDao
import kotlinx.coroutines.launch

class LoginViewModel(
    private val dao: UserDao
) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    fun changeEmail(email: String) {
        state = state.copy(email = email)
    }

    fun changePassword(password: String) {
        state = state.copy(password = password)
    }

    fun loginUser(onSuccess: () -> Unit) {
        viewModelScope.launch {
            // Iniciar carga
            state = state.copy(isLoading = true, errorMessage = null)

            val user = dao.getUserByEmail(state.email)
            if (user != null && user.password == state.password) {
                // Si el usuario existe y la contraseña es correcta
                state = state.copy(isLoading = false)
                onSuccess()
            } else {
                // Si la autenticación falla
                state = state.copy(
                    isLoading = false,
                    errorMessage = "Credenciales incorrectas. Por favor, intente de nuevo."
                )
            }
        }
    }
}
