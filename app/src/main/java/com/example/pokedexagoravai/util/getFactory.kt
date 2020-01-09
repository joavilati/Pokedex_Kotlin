package com.example.pokedexagoravai.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

fun getFactory(viewModel: ViewModel): ViewModelProvider.Factory {
    val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return viewModel as T
        }
    }

    return factory
}