package com.example.jetpackcompose.login.ui

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.login.domain.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _email = MutableLiveData<String>()
    private val _password = MutableLiveData<String>()
    private val _loginEnable = MutableLiveData<Boolean>()
    private val _isloading = MutableLiveData<Boolean>()


    val email: LiveData<String> = _email
    val password: LiveData<String> = _password
    val loginEnable: LiveData<Boolean> = _loginEnable
    val isLoading: LiveData<Boolean> = _isloading

    fun onChangedLogin(email: String, password: String) {
        _email.value = email
        _password.value = password

        _loginEnable.value = validEmailAndPassword(email, password)
    }

    private fun validEmailAndPassword(email: String, password: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length >= 6
    }

    fun onLoginSelected() {
        viewModelScope.launch {
            _isloading.value = true
            val resultLogin = loginUseCase(email.value!!, password.value!!)

            if (resultLogin) {
                Log.i("tati login", "Result ok")
            } else {
                Log.i("tati login", "Result fail")
            }

            _isloading.value = false
        }
    }
}

