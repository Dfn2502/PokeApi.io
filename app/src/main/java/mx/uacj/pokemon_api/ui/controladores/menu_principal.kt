package mx.uacj.pokemon_api.ui.controladores

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import mx.uacj.pokemon_api.ui.pantallas.PantallaUbicaciones
import androidx.navigation.compose.composable
import mx.uacj.pokemon_api.ui.pantallas.PantallaMaquinas
import mx.uacj.pokemon_api.ui.pantallas.PantallaPrincipal

data class OpcionesMenu(
    val titulo: String,
    val icono: String,
    val ruta: String
)

@Composable
fun OpcionesMenuInferior(
        opciones: List<OpcionesMenu>,
        ruta_acutal: String,
        navController: NavController
){
    BottomAppBar {
        Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
            for (opcion in opciones) {
                Text(
                    "${opcion.titulo}",
                    modifier = Modifier.clickable {
                        if(opcion.ruta != ruta_acutal){
                            navController.navigate(opcion.ruta)
                        }
                })
            }
        }
    }
}

@Composable
fun MenuPrincipal(){
    val navController = rememberNavController()

    val lista_opciones_menu by remember {  mutableStateOf(
        mutableStateListOf(
            OpcionesMenu("Pokemones", "icono", "PantallaPokemones"),
            OpcionesMenu("Ubicaciones", "icono", "pantalla_ubicaciones"),
            OpcionesMenu("Maquinas", "icono", "pantalla_maquinas"),
            )
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            OpcionesMenuInferior(
                lista_opciones_menu,
                "",
                navController = navController
            )
        }
    ) { innerPadding ->
        Navegacion(navController = navController, innerPadding = innerPadding)
    }
}

@Composable
fun Navegacion(navController: NavController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController as NavHostController ,
        startDestination = "PantallaPokemones",
        modifier = Modifier.padding(innerPadding)
    ) {
        composable("PantallaPokemones") { PantallaPrincipal() }
        composable("pantalla_ubicaciones") { PantallaUbicaciones() }
        composable("pantalla_maquinas") { PantallaMaquinas() }
    }
}


