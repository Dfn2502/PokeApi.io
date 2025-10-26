package mx.uacj.pokemon_api.modelos

data class Habilidad(
    val is_hidden: Boolean,
    val slot: Int,
    val ability: HabilidadURL
)