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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RegisterScreen( navigateToLogin: () -> Unit,
                    viewModel: RegisterViewModel){
    // State variables for TextFields

    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.image_42), // Replace with your logo resource
            contentDescription = "House Rent Logo",
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = "¿Tiene cuenta? Ingrese",
            color = Color.Blue,
            modifier = Modifier.align(Alignment.Start)
                .clickable { navigateToLogin() }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Register header
        Text(
            text = "Registro",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Email Field
        OutlinedTextField(
            value = state.userEmail,
            onValueChange = {viewModel.changeEmail(it)},
            label = { Text("Email") },
            leadingIcon = {
                Icon(Icons.Default.Email, contentDescription = "Email Icon")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        // First Name Field
        OutlinedTextField(
            value = state.userName,
            onValueChange = { viewModel.changeName(it) },
            label = { Text("Nombres") },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "First Name Icon")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        // Last Name Field
        OutlinedTextField(
            value = state.userLastname,
            onValueChange = {  viewModel.changeLastName(it)  },
            label = { Text("Apellidos") },
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "Last Name Icon")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        // Phone Number Field
        OutlinedTextField(
            value = state.userPhone,
            onValueChange = {  viewModel.changPhone(it)  },
            label = { Text("Numero Telefonico") },
            leadingIcon = {
                Icon(Icons.Default.Phone, contentDescription = "Phone Icon")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        // Password Field
        OutlinedTextField(
            value = state.userPassword,
            onValueChange = {  viewModel.changePassword(it)  },
            label = { Text("Contraseña") },
            leadingIcon = {
                Icon(Icons.Default.Lock, contentDescription = "Password Icon")
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Continue Button
        Button(
            onClick = { viewModel.createUser()
                      navigateToLogin()},
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
        ) {
            Text("Registrese", color = Color.White)
        }
    }
}