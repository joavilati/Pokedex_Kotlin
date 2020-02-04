package com.example.pokedexagoravai.view.holders

import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedexagoravai.util.drawableTypeByID
import kotlinx.android.synthetic.main.item_type_weakeness.view.*

class PokeWeaknessViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val imageWeakness = itemView.image_weakeness_item
    fun bind(type:String){
        Log.i("Drawble", drawableTypeByID.get(type).toString())
        Log.i("Drawble", type)
        imageWeakness.setImageDrawable(
            ContextCompat.
                getDrawable(itemView.context,drawableTypeByID.get(type)?:0)
        )
    }
}