package com.example.toof.esearchusergithub.data.source

import com.example.toof.esearchusergithub.data.model.User
import com.example.toof.esearchusergithub.data.source.remote.OnFetchDataJsonListener

class UserDataSource {

    interface LocalDataSource {
    }

    interface RemoteDataSource {
        fun getData(query: String, listener: OnFetchDataJsonListener<User>)
    }
}