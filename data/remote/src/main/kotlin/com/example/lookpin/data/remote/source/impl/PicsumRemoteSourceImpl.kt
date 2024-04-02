package com.example.lookpin.data.remote.source.impl

import com.example.lookpin.data.remote.service.PicsumService
import com.example.lookpin.data.remote.source.PicsumRemoteSource
import com.example.lookpin.model.response.PhotoResponse
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PicsumRemoteSourceImpl @Inject constructor(
    private val service: PicsumService,
) : PicsumRemoteSource {
    override fun getPhotos(): Flow<List<PhotoResponse>> = flow {
        emit(service.getPicsumList())
    }

}
