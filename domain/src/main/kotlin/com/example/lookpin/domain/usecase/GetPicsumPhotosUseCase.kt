package com.example.lookpin.domain.usecase

import com.example.lookpin.data.repository.PicsumRepository
import com.example.lookpin.model.entity.Photo
import dagger.Reusable
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

@Reusable
class GetPicsumPhotosUseCase @Inject constructor(
    private val repo: PicsumRepository,
) {
    operator fun invoke(): Flow<List<Photo>> = repo.getPicsumPhotos()
}
