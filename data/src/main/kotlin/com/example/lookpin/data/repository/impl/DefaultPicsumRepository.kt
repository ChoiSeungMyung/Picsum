package com.example.lookpin.data.repository.impl

import com.example.lookpin.data.remote.source.PicsumRemoteSource
import com.example.lookpin.data.repository.PicsumRepository
import com.example.lookpin.model.entity.Photo
import com.example.lookpin.model.mapper.toData
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultPicsumRepository @Inject constructor(
    private val remote: PicsumRemoteSource,
) : PicsumRepository {
    override fun getPicsumPhotos(): Flow<List<Photo>> {
        return remote
            .getPhotos()
            .map { photoResponse ->
                photoResponse
                    .map { it.toData() }
            }
    }
}
