package com.example.picsum.base.viewholder

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class ItemDataBindingViewHolder<VH : ViewDataBinding, T>(
    private val binding: VH,
) : BaseViewHolder(binding.root) {
    protected abstract fun variableId(): Int?

    fun bind(item: T) {
        variableId()?.let { id -> binding.setVariable(id, item) }
        binding.executePendingBindings()
    }

    protected fun bind(block: VH.() -> Unit) {
        binding.run(block)
    }
}

abstract class BaseViewHolder(
    itemView: View,
) : RecyclerView.ViewHolder(itemView)
