package com.example.lookpin.feature.photolist.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.lookpin.model.entity.Photo

class PhotoListAdapter(
    private val onChecked: (Photo) -> Unit,
) : ListAdapter<Photo, PhotoItemViewHolder>(photoDiffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PhotoItemViewHolder =
        PhotoItemViewHolder.create(parent)

    override fun onBindViewHolder(
        holder: PhotoItemViewHolder,
        position: Int,
    ) {
        val item = getItem(position)
        holder.bind(item = item)
        holder.itemView.setOnClickListener {
            onChecked(item)
        }
    }
}

private val photoDiffUtil = object : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }
}
