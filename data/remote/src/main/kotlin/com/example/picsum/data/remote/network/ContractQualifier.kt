package com.example.picsum.data.remote.network

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class WriteTimeout

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ReadTimeout

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ConnectTimeout
