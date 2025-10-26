package mx.uacj.pokemon_api.ui.molecula

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mx.uacj.pokemon_api.modelos.Pokemon

@Composable
fun PokemonLista(pokemon: Pokemon, modificador: Modifier = Modifier){
    Column(modificador) {
        Text("Nombre: ${pokemon.name}")
        Text("Altura: ${pokemon.height}")
        Text("Peso: ${pokemon.weight}")
    }
}
