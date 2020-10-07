package com.example.pokedexagoravai.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedexagoravai.R
import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.ui.pokemonDetail.EXTRA_POKEMON
import com.example.pokedexagoravai.ui.pokemonDetail.PokemonDetailActivity

import com.example.pokedexagoravai.util.colorTypeByID
import kotlinx.android.synthetic.main.item_pokemon.view.*

class PokemonAdapter(
    private val pokes: ArrayList<Pokemon> = arrayListOf()
) : RecyclerView.Adapter<PokemonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return pokes.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(pokes[position])
    }

    fun addPokemons(newPokemons: List<Pokemon>) {
        pokes.clear()
        pokes.addAll(newPokemons)
        notifyDataSetChanged()
    }

}

class PokemonViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    private val namePokemon : TextView = itemView.findViewById(R.id.text_nameP_pokemon)
    private val imagePokemon : ImageView = itemView.findViewById(R.id.image_indice)
    private val idPokemon: TextView = itemView.findViewById(R.id.text_id_pokemon)
    private  val cardPokemon : CardView = itemView.findViewById(R.id.card_item_indice_pokemon)


    fun bind(pokemon: Pokemon){

        namePokemon.text = pokemon.name
        idPokemon.text = "${pokemon.id} "
        Glide.with(itemView.context).load(pokemon.imageurl).into(imagePokemon)

        cardPokemon.setCardBackgroundColor(ContextCompat.getColor(itemView.context, colorTypeByID.get(pokemon.typeofpokemon[0]) ?: 0))
        namePokemon.setTextColor(ContextCompat.getColor(itemView.context, R.color.default_color))


        itemView.constraint_item_indice.setOnClickListener {
            println(pokemon.gifUrl)
            launchDetailScreen(pokemon)

        }
    }
    private fun launchDetailScreen( pokemon :Pokemon){
        val intent = Intent(itemView.context, PokemonDetailActivity::class.java)
        intent.putExtra(EXTRA_POKEMON,pokemon)
        itemView.context.startActivity(intent)
    }
}