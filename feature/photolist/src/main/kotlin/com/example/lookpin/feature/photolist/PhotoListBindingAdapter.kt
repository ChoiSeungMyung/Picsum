package com.example.lookpin.feature.photolist

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.lookpin.feature.photolist.adapter.PhotoListAdapter
import com.example.lookpin.model.entity.Photo

@BindingAdapter("bind:photoList")
fun RecyclerView.bindPhotoList(list: List<Photo>?) {
    (adapter as? PhotoListAdapter)?.submitList(list ?: emptyList())
}
