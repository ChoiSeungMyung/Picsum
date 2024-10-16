package com.example.picsum.domain.usecase

import com.example.picsum.data.repository.PhotoRepository
import com.example.picsum.model.entity.Photo
import dagger.Reusable
import javax.inject.Inject

@Reusable
class UpdatePhotosUseCase
    @Inject
    constructor(
        private val repo: PhotoRepository,
    ) {
        operator fun invoke(list: List<Photo>) {
            repo.updatePhotos(list)
        }
    }
