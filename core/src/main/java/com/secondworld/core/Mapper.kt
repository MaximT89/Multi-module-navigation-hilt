package com.secondworld.core

interface Mapper<T, R> {

    fun map(data : T) : R
}