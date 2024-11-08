package com.example.proyecto_movil.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class, Property::class], version = 1) // Incluye Property en las entidades
abstract class UserDatabase : RoomDatabase() {
    abstract val userDao: UserDao // Nombre descriptivo para UserDao
    abstract val propertiesDao: PropertiesDao // Nombre descriptivo para PropertiesDao
}
