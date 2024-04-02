package com.example.lookpin.data.remote.di

import com.example.lookpin.data.remote.source.PicsumRemoteSource
import com.example.lookpin.data.remote.source.impl.PicsumRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteSourceModule {

    @Binds
    @Singleton
    abstract fun bindPicsumRemoteSource(
        impl: PicsumRemoteSourceImpl,
    ): PicsumRemoteSource
}
