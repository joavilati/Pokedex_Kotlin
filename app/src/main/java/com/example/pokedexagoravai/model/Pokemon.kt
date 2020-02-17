package com.example.pokedexagoravai.model

import java.io.Serializable

data class Pokemon(
    val name :String,
    val id :String,
    val typeofpokemon: ArrayList<String>,
    val weaknesses : ArrayList<String>,
    val category :String,
    val evolutions: List<String>,
    val xdescription:String,
    val imageurl: String
) : Serializable {

    val cleanIdEvolution get():List<String> {
        return evolutions.map { id -> id.replace("#","") }
    }
    //TODO testar links
    val gifUrl get():String {
        var cleanName = name.replace("-","").replace(" ", "").replace(".","").replace("'","").toLowerCase()

        return "https://play.pokemonshowdown.com/sprites/xyani/$cleanName.gif"
    }

}