package com.example.toof.esearchusergithub.data.source.remote.fetchjson

import com.example.toof.esearchusergithub.data.model.SearchResponse
import com.example.toof.esearchusergithub.data.service.UserApiBuilder
import com.example.toof.esearchusergithub.data.source.remote.OnFetchDataJsonListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class GetDataJson(query: String, listener: OnFetchDataJsonListener<SearchResponse.Result>) {

    private val mListener: OnFetchDataJsonListener<SearchResponse.Result> = listener
    private val mQuery: String = query
    /*fun getData() {
        val userAPI = UserApiBuilder.getService()
        val call = userAPI.getSearchData(mQuery)

        call.enqueue(object : Callback<SearchResponse.Result> {
            override fun onFailure(call: Call<SearchResponse.Result>, t: Throwable) {
                mListener.onError(t.toString())

            }

            override fun onResponse(call: Call<SearchResponse.Result>, response: Response<SearchResponse.Result>) {
                if (response.isSuccessful) {
                    mListener.onSuccess(response.body()!!)
                } else {
                    mListener.onError(response.errorBody().toString())
                }
            }

        })

    }*/

    fun getData() {
        disposable = getService.getSearchData(mQuery)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> mListener.onSuccess(result) },
                { error -> mListener.onError(error.toString()) }
            )
    }

    companion object {
        private val getService by lazy { UserApiBuilder.create() }
        private var disposable: Disposable? = null
    }
}
