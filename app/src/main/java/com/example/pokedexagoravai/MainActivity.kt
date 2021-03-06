package com.example.pokedexagoravai

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexagoravai.extension.setVisible
import com.example.pokedexagoravai.repository.PokeRepository
import com.example.pokedexagoravai.ui.PokemonAdapter
import com.example.pokedexagoravai.viewModel.PokemonViewModel
import com.example.pokedexagoravai.viewModel.PokemonViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val pokemonIndexAdapter: PokemonAdapter by lazy {
        PokemonAdapter()
    }
    private val viewModel: PokemonViewModel by viewModels {
        PokemonViewModelFactory(this, PokeRepository(), intent.extras)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configAdapter()
        viewModel.getPokemons()
        setSupportActionBar(toolbar)
        registerObesrvers()
        searchPokemon()

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
            if(iv_psyduck.isVisible) {
                showPokemons(true)
            }
        })

        viewModel.pokemonsNotFound.observe(this, Observer { didntFind->
            if(recycler_main.isVisible && didntFind){
                showPokemons(false)
            }
        })
    }

    private fun showPokemons(show:Boolean) {
        recycler_main.setVisible(show)
        iv_psyduck.setVisible(!show)
    }

    private fun searchPokemon() {
        edit_text_search.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) { }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.getSpecificPokemon(edit_text_search.text.toString())
            }
        })
    }


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//
//        menuInflater.inflate(R.menu.menu_layout,menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(item.itemId == R.id.item_bar_search) Toast.makeText(this,"teste", Toast.LENGTH_SHORT).show()
//        return super.onOptionsItemSelected(item)
//    }

//    fun filterPokemon(pokemons: Pokemon, nameSearch:String){
//
//        val pokemonFound =
//    }


}