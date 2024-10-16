package com.example.picsum.feature.photolist

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.picsum.feature.photolist.adapter.PhotoListAdapter
import com.example.picsum.feature.photolist.model.PhotoUiModel

@BindingAdapter("bind:photoList")
fun RecyclerView.bindPhotoList(list: List<PhotoUiModel>?) {
    (adapter as? PhotoListAdapter)?.submitList(list ?: emptyList())
}
