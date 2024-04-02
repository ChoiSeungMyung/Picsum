package com.example.lookpin.data.remote.source

import com.example.lookpin.model.response.PhotoResponse
import kotlinx.coroutines.flow.Flow

interface PicsumRemoteSource {

    fun getPhotos(): Flow<List<PhotoResponse>>
}
