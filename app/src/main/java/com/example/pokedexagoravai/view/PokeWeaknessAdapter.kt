package com.example.pokedexagoravai.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.R
import com.example.pokedexagoravai.view.holders.PokeWeaknessViewHolder

class PokeWeaknessAdapter (
    val typesweaknesses: ArrayList<String> = arrayListOf()
): RecyclerView.Adapter<PokeWeaknessViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeWeaknessViewHolder {
        return PokeWeaknessViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_type_weakeness,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return  typesweaknesses.size
    }

    override fun onBindViewHolder(holder: PokeWeaknessViewHolder, position: Int) {
        val typeWeakness = typesweaknesses[position]
        holder.bind(typeWeakness)
    }

}