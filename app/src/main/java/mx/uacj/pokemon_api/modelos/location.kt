package mx.uacj.pokemon_api.modelos

data class Location(
    val id: Int,
    val name: String,
    val region: NamedAPIResource?,
    val areas: List<NamedAPIResource>,
    val game_indices: List<LocationGameIndex>,
    val names: List<Name>
)

data class LocationGameIndex(
    val game_index: Int,
    val generation: NamedAPIResource
)

data class Name(
    val name:String,
    val language: NamedAPIResource
)