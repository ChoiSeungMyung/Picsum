package com.example.picsum.data.remote.source.impl

import com.example.picsum.data.remote.service.PhotoService
import com.example.picsum.data.remote.source.PhotoRemoteSource
import com.example.picsum.model.response.PhotoResponse
import javax.inject.Inject

class PhotoRemoteSourceImpl
    @Inject
    constructor(
        private val service: PhotoService,
    ) : PhotoRemoteSource {
        override suspend fun getPhotos(): List<PhotoResponse> =
            service.getPhotos()
    }
