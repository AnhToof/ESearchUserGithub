package com.example.toof.esearchusergithub.screen.main

import com.example.toof.esearchusergithub.data.model.SearchResponse
import com.example.toof.esearchusergithub.utils.BasePresenter

interface MainContract {

    interface View {
        fun onGetDataSuccess(result: SearchResponse.Result)

        fun onError(error: String)
    }

    interface Presenter : BasePresenter<View> {
        fun getData(query: String)
    }
}
