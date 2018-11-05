package com.example.toof.esearchusergithub.data.source.remote

interface OnFetchDataJsonListener<T> {

    fun onSuccess(data: T)

    fun onError(error: String)
}
