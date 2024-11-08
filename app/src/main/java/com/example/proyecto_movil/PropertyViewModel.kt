package com.example.proyecto_movil

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto_movil.data.PropertiesDao
import com.example.proyecto_movil.data.Property
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.launch

// PropertyViewModel.kt
class PropertyViewModel(
    private val dao: PropertiesDao
) : ViewModel() {
    var state by mutableStateOf(PropertyState())
        private set

    init {
        // Insertar datos por defecto si la base de datos está vacía
        insertDefaultProperties()
    }

    private fun insertDefaultProperties() {
        viewModelScope.launch {
            // Lista de propiedades por defecto
            val defaultProperties = listOf(
                Property(id = "1", name = "Departamento en la Playa", description = "Hermosa casa frente al mar con acceso directo a la playa.",imageResId = R.drawable.img1),
                Property(id = "2", name = "Departamento en la Ciudad", description = "Departamento moderno en el centro de la ciudad, cerca de todas las comodidades.",imageResId = R.drawable.img2),
                Property(id = "3", name = "Departamento en el Bosque", description = "Cabaña acogedora rodeada de naturaleza, ideal para desconectar y relajarse.",imageResId = R.drawable.img3)
            )

            // Verifica si la base de datos ya tiene propiedades, si no las inserta
            // Aquí puedes hacer una verificación para no insertar cada vez que inicies la app
            viewModelScope.launch {
                dao.getAllProperties().collect { properties ->
                    if (properties.isEmpty()) {
                        dao.insertAll(defaultProperties)
                    }
                }
            }
        }
    }

    // Método para actualizar el término de búsqueda
    fun onSearchTermChanged(newSearchTerm: String) {
        state = state.copy(searchTerm = newSearchTerm)
    }

    // Función que devuelve las propiedades filtradas según el término de búsqueda
    fun getFilteredProperties(): List<Property> {
        return state.properties.filter {
            it.name.contains(state.searchTerm, ignoreCase = true)
        }
    }
}
