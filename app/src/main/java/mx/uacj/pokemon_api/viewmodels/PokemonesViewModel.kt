package mx.uacj.pokemon_api.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mx.uacj.pokemon_api.modelos.Pokemon
import mx.uacj.pokemon_api.repositorio_api.RepositorioPokemones
import mx.uacj.pokemon_api.repositorio_api.api_conexion.InterfazPokemonAPI
import javax.inject.Inject
import androidx.compose.runtime.State
import mx.uacj.pokemon_api.modelos.Location
import mx.uacj.pokemon_api.modelos.Machine
import javax.crypto.Mac

@HiltViewModel
class PokemonesViewModel @Inject constructor(
    private val repositorio: RepositorioPokemones,
    private val conexion_server: InterfazPokemonAPI
): ViewModel(){
    private var estado = mutableStateOf("cargando")

    public val pokemones: State<List<Pokemon>> = repositorio.pokemones
    private val _maquinas = mutableStateOf(emptyList<Machine>())
    public val maquinas: State<List<Machine>> = _maquinas

    private val _localizaciones = mutableStateOf(emptyList<Location>())
    public val localizaciones: State<List<Location>> = _localizaciones

    init {
        for(indice_pokemon in 1..50) {
            descargar_pokemon(indice_pokemon)
        }
        for(indice_maquina in 1..20){
            descargar_machine(indice_maquina)
        }
        for(indice_localizacion in 1..20){
            descargar_localizacion(indice_localizacion)
        }
    }

    fun descargar_pokemon(id: Int){
        viewModelScope.launch {
            val pokemon = conexion_server.descargar_pokemon(id)
            //pokemon_cache = mutableStateOf(pokemon_descargado)
            val lista = repositorio.pokemones.value.toMutableStateList()

            if(pokemon != null) {
                lista.add(pokemon!!)
            }

            repositorio.pokemones.value = lista
        }

    }

    fun descargar_machine(id: Int){
        viewModelScope.launch{
            val machines = conexion_server.descargar_machine(id)

            if(machines != null){
                val lista = _maquinas.value.toMutableStateList()
                lista.add(machines)
                _maquinas.value = lista
            }
        }
    }

    fun descargar_localizacion(id: Int){
        viewModelScope.launch {
            val location = conexion_server.descargar_localizacion(id)
            if(location != null){
                val lista = _localizaciones.value.toMutableStateList()
                lista.add(location)
                _localizaciones.value = lista
            }
        }


    }
}
