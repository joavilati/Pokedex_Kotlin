package com.example.pokedexagoravai.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.R
import com.example.pokedexagoravai.model.Pokemon

class PokemonAdapter(
    private val pokes: ArrayList<Pokemon> = arrayListOf()
) : RecyclerView.Adapter<PokemonViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon,parent, false)
        )
    }

    override fun getItemCount(): Int {
        return pokes.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokes[position]
        holder.bind(pokemon)
    }


    fun addPokemons(newPokemons:ArrayList<Pokemon>){
        pokes.clear()
        pokes.addAll(newPokemons)
        notifyDataSetChanged()
    }


    
}