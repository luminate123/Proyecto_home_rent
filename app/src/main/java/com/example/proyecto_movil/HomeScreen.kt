package com.example.proyecto_movil

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto_movil.data.Property

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.draw.shadow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: PropertyViewModel) {
    val searchTerm = viewModel.state.searchTerm
    val filteredProperties = viewModel.getFilteredProperties()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Search bar
        OutlinedTextField(
            value = searchTerm,
            onValueChange = { viewModel.onSearchTermChanged(it) },
            placeholder = { Text("Buscar aquí") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(50.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Lista desplazable de propiedades filtradas
        LazyColumn(
            modifier = Modifier
                .weight(1f) // Ocupa el espacio disponible en la pantalla
                .fillMaxHeight()
        ) {
            items(filteredProperties) { property ->
                PropertyCard(property)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Bottom Navigation
        NavigationBar(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            NavigationBarItem(
                icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Explorar") },
                label = { Text("Home") },
                selected = true,
                onClick = {}
            )
            NavigationBarItem(
                icon = { Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Deseos") },
                label = { Text("Deseos") },
                selected = false,
                onClick = {}
            )
            NavigationBarItem(
                icon = { Icon(imageVector = Icons.Default.Star, contentDescription = "Viajes") },
                label = { Text("Viajes") },
                selected = false,
                onClick = {}
            )
            NavigationBarItem(
                icon = { Icon(imageVector = Icons.Default.Email, contentDescription = "Inbox") },
                label = { Text("Inbox") },
                selected = false,
                onClick = {}
            )
            NavigationBarItem(
                icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Perfil") },
                label = { Text("Perfil") },
                selected = false,
                onClick = {}
            )
        }
    }
}
@Composable
fun PropertyCard(property: Property) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(16.dp)
            ) // Borde alrededor del card
    )  {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = property.imageResId), // Usa el id de imagen del Property
                contentDescription = "Property Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = property.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp)
            )

            Text(
                text = property.description,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

