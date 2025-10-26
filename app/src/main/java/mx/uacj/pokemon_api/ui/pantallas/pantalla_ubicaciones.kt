package mx.uacj.pokemon_api.ui.pantallas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import mx.uacj.pokemon_api.ui.molecula.LocalizacionLista
import mx.uacj.pokemon_api.viewmodels.PokemonesViewModel

@Composable
fun PantallaUbicaciones(
    modificador: Modifier = Modifier,
    controlador_pokemon: PokemonesViewModel = hiltViewModel()
){

    val lista_localizaciones = controlador_pokemon.localizaciones.value
    Column(modifier = modificador) {
        Text("Explora ${lista_localizaciones.size} localizaciones")


    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        for(localizacion in lista_localizaciones){
            LocalizacionLista(
                localizacion = localizacion,
                modificador = Modifier.clickable{

                }
            )
        }
    }
}
}