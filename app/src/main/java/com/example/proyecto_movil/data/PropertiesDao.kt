package com.example.proyecto_movil.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PropertiesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProperties(property: Property)

    @Query("SELECT * FROM property")
    fun getAllProperties(): Flow<List<Property>>  // Remove suspend here

    @Delete
    suspend fun deleteProperty(property: Property)

    @Query("SELECT * FROM property WHERE name = :name ")
    suspend fun getPropertyByName(name: String): Property

    @Insert
    suspend fun insert(property: Property)

    // Si quieres insertar múltiples propiedades
    @Insert
    suspend fun insertAll(properties: List<Property>)
}
