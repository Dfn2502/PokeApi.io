package mx.uacj.pokemon_api.ui.molecula

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mx.uacj.pokemon_api.modelos.Machine

@Composable
fun MaquinasLista(maquina: Machine, modificador: Modifier = Modifier ){
    Column(modificador) {
        Text(text = "Item: ${maquina.item?.name ?: "N/A"}")

        // CORRECCIÓN: Accedemos a .move?.name. Usamos el operador Elvis (?:) para mostrar un fallback.
        Text(text = "Movimiento: ${maquina.move?.name ?: "N/A"}")

        // El ID generalmente es un Int y se muestra sin problema:
        Text(text = "Id: ${maquina.id}")    }
}