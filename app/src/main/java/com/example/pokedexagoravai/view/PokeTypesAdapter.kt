package com.example.pokedexagoravai.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.R

class PokeTypesAdapter (
    private val types :ArrayList<String> = arrayListOf()
) :RecyclerView.Adapter<PokeTypesVyewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeTypesVyewHolder {
        return PokeTypesVyewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_type, parent, false)
        )
    }

    override fun getItemCount() = types.size


    override fun onBindViewHolder(holder: PokeTypesVyewHolder, position: Int) {
        val type = types[position]
        println("ninja $types")
        holder.bind(type)
    }


}