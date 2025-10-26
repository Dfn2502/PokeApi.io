package mx.uacj.pokemon_api.ui.pantallas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

import mx.uacj.pokemon_api.ui.molecula.MaquinasLista
import mx.uacj.pokemon_api.viewmodels.PokemonesViewModel

@Composable
fun PantallaMaquinas(
    modificador: Modifier = Modifier,
    controlador_pokemon: PokemonesViewModel = hiltViewModel()
) {

    val lista_maquinas = controlador_pokemon.maquinas.value
    Column(modifier = modificador) {
        Text(
            "Utiliza las ${lista_maquinas.size} maquinas",
            modifier = Modifier.padding(16.dp)
        )

        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            for (maquina in lista_maquinas) {
                MaquinasLista(
                    maquina = maquina,
                    modificador = Modifier.clickable {

                    }
                )
            }
        }
    }
}