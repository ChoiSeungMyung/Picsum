package com.example.picsum.feature.photodetail

import com.example.picsum.base.effect.ViewEffect

sealed interface PhotoDetailViewEffect : ViewEffect {
    data class Error(val throwable: Throwable) : PhotoDetailViewEffect

    data object Success : PhotoDetailViewEffect
}
