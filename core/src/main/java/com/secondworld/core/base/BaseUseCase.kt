package com.secondworld.core.base

import kotlinx.coroutines.flow.Flow

interface BaseUseCase<T> {

    suspend fun execute() : Flow<T>
}