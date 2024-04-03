package com.example.lookpin.data.remote.di

import com.example.lookpin.data.remote.source.PhotoRemoteSource
import com.example.lookpin.data.remote.source.impl.PhotoRemoteSourceImpl
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
    abstract fun bindPhotoRemoteSource(
        impl: PhotoRemoteSourceImpl,
    ): PhotoRemoteSource
}
