package com.example.pokedexagoravai.network

import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.util.LiveDataResult
import retrofit2.Response
import retrofit2.http.GET

class PokeApi {

    private val api = PokeIndexController.retrofit.create(PokeIndexAPI::class.java)

    suspend fun getPokemons(): LiveDataResult<ArrayList<Pokemon>> {

        val request = api.getPokemons()

        return DefaultNetworking.request(request)

    }
}

interface PokeIndexAPI{
    @GET("pokemon.json")
    suspend fun getPokemons() : Response<ArrayList<Pokemon>>
}