package com.example.lookpin.feature.photolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.lookpin.base.viewholder.ItemDataBindingViewHolder
import com.example.lookpin.feature.photolist.BR
import com.example.lookpin.feature.photolist.databinding.ItemPhotoBinding
import com.example.lookpin.model.entity.Photo

class PhotoItemViewHolder(
    binding: ItemPhotoBinding,
) : ItemDataBindingViewHolder<ItemPhotoBinding, Photo>(binding) {

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
