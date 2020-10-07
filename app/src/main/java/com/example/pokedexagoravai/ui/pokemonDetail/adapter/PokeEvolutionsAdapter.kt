package com.example.pokedexagoravai.ui.pokemonDetail.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedexagoravai.R
import kotlinx.android.synthetic.main.item_image_evolutions.view.*

class PokeEvolutionsAdapter (
    val evolutionsIds :List<String> = arrayListOf()
) :RecyclerView.Adapter<PokeEvolutionsViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeEvolutionsViewHolder {
        return PokeEvolutionsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_image_evolutions,
                parent,
                false
            )
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

class PokeEvolutionsViewHolder (itemView : View) :RecyclerView.ViewHolder(itemView) {

    val imagem_evolucao : ImageView = itemView.item_image_evolution

    fun bind(id:String){
        val url = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/$id.png"
        Glide.with(itemView.context).load(url).into(imagem_evolucao)
    }
}