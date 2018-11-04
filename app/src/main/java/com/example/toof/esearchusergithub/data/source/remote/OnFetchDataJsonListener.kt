package com.example.toof.esearchusergithub.data.source.remote

interface OnFetchDataJsonListener<T> {

    fun onSuccess(data: ArrayList<T>)

    fun onError(e: Exception)
}