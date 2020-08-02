package com.example.pokedexagoravai.ui.pokemon_detail


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.ui.pokemon_detail.states.HeaderState
import com.example.pokedexagoravai.ui.pokemon_detail.states.PokemonStatesDetails


class PokeDetailAdapter(val pokemon: Pokemon) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var viewsState: PokemonStatesDetails = HeaderState()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return viewsState.getViewHolder(parent)
    }

    override fun getItemCount(): Int = 4

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        viewsState.bind(pokemon, holder)
        viewsState.nextState?.let {
            viewsState = it
        }
    }
}