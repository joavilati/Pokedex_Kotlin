package com.example.pokedexagoravai

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.view.PokeDetailViewHolder
import com.example.pokedexagoravai.view.PokeEvolutionsAdapter
import com.example.pokedexagoravai.view.PokeTypesAdapter
import kotlinx.android.synthetic.main.activity_pokemon_detail.*

const val EXTRA_POKEMON = "com.example.pokedexagoravai.POKEMON"
class PokemonDetailActivity : AppCompatActivity() {

    val pokeEvolutionsAdapter : PokeEvolutionsAdapter by lazy {
        PokeEvolutionsAdapter(pokemon.cleanIdEvolution)
    }

    val pokeTypesAdapter : PokeTypesAdapter by lazy {
        PokeTypesAdapter(pokemon.typeofpokemon)
    }

    val pokemon: Pokemon by lazy{
            intent.extras?.getSerializable(EXTRA_POKEMON) as Pokemon
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)

        bind()
        configAdapters()

    }

    private fun bind(){
        text_name_pokemon_detail.text = pokemon.name
        text_description_pokemon_details.text = pokemon.xdescription
        Glide.with(this).load(pokemon.gifUrl).into(image_pokemon_detail)

    }

    private fun configAdapters(){
        configTypesAdapter()
        configEvolutionsAdapter()
    }

    private fun configTypesAdapter() {
        val layoutManager = LinearLayoutManager(this)
        recycler_types.layoutManager = layoutManager
        recycler_types.setHasFixedSize(true)
        recycler_types.adapter = pokeTypesAdapter
    }
    private fun configEvolutionsAdapter(){

        val layoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        recycler_evolutions.layoutManager = layoutManager
        recycler_evolutions.setHasFixedSize(true)
        recycler_evolutions.adapter = pokeEvolutionsAdapter

        if (pokemon.evolutions.size > 1) {

            text_evolution_label_pokemon_detail.visibility = View.VISIBLE
            recycler_evolutions.visibility = View.VISIBLE

        }
    }


}
