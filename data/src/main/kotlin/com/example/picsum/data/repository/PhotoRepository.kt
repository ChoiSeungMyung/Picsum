package com.example.picsum.data.repository

import com.example.picsum.model.entity.Photo
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {
    fun photos(): Flow<List<Photo>>

    suspend fun refresh()

    fun updatePhotos(list: List<Photo>)

    fun getPhotoById(id: String): Flow<Photo?>

    fun updatePhoto(photo: Photo)
}
