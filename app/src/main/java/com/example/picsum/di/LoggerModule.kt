package com.example.picsum.di

import android.content.Context
import com.example.picsum.R
import com.example.picsum.logger.TimberTree
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import timber.log.Timber

@Module
@InstallIn(SingletonComponent::class)
object LoggerModule {
    @Provides
    @Singleton
    fun provideTimberTree(
        @ApplicationContext context: Context,
    ): Timber.Tree {
        return TimberTree(context.getString(R.string.app_name))
    }
}
