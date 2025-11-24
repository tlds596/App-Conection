package com.sena.practica_de_consumo_api.domain.repository;
import com.sena.practica_de_consumo_api.domain.model.Pokemon;

interface PokemonRepository {
    suspend fun getPokemons(): List<Pokemon>
}
