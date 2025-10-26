package mx.uacj.pokemon_api.modelos

data class Machine(
    val id: Int,
    val item: NamedAPIResource?,
    val move: NamedAPIResource?,
    val version_group: NamedAPIResource?
)