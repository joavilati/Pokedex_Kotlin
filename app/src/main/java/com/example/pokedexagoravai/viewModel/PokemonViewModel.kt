package com.example.pokedexagoravai.viewModel

import android.os.Bundle
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner
import com.example.pokedexagoravai.extension.launchSafe
import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.repository.PokeRepository
import com.example.pokedexagoravai.util.Status

class PokemonViewModel (var repository: PokeRepository) : ViewModel() {

    private val _pokemons = MutableLiveData<List<Pokemon>>()
    val pokemons: LiveData<List<Pokemon>>
        get() = _pokemons

    fun getPokemons() {
        viewModelScope.launchSafe {
            repository.getPokemons {result ->
                when(result.status) {
                    Status.SUCCESS -> _pokemons.postValue(result.data)
                    Status.ERROR -> TODO()
                }
            }
        }
    }

    fun getEspecificPokemon(pokemonNameOrId:String = "") {
        pokemons.value?.filter { pokemon ->
            pokemon.name.toUpperCase().contains(pokemonNameOrId.toUpperCase()) || pokemon.id.contains(pokemonNameOrId)
        }
    }
}

class PokemonViewModelFactory(
    owner:SavedStateRegistryOwner,
    private val repository: PokeRepository,
    defaultArgs: Bundle? = null
): AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return PokemonViewModel(repository) as T
    }

}