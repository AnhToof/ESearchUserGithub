package com.example.toof.esearchusergithub.data.service

import com.example.toof.esearchusergithub.data.model.SearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query


interface UserApiService {

    @GET("/search/users")
    fun getSearchData(@Query("q") query: String): Single<SearchResponse.Result>
}
