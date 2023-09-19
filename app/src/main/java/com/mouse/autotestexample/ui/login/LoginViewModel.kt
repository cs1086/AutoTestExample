package com.mouse.autotestexample.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mouse.autotestexample.AuthManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(val iLoginRepository: ILoginRepository) : ViewModel() {
    private var _userName = MutableStateFlow("")
    val userName = _userName.asStateFlow()
    fun setUserName(value: String) {
        _userName.value = value
    }

    private var _password = MutableStateFlow("")
    val password = _password.asStateFlow()
    fun setPassword(value: String) {
        _password.value = value
    }

    private var _isLoginSuccess = MutableStateFlow(false)
    val isLoginSuccess = _isLoginSuccess.asStateFlow()

    fun login() {
        viewModelScope.launch {
            _isLoginSuccess.value = AuthManager().login(iLoginRepository)
        }
    }

}