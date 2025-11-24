package com.sena.practica_de_consumo_api.data.remote.dto

import com.sena.practica_de_consumo_api.domain.model.Pokemon
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDto(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String)


@JsonClass(generateAdapter = true)
data class PokemonListResponseDto(
    @Json(name = "results")
    val results: List<PokemonDto>)


fun PokemonDto.toDomain(): Pokemon {
    return Pokemon(
        name = name,
        url = url
    )
}