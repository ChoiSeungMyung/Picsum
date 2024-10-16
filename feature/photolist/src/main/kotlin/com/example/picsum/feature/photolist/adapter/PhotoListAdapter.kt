package com.example.picsum.feature.photolist.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.picsum.feature.photolist.model.PhotoUiModel

class PhotoListAdapter(
    private val onChecked: (PhotoUiModel) -> Unit,
    private val onClick: (PhotoUiModel) -> Unit,
) : ListAdapter<PhotoUiModel, PhotoItemViewHolder>(PhotoUiModel.diffUtil) {
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
            onClick(item)
        }
        holder.binding.checkBox.setOnClickListener {
            onChecked(item)
        }
    }
}
