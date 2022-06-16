package com.secondworld.core

import com.secondworld.core.base.Dispatchers
import com.secondworld.core.base.ResourceProvider
import com.secondworld.core.base.ResponseWrapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CoreModule {

    @Binds
    abstract fun bindsResourceProvider(resourceProvider: ResourceProvider.Base) : ResourceProvider

    @Binds
    abstract fun bindsDispatchers(dispatchers: Dispatchers.Base) : Dispatchers

    @Binds
    abstract fun bindsResponseWrapper(responseWrapper: ResponseWrapper.Base) : ResponseWrapper
}