package com.example.lookpin.data.repository

import com.example.lookpin.model.entity.Photo
import kotlinx.coroutines.flow.Flow

interface PicsumRepository {

    fun getPicsumPhotos(): Flow<List<Photo>>
}
