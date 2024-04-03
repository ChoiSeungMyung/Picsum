package com.example.lookpin.ui.ktx

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.lookpin.core.ui.R

@BindingAdapter("bind:photo")
fun ImageView.setPhoto(url: String?) {
    if (url == null) {
        return
    }

    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.shape_rectangle)
        .error(R.drawable.ic_warning)
        .into(this)
}
