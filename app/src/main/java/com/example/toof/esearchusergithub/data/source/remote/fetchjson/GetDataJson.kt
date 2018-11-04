package com.example.toof.esearchusergithub.data.source.remote.fetchjson

import com.example.toof.esearchusergithub.data.model.User
import com.example.toof.esearchusergithub.data.source.remote.OnFetchDataJsonListener
import com.example.toof.esearchusergithub.utils.Constant

class GetDataJson(query: String, listener: OnFetchDataJsonListener<User>) {

    private val mListener: OnFetchDataJsonListener<User> = listener
    private val mQuery: String = query

    fun getData() {
        GetJsonFromUrl(mListener).execute(Constant.BASE_URL + mQuery)
    }
}