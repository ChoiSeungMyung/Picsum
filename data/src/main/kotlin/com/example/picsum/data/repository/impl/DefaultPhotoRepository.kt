package com.example.picsum.data.repository.impl

import com.example.picsum.data.remote.source.PhotoRemoteSource
import com.example.picsum.data.repository.PhotoRepository
import com.example.picsum.model.entity.Photo
import com.example.picsum.model.mapper.toData
import javax.inject.Inject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onStart

class DefaultPhotoRepository
    @Inject
    constructor(
        private val remote: PhotoRemoteSource,
    ) : PhotoRepository {
        private val photosStateFlow =
            MutableStateFlow<List<Photo>>(emptyList())

        override fun photos(): Flow<List<Photo>> {
            return photosStateFlow.onStart {
                if (photosStateFlow.value.isEmpty()) {
                    refresh()
                }
            }
        }

        override suspend fun refresh() {
            photosStateFlow.value = emptyList()
            remote
                .getPhotos()
                .map { photoResponse ->
                    photoResponse.toData()
                }
                .let {
                    photosStateFlow.value = it
                }
        }

        @OptIn(ExperimentalCoroutinesApi::class)
        override fun getPhotoById(id: String): Flow<Photo?> =
            photosStateFlow.mapLatest { list ->
                list.firstOrNull { it.id == id }
            }

        override fun updatePhotos(list: List<Photo>) {
            photosStateFlow.value = list
        }

        override fun updatePhoto(photo: Photo) {
            photosStateFlow.getAndUpdate { list ->
                list.map {
                    if (it.id == photo.id) {
                        photo
                    } else {
                        it
                    }
                }
            }
        }
    }
