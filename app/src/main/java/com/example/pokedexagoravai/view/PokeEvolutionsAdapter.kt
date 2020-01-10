package com.example.pokedexagoravai.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.R

class PokeEvolutionsAdapter (
    val evolutionsIds :List<String> = arrayListOf()
) :RecyclerView.Adapter<PokeEvolutionsViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeEvolutionsViewHolder {
        return PokeEvolutionsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_image_evolutions,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return evolutionsIds.size
    }

    override fun onBindViewHolder(holder: PokeEvolutionsViewHolder, position: Int) {
        val evolutionId = evolutionsIds[position]
        holder.bind(evolutionId)
    }

}
