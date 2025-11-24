package com.sena.practica_de_consumo_api.presentation.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sena.practica_de_consumo_api.domain.useCase.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {


    private val _uiState = MutableStateFlow(PokemonUiState())

    val uiState: StateFlow<PokemonUiState> = _uiState.asStateFlow()

    init {

        loadPokemons()
    }

    private fun loadPokemons() {
        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(
                isLoading = true,
                errorMessage = null
            )
            try {
                val pokemons = getPokemonsUseCase()


                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    pokemons = pokemons,
                    errorMessage = null
                )
            } catch (e: Exception) {
                e.printStackTrace()

                // Estado: Error
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = e.message ?: "Ocurrió un error al cargar los Pokemons"
                )
            }
        }
    }
}
