package com.example.lookpin.ui.ktx

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("bind:photo")
fun ImageView.setPhoto(url: String?) {
    if (url == null) {
        return
    }

    Glide.with(this)
        .load(url)
        .into(this)
}
