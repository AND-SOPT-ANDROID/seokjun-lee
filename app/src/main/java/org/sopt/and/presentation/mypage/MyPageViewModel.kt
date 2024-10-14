package org.sopt.and.presentation.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import org.sopt.and.R

class MyPageViewModel : ViewModel() {
    private var _sideEffect = MutableSharedFlow<MyPageSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    fun onLogoutButtonClick() = viewModelScope.launch {
        _sideEffect.emit(MyPageSideEffect.ShowSnackBar(R.string.mypage_button_logout))

    }

}