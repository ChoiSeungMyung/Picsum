package com.example.lookpin.feature.photodetail

import com.example.lookpin.base.effect.ViewEffect

sealed interface PhotoDetailViewEffect : ViewEffect {

    data class Error(val throwable: Throwable) : PhotoDetailViewEffect

    data object Success : PhotoDetailViewEffect
}
