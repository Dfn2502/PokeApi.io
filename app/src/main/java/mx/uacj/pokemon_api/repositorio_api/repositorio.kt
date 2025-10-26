package mx.uacj.pokemon_api.repositorio_api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositorioOficial{
    @Provides
    @Singleton
    fun crea_un_repositorio_para_guardar_pokemones(): RepositorioPokemones{
        return AlmacenDatosPokemon()
    }
}
