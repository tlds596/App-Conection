package com.sena.practica_de_consumo_api.data.repository

import com.sena.practica_de_consumo_api.data.remote.dto.PokemonListResponseDto
import retrofit2.http.GET

interface PokemonApi {

    @GET( value = "pokemon")
    suspend fun getPokemons(): PokemonListResponseDto
}

