package com.example.lookpin.data.remote.source

import com.example.lookpin.model.response.PhotoResponse

interface PhotoRemoteSource {

    suspend fun getPhotos(): List<PhotoResponse>
}
