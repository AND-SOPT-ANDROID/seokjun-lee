package org.sopt.and.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<State : UiState, SideEffect : UiSideEffect, Event : UiEvent>(
) : ViewModel() {

    /**
     * [createInitialState] is a function that creates the initial state of the state.
     * Its role is to force users to initialize UiState in child viewmodel
     */
    private val initialState: State by lazy { createInitialState() }
    abstract fun createInitialState(): State

    private val _uiState = MutableStateFlow<State>(initialState)
    val uiState = _uiState.asStateFlow()
    val currentState: State
        get() = uiState.value

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow<Event>()
    val event = _event.asSharedFlow()

    private val _sideEffect: MutableSharedFlow<UiSideEffect> = MutableSharedFlow<UiSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    fun setState(reduce: State.() -> State) {
        _uiState.value = currentState.reduce()
    }

    /**
     * [setEvent] is used in UI to send out event which can change UI State
     *
     * It is set as `open`, making it possible for child viewmodel to override and customize this method
     */
    open fun setEvent(event: Event) {
        dispatchEvent(event)
    }

    /**
     * [dispatchEvent] is used to wrap event logins with coroutineScope
     *
     * By doing so, event logics can handle multiple emissions such as `SideEffect`
     */
    private fun dispatchEvent(event: Event) = viewModelScope.launch {
        handleEvent(event)
    }

    protected abstract suspend fun handleEvent(event: Event)

    fun setSideEffect(sideEffect: SideEffect) {
        viewModelScope.launch {
            _sideEffect.emit(sideEffect)
        }
    }
}