package com.example.pokedexagoravai.ui.pokemon_detail

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.util.colorTypeByID
import kotlinx.android.synthetic.main.item_pokemon_detail_header.view.*

class PokeHeaderDetailsViewHolder (itemView :View) :RecyclerView.ViewHolder(itemView){
    val recycler = itemView.recycler_types
    fun bind(pokemon : Pokemon){
        itemView.text_name_pokemon_detail.text = pokemon.name
        Glide.with(itemView).load(pokemon.gifUrl).into(itemView.image_pokemon_detail)
        itemView.card_pokemon_detail.setCardBackgroundColor(ContextCompat.getColor(
            itemView.context, colorTypeByID.get(pokemon.typeofpokemon[0]) ?: 0)
        )
    }
}