package com.secondworld.core.base

sealed class BaseResult<out T, out R> {
    class Success<T>(val data: T) : BaseResult<T, Nothing>()
    class Error<R>(val err: R) : BaseResult<Nothing, R>()
}