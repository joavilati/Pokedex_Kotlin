package com.example.pokedexagoravai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedexagoravai.network.PokeApi
import com.example.pokedexagoravai.util.getFactory
import com.example.pokedexagoravai.ui.pokemon_list.PokemonAdapter
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
        setSupportActionBar(toolbar)
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
        })
    }

    private fun searchPokemon() {
        edit_text_search.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) { }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.getEspecificPokemon(edit_text_search.text.toString())
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