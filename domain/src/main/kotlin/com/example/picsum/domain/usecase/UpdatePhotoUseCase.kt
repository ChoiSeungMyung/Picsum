package com.example.picsum.domain.usecase

import com.example.picsum.data.repository.PhotoRepository
import com.example.picsum.model.entity.Photo
import dagger.Reusable
import javax.inject.Inject

@Reusable
class UpdatePhotoUseCase
    @Inject
    constructor(
        private val repo: PhotoRepository,
    ) {
        operator fun invoke(photo: Photo) {
            repo.updatePhoto(photo)
        }
    }
