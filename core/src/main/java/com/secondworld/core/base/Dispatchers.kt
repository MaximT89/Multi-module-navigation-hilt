package com.secondworld.core.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface Dispatchers {

    fun launchUI(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit) : Job
    fun launchBackground(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit) : Job
    suspend fun changeToUI(block: suspend CoroutineScope.() -> Unit)

    class Base @Inject constructor() : Dispatchers {
        override fun launchUI(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit) =
            scope.launch(kotlinx.coroutines.Dispatchers.Main, block = block)

        override fun launchBackground(scope: CoroutineScope, block: suspend CoroutineScope.() -> Unit) =
            scope.launch(kotlinx.coroutines.Dispatchers.IO, block = block)

        override suspend fun changeToUI(block: suspend CoroutineScope.() -> Unit) =
            withContext(kotlinx.coroutines.Dispatchers.Main, block)
    }
}