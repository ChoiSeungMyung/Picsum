package com.example.lookpin.data.di

import com.example.lookpin.data.repository.PhotoRepository
import com.example.lookpin.data.repository.impl.DefaultPhotoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    @Singleton
    abstract fun bindPhotoRepository(
        impl: DefaultPhotoRepository,
    ): PhotoRepository
}
