package com.example.pokedexagoravai.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.R
import com.example.pokedexagoravai.util.colorTypeByID
import kotlinx.android.synthetic.main.item_type.view.*

class PokeTypesAdapter (
    private val types :ArrayList<String> = arrayListOf()
) :RecyclerView.Adapter<PokeTypesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeTypesViewHolder {
        return PokeTypesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_type, parent, false)
        )
    }

    override fun getItemCount() = types.size

    override fun onBindViewHolder(holder: PokeTypesViewHolder, position: Int) {
        val type = types[position]
        holder.bind(type)
    }
}

class PokeTypesViewHolder (itemView : View) :RecyclerView.ViewHolder(itemView){

    val typeText = itemView.text_type_1

    fun bind(type:String){
        println("ninja $type")
        typeText.text = type
        typeText.setTextColor(ContextCompat.getColor(itemView.context, colorTypeByID.get(type)?:0))
    }
}