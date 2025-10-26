package mx.uacj.pokemon_api.ui.pantallas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.uacj.pokemon_api.modelos.Pokemon
import mx.uacj.pokemon_api.ui.molecula.PokemonLista
import mx.uacj.pokemon_api.viewmodels.PokemonesViewModel


@Composable
fun PantallaPrincipal(modificador: Modifier = Modifier,
                      controlador_pokemones: PokemonesViewModel = hiltViewModel()) {
    val contrlador_navegacion = rememberNavController()

    var pokemon_seleccionado by remember { mutableStateOf<Pokemon?>(null) }

    NavHost(navController = contrlador_navegacion, startDestination = "lista_pokemones"){
        composable("lista_pokemones") {
            Column(modifier = modificador) {
                Column {
                    Text("Atrapa a los ${controlador_pokemones.pokemones.value.size} pokemones")
                }

                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    for (pokemon in controlador_pokemones.pokemones.value) {
                        PokemonLista(pokemon = pokemon, modificador = Modifier.clickable {
                            pokemon_seleccionado = pokemon
                            contrlador_navegacion.navigate("pantalla_pokemones")
                        })
                    }
                }
            }
        }

        composable("pantalla_pokemones") {
            PantallaPokemon(modificador = modificador, pokemon = pokemon_seleccionado!!)
        }
    }


}

@Composable
@Preview(showBackground = true)
fun PreviewPantallaPrincipal(){
    PantallaPrincipal()
}
