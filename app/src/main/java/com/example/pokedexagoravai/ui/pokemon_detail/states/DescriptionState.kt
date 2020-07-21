package com.example.pokedexagoravai.ui.pokemon_detail.states

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.R
import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.ui.pokemon_detail.PokeDescriptionViewHolder

class DescriptionState : PokemonStatesDetails {
    override val nextState: PokemonStatesDetails?
        get() = WeaknessStates()

    override fun getViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return PokeDescriptionViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_description,
                parent,
                false
            )
        )
    }

    override fun bind(pokemon: Pokemon,holder: RecyclerView.ViewHolder) {
        val viewHolder = holder as PokeDescriptionViewHolder
        viewHolder.bind(pokemon)
    }

}