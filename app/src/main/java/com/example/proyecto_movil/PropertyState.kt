package com.example.proyecto_movil

import com.example.proyecto_movil.data.Property

// PropertyState.kt
data class PropertyState(
    val properties: List<Property> = listOf(
        Property(id = "1", name = "Departamento en la Playa", description = "Hermosa casa frente al mar con acceso directo a la playa.",imageResId = R.drawable.img1),
        Property(id = "2", name = "Departamento en la Ciudad", description = "Departamento moderno en el centro de la ciudad, cerca de todas las comodidades.",imageResId = R.drawable.img2),
        Property(id = "3", name = "Departamento en el Bosque", description = "Cabaña acogedora rodeada de naturaleza, ideal para desconectar y relajarse.",imageResId = R.drawable.img3)
    ),
    val searchTerm: String = ""
)
