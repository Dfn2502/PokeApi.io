package mx.uacj.pokemon_api.modelos


data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<Tipos>,
    val base_experience: Int,
    val height: Int,
    val is_default: Boolean,
    val order: Int,
    val weight: Int,
    val abilities: List<Habilidad>,
    val location_area_encounters: String,
    val sprites: Sprite,
    val cries: Aullido,
    val stats: List<EstadisticaBase>
)
