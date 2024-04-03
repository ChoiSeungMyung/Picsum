package com.example.lookpin.domain.usecase

import com.example.lookpin.data.repository.PhotoRepository
import com.example.lookpin.model.entity.Photo
import dagger.Reusable
import javax.inject.Inject

@Reusable
class UpdatePhotosUseCase @Inject constructor(
    private val repo: PhotoRepository,
) {
    operator fun invoke(list: List<Photo>) {
        repo.updatePhotos(list)
    }
}
