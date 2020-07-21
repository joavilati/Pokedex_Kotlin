package com.example.pokedexagoravai.ui.pokemon_detail.states

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.model.Pokemon

interface PokemonStatesDetails {
    val nextState:PokemonStatesDetails?

    fun getViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun bind(pokemon: Pokemon, holder: RecyclerView.ViewHolder)

}