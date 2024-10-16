package com.example.picsum.feature.photolist.model

import androidx.recyclerview.widget.DiffUtil
import com.example.picsum.model.entity.Photo

data class PhotoUiModel(
    val id: String,
    val imageUrl: String,
    val checked: Boolean,
) {
    companion object {
        private fun toUiModel(photo: Photo) =
            PhotoUiModel(
                id = photo.id,
                imageUrl = photo.downloadUrl,
                checked = photo.checked,
            )

        fun toUiModel(photos: List<Photo>) =
            photos.map { toUiModel(it) }

        val diffUtil =
            object : DiffUtil.ItemCallback<PhotoUiModel>() {
                override fun areItemsTheSame(
                    oldItem: PhotoUiModel,
                    newItem: PhotoUiModel,
                ): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(
                    oldItem: PhotoUiModel,
                    newItem: PhotoUiModel,
                ): Boolean {
                    return oldItem == newItem
                }
            }
    }
}
