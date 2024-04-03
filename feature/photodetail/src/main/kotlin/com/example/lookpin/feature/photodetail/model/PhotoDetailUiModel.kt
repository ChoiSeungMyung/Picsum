package com.example.lookpin.feature.photodetail.model

import com.example.lookpin.model.entity.Photo

data class PhotoDetailUiModel(
    val imageUrl: String,
    val checked: Boolean,
) {

    companion object {
        fun from(photo: Photo) = PhotoDetailUiModel(
            imageUrl = photo.downloadUrl,
            checked = photo.checked,
        )
    }
}
