package com.example.lookpin.feature.photolist

import androidx.lifecycle.viewModelScope
import com.example.lookpin.base.viewmodel.BaseViewModel
import com.example.lookpin.domain.usecase.GetPhotosUseCase
import com.example.lookpin.domain.usecase.RefreshPhotosUseCase
import com.example.lookpin.domain.usecase.UpdatePhotosUseCase
import com.example.lookpin.feature.photolist.model.PhotoUiModel
import com.example.lookpin.model.entity.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel
class PhotoListViewModel @Inject constructor(
    getPhotosUseCase: GetPhotosUseCase,
    private val updatePhotosUseCase: UpdatePhotosUseCase,
    private val refreshPhotosUseCase: RefreshPhotosUseCase,
) : BaseViewModel<PhotoListViewEffect>() {

    private val photos: StateFlow<List<Photo>> =
        getPhotosUseCase()
            .catch { t -> sendEffect(PhotoListViewEffect.Error(t)) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList(),
            )

    val photoUiModels: StateFlow<List<PhotoUiModel>> =
        photos
            .map { PhotoUiModel.toUiModel(it) }
            .onEach { sendEffect(PhotoListViewEffect.Success) }
            .catch { t -> sendEffect(PhotoListViewEffect.Error(t)) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = emptyList(),
            )

    fun refresh() {
        viewModelScope.launch {
            refreshPhotosUseCase()
        }
    }

    fun checkedPhoto(
        photo: PhotoUiModel,
    ) {
        updatePhotosUseCase(
            photos.value.map {
                if (it.id == photo.id) it.copy(checked = !it.checked)
                else it
            },
        )
    }
}
