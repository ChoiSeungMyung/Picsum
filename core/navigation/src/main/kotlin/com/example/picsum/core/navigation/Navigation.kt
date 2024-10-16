package com.example.picsum.navigation

interface Navigation {
    fun navigateToPhotoList()

    fun navigateToPhotoDetail(photoId: String)
}
