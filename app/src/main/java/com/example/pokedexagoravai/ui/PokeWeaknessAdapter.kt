package com.example.pokedexagoravai.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.R
import com.example.pokedexagoravai.util.drawableTypeByID
import kotlinx.android.synthetic.main.item_type_weakeness.view.*

class PokeWeaknessAdapter (
    val typesweaknesses: ArrayList<String> = arrayListOf()
): RecyclerView.Adapter<PokeWeaknessItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeWeaknessItemViewHolder {
        return PokeWeaknessItemViewHolder(
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

    override fun onBindViewHolder(holderItem: PokeWeaknessItemViewHolder, position: Int) {
        val typeWeakness = typesweaknesses[position]
        holderItem.bind(typeWeakness)
    }

}

class PokeWeaknessItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val imageWeakness = itemView.image_weakeness_item
    fun bind(type:String){
        Log.i("Drawble", drawableTypeByID.get(type).toString())
        Log.i("Drawble", type)
        imageWeakness.setImageDrawable(
            ContextCompat.
            getDrawable(itemView.context, drawableTypeByID.get(type)?:0)
        )
    }
}