package com.example.lookpin.feature.photodetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.lookpin.base.viewmodel.BaseViewModel
import com.example.lookpin.domain.usecase.GetPhotoUseCase
import com.example.lookpin.domain.usecase.UpdatePhotoUseCase
import com.example.lookpin.feature.photodetail.model.PhotoDetailUiModel
import com.example.lookpin.model.entity.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPhotoUseCase: GetPhotoUseCase,
    private val updatePhotoUseCase: UpdatePhotoUseCase,
) : BaseViewModel<PhotoDetailViewEffect>() {
    private val photoId =
        PhotoDetailFragmentArgs.fromSavedStateHandle(savedStateHandle).photoId

    private val photo: MutableStateFlow<Photo?> = MutableStateFlow(null)

    val photoUiModel: StateFlow<PhotoDetailUiModel?> =
        photo
            .filterNotNull()
            .map { PhotoDetailUiModel.from(it) }
            .onEach {
                sendEffect(PhotoDetailViewEffect.Success)
            }
            .catch { t ->
                sendEffect(PhotoDetailViewEffect.Error(t))
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = null,
            )

    init {
        loadPhoto()
    }

    private fun loadPhoto() {
        getPhotoUseCase(photoId)
            .onEach { photo.value = it }
            .launchIn()
    }

    fun onCheckClick(checked: Boolean) {
        val photo = photo.value ?: return
        updatePhotoUseCase(
            photo.copy(checked = checked),
        )
    }

    fun refreshPhoto() {
        photo.value = null
        loadPhoto()
    }

    fun imageLoadError() {
        sendEffect(PhotoDetailViewEffect.Error(IllegalStateException("Image load error")))
        refreshPhoto()
    }
}
