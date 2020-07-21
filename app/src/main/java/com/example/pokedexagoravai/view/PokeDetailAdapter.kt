package com.example.pokedexagoravai.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.R
import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.util.buildAdapter
import com.example.pokedexagoravai.view.holders.*
import java.lang.RuntimeException
import kotlin.math.log

private const val ITEM_HEADER = 0
private const val ITEM_DESCRIPTION = 1
private const val ITEM_WEAKNESS =2
private const val ITEM_EVOLUTION = 3


class PokeDetailAdapter (val pokemon: Pokemon) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    val typeViewPool = RecyclerView.RecycledViewPool()
    val evolutionsViewPool = RecyclerView.RecycledViewPool()
    val weakenessesViewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            ITEM_HEADER -> PokeHeaderDetailsViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_pokemon_detail_header,
                    parent,
                    false
                )
            )
            ITEM_DESCRIPTION -> PokeDescriptionViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_description,
                    parent,
                    false
                )
            )
            ITEM_WEAKNESS-> PokeWeaknessesViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_weaknesses,
                    parent,
                    false
                )
            )
            ITEM_EVOLUTION -> PokeEvolutionSectionViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_evolution,
                    parent,
                    false
                )
            )
            else -> throw RuntimeException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> ITEM_HEADER
            1 -> ITEM_DESCRIPTION
            2 -> ITEM_WEAKNESS
            else -> ITEM_EVOLUTION
        }
    }

    override fun getItemCount(): Int = 4

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder.itemViewType) {
            ITEM_HEADER -> {
                val viewHolder = holder as PokeHeaderDetailsViewHolder
                viewHolder.bind(pokemon)

                buildAdapter(
                    viewHolder.recycler,
                    PokeTypesAdapter(pokemon.typeofpokemon),
                    null,
                    LinearLayoutManager(holder.itemView.context),
                    typeViewPool
                )
            }
            ITEM_DESCRIPTION -> {
                val viewHolder = holder as PokeDescriptionViewHolder
                viewHolder.bind(pokemon)
            }
            ITEM_WEAKNESS -> {
                val viewHolder = holder as PokeWeaknessesViewHolder

                buildAdapter(
                    viewHolder.recycler,
                    PokeWeaknessAdapter(pokemon.weaknesses),
                    null,
                    LinearLayoutManager(
                        holder.itemView.context,
                        LinearLayoutManager.HORIZONTAL,
                        false),
                    weakenessesViewPool

                )
            }
            ITEM_EVOLUTION -> {
                val viewHolder = holder as PokeEvolutionSectionViewHolder

                buildAdapter(
                    viewHolder.recycler,
                    PokeEvolutionsAdapter(pokemon.cleanIdEvolution),
                    null,
                    LinearLayoutManager(holder.itemView.context,LinearLayoutManager.HORIZONTAL,false),
                    evolutionsViewPool
                )
            }
        }
    }
}