package com.example.pokedexagoravai.view

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.util.colorTypeByID
import com.example.symbol_pokedexagoravai.util.drawableSymbolTypeByID
import kotlinx.android.synthetic.main.item_type.view.*

class PokeTypesVyewHolder (itemView : View) :RecyclerView.ViewHolder(itemView){

    val typeText = itemView.text_type_1
    val imageType = itemView.image_type

    fun bind(type:String){
        println("ninja $type")
        typeText.text = type
        typeText.setTextColor(ContextCompat.getColor(itemView.context, colorTypeByID.get(type)?:0))
        imageType.setImageDrawable(ContextCompat.getDrawable(itemView.context,drawableSymbolTypeByID.get(type)?:0))
        imageType.visibility = View.VISIBLE
    }
}