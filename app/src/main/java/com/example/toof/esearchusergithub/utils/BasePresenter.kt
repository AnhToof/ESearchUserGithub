package com.example.toof.esearchusergithub.utils

interface BasePresenter<T> {

    fun onStart()

    fun onStop()

    fun setView(view: T)
}
