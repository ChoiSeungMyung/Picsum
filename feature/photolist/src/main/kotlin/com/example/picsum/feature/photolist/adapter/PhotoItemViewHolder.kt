package com.example.picsum.feature.photolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.picsum.base.viewholder.ItemDataBindingViewHolder
import com.example.picsum.feature.photolist.BR
import com.example.picsum.feature.photolist.databinding.ItemPhotoBinding
import com.example.picsum.feature.photolist.model.PhotoUiModel

class PhotoItemViewHolder(
    val binding: ItemPhotoBinding,
) : ItemDataBindingViewHolder<ItemPhotoBinding, PhotoUiModel>(binding) {
    override fun variableId(): Int = BR.photo

    companion object {
        fun create(parent: ViewGroup) =
            PhotoItemViewHolder(
                ItemPhotoBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false,
                ),
            )
    }
}
