package com.example.lookpin.domain.usecase

import com.example.lookpin.data.repository.PhotoRepository
import com.example.lookpin.model.entity.Photo
import dagger.Reusable
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@Reusable
class GetPhotosUseCase @Inject constructor(
    private val repo: PhotoRepository,
) {
    operator fun invoke(): Flow<List<Photo>> = repo.photos()
}
