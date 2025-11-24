package com.sena.practica_de_consumo_api.domain.useCase

import com.sena.practica_de_consumo_api.domain.model.Pokemon
import com.sena.practica_de_consumo_api.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {
    suspend operator fun invoke(): List<Pokemon>{
        return pokemonRepository.getPokemons()

    }
}