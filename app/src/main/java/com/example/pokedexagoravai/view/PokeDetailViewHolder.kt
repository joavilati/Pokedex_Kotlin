package com.example.pokedexagoravai.view

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.pokedexagoravai.R
import com.example.pokedexagoravai.model.Pokemon
import kotlinx.android.synthetic.main.activity_pokemon_detail.view.*

class PokeDetailViewHolder (itemView: View): View(itemView.context){

    val namePokemon :TextView = itemView.text_name_pokemon_detail
    val gifPokemon :ImageView = itemView.image_pokemon_detail
    val description :TextView = itemView.text_description_pokemon_details

    fun bind(pokemon:Pokemon){
        namePokemon.text = pokemon.name
        description.text = pokemon.xdescription
        Glide.with(this.context).load(pokemon.gifUrl).into(gifPokemon)
    }
}