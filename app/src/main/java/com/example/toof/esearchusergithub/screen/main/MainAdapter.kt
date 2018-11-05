package com.example.toof.esearchusergithub.screen.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.toof.esearchusergithub.R
import com.example.toof.esearchusergithub.data.model.SearchResponse
import com.example.toof.esearchusergithub.utils.OnItemRecyclerViewClickListener

class MainAdapter(context: Context, listener: OnItemRecyclerViewClickListener<SearchResponse.User>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val mContext = context
    private var mResult: SearchResponse.Result? = null
    private val mListener: OnItemRecyclerViewClickListener<SearchResponse.User> = listener

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(mContext).inflate(R.layout.item_user, p0, false),
            mResult!!,
            mListener
        )
    }

    override fun getItemCount(): Int {
        return if (mResult != null) mResult?.items?.size!! else 0
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        mResult?.items?.get(p1)?.let { p0.bindViewData(it) }
    }

    fun updateData(result: SearchResponse.Result) {
        mResult = result
        notifyDataSetChanged()
    }

    class ViewHolder(
        view: View,
        result: SearchResponse.Result,
        listener: OnItemRecyclerViewClickListener<SearchResponse.User>
    ) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private val mResult: SearchResponse.Result = result
        private val mListener: OnItemRecyclerViewClickListener<SearchResponse.User> = listener
        private val mImageView: ImageView = view.findViewById(R.id.image_view)
        private val mTextViewId: TextView = view.findViewById(R.id.text_id)
        private val mTextViewLogin: TextView = view.findViewById(R.id.text_login)

        init {
            itemView.setOnClickListener(this)
        }

        fun bindViewData(user: SearchResponse.User) {
            mTextViewId.text = user.id
            mTextViewLogin.text = user.login
            Glide.with(itemView)
                .load(user.avatar_url)
                .into(mImageView)
        }

        override fun onClick(v: View?) {
            mListener.onItemClickListener(mResult.items[adapterPosition])
        }

    }
}
