package com.secondworld.singleuser.data.module

import com.secondworld.singleuser.data.SingleUserRepositoryImpl
import com.secondworld.singleuser.domain.repository.SingleUserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsSingleUserRepository(singleUserRepositoryImpl: SingleUserRepositoryImpl) :
            SingleUserRepository
}