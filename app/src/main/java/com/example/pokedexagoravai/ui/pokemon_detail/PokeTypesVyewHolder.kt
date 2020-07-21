package com.example.pokedexagoravai.ui.pokemon_detail

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.util.colorTypeByID
import kotlinx.android.synthetic.main.item_type.view.*

class PokeTypesVyewHolder (itemView : View) :RecyclerView.ViewHolder(itemView){

    val typeText = itemView.text_type_1

    fun bind(type:String){
        println("ninja $type")
        typeText.text = type
        typeText.setTextColor(ContextCompat.getColor(itemView.context, colorTypeByID.get(type)?:0))
    }
}