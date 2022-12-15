package com.example.jetpackcompose.login.domain

import com.example.jetpackcompose.login.data.network.LoginRepository

class LoginUseCase {

    val reposiroty = LoginRepository()

    suspend operator fun invoke(email: String, password: String): Boolean {
        return reposiroty.doLogin(email, password)
    }
}