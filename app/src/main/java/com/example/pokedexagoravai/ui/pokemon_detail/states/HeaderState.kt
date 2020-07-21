package com.example.pokedexagoravai.ui.pokemon_detail.states

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.R
import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.ui.pokemon_detail.PokeHeaderDetailsViewHolder
import com.example.pokedexagoravai.ui.pokemon_detail.PokeTypesAdapter
import com.example.pokedexagoravai.util.buildAdapter

class HeaderState : PokemonStatesDetails {
    override val nextState: PokemonStatesDetails?
        get() = DescriptionState()

    override fun getViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return PokeHeaderDetailsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_pokemon_detail_header,
                parent,
                false
            )
        )
    }


    override fun bind(pokemon: Pokemon, holder: RecyclerView.ViewHolder) {
        holder as PokeHeaderDetailsViewHolder
        holder.bind(pokemon)

        buildAdapter(
            holder.recycler,
            PokeTypesAdapter(
                pokemon.typeofpokemon
            ),
            null,
            LinearLayoutManager(holder.itemView.context)
        )
    }

}