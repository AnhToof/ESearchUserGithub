package com.example.toof.esearchusergithub.screen.main

import com.example.toof.esearchusergithub.data.repository.UserRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(repository: UserRepository) : MainContract.Presenter {

    private lateinit var mView: MainContract.View
    private val mRepository: UserRepository = repository
    private val mCompositeDisposable = CompositeDisposable()
    override fun getData(query: String) {
        mView.showLoading()
        val disposable = mRepository.getData(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate { mView.hideLoading() }
            .subscribe(
                { result -> mView.onGetDataSuccess(result) },
                { error -> mView.onError(error.toString()) }
            )
        mCompositeDisposable.add(disposable)
    }

    override fun onStart() {
    }

    override fun onStop() {
        mCompositeDisposable.clear()
    }


    override fun setView(view: MainContract.View) {
        mView = view
    }
}
