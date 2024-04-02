package com.example.lookpin.data.remote.di

import com.example.lookpin.data.remote.service.PicsumService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun providePicsumService(
        retrofit: Retrofit,
    ): PicsumService = retrofit.create(PicsumService::class.java)
}
