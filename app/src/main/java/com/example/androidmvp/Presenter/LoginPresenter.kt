package com.example.androidmvp.Presenter

import com.example.androidmvp.MainActivity
import com.example.androidmvp.User

class LoginPresenter(internal val iLoginView: MainActivity) : ILoginPresente {
    override fun onLogin(email: String, password: String) {
        val user = User(email, password)
        val loginCode = user.isDataValid()

        if (loginCode == 0)
            iLoginView.onLoginSuccess("Email must not be null")
         else if (loginCode == 1)
            iLoginView.onLoginError("Wrong Email Adress")
        else if (loginCode == 2)
            iLoginView.onLoginError("Password must be greather than 6")
        else iLoginView.onLoginSuccess("Login Succees")
    }
}