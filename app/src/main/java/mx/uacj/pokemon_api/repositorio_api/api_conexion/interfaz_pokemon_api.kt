package mx.uacj.pokemon_api.repositorio_api.api_conexion

import mx.uacj.pokemon_api.modelos.Location
import mx.uacj.pokemon_api.modelos.Machine
import mx.uacj.pokemon_api.modelos.Pokemon
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface InterfazPokemonAPI{
    ///@POST("/pokemon")

    @GET("pokemon/{id}")
    suspend fun descargar_pokemon(@Path("id") id: Int): Pokemon

    @GET("machine/{id}")
    suspend fun  descargar_machine(@Path("id") id:Int): Machine

    @GET("location/{id}")
    suspend fun  descargar_localizacion(@Path("id") id:Int): Location

}

