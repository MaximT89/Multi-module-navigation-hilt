package com.secondworld.core

import com.secondworld.core.base.Dispatchers
import com.secondworld.core.base.ResourceProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CoreModule {

    @Binds
    @Singleton
    abstract fun bindsResourceProvider(resourceProvider: ResourceProvider.Base) : ResourceProvider

    @Binds
    @Singleton
    abstract fun bindsDispatchers(dispatchers: Dispatchers.Base) : Dispatchers
}