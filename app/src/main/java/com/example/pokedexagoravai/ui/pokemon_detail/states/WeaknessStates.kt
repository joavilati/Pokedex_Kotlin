package com.example.pokedexagoravai.ui.pokemon_detail.states

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.R
import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.ui.pokemon_detail.PokeWeaknessAdapter
import com.example.pokedexagoravai.ui.pokemon_detail.PokeWeaknessesViewHolder
import com.example.pokedexagoravai.util.buildAdapter

class WeaknessStates: PokemonStatesDetails {
    override val nextState: PokemonStatesDetails?
        get() = EvolutionsState()

    override fun getViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return PokeWeaknessesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_weaknesses,
                parent,
                false
            )
        )
    }

    override fun bind(pokemon: Pokemon, holder: RecyclerView.ViewHolder) {
       holder as PokeWeaknessesViewHolder
        buildAdapter(
            holder.recycler,
            PokeWeaknessAdapter(
                pokemon.weaknesses
            ),
            null,
            LinearLayoutManager(
                holder.itemView.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )

        )
    }
}