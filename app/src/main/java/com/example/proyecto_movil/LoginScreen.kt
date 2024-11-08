package com.example.proyecto_movil

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.provider.FontsContractCompat.Columns

@Composable
fun LoginScreen(navigateToHome:()->Unit,navigateToRegister: ()->Unit, viewModel: LoginViewModel){
    val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Header - Logo
        Image(
            painter = painterResource(id = R.drawable.image_42), // Use your logo resource
            contentDescription = "House Rent Logo",
            modifier = Modifier.size(160.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Bienvenidos",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(8.dp)
                .align(Alignment.Start)
        )
        // Email Text Field
        OutlinedTextField(
            value = state.email, // state for email
            onValueChange = {viewModel.changeEmail(it)},
            label = { Text("Email") },
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "Email Icon")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Password Text Field
        OutlinedTextField(
            value = state.password, // state for password
            onValueChange = {viewModel.changePassword(it)},
            label = { Text("Contraseña") },
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Password Icon")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Button(
            onClick = {
                viewModel.loginUser(
                    onSuccess = navigateToHome
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
        ) {
            Text("Ingresar", color = Color.White)
        }

        // Mostrar el mensaje de error si existe
        state.errorMessage?.let { error ->
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = error,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }


        Spacer(modifier = Modifier.height(16.dp))

        // Sign Up Text
        Text(
            text = "¿No tienes cuenta? Registrate",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Blue,
            modifier = Modifier.clickable { navigateToRegister() }
        )
    }

}