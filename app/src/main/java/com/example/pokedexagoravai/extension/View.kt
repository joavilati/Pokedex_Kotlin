package com.example.pokedexagoravai.extension

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE

fun View.setVisible(visible: Boolean) {
    if(visible) this.visibility = VISIBLE else this.visibility = GONE
}