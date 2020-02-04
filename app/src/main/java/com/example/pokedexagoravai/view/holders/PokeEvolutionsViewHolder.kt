package com.example.pokedexagoravai.view.holders

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_image_evolutions.view.*

class PokeEvolutionsViewHolder (itemView : View) :RecyclerView.ViewHolder(itemView) {

    val imagem_evolucao : ImageView = itemView.item_image_evolution

    fun bind(id:String){
        val url = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/$id.png"
        Glide.with(itemView.context).load(url).into(imagem_evolucao)
    }
}