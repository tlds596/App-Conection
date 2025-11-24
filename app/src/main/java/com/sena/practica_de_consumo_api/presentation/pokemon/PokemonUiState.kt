package com.sena.practica_de_consumo_api.presentation.pokemon
import com.sena.practica_de_consumo_api.domain.model.Pokemon

data class PokemonUiState(
    val isLoading: Boolean = false,
    val pokemons: List<Pokemon> = emptyList(),
    val errorMessage: String? = null
)


