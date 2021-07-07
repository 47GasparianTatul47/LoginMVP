package com.example.androidmvp.View

interface ILoginView {
    fun onLoginSuccess(message: String)
    fun onLoginError(message: String)
}