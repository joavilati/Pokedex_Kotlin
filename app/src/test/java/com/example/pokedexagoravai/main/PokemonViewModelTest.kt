package com.example.pokedexagoravai.main

import br.com.taglivros.extensions.Assertion
import br.com.taglivros.extensions.getOrAwaitValue
import com.example.pokedexagoravai.BaseTest
import com.example.pokedexagoravai.extensions.readJSON
import com.example.pokedexagoravai.model.Pokemon
import com.example.pokedexagoravai.repository.PokeRepository
import com.example.pokedexagoravai.retrofit.PokemonService
import com.example.pokedexagoravai.viewModel.PokemonViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import retrofit2.Response
import java.util.ArrayList

@ExperimentalCoroutinesApi
class PokemonViewModelTest: BaseTest() {

    lateinit var viewModel: PokemonViewModel

    override fun setup() {
        super.setup()
        val repository = PokeRepository()
        repository.service = mock(PokemonService::class.java)
        viewModel = PokemonViewModel(repository)
    }

    @Test
    fun `When getPokemons is called, it must return a list of pokemons`() = runBlocking {
        val response = Response.success(
            readJSON<List<Pokemon>>("PokemonsListJSON")
        )
        val expectedValue = Assertion(listPokemon)
        val notExpectedValue = Assertion(listPokemon2)
        `when`(
            viewModel.repository.service.getPokemons()
        ).thenReturn(response)

        viewModel.getPokemons()

        expectedValue isEqualTo viewModel.pokemons.getOrAwaitValue()
        notExpectedValue isDifferentFrom viewModel.pokemons.getOrAwaitValue()
    }

}
val listPokemon = listOf<Pokemon>(
    Pokemon(
        name = "Bulbasaur",
        id = "#001",
        imageurl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
        xdescription = "Bulbasaur can be seen napping in bright sunlight. There is a seed on its back. By soaking up the sun's rays, the seed grows progressively larger.",
        category = "Seed",
        typeofpokemon = arrayListOf("Grass", "Poison"),
        weaknesses = arrayListOf(
            "Fire",
            "Flying",
            "Ice",
            "Psychic"
        ),
        evolutions = arrayListOf(
            "#001",
            "#002",
            "#003"
        )
    ),
    Pokemon(
        name = "Ivysaur",
        id = "#002",
        imageurl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/002.png",
        xdescription = "There is a bud on this Pok\u00e9mon's back. To support its weight, Ivysaur's legs and trunk grow thick and strong. If it starts spending more time lying in the sunlight, it's a sign that the bud will bloom into a large flower soon.",
        category = "Seed",
        typeofpokemon = arrayListOf(
            "Grass",
            "Poison"
        ),
        weaknesses = arrayListOf(
            "Fire",
            "Flying",
            "Ice",
            "Psychic"
        ),
        evolutions = arrayListOf(
            "#001",
            "#002",
            "#003"
        )
    ),
    Pokemon(
        name = "Venusaur",
        id = "#003",
        imageurl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/003.png",
        xdescription = "There is a large flower on Venusaur's back. The flower is said to take on vivid colors if it gets plenty of nutrition and sunlight. The flower's aroma soothes the emotions of people.",
        category = "Seed",
        typeofpokemon = arrayListOf("Grass", "Poison"),
        weaknesses = arrayListOf(
            "Fire",
            "Flying",
            "Ice",
            "Psychic"
        ),
        evolutions = arrayListOf(
            "#001",
            "#002",
            "#003"
        )
    )
)

val listPokemon2 = listOf<Pokemon>(
    Pokemon(
        name = "Bulbasaur",
        id = "#001",
        imageurl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
        xdescription = "Bulbasaur can be seen napping in bright sunlight. There is a seed on its back. By soaking up the sun's rays, the seed grows progressively larger.",
        category = "Seed",
        typeofpokemon = arrayListOf("Grass", "Poison"),
        weaknesses = arrayListOf(
            "Fire",
            "Flying",
            "Ice",
            "Psychic"
        ),
        evolutions = arrayListOf(
            "#001",
            "#002",
            "#003"
        )
    ),
    Pokemon(
        name = "Ivysaur",
        id = "#002",
        imageurl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/002.png",
        xdescription = "There is a bud on this Pok\u00e9mon's back. To support its weight, Ivysaur's legs and trunk grow thick and strong. If it starts spending more time lying in the sunlight, it's a sign that the bud will bloom into a large flower soon.",
        category = "Seed",
        typeofpokemon = arrayListOf(
            "Grass",
            "Poison"
        ),
        weaknesses = arrayListOf(
            "Fire",
            "Flying",
            "Ice",
            "Psychic"
        ),
        evolutions = arrayListOf(
            "#001",
            "#002",
            "#003"
        )
    )
)