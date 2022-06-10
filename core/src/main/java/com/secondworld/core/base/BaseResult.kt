package com.secondworld.core.base

sealed class BaseResult<out T : Any , out R : Any> {
    class Success<T : Any>(val data: T) : BaseResult<T, Nothing>()
    class Error<R : Any>(val err : R) : BaseResult<Nothing, R>()
}