package com.example.toof.esearchusergithub.data.source.remote

import com.example.toof.esearchusergithub.data.model.User
import com.example.toof.esearchusergithub.data.source.UserDataSource
import com.example.toof.esearchusergithub.data.source.remote.fetchjson.GetDataJson

class UserRemoteDataSource : UserDataSource.RemoteDataSource {

    override fun getData(query: String, listener: OnFetchDataJsonListener<User>) {
        val getJsonData = GetDataJson(query, listener)
        getJsonData.getData()
    }
}