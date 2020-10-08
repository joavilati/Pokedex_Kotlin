package com.example.pokedexagoravai.extensions

import com.google.gson.Gson

inline fun <reified T> Any.readJSON(fileName: String) = Gson().fromJson<T>(readJSONRaw(fileName))!!

fun Any.readJSONRaw(fileName: String) = javaClass.classLoader!!.getResourceAsStream("json/${if (fileName.endsWith(".json")) fileName else "$fileName.json"}").bufferedReader().use { it.readText() }


