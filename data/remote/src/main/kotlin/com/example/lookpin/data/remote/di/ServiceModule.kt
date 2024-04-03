package com.example.lookpin.data.remote.di

import com.example.lookpin.data.remote.service.PhotoService
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
    fun providePhotoService(
        retrofit: Retrofit,
    ): PhotoService = retrofit.create(PhotoService::class.java)
}
