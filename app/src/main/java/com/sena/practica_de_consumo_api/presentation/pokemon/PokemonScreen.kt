package com.sena.practica_de_consumo_api.presentation.pokemon

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PokemonScreen(
    modifier: Modifier = Modifier,
    // Se cambia a PokemonViewModel
    viewModel: PokemonViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        // 1) Loading
        if (uiState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }

        uiState.errorMessage?.let { error ->
            Text(
                text = error,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 32.dp)
            )
        }

        if (!uiState.isLoading && uiState.errorMessage == null) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(uiState.pokemons) { pokemon ->
                    PokemonItem(pokemon = pokemon)
                }
            }
        }
    }
}