package mx.uacj.pokemon_api.modelos

data class Tipo(
    val name: String,
    val url: String
)

data class Tipos(
    val slot: Int,
    val type: Tipo,
)