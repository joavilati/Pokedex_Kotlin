package com.example.pokedexagoravai.network
import com.example.pokedexagoravai.exception.FailureResponseException
import com.example.pokedexagoravai.util.LiveDataResult
import retrofit2.Response

object LiveDataNetworking {
  fun <T> request(response: Response<T>): LiveDataResult<T> {
    return try {

      val body = response.body()

      if (response.isSuccessful && body != null) {
        LiveDataResult.success(body)
      } else {
        LiveDataResult.error(FailureResponseException(), response.code())
      }
    } catch (e: Exception) {
      LiveDataResult.error(e, response.code())
    }
  }

  fun <T> requestWithoutResponse(response: Response<T>): LiveDataResult<Void?> {
    return try {
      if (response.isSuccessful) {
        LiveDataResult.success(null)
      } else {
        LiveDataResult.error(FailureResponseException())
      }
    } catch (e: Exception) {
      LiveDataResult.error(e)
    }
  }
}