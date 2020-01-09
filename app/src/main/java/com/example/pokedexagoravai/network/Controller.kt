package com.example.pokedexagoravai.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokeIndexController {

    private const val url = "https://gist.githubusercontent.com/mrcsxsiq/b94dbe9ab67147b642baa9109ce16e44/raw/97811a5df2df7304b5bc4fbb9ee018a0339b8a38/"

    val retrofit = Retrofit.Builder().
        baseUrl(url).
        addConverterFactory(GsonConverterFactory.create()).
        build()


}