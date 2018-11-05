package com.example.toof.esearchusergithub.screen.main

import com.example.toof.esearchusergithub.data.model.SearchResponse
import com.example.toof.esearchusergithub.data.repository.UserRepository
import com.example.toof.esearchusergithub.data.source.remote.OnFetchDataJsonListener

class MainPresenter(repository: UserRepository) : MainContract.Presenter {

    private lateinit var mView: MainContract.View
    private val mRepository: UserRepository = repository
    override fun getData(query: String) {
        mRepository.getData(query, object : OnFetchDataJsonListener<SearchResponse.Result> {

            override fun onSuccess(data: SearchResponse.Result) {
                mView.onGetDataSuccess(data)
            }

            override fun onError(error: String) {
                mView.onError(error)
            }

        })
    }

    override fun setView(view: MainContract.View) {
        mView = view
    }
}
