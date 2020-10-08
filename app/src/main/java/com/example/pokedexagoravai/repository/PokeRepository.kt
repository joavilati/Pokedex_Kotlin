package com.example.pokedexagoravai.repository

import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.network.LiveDataNetworking
import com.example.pokedexagoravai.network.PokeIndexController
import com.example.pokedexagoravai.retrofit.PokemonService
import com.example.pokedexagoravai.util.LiveDataResult
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import java.lang.Exception

class PokeRepository {

    var service = PokeIndexController.retrofit.create(PokemonService::class.java)

    suspend fun getPokemons(listener: (LiveDataResult<List<Pokemon>>) -> Unit) {
        withContext(IO) {
            try{
                val request = service.getPokemons()
                val response = LiveDataNetworking.request(request)
                listener(response)
            } catch (e: Exception) {
                listener(LiveDataResult.error(e))
            }
        }

    }
}

