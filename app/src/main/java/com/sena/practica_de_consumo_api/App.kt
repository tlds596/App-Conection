package com.sena.practica_de_consumo_api

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


// Usage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de pokemones") }
            )
        }
    ) { innerPadding ->
        UserScreen(
            modifier = Modifier.padding(paddingValues = innerPadding)
        )
    }
}
@Composable
fun UserScreen(modifier : Modifier){
    Text(text = "Hola")
}