package com.secondworld.singleuser.data.module

import com.secondworld.singleuser.data.remote.api.SingleUserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    @Singleton
    fun provideSingleUserApi(retrofit: Retrofit) : SingleUserApi = retrofit.create(SingleUserApi::class.java)
}