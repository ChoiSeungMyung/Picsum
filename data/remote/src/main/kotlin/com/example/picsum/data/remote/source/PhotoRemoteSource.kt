package com.example.picsum.data.remote.source

import com.example.picsum.model.response.PhotoResponse

interface PhotoRemoteSource {
    suspend fun getPhotos(): List<PhotoResponse>
}
