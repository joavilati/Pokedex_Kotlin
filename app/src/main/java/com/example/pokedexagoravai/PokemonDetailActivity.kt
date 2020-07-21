package com.example.pokedexagoravai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.ui.pokemon_detail.PokeDetailAdapter
import kotlinx.android.synthetic.main.activity_pokemon_detail.*

const val EXTRA_POKEMON = "com.example.pokedexagoravai.POKEMON"
class PokemonDetailActivity : AppCompatActivity() {

    val pokeDetailAdapter: PokeDetailAdapter by lazy {
        PokeDetailAdapter(pokemon)
    }

    val pokemon: Pokemon by lazy{
            intent.extras?.getSerializable(EXTRA_POKEMON) as Pokemon
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)

        configAdapters()
        configToolbar()

    }

    private fun configToolbar() {
        setSupportActionBar(toolbar_details)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun configAdapters(){

        val layoutManager = LinearLayoutManager(this)
        recycler_details.layoutManager = layoutManager
        recycler_details.adapter = pokeDetailAdapter

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> onBackPressed()

        }
        return super.onOptionsItemSelected(item)
    }


}
