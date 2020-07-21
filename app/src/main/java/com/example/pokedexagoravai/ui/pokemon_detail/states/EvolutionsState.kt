package com.example.pokedexagoravai.ui.pokemon_detail.states

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.R
import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.ui.pokemon_detail.PokeEvolutionSectionViewHolder
import com.example.pokedexagoravai.ui.pokemon_detail.PokeEvolutionsAdapter
import com.example.pokedexagoravai.util.buildAdapter

class EvolutionsState : PokemonStatesDetails {
    override val nextState: PokemonStatesDetails?
        get() = null

    override fun getViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return PokeEvolutionSectionViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_evolution,
                parent,
                false
            )
        )
    }

    override fun bind(pokemon: Pokemon, holder: RecyclerView.ViewHolder) {
        holder as PokeEvolutionSectionViewHolder
        buildAdapter(
            holder.recycler,
            PokeEvolutionsAdapter(
                pokemon.cleanIdEvolution
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