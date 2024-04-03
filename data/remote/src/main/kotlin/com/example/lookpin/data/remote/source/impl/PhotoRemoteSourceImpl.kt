package com.example.lookpin.data.remote.source.impl

import com.example.lookpin.data.remote.service.PhotoService
import com.example.lookpin.data.remote.source.PhotoRemoteSource
import com.example.lookpin.model.response.PhotoResponse
import javax.inject.Inject

class PhotoRemoteSourceImpl @Inject constructor(
    private val service: PhotoService,
) : PhotoRemoteSource {
    override suspend fun getPhotos(): List<PhotoResponse> =
        service.getPhotos()

}
