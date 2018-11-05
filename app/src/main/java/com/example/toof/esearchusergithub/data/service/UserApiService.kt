package com.example.toof.esearchusergithub.data.service

import com.example.toof.esearchusergithub.data.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface UserApiService {

    @GET("/search/users")
    fun getSearchData(@Query("q") query: String): Call<SearchResponse.Result>
}
