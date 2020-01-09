package com.example.pokedexagoravai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexagoravai.network.PokeApi
import com.example.pokedexagoravai.util.getFactory
import com.example.pokedexagoravai.view.PokemonAdapter
import com.example.pokedexagoravai.viewModel.PokemonViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val pokemonIndexAdapter: PokemonAdapter by lazy {
        PokemonAdapter()
    }

    private val viewModel: PokemonViewModel by lazy {
        ViewModelProviders.of(this, getFactory(PokemonViewModel(PokeApi()))).get(PokemonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configAdapter()
        registerObesrvers()
        viewModel.getPokemons()


    }


    private fun configAdapter(){
        val layoutManager = LinearLayoutManager(this)

        recycler_main.layoutManager = layoutManager
        recycler_main.setHasFixedSize(true)
        recycler_main.adapter = pokemonIndexAdapter

    }
    fun registerObesrvers(){
        viewModel.pokemons.observe(this, Observer { pokemons ->
            pokemonIndexAdapter.addPokemons(pokemons ?: return@Observer)
        })
    }


}