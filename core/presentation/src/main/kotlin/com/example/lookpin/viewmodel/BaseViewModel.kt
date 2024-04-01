package com.example.lookpin.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lookpin.effect.ViewEffect
import com.example.lookpin.error.ViewError
import com.example.lookpin.state.ViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseViewModel<E : ViewEffect, S : ViewState>(
    initialState: S,
) : ViewModel() {
    protected inline val TAG: String
        get() = this::class.java.simpleName

    private val _effect: MutableStateFlow<E?> = MutableStateFlow(null)
    val effect = _effect.asStateFlow()

    private val _state: MutableStateFlow<S> = MutableStateFlow(initialState)
    val state: StateFlow<S>
        get() = _state

    private val _error: MutableStateFlow<ViewError?> = MutableStateFlow(null)
    val error = _error.asStateFlow()

    protected fun callEffect(event: E) {
        _effect.value = event
    }

    protected fun updateState(block: (state: S) -> S) {
        Timber.tag(TAG).d("updateState before : ${state.value}")
        _state.value = block(requireNotNull(state.value))
        Timber.tag(TAG).d("updateState after : ${state.value}")
    }

    protected fun <T> Flow<T>.launchIn(coroutineScope: CoroutineScope = viewModelScope): Job =
        coroutineScope.launch {
            catch { onError(it) }.collect()
        }

    open fun onError(throwable: Throwable) {
        Timber.tag(TAG).e(throwable)
        _error.value = ViewError(throwable)
    }
}
