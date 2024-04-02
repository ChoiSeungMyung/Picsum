package com.example.lookpin.data.di

import com.example.lookpin.data.repository.PicsumRepository
import com.example.lookpin.data.repository.impl.DefaultPicsumRepository
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
    abstract fun bindPicsumRepository(
        impl: DefaultPicsumRepository,
    ): PicsumRepository
}
