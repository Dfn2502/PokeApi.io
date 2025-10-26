package mx.uacj.pokemon_api.ui.molecula

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mx.uacj.pokemon_api.modelos.Location

@Composable
fun LocalizacionLista(
    localizacion: Location,
    modificador: Modifier = Modifier
){
    Column(modificador) {
        Text("Localizacion: ${localizacion.name}")

        localizacion.region?.let { namedResource ->
            Text(text = "Región: ${namedResource.name}") // <-- Usamos .name aquí
        }

        if (localizacion.areas.isNotEmpty()) {
            Text("Area: ${localizacion.areas.first().name}") // <-- Agregamos .name
        }

        Text("Id: ${localizacion.id}")
    }
}