package com.example.lookpin.feature.photolist

import androidx.lifecycle.viewModelScope
import com.example.lookpin.base.viewmodel.BaseViewModel
import com.example.lookpin.domain.usecase.GetPicsumPhotosUseCase
import com.example.lookpin.model.entity.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    getPicsumPhotosUseCase: GetPicsumPhotosUseCase,
) : BaseViewModel<PhotoListViewEffect>() {

    val photoList: StateFlow<List<Photo>> =
        getPicsumPhotosUseCase()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList(),
            )

    init {
        loadPhotoList()
    }

    private fun loadPhotoList() {
        photoList
            .launchIn()
    }
}
