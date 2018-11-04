package com.example.toof.esearchusergithub.screen.main

import com.example.toof.esearchusergithub.data.model.User
import com.example.toof.esearchusergithub.utils.BasePresenter

interface MainContract {

    interface View {
        fun onGetDataSuccess(list: ArrayList<User>)

        fun onError(e: Exception)
    }

    interface Presenter : BasePresenter<View> {
        fun getData(query: String)
    }
}