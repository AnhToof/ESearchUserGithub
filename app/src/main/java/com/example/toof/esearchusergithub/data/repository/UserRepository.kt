package com.example.toof.esearchusergithub.data.repository

import com.example.toof.esearchusergithub.data.model.SearchResponse
import com.example.toof.esearchusergithub.data.service.UserApiBuilder
import io.reactivex.Single

class UserRepository {
    fun getData(query: String): Single<SearchResponse.Result> {
        return getService.getSearchData(query)
    }

    companion object {
        private val getService by lazy { UserApiBuilder.create() }
    }

}
