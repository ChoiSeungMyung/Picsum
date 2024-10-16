package com.example.picsum.di

import android.content.Context
import com.example.picsum.R
import com.example.picsum.data.remote.network.BaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @BaseUrl
    @Provides
    fun provideBaseUrl(
        @ApplicationContext context: Context,
    ): String = context.getString(R.string.base_url)
}
