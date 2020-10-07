package com.example.pokedexagoravai.viewModel

import android.os.Bundle
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner
import com.example.pokedexagoravai.extension.launchSafe
import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.repository.PokeRepository
import com.example.pokedexagoravai.util.Status
import java.util.*

class PokemonViewModel(var repository: PokeRepository) : ViewModel() {

    private val _pokemons = MutableLiveData<List<Pokemon>>()
    val pokemons: LiveData<List<Pokemon>>
        get() = _pokemons

    private val _pokemonsNotFound = MutableLiveData<Boolean>()
    val pokemonsNotFound: LiveData<Boolean>
        get() = _pokemonsNotFound

    fun getPokemons() {
        viewModelScope.launchSafe {
            repository.getPokemons { result ->
                when (result.status) {
                    Status.SUCCESS -> _pokemons.postValue(result.data)
                    Status.ERROR -> _pokemonsNotFound.postValue(true)
                }
            }
        }
    }

    fun getSpecificPokemon(pokemonNameOrId: String = "") {
        _pokemons.value = pokemons.value?.filter { pokemon ->
            pokemon.name.toUpperCase(Locale.ROOT)
                .contains(pokemonNameOrId.toUpperCase(Locale.ROOT)) || pokemon.id.contains(
                pokemonNameOrId
            )
        }
        if (_pokemons.value.isNullOrEmpty()) {
            _pokemonsNotFound.value = true
        }
        if (pokemonNameOrId.isBlank()) getPokemons()

    }
}

class PokemonViewModelFactory(
    owner: SavedStateRegistryOwner,
    private val repository: PokeRepository,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return PokemonViewModel(repository) as T
    }

}