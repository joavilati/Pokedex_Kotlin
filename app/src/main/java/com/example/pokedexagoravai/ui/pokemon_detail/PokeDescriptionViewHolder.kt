package com.example.pokedexagoravai.ui.pokemon_detail

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.model.Pokemon
import kotlinx.android.synthetic.main.item_description.view.*

class PokeDescriptionViewHolder (itemView : View) :RecyclerView.ViewHolder(itemView) {

    fun bind(pokemon: Pokemon) {
        itemView.text_description.text = pokemon.xdescription
    }
}