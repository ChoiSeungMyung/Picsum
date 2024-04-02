package com.example.lookpin.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lookpin.base.effect.ViewEffect
import com.example.lookpin.base.error.ViewError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class BaseViewModel<E : ViewEffect> : ViewModel() {
    protected inline val TAG: String
        get() = this::class.java.simpleName

    private val _effect: MutableStateFlow<E?> = MutableStateFlow(null)
    val effect = _effect.asStateFlow()

    private val _error: MutableStateFlow<ViewError?> = MutableStateFlow(null)
    val error = _error.asStateFlow()

    protected fun sendEffect(event: E) {
        _effect.value = event
    }

    fun clearEffect() {
        _effect.value = null
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
