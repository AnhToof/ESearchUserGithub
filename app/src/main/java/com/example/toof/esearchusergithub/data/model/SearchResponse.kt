package com.example.toof.esearchusergithub.data.model

import com.google.gson.annotations.SerializedName

object SearchResponse {
    data class User(
        @SerializedName("login") val login: String,
        @SerializedName("id") val id: String,
        @SerializedName("avatar_url") val avatar_url: String,
        @SerializedName("html_url") val html_url: String
    )

    data class Result(
        @SerializedName("total_count") val total_count: Int,
        @SerializedName("incomplete_results") val incomplete_results: Boolean,
        @SerializedName("items") val items: ArrayList<User>
    )
}
