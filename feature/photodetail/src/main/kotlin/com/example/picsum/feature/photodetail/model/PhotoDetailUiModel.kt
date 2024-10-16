package com.example.picsum.feature.photodetail.model

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.picsum.model.entity.Photo

data class PhotoDetailUiModel(
    val imageUrl: String,
    val checked: Boolean,
) {
    companion object {
        fun from(photo: Photo) =
            PhotoDetailUiModel(
                imageUrl = photo.downloadUrl,
                checked = photo.checked,
            )
    }
}

internal class PhotoDetailUiModelProvider : PreviewParameterProvider<PhotoDetailUiModel> {
    override val values: Sequence<PhotoDetailUiModel>
        get() =
            sequenceOf(
                PhotoDetailUiModel(
                    imageUrl = "https://picsum.photos/id/23/3887/4899",
                    checked = false,
                ),
                PhotoDetailUiModel(
                    imageUrl = "https://picsum.photos/id/23/3887/4899",
                    checked = true,
                ),
            )
}
