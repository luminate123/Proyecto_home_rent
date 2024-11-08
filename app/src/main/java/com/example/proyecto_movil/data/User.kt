package com.example.proyecto_movil.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val email: String,
    val lastname: String,
    val phone : String,
    val password : String
)

@Entity
data class Property(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val name: String,
    val description: String,
    val imageResId: Int
)