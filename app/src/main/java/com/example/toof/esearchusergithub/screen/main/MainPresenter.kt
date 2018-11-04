package com.example.toof.esearchusergithub.screen.main

import com.example.toof.esearchusergithub.data.model.User
import com.example.toof.esearchusergithub.data.repository.UserRepository
import com.example.toof.esearchusergithub.data.source.remote.OnFetchDataJsonListener

class MainPresenter(repository: UserRepository): MainContract.Presenter {

    private lateinit var mView: MainContract.View
    private val mRepository: UserRepository = repository
    override fun getData(query: String) {
        mRepository.getData(query, object : OnFetchDataJsonListener<User> {
            override fun onSuccess(data: ArrayList<User>) {
                mView.onGetDataSuccess(data)
            }

            override fun onError(e: Exception) {
                mView.onError(e)
            }

        })
    }

    override fun setView(view: MainContract.View) {
        mView = view
    }
}