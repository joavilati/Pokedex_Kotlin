package com.example.pokedexagoravai.util

class LiveDataResult<T>(val status: Status, val data: T? = null, val error: Throwable? = null, val code: Int? = null) {
    companion object {
        fun <T> success (data: T) = LiveDataResult<T>(status = Status.SUCCESS, data = data)
        fun <T> error(err: Throwable, code: Int? = null) = LiveDataResult<T>(
            status = Status.ERROR,
            data =  null,
            error = err,
            code = code
        )
        fun <T> loading() = LiveDataResult<T>(Status.LOADING)
    }
}