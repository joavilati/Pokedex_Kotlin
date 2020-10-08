package com.example.pokedexagoravai.retrofit

import com.example.pokedexagoravai.model.Pokemon
import retrofit2.Response
import retrofit2.http.GET

interface PokemonService{
    @GET("pokemon.json")
    suspend fun getPokemons() : Response<List<Pokemon>>
}