package com.example.lookpin.feature.photolist

import com.example.lookpin.base.effect.ViewEffect

sealed interface PhotoListViewEffect : ViewEffect {
    data class Error(val throwable: Throwable) : PhotoListViewEffect

    data object Success : PhotoListViewEffect
}
