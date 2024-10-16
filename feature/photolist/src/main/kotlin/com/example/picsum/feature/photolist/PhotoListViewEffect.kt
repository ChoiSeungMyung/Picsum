package com.example.picsum.feature.photolist

import com.example.picsum.base.effect.ViewEffect

sealed interface PhotoListViewEffect : ViewEffect {
    data class Error(val throwable: Throwable) : PhotoListViewEffect

    data object Success : PhotoListViewEffect
}
