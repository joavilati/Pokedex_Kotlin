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

    val pokemons = MutableLiveData<ArrayList<Pokemon>>()

    fun getPokemons() {
        CoroutineScope(Dispatchers.IO).launchSafe(
            {
                println("nao sei oq ta acontecendo")
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

}