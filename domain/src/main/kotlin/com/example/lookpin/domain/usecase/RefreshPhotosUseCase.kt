package com.example.lookpin.domain.usecase

import com.example.lookpin.data.repository.PhotoRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class RefreshPhotosUseCase @Inject constructor(
    private val repo: PhotoRepository,
) {
    suspend operator fun invoke() {
        repo.refresh()
    }
}
