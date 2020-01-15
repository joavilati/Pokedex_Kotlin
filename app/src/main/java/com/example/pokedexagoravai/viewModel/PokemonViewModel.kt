package com.example.pokedexagoravai.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedexagoravai.extension.launchSafe
import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.network.PokeApi
import com.example.pokedexagoravai.util.STATUS
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class PokemonViewModel (private val pokeIndexAPINetwork: PokeApi) : ViewModel() {

    val pokemons = MutableLiveData<List<Pokemon>>()

    fun getPokemons() {
        CoroutineScope(Dispatchers.IO).launchSafe(
            {

            },
            {
                val result = pokeIndexAPINetwork.getPokemons()

                if (result.status == STATUS.SUCCESS) {

                    val results = result.data ?: arrayListOf()

                    pokemons.postValue(results)
                }
            }
        )
    }

    fun getEspecificPokemon(pokemon:String = "") {

        CoroutineScope(Dispatchers.IO).launchSafe(
            {

            },
            {
                val result = pokeIndexAPINetwork.getPokemons()

                if (result.status == STATUS.SUCCESS) {

                    val results = result.data?.filter {
                        it.name.toUpperCase().contains(pokemon.toUpperCase()) || it.id.contains(pokemon)
                    }

                    pokemons.postValue(results)

                }

            }
        )
    }

}