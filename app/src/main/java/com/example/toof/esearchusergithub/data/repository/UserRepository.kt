package com.example.toof.esearchusergithub.data.repository

import com.example.toof.esearchusergithub.data.model.SearchResponse
import com.example.toof.esearchusergithub.data.source.UserDataSource
import com.example.toof.esearchusergithub.data.source.remote.OnFetchDataJsonListener
import com.example.toof.esearchusergithub.data.source.remote.UserRemoteDataSource

class UserRepository(remoteDataSource: UserRemoteDataSource) {
    private val mRemoteDataSource: UserDataSource.RemoteDataSource = remoteDataSource

    fun getData(query: String, listener: OnFetchDataJsonListener<SearchResponse.Result>) {
        mRemoteDataSource.getData(query, listener)
    }

}
