package com.example.toof.esearchusergithub.screen.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.toof.esearchusergithub.R
import com.example.toof.esearchusergithub.data.model.SearchResponse
import com.example.toof.esearchusergithub.data.repository.UserRepository
import com.example.toof.esearchusergithub.utils.OnItemRecyclerViewClickListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View, OnItemRecyclerViewClickListener<SearchResponse.User> {

    private lateinit var mAdapter: MainAdapter
    private lateinit var mPresenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAdapter = MainAdapter(this, this)
        recycler_view.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }

        val repository = UserRepository()
        mPresenter = MainPresenter(repository)
        mPresenter.setView(this)

        button_search.setOnClickListener {
            mPresenter.getData(edit_search.text.toString())
        }

    }

    override fun onGetDataSuccess(result: SearchResponse.Result) {
        mAdapter.updateData(result)
    }

    override fun onError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun onStart() {
        mPresenter.onStart()
        super.onStart()
    }

    override fun onStop() {
        mPresenter.onStop()
        super.onStop()
    }

    override fun onItemClickListener(item: SearchResponse.User) {
        val intent = Intent()
        intent.apply {
            action = Intent.ACTION_VIEW
            data = Uri.parse(item.html_url)
        }

        startActivity(Intent.createChooser(intent, "Open the page at ..."))
    }


}
