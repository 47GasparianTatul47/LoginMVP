package com.example.androidmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidmvp.Presenter.LoginPresenter
import com.example.androidmvp.View.ILoginView

class MainActivity : AppCompatActivity(),ILoginView {

    internal lateinit var loginPresenter: LoginPresenter
    lateinit var btn :Button
    lateinit var email :EditText
    lateinit var password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.loginBtn)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        loginPresenter = LoginPresenter(this)



        btn.setOnClickListener {
            loginPresenter.onLogin(email.text.toString(),password.text.toString())
        }

    }

    override fun onLoginSuccess(message: String) {

        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()    }

    override fun onLoginError(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}