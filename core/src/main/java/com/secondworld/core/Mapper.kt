package com.secondworld.core

interface Mapper {

    interface Data<T, R> : Mapper {
        fun map(data: T): R
    }
}