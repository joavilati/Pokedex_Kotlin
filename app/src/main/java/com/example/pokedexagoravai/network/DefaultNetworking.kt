package com.example.pokedexagoravai.network

import com.example.pokedexagoravai.util.LiveDataResult
import retrofit2.Response
import java.lang.RuntimeException

object DefaultNetworking {
    fun <T> request(response: Response<T>) : LiveDataResult<T> {
        return try {
            val body = response.body()
            if (response.isSuccessful && body != null) {
                LiveDataResult.success(body)
            } else {
                LiveDataResult.error(RuntimeException())
            }
        } catch (e: Exception) {
            LiveDataResult.error(e)
        }
    }
}
